import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor
import org.antlr.v4.runtime.tree.ErrorNode
import target.java.ast.*
import java.util.stream.Collectors

class ProtofunVisitorImpl : AbstractParseTreeVisitor<JavaNode>(), ProtofunParserVisitor<JavaNode> {

    private val variables = HashMap<String, Any>()

    override fun visitErrorNode(node: ErrorNode): JavaNode {
        throw IllegalStateException("There is a parse error!\n${node.text}")
    }

    override fun visitStart(ctx: ProtofunParser.StartContext): JavaNode {
        println(ctx.IDENTIFIER().text)

        var block: BlockDto = visitBlock(ctx.block()) as BlockDto
        return PackageDto(ctx.IDENTIFIER().text, block)
    }

    override fun visitBlock(ctx: ProtofunParser.BlockContext): JavaNode {
        val statementNodes = ctx.statement().stream()
            .map { it ->
                visitStatement(it)
            }
            .map { s ->
                s as Statement
            }
            .collect(Collectors.toUnmodifiableList())
        return BlockDto(statementNodes)
    }

    override fun visitStatement(ctx: ProtofunParser.StatementContext): JavaNode {
        if (ctx.print() != null) {
            return visitPrint(ctx.print())
        } else if (ctx.variableDeclaration() != null) {
            return visitVariableDeclaration(ctx.variableDeclaration())
        } else if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment())
        }
        throw IllegalStateException("Not implementation for ${ctx.text}")
    }

    override fun visitVariableDeclaration(ctx: ProtofunParser.VariableDeclarationContext): JavaNode {
        return VariableDeclarationDto(ctx.IDENTIFIER().text, ctx.TYPE().text, visitExpr(ctx.expr()))
    }

    override fun visitAssignment(ctx: ProtofunParser.AssignmentContext): JavaNode {
        return AssignmentDto(ctx.IDENTIFIER().text, visitExpr(ctx.expr()))
    }

    override fun visitExpr(ctx: ProtofunParser.ExprContext): Expression {
        return if (ctx.ACCUMULATION_OP() != null) {
            val left: Expression = visitExpr(ctx.expr(0));
            val right: Expression = visitExpr(ctx.expr(1));
            BinaryOp(left, javaOp(ctx.ACCUMULATION_OP().text), right)
        } else if (ctx.MULOP() != null) {
            val left: Expression = visitExpr(ctx.expr(0));
            val right: Expression = visitExpr(ctx.expr(1));
            BinaryOp(left, javaOp(ctx.MULOP().text), right)
        } else if (ctx.L_PAREN() != null) {
            visitExpr(ctx.expr(0))
        } else if (ctx.REAL_LITERAL() != null) {
            RealLiteral(ctx.REAL_LITERAL().text.toDouble())
        } else if (ctx.INTEGER_LITERAL() != null) {
            IntegerLiteral(ctx.INTEGER_LITERAL().text.toLong())
        } else if (ctx.IDENTIFIER() != null) {
            IdentifierExpression(ctx.IDENTIFIER().text)
        } else {
            throw IllegalStateException()
        }
    }

    override fun visitPrint(ctx: ProtofunParser.PrintContext): JavaNode {
        return PrintDto(visitExpr(ctx.expr()))
    }

    private fun javaOp(text: String): JavaOperator {
        return when (text) {
            "+" -> JavaOperator.ADD
            "-" -> JavaOperator.SUBTRACT
            "*" -> JavaOperator.MULTIPLY
            "/" -> JavaOperator.DIVIDE
            else -> throw IllegalArgumentException();
        }
    }

}


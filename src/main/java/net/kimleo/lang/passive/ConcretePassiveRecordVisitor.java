package net.kimleo.lang.passive;

import net.kimleo.model.component.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcretePassiveRecordVisitor extends AbstractParseTreeVisitor<Component> {
    @Override
    public Component visitModel(PassiveRecordParser.ModelContext ctx) {
        List<Component> components = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            components.add(ctx.getChild(i).accept(this));
        }
        return new Model(components);
    }

    @Override
    public Component visitEntity(PassiveRecordParser.EntityContext ctx) {
        return new Entity(ctx.name().ID().getSymbol().getText(), (Record) ctx.record().accept(this));
    }

    @Override
    public Component visitRelation(PassiveRecordParser.RelationContext ctx) {
        return new Relation(ctx.name().ID().getSymbol().getText());
    }

    @Override
    public Component visitQuery(PassiveRecordParser.QueryContext ctx) {
        return super.visitQuery(ctx);
    }

    @Override
    public Component visitFunction(PassiveRecordParser.FunctionContext ctx) {
        if (ctx.expr() == null)
            return new Function(ctx.name().getText(),
                    ctx.params().accept(this),
                    ctx.statement().accept(this));
        else return new Function(ctx.name().getText(),
                ctx.params().accept(this),
                ctx.expr().accept(this));
    }

    @Override
    public Component visitView(PassiveRecordParser.ViewContext ctx) {
        return super.visitView(ctx);
    }

    @Override
    public Component visitRecord(PassiveRecordParser.RecordContext ctx) {
        return super.visitRecord(ctx);
    }

    @Override
    public Component visitStatement(PassiveRecordParser.StatementContext ctx) {
        if (ctx.expr() != null) {
            return new Expr(ctx.expr().accept(this));
        } else {
            return new Statement(ctx.statement().stream().map(stmt -> stmt.accept(this)).collect(Collectors.toList()));
        }
    }

    @Override
    public Component visitPair(PassiveRecordParser.PairContext ctx) {
        return super.visitPair(ctx);
    }

    @Override
    public Component visitConstraint(PassiveRecordParser.ConstraintContext ctx) {
        return super.visitConstraint(ctx);
    }

    @Override
    public Component visitConstraint_expr(PassiveRecordParser.Constraint_exprContext ctx) {
        return super.visitConstraint_expr(ctx);
    }

    @Override
    public Component visitParams(PassiveRecordParser.ParamsContext ctx) {
        return new Params(ctx.param().stream().map(param -> param.accept(this)).collect(Collectors.toList()));
    }

    @Override
    public Component visitParam(PassiveRecordParser.ParamContext ctx) {
        return new Name(ctx.name().getText());
    }

    @Override
    public Component visitType(PassiveRecordParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Component visitTypedef(PassiveRecordParser.TypedefContext ctx) {
        return super.visitTypedef(ctx);
    }

    @Override
    public Component visitTypealias(PassiveRecordParser.TypealiasContext ctx) {
        return super.visitTypealias(ctx);
    }

    @Override
    public Component visitHint(PassiveRecordParser.HintContext ctx) {
        return super.visitHint(ctx);
    }

    @Override
    public Component visitExpr(PassiveRecordParser.ExprContext ctx) {
        if (ctx.ID() != null) {
            return new Name(ctx.ID().getText());
        } else if (ctx.QUERY() != null) {
            return ctx.query_expr().accept(this);
        } else if (ctx.funcall_expr() != null) {
            return ctx.funcall_expr().accept(this);
        } else if (ctx.literals() != null) {
            return ctx.literals().accept(this);
        } else {
            return null;
        }
    }

    @Override
    public Component visitFuncall_expr(PassiveRecordParser.Funcall_exprContext ctx) {
        if (ctx.expr() == null)
            return new FunCall(ctx.name().getText(), ctx.arguments().accept(this));
        else
            return new FunCall(ctx.name().getText(), new Expr(ctx.expr().accept(this)));
    }

    @Override
    public Component visitArguments(PassiveRecordParser.ArgumentsContext ctx) {
        return super.visitArguments(ctx);
    }

    @Override
    public Component visitQuery_expr(PassiveRecordParser.Query_exprContext ctx) {
        return super.visitQuery_expr(ctx);
    }

    @Override
    public Component visitSelection(PassiveRecordParser.SelectionContext ctx) {
        return super.visitSelection(ctx);
    }

    @Override
    public Component visitPipe(PassiveRecordParser.PipeContext ctx) {
        return super.visitPipe(ctx);
    }

    @Override
    public Component visitProjection(PassiveRecordParser.ProjectionContext ctx) {
        return super.visitProjection(ctx);
    }

    @Override
    public Component visitProjector(PassiveRecordParser.ProjectorContext ctx) {
        return super.visitProjector(ctx);
    }

    @Override
    public Component visitExcluded_name(PassiveRecordParser.Excluded_nameContext ctx) {
        return super.visitExcluded_name(ctx);
    }

    @Override
    public Component visitIncluded_type(PassiveRecordParser.Included_typeContext ctx) {
        return super.visitIncluded_type(ctx);
    }

    @Override
    public Component visitFiltering(PassiveRecordParser.FilteringContext ctx) {
        return super.visitFiltering(ctx);
    }

    @Override
    public Component visitOrdering(PassiveRecordParser.OrderingContext ctx) {
        return super.visitOrdering(ctx);
    }

    @Override
    public Component visitGrouping(PassiveRecordParser.GroupingContext ctx) {
        return super.visitGrouping(ctx);
    }

    @Override
    public Component visitAggregating(PassiveRecordParser.AggregatingContext ctx) {
        return super.visitAggregating(ctx);
    }

    @Override
    public Component visitLimiting(PassiveRecordParser.LimitingContext ctx) {
        return super.visitLimiting(ctx);
    }

    @Override
    public Component visitJoining(PassiveRecordParser.JoiningContext ctx) {
        return super.visitJoining(ctx);
    }

    @Override
    public Component visitLiterals(PassiveRecordParser.LiteralsContext ctx) {
        return super.visitLiterals(ctx);
    }

    @Override
    public Component visitNumber(PassiveRecordParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    @Override
    public Component visitInteger(PassiveRecordParser.IntegerContext ctx) {
        return super.visitInteger(ctx);
    }

    @Override
    public Component visitName(PassiveRecordParser.NameContext ctx) {
        return super.visitName(ctx);
    }
}

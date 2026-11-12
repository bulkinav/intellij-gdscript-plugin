// This is a generated file. Not intended for manual editing.
package gdscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static gdscript.psi.ScriptElementTypes.*;
import gdscript.psi.ScriptBaseElement;
import gdscript.psi.*;

public class ScriptVarStatementImpl extends ScriptBaseElement implements ScriptVarStatement {

  public ScriptVarStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitVarStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptExpression.class);
  }

  @Override
  @NotNull
  public ScriptId getId() {
    return findNotNullChildByClass(ScriptId.class);
  }

  @Override
  @Nullable
  public ScriptType getType() {
    return findChildByClass(ScriptType.class);
  }

  @Override
  @Nullable
  public ScriptVarExport getVarExport() {
    return findChildByClass(ScriptVarExport.class);
  }

  @Override
  @Nullable
  public ScriptVarGetter getVarGetter() {
    return findChildByClass(ScriptVarGetter.class);
  }

  @Override
  @Nullable
  public ScriptVarSetter getVarSetter() {
    return findChildByClass(ScriptVarSetter.class);
  }

}

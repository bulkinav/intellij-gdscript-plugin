// This is a generated file. Not intended for manual editing.
package gdscript.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static gdscript.psi.ScriptElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return root(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // L_PAREN expression? (COMMA expression)* R_PAREN
  static boolean annotation_arguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_arguments")) return false;
    if (!nextTokenIs(builder_, L_PAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_PAREN);
    result_ = result_ && annotation_arguments_1(builder_, level_ + 1);
    result_ = result_ && annotation_arguments_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression?
  private static boolean annotation_arguments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_arguments_1")) return false;
    expression(builder_, level_ + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean annotation_arguments_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_arguments_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!annotation_arguments_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "annotation_arguments_2", pos_)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean annotation_arguments_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_arguments_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // group_annotation | warning_annotation | AT_STATIC_UNLOAD | AT_ABSTRACT
  public static boolean annotation_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_STATEMENT, "<annotation statement>");
    result_ = group_annotation(builder_, level_ + 1);
    if (!result_) result_ = warning_annotation(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, AT_STATIC_UNLOAD);
    if (!result_) result_ = consumeToken(builder_, AT_ABSTRACT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (VAR? expression) | DOT_DOT | UNDERSCORE
  public static boolean array_argument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_argument")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARRAY_ARGUMENT, "<array argument>");
    result_ = array_argument_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, DOT_DOT);
    if (!result_) result_ = consumeToken(builder_, UNDERSCORE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // VAR? expression
  private static boolean array_argument_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_argument_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = array_argument_0_0(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // VAR?
  private static boolean array_argument_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_argument_0_0")) return false;
    consumeToken(builder_, VAR);
    return true;
  }

  /* ********************************************************** */
  // id? L_BRACKET LINE_BREAK* array_argument? LINE_BREAK* (COMMA LINE_BREAK* array_argument LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACKET
  public static boolean array_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARRAY_EXPRESSION, "<array expression>");
    result_ = array_expression_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_BRACKET);
    result_ = result_ && array_expression_2(builder_, level_ + 1);
    result_ = result_ && array_expression_3(builder_, level_ + 1);
    result_ = result_ && array_expression_4(builder_, level_ + 1);
    result_ = result_ && array_expression_5(builder_, level_ + 1);
    result_ = result_ && array_expression_6(builder_, level_ + 1);
    result_ = result_ && array_expression_7(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // id?
  private static boolean array_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_0")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_2", pos_)) break;
    }
    return true;
  }

  // array_argument?
  private static boolean array_expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_3")) return false;
    array_argument(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_4", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* array_argument LINE_BREAK*)*
  private static boolean array_expression_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_5")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!array_expression_5_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_5", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* array_argument LINE_BREAK*
  private static boolean array_expression_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_5_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && array_expression_5_0_1(builder_, level_ + 1);
    result_ = result_ && array_argument(builder_, level_ + 1);
    result_ = result_ && array_expression_5_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean array_expression_5_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_5_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_5_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_5_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_5_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_5_0_3", pos_)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean array_expression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_6")) return false;
    consumeToken(builder_, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_expression_7")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "array_expression_7", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // id (L_BRACKET id R_BRACKET)
  static boolean array_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_type")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = id(builder_, level_ + 1);
    result_ = result_ && array_type_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // L_BRACKET id R_BRACKET
  private static boolean array_type_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_type_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACKET);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ASSERT expression
  public static boolean assert_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_statement")) return false;
    if (!nextTokenIs(builder_, ASSERT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSERT);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, ASSERT_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // EQUAL
  //     | PLUS_EQUAL
  //     | MINUS_EQUAL
  //     | STAR_EQUAL
  //     | SLASH_EQUAL
  //     | PERCENT_EQUAL
  //     | LESS_LESS_EQUAL
  //     | GREATER_GREATER_EQUAL
  //     | AMPERSAND_EQUAL
  //     | PIPE_EQUAL
  //     | CARET_EQUAL
  //     | INFER
  static boolean assign_operator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assign_operator")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EQUAL);
    if (!result_) result_ = consumeToken(builder_, PLUS_EQUAL);
    if (!result_) result_ = consumeToken(builder_, MINUS_EQUAL);
    if (!result_) result_ = consumeToken(builder_, STAR_EQUAL);
    if (!result_) result_ = consumeToken(builder_, SLASH_EQUAL);
    if (!result_) result_ = consumeToken(builder_, PERCENT_EQUAL);
    if (!result_) result_ = consumeToken(builder_, LESS_LESS_EQUAL);
    if (!result_) result_ = consumeToken(builder_, GREATER_GREATER_EQUAL);
    if (!result_) result_ = consumeToken(builder_, AMPERSAND_EQUAL);
    if (!result_) result_ = consumeToken(builder_, PIPE_EQUAL);
    if (!result_) result_ = consumeToken(builder_, CARET_EQUAL);
    if (!result_) result_ = consumeToken(builder_, INFER);
    return result_;
  }

  /* ********************************************************** */
  // expression assign_operator expression
  public static boolean assign_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assign_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSIGN_STATEMENT, "<assign statement>");
    result_ = expression(builder_, level_ + 1);
    result_ = result_ && assign_operator(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // AWAIT expression
  public static boolean await_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "await_statement")) return false;
    if (!nextTokenIs(builder_, AWAIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AWAIT);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, AWAIT_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // AT_ABSTRACT? CLASS id (EXTENDS type)? COLON
  public static boolean class_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement")) return false;
    if (!nextTokenIs(builder_, "<class statement>", AT_ABSTRACT, CLASS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CLASS_STATEMENT, "<class statement>");
    result_ = class_statement_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLASS);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && class_statement_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // AT_ABSTRACT?
  private static boolean class_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_0")) return false;
    consumeToken(builder_, AT_ABSTRACT);
    return true;
  }

  // (EXTENDS type)?
  private static boolean class_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_3")) return false;
    class_statement_3_0(builder_, level_ + 1);
    return true;
  }

  // EXTENDS type
  private static boolean class_statement_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (AT_ABSTRACT | AT_STATIC_UNLOAD)* CLASS_NAME id (EXTENDS type)? (COMMA string)?
  public static boolean classname_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CLASSNAME_STATEMENT, "<classname statement>");
    result_ = classname_statement_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLASS_NAME);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && classname_statement_3(builder_, level_ + 1);
    result_ = result_ && classname_statement_4(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (AT_ABSTRACT | AT_STATIC_UNLOAD)*
  private static boolean classname_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!classname_statement_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "classname_statement_0", pos_)) break;
    }
    return true;
  }

  // AT_ABSTRACT | AT_STATIC_UNLOAD
  private static boolean classname_statement_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, AT_ABSTRACT);
    if (!result_) result_ = consumeToken(builder_, AT_STATIC_UNLOAD);
    return result_;
  }

  // (EXTENDS type)?
  private static boolean classname_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_3")) return false;
    classname_statement_3_0(builder_, level_ + 1);
    return true;
  }

  // EXTENDS type
  private static boolean classname_statement_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COMMA string)?
  private static boolean classname_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_4")) return false;
    classname_statement_4_0(builder_, level_ + 1);
    return true;
  }

  // COMMA string
  private static boolean classname_statement_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classname_statement_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && string(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // func_statement
  //     | if_statement
  //     | elif_statement
  //     | else_statement
  //     | for_statement
  //     | class_statement
  //     | while_statement
  //     | match_statement
  //     | match_label_statement
  static boolean colon_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "colon_statement")) return false;
    boolean result_;
    result_ = func_statement(builder_, level_ + 1);
    if (!result_) result_ = if_statement(builder_, level_ + 1);
    if (!result_) result_ = elif_statement(builder_, level_ + 1);
    if (!result_) result_ = else_statement(builder_, level_ + 1);
    if (!result_) result_ = for_statement(builder_, level_ + 1);
    if (!result_) result_ = class_statement(builder_, level_ + 1);
    if (!result_) result_ = while_statement(builder_, level_ + 1);
    if (!result_) result_ = match_statement(builder_, level_ + 1);
    if (!result_) result_ = match_label_statement(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // CONST id (COLON type)? (EQUAL expression)
  public static boolean const_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "const_statement")) return false;
    if (!nextTokenIs(builder_, CONST)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CONST);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && const_statement_2(builder_, level_ + 1);
    result_ = result_ && const_statement_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, CONST_STATEMENT, result_);
    return result_;
  }

  // (COLON type)?
  private static boolean const_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "const_statement_2")) return false;
    const_statement_2_0(builder_, level_ + 1);
    return true;
  }

  // COLON type
  private static boolean const_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "const_statement_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EQUAL expression
  private static boolean const_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "const_statement_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUAL);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (key LINE_BREAK* (COLON LINE_BREAK* VAR? expression)?) | DOT_DOT
  public static boolean dictionary_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, DICTIONARY_ENTRY, "<dictionary entry>");
    result_ = dictionary_entry_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, DOT_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // key LINE_BREAK* (COLON LINE_BREAK* VAR? expression)?
  private static boolean dictionary_entry_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = key(builder_, level_ + 1);
    result_ = result_ && dictionary_entry_0_1(builder_, level_ + 1);
    result_ = result_ && dictionary_entry_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean dictionary_entry_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_entry_0_1", pos_)) break;
    }
    return true;
  }

  // (COLON LINE_BREAK* VAR? expression)?
  private static boolean dictionary_entry_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0_2")) return false;
    dictionary_entry_0_2_0(builder_, level_ + 1);
    return true;
  }

  // COLON LINE_BREAK* VAR? expression
  private static boolean dictionary_entry_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && dictionary_entry_0_2_0_1(builder_, level_ + 1);
    result_ = result_ && dictionary_entry_0_2_0_2(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean dictionary_entry_0_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_entry_0_2_0_1", pos_)) break;
    }
    return true;
  }

  // VAR?
  private static boolean dictionary_entry_0_2_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_entry_0_2_0_2")) return false;
    consumeToken(builder_, VAR);
    return true;
  }

  /* ********************************************************** */
  // L_BRACE LINE_BREAK* dictionary_entry? LINE_BREAK* (COMMA LINE_BREAK* dictionary_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  public static boolean dictionary_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACE);
    result_ = result_ && dictionary_expression_1(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_2(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_3(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_4(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_5(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACE);
    exit_section_(builder_, marker_, DICTIONARY_EXPRESSION, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_1", pos_)) break;
    }
    return true;
  }

  // dictionary_entry?
  private static boolean dictionary_expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_2")) return false;
    dictionary_entry(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_3", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* dictionary_entry LINE_BREAK*)*
  private static boolean dictionary_expression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!dictionary_expression_4_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_4", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* dictionary_entry LINE_BREAK*
  private static boolean dictionary_expression_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && dictionary_expression_4_0_1(builder_, level_ + 1);
    result_ = result_ && dictionary_entry(builder_, level_ + 1);
    result_ = result_ && dictionary_expression_4_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_4_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_4_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_4_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_4_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_4_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_4_0_3", pos_)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean dictionary_expression_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_5")) return false;
    consumeToken(builder_, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dictionary_expression_6")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "dictionary_expression_6", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ELIF expression COLON
  public static boolean elif_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elif_statement")) return false;
    if (!nextTokenIs(builder_, ELIF)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELIF);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, ELIF_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // ELSE COLON
  public static boolean else_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "else_statement")) return false;
    if (!nextTokenIs(builder_, ELSE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, ELSE, COLON);
    exit_section_(builder_, marker_, ELSE_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // id (EQUAL expression)?
  public static boolean enum_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_entry")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENUM_ENTRY, "<enum entry>");
    result_ = id(builder_, level_ + 1);
    result_ = result_ && enum_entry_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (EQUAL expression)?
  private static boolean enum_entry_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_entry_1")) return false;
    enum_entry_1_0(builder_, level_ + 1);
    return true;
  }

  // EQUAL expression
  private static boolean enum_entry_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_entry_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUAL);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ENUM id? (L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE)?
  public static boolean enum_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement")) return false;
    if (!nextTokenIs(builder_, ENUM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ENUM);
    result_ = result_ && enum_statement_1(builder_, level_ + 1);
    result_ = result_ && enum_statement_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, ENUM_STATEMENT, result_);
    return result_;
  }

  // id?
  private static boolean enum_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_1")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // (L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE)?
  private static boolean enum_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2")) return false;
    enum_statement_2_0(builder_, level_ + 1);
    return true;
  }

  // L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  private static boolean enum_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACE);
    result_ = result_ && enum_statement_2_0_1(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_2(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_3(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_4(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_5(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_1", pos_)) break;
    }
    return true;
  }

  // enum_entry?
  private static boolean enum_statement_2_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_2")) return false;
    enum_entry(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_3", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* enum_entry LINE_BREAK*)*
  private static boolean enum_statement_2_0_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!enum_statement_2_0_4_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_4", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* enum_entry LINE_BREAK*
  private static boolean enum_statement_2_0_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && enum_statement_2_0_4_0_1(builder_, level_ + 1);
    result_ = result_ && enum_entry(builder_, level_ + 1);
    result_ = result_ && enum_statement_2_0_4_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_4_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_4_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_4_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_4_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_4_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_4_0_3", pos_)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean enum_statement_2_0_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_5")) return false;
    consumeToken(builder_, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_statement_2_0_6")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_statement_2_0_6", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // AT_EXPORT
  //     | AT_EXPORT_ENUM
  //     | AT_EXPORT_FILE
  //     | AT_EXPORT_DIR
  //     | AT_EXPORT_GLOBAL_FILE
  //     | AT_EXPORT_GLOBAL_DIR
  //     | AT_EXPORT_MULTILINE
  //     | AT_EXPORT_PLACEHOLDER
  //     | AT_EXPORT_RANGE
  //     | AT_EXPORT_EXP_EASING
  //     | AT_EXPORT_COLOR_NO_ALPHA
  //     | AT_EXPORT_NODE_PATH
  //     | AT_EXPORT_FLAGS
  //     | AT_EXPORT_FLAGS_2D_RENDER
  //     | AT_EXPORT_FLAGS_2D_PHYSICS
  //     | AT_EXPORT_FLAGS_2D_NAVIGATION
  //     | AT_EXPORT_FLAGS_3D_RENDER
  //     | AT_EXPORT_FLAGS_3D_PHYSICS
  //     | AT_EXPORT_FLAGS_3D_NAVIGATION
  //     | AT_EXPORT_TOOL_BUTTON
  static boolean export_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "export_annotation")) return false;
    boolean result_;
    result_ = consumeToken(builder_, AT_EXPORT);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_ENUM);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FILE);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_DIR);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_GLOBAL_FILE);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_GLOBAL_DIR);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_MULTILINE);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_PLACEHOLDER);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_RANGE);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_EXP_EASING);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_COLOR_NO_ALPHA);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_NODE_PATH);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_2D_RENDER);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_2D_PHYSICS);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_2D_NAVIGATION);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_3D_RENDER);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_3D_PHYSICS);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_FLAGS_3D_NAVIGATION);
    if (!result_) result_ = consumeToken(builder_, AT_EXPORT_TOOL_BUTTON);
    return result_;
  }

  /* ********************************************************** */
  // (operand | operator)+
  public static boolean expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION, "<expression>");
    result_ = expression_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!expression_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "expression", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // operand | operator
  private static boolean expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_0")) return false;
    boolean result_;
    result_ = operand(builder_, level_ + 1);
    if (!result_) result_ = operator(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // expression
  public static boolean expression_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    result_ = expression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // EXTENDS (type | string) (DOT IDENTIFIER)*
  public static boolean extends_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extends_statement")) return false;
    if (!nextTokenIs(builder_, EXTENDS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && extends_statement_1(builder_, level_ + 1);
    result_ = result_ && extends_statement_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, EXTENDS_STATEMENT, result_);
    return result_;
  }

  // type | string
  private static boolean extends_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extends_statement_1")) return false;
    boolean result_;
    result_ = type(builder_, level_ + 1);
    if (!result_) result_ = string(builder_, level_ + 1);
    return result_;
  }

  // (DOT IDENTIFIER)*
  private static boolean extends_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extends_statement_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!extends_statement_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "extends_statement_2", pos_)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean extends_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extends_statement_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, DOT, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // FOR id IN expression COLON
  public static boolean for_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "for_statement")) return false;
    if (!nextTokenIs(builder_, FOR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FOR);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IN);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, FOR_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // id (COLON type)? ((EQUAL | INFER) expression)?
  public static boolean func_argument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNC_ARGUMENT, "<func argument>");
    result_ = id(builder_, level_ + 1);
    result_ = result_ && func_argument_1(builder_, level_ + 1);
    result_ = result_ && func_argument_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (COLON type)?
  private static boolean func_argument_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument_1")) return false;
    func_argument_1_0(builder_, level_ + 1);
    return true;
  }

  // COLON type
  private static boolean func_argument_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ((EQUAL | INFER) expression)?
  private static boolean func_argument_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument_2")) return false;
    func_argument_2_0(builder_, level_ + 1);
    return true;
  }

  // (EQUAL | INFER) expression
  private static boolean func_argument_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = func_argument_2_0_0(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EQUAL | INFER
  private static boolean func_argument_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_argument_2_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EQUAL);
    if (!result_) result_ = consumeToken(builder_, INFER);
    return result_;
  }

  /* ********************************************************** */
  // warning_annotation* AT_ABSTRACT? STATIC? network_modifier? FUNC id L_PAREN LINE_BREAK* func_argument? LINE_BREAK* (COMMA LINE_BREAK* func_argument LINE_BREAK*)* COMMA? LINE_BREAK* R_PAREN (ARROW type)? COLON?
  public static boolean func_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNC_STATEMENT, "<func statement>");
    result_ = func_statement_0(builder_, level_ + 1);
    result_ = result_ && func_statement_1(builder_, level_ + 1);
    result_ = result_ && func_statement_2(builder_, level_ + 1);
    result_ = result_ && func_statement_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, FUNC);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_PAREN);
    result_ = result_ && func_statement_7(builder_, level_ + 1);
    result_ = result_ && func_statement_8(builder_, level_ + 1);
    result_ = result_ && func_statement_9(builder_, level_ + 1);
    result_ = result_ && func_statement_10(builder_, level_ + 1);
    result_ = result_ && func_statement_11(builder_, level_ + 1);
    result_ = result_ && func_statement_12(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    result_ = result_ && func_statement_14(builder_, level_ + 1);
    result_ = result_ && func_statement_15(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // warning_annotation*
  private static boolean func_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!warning_annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_0", pos_)) break;
    }
    return true;
  }

  // AT_ABSTRACT?
  private static boolean func_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_1")) return false;
    consumeToken(builder_, AT_ABSTRACT);
    return true;
  }

  // STATIC?
  private static boolean func_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_2")) return false;
    consumeToken(builder_, STATIC);
    return true;
  }

  // network_modifier?
  private static boolean func_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_3")) return false;
    network_modifier(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_7")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_7", pos_)) break;
    }
    return true;
  }

  // func_argument?
  private static boolean func_statement_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_8")) return false;
    func_argument(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_9(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_9")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_9", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* func_argument LINE_BREAK*)*
  private static boolean func_statement_10(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_10")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!func_statement_10_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_10", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* func_argument LINE_BREAK*
  private static boolean func_statement_10_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_10_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && func_statement_10_0_1(builder_, level_ + 1);
    result_ = result_ && func_argument(builder_, level_ + 1);
    result_ = result_ && func_statement_10_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean func_statement_10_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_10_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_10_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_10_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_10_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_10_0_3", pos_)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean func_statement_11(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_11")) return false;
    consumeToken(builder_, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_12(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_12")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "func_statement_12", pos_)) break;
    }
    return true;
  }

  // (ARROW type)?
  private static boolean func_statement_14(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_14")) return false;
    func_statement_14_0(builder_, level_ + 1);
    return true;
  }

  // ARROW type
  private static boolean func_statement_14_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_14_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARROW);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLON?
  private static boolean func_statement_15(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "func_statement_15")) return false;
    consumeToken(builder_, COLON);
    return true;
  }

  /* ********************************************************** */
  // AT_EXPORT_CATEGORY annotation_arguments
  //     | AT_EXPORT_GROUP annotation_arguments
  //     | AT_EXPORT_SUBGROUP annotation_arguments
  static boolean group_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "group_annotation")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = group_annotation_0(builder_, level_ + 1);
    if (!result_) result_ = group_annotation_1(builder_, level_ + 1);
    if (!result_) result_ = group_annotation_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AT_EXPORT_CATEGORY annotation_arguments
  private static boolean group_annotation_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "group_annotation_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AT_EXPORT_CATEGORY);
    result_ = result_ && annotation_arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AT_EXPORT_GROUP annotation_arguments
  private static boolean group_annotation_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "group_annotation_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AT_EXPORT_GROUP);
    result_ = result_ && annotation_arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AT_EXPORT_SUBGROUP annotation_arguments
  private static boolean group_annotation_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "group_annotation_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AT_EXPORT_SUBGROUP);
    result_ = result_ && annotation_arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // AT_ICON L_PAREN string R_PAREN
  public static boolean icon_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "icon_statement")) return false;
    if (!nextTokenIs(builder_, AT_ICON)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, AT_ICON, L_PAREN);
    result_ = result_ && string(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, marker_, ICON_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER | INT | FLOAT | BOOL | VOID | NODE_PATH
  public static boolean id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ID, "<id>");
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, BOOL);
    if (!result_) result_ = consumeToken(builder_, VOID);
    if (!result_) result_ = consumeToken(builder_, NODE_PATH);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // IF expression COLON
  public static boolean if_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_statement")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IF);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, IF_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // id? L_PAREN LINE_BREAK* expression? LINE_BREAK* (COMMA LINE_BREAK* expression LINE_BREAK*)* R_PAREN
  public static boolean invocation_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, INVOCATION_EXPRESSION, "<invocation expression>");
    result_ = invocation_expression_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_PAREN);
    result_ = result_ && invocation_expression_2(builder_, level_ + 1);
    result_ = result_ && invocation_expression_3(builder_, level_ + 1);
    result_ = result_ && invocation_expression_4(builder_, level_ + 1);
    result_ = result_ && invocation_expression_5(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // id?
  private static boolean invocation_expression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_0")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "invocation_expression_2", pos_)) break;
    }
    return true;
  }

  // expression?
  private static boolean invocation_expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_3")) return false;
    expression(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "invocation_expression_4", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* expression LINE_BREAK*)*
  private static boolean invocation_expression_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_5")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!invocation_expression_5_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "invocation_expression_5", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* expression LINE_BREAK*
  private static boolean invocation_expression_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_5_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && invocation_expression_5_0_1(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && invocation_expression_5_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_5_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_5_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "invocation_expression_5_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_5_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invocation_expression_5_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "invocation_expression_5_0_3", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression
  public static boolean key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, KEY, "<key>");
    result_ = expression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // FUNC id? L_PAREN id? (COMMA id)* R_PAREN COLON expression
  public static boolean lambda_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression")) return false;
    if (!nextTokenIs(builder_, FUNC)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FUNC);
    result_ = result_ && lambda_expression_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, L_PAREN);
    result_ = result_ && lambda_expression_3(builder_, level_ + 1);
    result_ = result_ && lambda_expression_4(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, R_PAREN, COLON);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, LAMBDA_EXPRESSION, result_);
    return result_;
  }

  // id?
  private static boolean lambda_expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression_1")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // id?
  private static boolean lambda_expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression_3")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // (COMMA id)*
  private static boolean lambda_expression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!lambda_expression_4_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "lambda_expression_4", pos_)) break;
    }
    return true;
  }

  // COMMA id
  private static boolean lambda_expression_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (key EQUAL expression) | DOT_DOT
  public static boolean lua_dictionary_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_entry")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LUA_DICTIONARY_ENTRY, "<lua dictionary entry>");
    result_ = lua_dictionary_entry_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, DOT_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // key EQUAL expression
  private static boolean lua_dictionary_entry_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_entry_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = key(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQUAL);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // L_BRACE LINE_BREAK* lua_dictionary_entry? LINE_BREAK* (COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  public static boolean lua_dictionary_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression")) return false;
    if (!nextTokenIs(builder_, L_BRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_BRACE);
    result_ = result_ && lua_dictionary_expression_1(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_2(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_3(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_4(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_5(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_BRACE);
    exit_section_(builder_, marker_, LUA_DICTIONARY_EXPRESSION, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_1", pos_)) break;
    }
    return true;
  }

  // lua_dictionary_entry?
  private static boolean lua_dictionary_expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_2")) return false;
    lua_dictionary_entry(builder_, level_ + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_3", pos_)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*)*
  private static boolean lua_dictionary_expression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!lua_dictionary_expression_4_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_4", pos_)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && lua_dictionary_expression_4_0_1(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_entry(builder_, level_ + 1);
    result_ = result_ && lua_dictionary_expression_4_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_4_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_4_0_1", pos_)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_4_0_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_4_0_3", pos_)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean lua_dictionary_expression_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_5")) return false;
    consumeToken(builder_, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_dictionary_expression_6")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_dictionary_expression_6", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (expression (WHEN expression)?) | UNDERSCORE
  public static boolean match_label_argument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_argument")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MATCH_LABEL_ARGUMENT, "<match label argument>");
    result_ = match_label_argument_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, UNDERSCORE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // expression (WHEN expression)?
  private static boolean match_label_argument_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_argument_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = expression(builder_, level_ + 1);
    result_ = result_ && match_label_argument_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (WHEN expression)?
  private static boolean match_label_argument_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_argument_0_1")) return false;
    match_label_argument_0_1_0(builder_, level_ + 1);
    return true;
  }

  // WHEN expression
  private static boolean match_label_argument_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_argument_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, WHEN);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // match_label_argument (COMMA match_label_argument)* COLON
  public static boolean match_label_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MATCH_LABEL_STATEMENT, "<match label statement>");
    result_ = match_label_argument(builder_, level_ + 1);
    result_ = result_ && match_label_statement_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (COMMA match_label_argument)*
  private static boolean match_label_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_statement_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!match_label_statement_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "match_label_statement_1", pos_)) break;
    }
    return true;
  }

  // COMMA match_label_argument
  private static boolean match_label_statement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_label_statement_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && match_label_argument(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // MATCH expression COLON
  public static boolean match_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "match_statement")) return false;
    if (!nextTokenIs(builder_, MATCH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MATCH);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, MATCH_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // MULTILINE_SINGLE_QUOTED_STRING | MULTILINE_DOUBLE_QUOTED_STRING
  static boolean multiline_string(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_string")) return false;
    if (!nextTokenIs(builder_, "", MULTILINE_DOUBLE_QUOTED_STRING, MULTILINE_SINGLE_QUOTED_STRING)) return false;
    boolean result_;
    result_ = consumeToken(builder_, MULTILINE_SINGLE_QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, MULTILINE_DOUBLE_QUOTED_STRING);
    return result_;
  }

  /* ********************************************************** */
  // id (DOT id)*
  static boolean nested_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nested_type")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = id(builder_, level_ + 1);
    result_ = result_ && nested_type_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (DOT id)*
  private static boolean nested_type_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nested_type_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!nested_type_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "nested_type_1", pos_)) break;
    }
    return true;
  }

  // DOT id
  private static boolean nested_type_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nested_type_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // MASTER
  //     | SYNC
  //     | PUPPET
  //     | REMOTE
  //     | MASTERSYNC
  //     | PUPPETSYNC
  //     | REMOTESYNC
  //     | AT_MASTER
  //     | AT_PUPPET
  //     | AT_REMOTE
  //     | AT_MASTERSYNC
  //     | AT_PUPPETSYNC
  //     | AT_REMOTESYNC
  static boolean network_modifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "network_modifier")) return false;
    boolean result_;
    result_ = consumeToken(builder_, MASTER);
    if (!result_) result_ = consumeToken(builder_, SYNC);
    if (!result_) result_ = consumeToken(builder_, PUPPET);
    if (!result_) result_ = consumeToken(builder_, REMOTE);
    if (!result_) result_ = consumeToken(builder_, MASTERSYNC);
    if (!result_) result_ = consumeToken(builder_, PUPPETSYNC);
    if (!result_) result_ = consumeToken(builder_, REMOTESYNC);
    if (!result_) result_ = consumeToken(builder_, AT_MASTER);
    if (!result_) result_ = consumeToken(builder_, AT_PUPPET);
    if (!result_) result_ = consumeToken(builder_, AT_REMOTE);
    if (!result_) result_ = consumeToken(builder_, AT_MASTERSYNC);
    if (!result_) result_ = consumeToken(builder_, AT_PUPPETSYNC);
    if (!result_) result_ = consumeToken(builder_, AT_REMOTESYNC);
    return result_;
  }

  /* ********************************************************** */
  // var_statement
  //     | const_statement
  //     | extends_statement
  //     | enum_statement
  //     | tool_statement
  //     | icon_statement
  //     | return_statement
  //     | signal_statement
  //     | classname_statement
  //     | assert_statement
  //     | await_statement
  //     | yield_statement
  //     | assign_statement
  //     | expression_statement
  //     | PASS
  //     | BREAK
  //     | CONTINUE
  //     | BREAKPOINT
  //     | annotation_statement
  static boolean non_colon_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "non_colon_statement")) return false;
    boolean result_;
    result_ = var_statement(builder_, level_ + 1);
    if (!result_) result_ = const_statement(builder_, level_ + 1);
    if (!result_) result_ = extends_statement(builder_, level_ + 1);
    if (!result_) result_ = enum_statement(builder_, level_ + 1);
    if (!result_) result_ = tool_statement(builder_, level_ + 1);
    if (!result_) result_ = icon_statement(builder_, level_ + 1);
    if (!result_) result_ = return_statement(builder_, level_ + 1);
    if (!result_) result_ = signal_statement(builder_, level_ + 1);
    if (!result_) result_ = classname_statement(builder_, level_ + 1);
    if (!result_) result_ = assert_statement(builder_, level_ + 1);
    if (!result_) result_ = await_statement(builder_, level_ + 1);
    if (!result_) result_ = yield_statement(builder_, level_ + 1);
    if (!result_) result_ = assign_statement(builder_, level_ + 1);
    if (!result_) result_ = expression_statement(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, PASS);
    if (!result_) result_ = consumeToken(builder_, BREAK);
    if (!result_) result_ = consumeToken(builder_, CONTINUE);
    if (!result_) result_ = consumeToken(builder_, BREAKPOINT);
    if (!result_) result_ = annotation_statement(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // array_expression
  //     | dictionary_expression
  //     | lua_dictionary_expression
  //     | invocation_expression
  //     | lambda_expression
  //     | string
  //     | multiline_string
  //     | id
  //     | REAL_NUMBER
  //     | BINARY_NUMBER
  //     | HEXADECIMAL_NUMBER
  //     | TRUE
  //     | FALSE
  //     | NULL
  //     | SELF
  static boolean operand(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operand")) return false;
    boolean result_;
    result_ = array_expression(builder_, level_ + 1);
    if (!result_) result_ = dictionary_expression(builder_, level_ + 1);
    if (!result_) result_ = lua_dictionary_expression(builder_, level_ + 1);
    if (!result_) result_ = invocation_expression(builder_, level_ + 1);
    if (!result_) result_ = lambda_expression(builder_, level_ + 1);
    if (!result_) result_ = string(builder_, level_ + 1);
    if (!result_) result_ = multiline_string(builder_, level_ + 1);
    if (!result_) result_ = id(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, REAL_NUMBER);
    if (!result_) result_ = consumeToken(builder_, BINARY_NUMBER);
    if (!result_) result_ = consumeToken(builder_, HEXADECIMAL_NUMBER);
    if (!result_) result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    if (!result_) result_ = consumeToken(builder_, NULL);
    if (!result_) result_ = consumeToken(builder_, SELF);
    return result_;
  }

  /* ********************************************************** */
  // LESS
  //     | LESS_EQUAL
  //     | GREATER
  //     | GREATER_EQUAL
  //     | EQUAL_EQUAL
  //     | BANG_EQUAL
  //     | AMPERSAND_AMPERSAND
  //     | PIPE_PIPE
  //     | BANG
  //     | AMPERSAND
  //     | PIPE
  //     | TILDE
  //     | CARET
  //     | LESS_LESS
  //     | GREATER_GREATER
  //     | PLUS
  //     | MINUS
  //     | STAR
  //     | SLASH
  //     | PERCENT
  //     | DOT
  //     | DOT_DOT
  //     | IS
  //     | AS
  //     | IN
  //     | AND
  //     | OR
  //     | NOT
  //     | IF
  //     | ELSE
  static boolean operator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operator")) return false;
    boolean result_;
    result_ = consumeToken(builder_, LESS);
    if (!result_) result_ = consumeToken(builder_, LESS_EQUAL);
    if (!result_) result_ = consumeToken(builder_, GREATER);
    if (!result_) result_ = consumeToken(builder_, GREATER_EQUAL);
    if (!result_) result_ = consumeToken(builder_, EQUAL_EQUAL);
    if (!result_) result_ = consumeToken(builder_, BANG_EQUAL);
    if (!result_) result_ = consumeToken(builder_, AMPERSAND_AMPERSAND);
    if (!result_) result_ = consumeToken(builder_, PIPE_PIPE);
    if (!result_) result_ = consumeToken(builder_, BANG);
    if (!result_) result_ = consumeToken(builder_, AMPERSAND);
    if (!result_) result_ = consumeToken(builder_, PIPE);
    if (!result_) result_ = consumeToken(builder_, TILDE);
    if (!result_) result_ = consumeToken(builder_, CARET);
    if (!result_) result_ = consumeToken(builder_, LESS_LESS);
    if (!result_) result_ = consumeToken(builder_, GREATER_GREATER);
    if (!result_) result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    if (!result_) result_ = consumeToken(builder_, STAR);
    if (!result_) result_ = consumeToken(builder_, SLASH);
    if (!result_) result_ = consumeToken(builder_, PERCENT);
    if (!result_) result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = consumeToken(builder_, DOT_DOT);
    if (!result_) result_ = consumeToken(builder_, IS);
    if (!result_) result_ = consumeToken(builder_, AS);
    if (!result_) result_ = consumeToken(builder_, IN);
    if (!result_) result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, OR);
    if (!result_) result_ = consumeToken(builder_, NOT);
    if (!result_) result_ = consumeToken(builder_, IF);
    if (!result_) result_ = consumeToken(builder_, ELSE);
    return result_;
  }

  /* ********************************************************** */
  // RETURN expression?
  public static boolean return_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "return_statement")) return false;
    if (!nextTokenIs(builder_, RETURN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RETURN);
    result_ = result_ && return_statement_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, RETURN_STATEMENT, result_);
    return result_;
  }

  // expression?
  private static boolean return_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "return_statement_1")) return false;
    expression(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // statement*
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "root", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SIGNAL id (L_PAREN id? (COMMA id)* R_PAREN)?
  public static boolean signal_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement")) return false;
    if (!nextTokenIs(builder_, SIGNAL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SIGNAL);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && signal_statement_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, SIGNAL_STATEMENT, result_);
    return result_;
  }

  // (L_PAREN id? (COMMA id)* R_PAREN)?
  private static boolean signal_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement_2")) return false;
    signal_statement_2_0(builder_, level_ + 1);
    return true;
  }

  // L_PAREN id? (COMMA id)* R_PAREN
  private static boolean signal_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_PAREN);
    result_ = result_ && signal_statement_2_0_1(builder_, level_ + 1);
    result_ = result_ && signal_statement_2_0_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // id?
  private static boolean signal_statement_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement_2_0_1")) return false;
    id(builder_, level_ + 1);
    return true;
  }

  // (COMMA id)*
  private static boolean signal_statement_2_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement_2_0_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!signal_statement_2_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "signal_statement_2_0_2", pos_)) break;
    }
    return true;
  }

  // COMMA id
  private static boolean signal_statement_2_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "signal_statement_2_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (colon_statement LINE_BREAK?) | (non_colon_statement (LINE_BREAK | <<eof>> | SEMICOLON+)) | LINE_BREAK
  static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = statement_0(builder_, level_ + 1);
    if (!result_) result_ = statement_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, LINE_BREAK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // colon_statement LINE_BREAK?
  private static boolean statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = colon_statement(builder_, level_ + 1);
    result_ = result_ && statement_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK?
  private static boolean statement_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_0_1")) return false;
    consumeToken(builder_, LINE_BREAK);
    return true;
  }

  // non_colon_statement (LINE_BREAK | <<eof>> | SEMICOLON+)
  private static boolean statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = non_colon_statement(builder_, level_ + 1);
    result_ = result_ && statement_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LINE_BREAK | <<eof>> | SEMICOLON+
  private static boolean statement_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LINE_BREAK);
    if (!result_) result_ = eof(builder_, level_ + 1);
    if (!result_) result_ = statement_1_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SEMICOLON+
  private static boolean statement_1_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1_1_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SEMICOLON);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, SEMICOLON)) break;
      if (!empty_element_parsed_guard_(builder_, "statement_1_1_2", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING
  public static boolean string(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string")) return false;
    if (!nextTokenIs(builder_, "<string>", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STRING, "<string>");
    result_ = consumeToken(builder_, SINGLE_QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, DOUBLE_QUOTED_STRING);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TOOL | AT_TOOL
  public static boolean tool_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tool_statement")) return false;
    if (!nextTokenIs(builder_, "<tool statement>", AT_TOOL, TOOL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TOOL_STATEMENT, "<tool statement>");
    result_ = consumeToken(builder_, TOOL);
    if (!result_) result_ = consumeToken(builder_, AT_TOOL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // array_type | nested_type
  public static boolean type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPE, "<type>");
    result_ = array_type(builder_, level_ + 1);
    if (!result_) result_ = nested_type(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (EXPORT | export_annotation) (L_PAREN expression? (COMMA expression)* R_PAREN)?
  public static boolean var_export(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VAR_EXPORT, "<var export>");
    result_ = var_export_0(builder_, level_ + 1);
    result_ = result_ && var_export_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // EXPORT | export_annotation
  private static boolean var_export_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EXPORT);
    if (!result_) result_ = export_annotation(builder_, level_ + 1);
    return result_;
  }

  // (L_PAREN expression? (COMMA expression)* R_PAREN)?
  private static boolean var_export_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_1")) return false;
    var_export_1_0(builder_, level_ + 1);
    return true;
  }

  // L_PAREN expression? (COMMA expression)* R_PAREN
  private static boolean var_export_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, L_PAREN);
    result_ = result_ && var_export_1_0_1(builder_, level_ + 1);
    result_ = result_ && var_export_1_0_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, R_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression?
  private static boolean var_export_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_1_0_1")) return false;
    expression(builder_, level_ + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean var_export_1_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_1_0_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!var_export_1_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "var_export_1_0_2", pos_)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean var_export_1_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_export_1_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // id
  public static boolean var_getter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_getter")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VAR_GETTER, "<var getter>");
    result_ = id(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // id
  public static boolean var_setter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_setter")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VAR_SETTER, "<var setter>");
    result_ = id(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (warning_annotation | group_annotation)* var_export? (ONREADY | AT_ONREADY)? network_modifier? VAR id (COLON type)? ((EQUAL | INFER) expression)?
  //     (SETGET var_setter? (COMMA var_getter)?)?
  public static boolean var_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VAR_STATEMENT, "<var statement>");
    result_ = var_statement_0(builder_, level_ + 1);
    result_ = result_ && var_statement_1(builder_, level_ + 1);
    result_ = result_ && var_statement_2(builder_, level_ + 1);
    result_ = result_ && var_statement_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VAR);
    result_ = result_ && id(builder_, level_ + 1);
    result_ = result_ && var_statement_6(builder_, level_ + 1);
    result_ = result_ && var_statement_7(builder_, level_ + 1);
    result_ = result_ && var_statement_8(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (warning_annotation | group_annotation)*
  private static boolean var_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!var_statement_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "var_statement_0", pos_)) break;
    }
    return true;
  }

  // warning_annotation | group_annotation
  private static boolean var_statement_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_0_0")) return false;
    boolean result_;
    result_ = warning_annotation(builder_, level_ + 1);
    if (!result_) result_ = group_annotation(builder_, level_ + 1);
    return result_;
  }

  // var_export?
  private static boolean var_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_1")) return false;
    var_export(builder_, level_ + 1);
    return true;
  }

  // (ONREADY | AT_ONREADY)?
  private static boolean var_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_2")) return false;
    var_statement_2_0(builder_, level_ + 1);
    return true;
  }

  // ONREADY | AT_ONREADY
  private static boolean var_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_2_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, ONREADY);
    if (!result_) result_ = consumeToken(builder_, AT_ONREADY);
    return result_;
  }

  // network_modifier?
  private static boolean var_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_3")) return false;
    network_modifier(builder_, level_ + 1);
    return true;
  }

  // (COLON type)?
  private static boolean var_statement_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_6")) return false;
    var_statement_6_0(builder_, level_ + 1);
    return true;
  }

  // COLON type
  private static boolean var_statement_6_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_6_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ((EQUAL | INFER) expression)?
  private static boolean var_statement_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_7")) return false;
    var_statement_7_0(builder_, level_ + 1);
    return true;
  }

  // (EQUAL | INFER) expression
  private static boolean var_statement_7_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_7_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = var_statement_7_0_0(builder_, level_ + 1);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EQUAL | INFER
  private static boolean var_statement_7_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_7_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EQUAL);
    if (!result_) result_ = consumeToken(builder_, INFER);
    return result_;
  }

  // (SETGET var_setter? (COMMA var_getter)?)?
  private static boolean var_statement_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_8")) return false;
    var_statement_8_0(builder_, level_ + 1);
    return true;
  }

  // SETGET var_setter? (COMMA var_getter)?
  private static boolean var_statement_8_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_8_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SETGET);
    result_ = result_ && var_statement_8_0_1(builder_, level_ + 1);
    result_ = result_ && var_statement_8_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // var_setter?
  private static boolean var_statement_8_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_8_0_1")) return false;
    var_setter(builder_, level_ + 1);
    return true;
  }

  // (COMMA var_getter)?
  private static boolean var_statement_8_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_8_0_2")) return false;
    var_statement_8_0_2_0(builder_, level_ + 1);
    return true;
  }

  // COMMA var_getter
  private static boolean var_statement_8_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_statement_8_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && var_getter(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (AT_WARNING_IGNORE | AT_WARNING_IGNORE_START | AT_WARNING_IGNORE_RESTORE) annotation_arguments
  static boolean warning_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "warning_annotation")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = warning_annotation_0(builder_, level_ + 1);
    result_ = result_ && annotation_arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AT_WARNING_IGNORE | AT_WARNING_IGNORE_START | AT_WARNING_IGNORE_RESTORE
  private static boolean warning_annotation_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "warning_annotation_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, AT_WARNING_IGNORE);
    if (!result_) result_ = consumeToken(builder_, AT_WARNING_IGNORE_START);
    if (!result_) result_ = consumeToken(builder_, AT_WARNING_IGNORE_RESTORE);
    return result_;
  }

  /* ********************************************************** */
  // WHILE expression COLON
  public static boolean while_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "while_statement")) return false;
    if (!nextTokenIs(builder_, WHILE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, WHILE);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, WHILE_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // YIELD expression
  public static boolean yield_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "yield_statement")) return false;
    if (!nextTokenIs(builder_, YIELD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, YIELD);
    result_ = result_ && expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, YIELD_STATEMENT, result_);
    return result_;
  }

}

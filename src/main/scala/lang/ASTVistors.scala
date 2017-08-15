package uclid
package lang

abstract class ASTAnalysis {
  var _manager : Option[PassManager] = None
  def manager : PassManager = { _manager.get }
  
  def passName : String
  def reset() {}
  def visit (module : Module) : Option[Module]
  def astChanged : Boolean
  def iteratedApply = false
}

object TraversalDirection extends Enumeration {
  type T = Value
  val Up, Down = Value
}

/* AST visitor that walks through the AST and collects information. */
trait ReadOnlyPass[T] {
  var _analysis : Option[ASTAnalysis] = None
  def analysis : ASTAnalysis = _analysis.get
  def reset() {}
  
  def applyOnModule(d : TraversalDirection.T, module : Module, in : T, context : ScopeMap) : T = { in }
  def applyOnDecl(d : TraversalDirection.T, decl : Decl, in : T, context : ScopeMap) : T = { in }
  def applyOnProcedure(d : TraversalDirection.T, proc : ProcedureDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnFunction(d : TraversalDirection.T, func : FunctionDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnStateVar(d : TraversalDirection.T, stvar : StateVarDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnInputVar(d : TraversalDirection.T, inpvar : InputVarDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnOutputVar(d : TraversalDirection.T, outvar : OutputVarDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnConstant(d : TraversalDirection.T, cnst : ConstantDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnSpec(d : TraversalDirection.T, spec : SpecDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnTypeDecl(d : TraversalDirection.T, typDec : TypeDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnInit(d : TraversalDirection.T, init : InitDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnNext(d : TraversalDirection.T, next : NextDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnType(d : TraversalDirection.T, typ: Type, in : T, context : ScopeMap) : T = { in }
  def applyOnTemporalType(d : TraversalDirection.T, tempT : TemporalType, in : T, context : ScopeMap) : T = { in }
  def applyOnBoolType(d : TraversalDirection.T, boolT : BoolType, in : T, context : ScopeMap) : T = { in }
  def applyOnIntType(d : TraversalDirection.T, intT : IntType, in : T, context : ScopeMap) : T = { in }
  def applyOnBitVectorType(d : TraversalDirection.T, bvT : BitVectorType, in : T, context : ScopeMap) : T = { in }
  def applyOnEnumType(d : TraversalDirection.T, enumT : EnumType, in : T, context : ScopeMap) : T = { in }
  def applyOnTupleType(d : TraversalDirection.T, tupleT : TupleType, in : T, context : ScopeMap) : T = { in }
  def applyOnRecordType(d : TraversalDirection.T, recordT : RecordType, in : T, context : ScopeMap) : T = { in }
  def applyOnMapType(d : TraversalDirection.T, mapT : MapType, in : T, context : ScopeMap) : T = { in }
  def applyOnArrayType(d : TraversalDirection.T, arrayT : ArrayType, in : T, context : ScopeMap) : T = { in }
  def applyOnSynonymType(d : TraversalDirection.T, synT : SynonymType, in : T, context : ScopeMap) : T = { in }
  def applyOnProcedureSig(d : TraversalDirection.T, sig : ProcedureSig, in : T, context : ScopeMap) : T = { in }
  def applyOnFunctionSig(d : TraversalDirection.T, sig : FunctionSig, in : T, context : ScopeMap) : T = { in }
  def applyOnLocalVar(d : TraversalDirection.T, lvar : LocalVarDecl, in : T, context : ScopeMap) : T = { in }
  def applyOnStatement(d : TraversalDirection.T, st : Statement, in : T, context : ScopeMap) : T = { in }
  def applyOnSkip(d : TraversalDirection.T, st : SkipStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnAssert(d : TraversalDirection.T, st : AssertStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnAssume(d : TraversalDirection.T, st : AssumeStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnHavoc(d : TraversalDirection.T, st : HavocStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnAssign(d : TraversalDirection.T, st : AssignStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnIfElse(d : TraversalDirection.T, st : IfElseStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnFor(d : TraversalDirection.T, st : ForStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnCase(d : TraversalDirection.T, st : CaseStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnProcedureCall(d : TraversalDirection.T, st : ProcedureCallStmt, in : T, context : ScopeMap) : T = { in }
  def applyOnLHS(d : TraversalDirection.T, lhs : Lhs, in : T, context : ScopeMap) : T = { in }
  def applyOnExpr(d : TraversalDirection.T, e : Expr, in : T, context : ScopeMap) : T = { in }
  def applyOnIdentifier(d : TraversalDirection.T, id : Identifier, in : T, context : ScopeMap) : T = { in }
  def applyOnLit(d : TraversalDirection.T, lit : Literal, in : T, context : ScopeMap) : T = { in }
  def applyOnBoolLit(d : TraversalDirection.T, b : BoolLit, in : T, context : ScopeMap) : T = { in }
  def applyOnIntLit(d : TraversalDirection.T, i : IntLit, in : T, context : ScopeMap) : T = { in }
  def applyOnBitVectorLit(d : TraversalDirection.T, bv : BitVectorLit, in : T, context : ScopeMap) : T = { in }
  def applyOnTuple(d : TraversalDirection.T, rec : Tuple, in : T, context : ScopeMap) : T = { in }
  def applyOnOperatorApp(d : TraversalDirection.T, opapp : OperatorApplication, in : T, context : ScopeMap) : T = { in }
  def applyOnOperator(d : TraversalDirection.T, op : Operator, in : T, context : ScopeMap) : T = { in }
  def applyOnArraySelect(d : TraversalDirection.T, arrSel : ArraySelectOperation, in : T, context : ScopeMap) : T = { in }
  def applyOnArrayStore(d : TraversalDirection.T, arrStore : ArrayStoreOperation, in : T, context : ScopeMap) : T = { in }
  def applyOnFuncApp(d : TraversalDirection.T, fapp : FuncApplication, in : T, context : ScopeMap) : T = { in }
  def applyOnITE(d : TraversalDirection.T, ite : ITE, in : T, context : ScopeMap) : T = { in }
  def applyOnLambda(d : TraversalDirection.T, lambda : Lambda, in : T, context : ScopeMap) : T = { in }
  def applyOnCmd(d : TraversalDirection.T, cmd : UclCmd, in : T, context : ScopeMap) : T = { in }
}

class ASTAnalyzer[T] (_passName : String, _pass: ReadOnlyPass[T]) extends ASTAnalysis {
  // Set a backpointer to the pass from here.
  _pass._analysis = Some(this)

  /** The pass itself. */
  def pass : ReadOnlyPass[T] = _pass
  /** The input/outputs of the pass. */
  private[this] var _in : Option[T] = None
  private[this] var _out : Option[T] = None
  /** The pseudo-variable 'in' sets the input to the analysis. */
  def in : Option[T] = _in
  def in_=(i : Option[T]): Unit = {
    _in = i
    _out = None
  }
  /** out contains the result of the analysis. */
  def out : Option[T] = _out
  /** Name of the pass. */
  override def passName = _passName
  /** The main 'do-er' method. */
  override def visit(module : Module) : Option[Module] = {
    _out = Some(visitModule(module, _in.get))
    return Some(module)
  }
  /** These analyses never change the AST. */
  override def astChanged = false

  // Reset calls reset on the pass.
  override  def reset() = { pass.reset() }
  
  // We now have the code that actually traverses the AST.
  def visitModule(module : Module, in : T) : T = {
    var result : T = in
    val emptyContext = new ScopeMap()
    val context = emptyContext + module

    result = pass.applyOnModule(TraversalDirection.Down, module, result, emptyContext)
    result = visitIdentifier(module.id, result, context)
    result = module.decls.foldLeft(result)((acc, i) => visitDecl(i, acc, context))
    result = module.cmds.foldLeft(result)((acc, i) => visitCmd(i, acc, context))
    result = pass.applyOnModule(TraversalDirection.Up, module, result, emptyContext)
    return result
  }
  def visitDecl(decl : Decl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnDecl(TraversalDirection.Down, decl, result, context)
    result = decl match {
      case ProcedureDecl(id, sig, vars, body) => visitProcedure(decl.asInstanceOf[ProcedureDecl], result, context)
      case TypeDecl(id, typ) => visitTypeDecl(decl.asInstanceOf[TypeDecl], result, context)
      case StateVarDecl(id, typ) => visitStateVar(decl.asInstanceOf[StateVarDecl], result, context)
      case InputVarDecl(id, typ) => visitInputVar(decl.asInstanceOf[InputVarDecl], result, context)
      case OutputVarDecl(id, typ) => visitOutputVar(decl.asInstanceOf[OutputVarDecl], result, context)
      case ConstantDecl(id, typ) => visitConstant(decl.asInstanceOf[ConstantDecl], result, context)
      case FunctionDecl(id, sig) => visitFunction(decl.asInstanceOf[FunctionDecl], result, context)
      case InitDecl(body) => visitInit(decl.asInstanceOf[InitDecl], result, context)
      case NextDecl(body) => visitNext(decl.asInstanceOf[NextDecl], result, context)
      case SpecDecl(id, expr) => visitSpec(decl.asInstanceOf[SpecDecl], result, context)
    }
    result = pass.applyOnDecl(TraversalDirection.Up, decl, result, context)
    return result
  }
  def visitProcedure(proc : ProcedureDecl, in : T, contextIn : ScopeMap) : T = {
    var result : T = in
    val context = contextIn + proc
    result = pass.applyOnProcedure(TraversalDirection.Down, proc, result, contextIn)
    result = visitIdentifier(proc.id, result, context)
    result = visitProcedureSig(proc.sig, result, context)
    result = proc.decls.foldLeft(result)((acc, i) => visitLocalVar(i, acc, context))
    result = proc.body.foldLeft(result)((acc, i) => visitStatement(i, acc, context))
    result = pass.applyOnProcedure(TraversalDirection.Up, proc, result, contextIn)
    return result
  }
  def visitFunction(func : FunctionDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnFunction(TraversalDirection.Down, func, result, context)
    result = visitIdentifier(func.id, result, context)
    result = visitFunctionSig(func.sig, result, context)
    result = pass.applyOnFunction(TraversalDirection.Up, func, result, context)
    return result
  }
  def visitStateVar(stvar : StateVarDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnStateVar(TraversalDirection.Down, stvar, result, context)
    result = visitIdentifier(stvar.id, result, context)
    result = visitType(stvar.typ, result, context)
    result = pass.applyOnStateVar(TraversalDirection.Up, stvar, result, context)
    return result
  }
  def visitInputVar(inpvar : InputVarDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnInputVar(TraversalDirection.Down, inpvar, result, context)
    result = visitIdentifier(inpvar.id, result, context)
    result = visitType(inpvar.typ, result, context)
    result = pass.applyOnInputVar(TraversalDirection.Up, inpvar, result, context)
    return result
  }
  def visitOutputVar(outvar : OutputVarDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnOutputVar(TraversalDirection.Down, outvar, result, context)
    result = visitIdentifier(outvar.id, result, context)
    result = visitType(outvar.typ, result, context)
    result = pass.applyOnOutputVar(TraversalDirection.Up, outvar, result, context)
    return result
  }
  def visitConstant(cnst : ConstantDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnConstant(TraversalDirection.Down, cnst, result, context)
    result = visitIdentifier(cnst.id, result, context)
    result = visitType(cnst.typ, result, context)
    result = pass.applyOnConstant(TraversalDirection.Up, cnst, result, context)
    return result
  }
  def visitSpec(spec : SpecDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnSpec(TraversalDirection.Down, spec, result, context)
    result = visitIdentifier(spec.id, result, context)
    result = visitExpr(spec.expr, result, context)
    result = pass.applyOnSpec(TraversalDirection.Up, spec, result, context)
    return result
  }
  def visitTypeDecl(typDec : TypeDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnTypeDecl(TraversalDirection.Down, typDec, result, context)
    result = visitIdentifier(typDec.id, result, context)
    result = visitType(typDec.typ, result, context)
    result = pass.applyOnTypeDecl(TraversalDirection.Up, typDec, result, context)
    return result
  }
  def visitInit(init : InitDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnInit(TraversalDirection.Down, init, result, context)
    result = init.body.foldLeft(result)((acc, i) => visitStatement(i, acc, context))
    result = pass.applyOnInit(TraversalDirection.Up, init, result, context)
    return result
  }
  def visitNext(next : NextDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnNext(TraversalDirection.Down, next, result, context)
    result = next.body.foldLeft(result)((acc, i) => visitStatement(i, acc, context))
    result = pass.applyOnNext(TraversalDirection.Up, next, result, context)
    return result
  }
  def visitCmd(cmd : UclCmd, in : T, context : ScopeMap) : T = {
    val result : T = in
    return pass.applyOnCmd(TraversalDirection.Down, cmd, result, context)
    return pass.applyOnCmd(TraversalDirection.Up, cmd, result, context)
  }

  def visitType(typ: Type, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnType(TraversalDirection.Down, typ, result, context)
    result = typ match {
      case tempT : TemporalType => visitTemporalType(tempT, in, context)
      case boolT : BoolType => visitBoolType(boolT, in, context)
      case intT : IntType => visitIntType(intT, in, context)
      case bvT : BitVectorType => visitBitVectorType(bvT, in, context)
      case enumT : EnumType => visitEnumType(enumT, in, context)
      case tupleT : TupleType => visitTupleType(tupleT, in, context)
      case recT : RecordType => visitRecordType(recT, in, context)
      case mapT : MapType => visitMapType(mapT, in, context)
      case arrT : ArrayType => visitArrayType(arrT, in, context)
      case synT : SynonymType => visitSynonymType(synT, in, context)
    }
    result = pass.applyOnType(TraversalDirection.Up, typ, result, context)
    return result
  }
  def visitTemporalType(tempT : TemporalType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnTemporalType(TraversalDirection.Down, tempT, result, context)
    result = pass.applyOnTemporalType(TraversalDirection.Up, tempT, result, context)
    return result
  }
  def visitBoolType(boolT : BoolType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnBoolType(TraversalDirection.Down, boolT, result, context)
    result = pass.applyOnBoolType(TraversalDirection.Up, boolT, result, context)
    return result
  }
  def visitIntType(intT : IntType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnIntType(TraversalDirection.Down, intT, result, context)
    result = pass.applyOnIntType(TraversalDirection.Up, intT, result, context)
    return result
  }
  def visitBitVectorType(bvT : BitVectorType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnBitVectorType(TraversalDirection.Down, bvT, result, context)
    result = pass.applyOnBitVectorType(TraversalDirection.Up, bvT, result, context)
    return result
  }
  def visitEnumType(enumT : EnumType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnEnumType(TraversalDirection.Down, enumT, result, context)
    result = pass.applyOnEnumType(TraversalDirection.Up, enumT, result, context)
    return result
  }
  def visitTupleType(tupleT : TupleType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnTupleType(TraversalDirection.Down, tupleT, result, context)
    result = tupleT.fieldTypes.foldLeft(result)((acc, typ) => visitType(typ, acc, context))
    result = pass.applyOnTupleType(TraversalDirection.Up, tupleT, result, context)
    return result
  }
  def visitRecordType(recordT : RecordType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnRecordType(TraversalDirection.Down, recordT, result, context)
    result = recordT.fields.foldLeft(result)((acc, fld) => {
      visitType(fld._2, visitIdentifier(fld._1, acc, context), context)
    })
    result = pass.applyOnRecordType(TraversalDirection.Up, recordT, result, context)
    return result
  }
  def visitMapType(mapT : MapType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnMapType(TraversalDirection.Down, mapT, result, context)
    result = mapT.inTypes.foldLeft(result)((acc, t) => visitType(t, acc, context))
    result = visitType(mapT.outType, result, context)
    result = pass.applyOnMapType(TraversalDirection.Up, mapT, result, context)
    return result
  }
  def visitArrayType(arrT : ArrayType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnArrayType(TraversalDirection.Down, arrT, result, context)
    result = arrT.inTypes.foldLeft(result)((acc, t) => visitType(t, acc, context))
    result = visitType(arrT.outType, result, context)
    result = pass.applyOnArrayType(TraversalDirection.Up, arrT, result, context)
    return result
  }
  def visitSynonymType(synT : SynonymType, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnSynonymType(TraversalDirection.Down, synT, result, context)
    result = pass.applyOnSynonymType(TraversalDirection.Up, synT, result, context)
    return result
  }

  def visitProcedureSig(sig : ProcedureSig, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnProcedureSig(TraversalDirection.Down, sig, result, context)
    result = sig.inParams.foldLeft(result)((acc, inparam) => visitIdentifier(inparam._1, acc, context))
    result = sig.inParams.foldLeft(result)((acc, inparam) => visitType(inparam._2, acc, context))
    result = sig.outParams.foldLeft(result)((acc, outparam) => visitIdentifier(outparam._1, acc, context))
    result = sig.outParams.foldLeft(result)((acc, outparam) => visitType(outparam._2, acc, context))
    result = pass.applyOnProcedureSig(TraversalDirection.Up, sig, result, context)
    return result
  }
  def visitFunctionSig(sig : FunctionSig, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnFunctionSig(TraversalDirection.Down, sig, result, context)
    result = sig.args.foldLeft(result)((acc, arg) => visitIdentifier(arg._1, acc, context))
    result = sig.args.foldLeft(result)((acc, arg) => visitType(arg._2, acc, context))
    result = visitType(sig.retType, result, context)
    result = pass.applyOnFunctionSig(TraversalDirection.Up, sig, result, context)
    return result
  }
  def visitLocalVar(lvar : LocalVarDecl, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnLocalVar(TraversalDirection.Down, lvar, result, context)
    result = pass.applyOnLocalVar(TraversalDirection.Up, lvar, result, context)
    return result
  }
  def visitStatement(st : Statement, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnStatement(TraversalDirection.Down, st, result, context)
    result = st match {
      case SkipStmt() => visitSkipStatement(st.asInstanceOf[SkipStmt], result, context)
      case AssertStmt(e) => visitAssertStatement(st.asInstanceOf[AssertStmt], result, context)
      case AssumeStmt(e) => visitAssumeStatement(st.asInstanceOf[AssumeStmt], result, context)
      case HavocStmt(id) => visitHavocStatement(st.asInstanceOf[HavocStmt], result, context)
      case AssignStmt(lhss, rhss) => visitAssignStatement(st.asInstanceOf[AssignStmt], result, context)
      case IfElseStmt(cond, ifblock, elseblock) => visitIfElseStatement(st.asInstanceOf[IfElseStmt], result, context)
      case ForStmt(id, range, body) => visitForStatement(st.asInstanceOf[ForStmt], result, context)
      case CaseStmt(body) => visitCaseStatement(st.asInstanceOf[CaseStmt], result, context)
      case ProcedureCallStmt(id, callLhss, args) => visitProcedureCallStatement(st.asInstanceOf[ProcedureCallStmt], result, context)
    }
    result = pass.applyOnStatement(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitSkipStatement(st : SkipStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnSkip(TraversalDirection.Down, st, result, context)
    result = pass.applyOnSkip(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitAssertStatement(st : AssertStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnAssert(TraversalDirection.Down, st, result, context)
    result = visitExpr(st.e, result, context)
    result = pass.applyOnAssert(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitAssumeStatement(st : AssumeStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnAssume(TraversalDirection.Down, st, result, context)
    result = visitExpr(st.e, result, context)
    result = pass.applyOnAssume(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitHavocStatement(st: HavocStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnHavoc(TraversalDirection.Down, st, result, context)
    result = visitIdentifier(st.id, result, context)
    result = pass.applyOnHavoc(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitAssignStatement(st : AssignStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnAssign(TraversalDirection.Down, st, result, context)
    result = st.lhss.foldLeft(result)((arg, i) => visitLhs(i, arg, context))
    result = st.rhss.foldLeft(result)((arg, i) => visitExpr(i, arg, context))
    result = pass.applyOnAssign(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitIfElseStatement(st : IfElseStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnIfElse(TraversalDirection.Down, st, result, context)
    result = visitExpr(st.cond, result, context)
    result = st.ifblock.foldLeft(result)((arg, i) => visitStatement(i, arg, context))
    result = st.elseblock.foldLeft(result)((arg, i) => visitStatement(i, arg, context))
    result = pass.applyOnIfElse(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitForStatement(st : ForStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnFor(TraversalDirection.Down, st, result, context)
    result = visitIdentifier(st.id, result, context)
    result = visitLiteral(st.range._1, result, context)
    result = visitLiteral(st.range._2, result, context)
    result = st.body.foldLeft(result)((arg, i) => visitStatement(i, arg, context))
    result = pass.applyOnFor(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitCaseStatement(st : CaseStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnCase(TraversalDirection.Down, st, result, context)
    result = st.body.foldLeft(result)(
      (arg1, cases) => {
        cases._2.foldLeft(visitExpr(cases._1, arg1, context))((arg2, i) => visitStatement(i, arg2, context))
      }
    )
    result = pass.applyOnCase(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitProcedureCallStatement(st : ProcedureCallStmt, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnProcedureCall(TraversalDirection.Down, st, result, context)
    result = visitIdentifier(st.id, result, context)
    result = st.callLhss.foldLeft(result)((arg, i) => visitLhs(i, arg, context))
    result = st.args.foldLeft(result)((arg, i) => visitExpr(i, arg, context))
    result = pass.applyOnProcedureCall(TraversalDirection.Up, st, result, context)
    return result
  }
  def visitLhs(lhs : Lhs, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnLHS(TraversalDirection.Down, lhs, result, context)
    result = lhs.arraySelect match {
      case Some(as) => as.foldLeft(result)((acc, i) => visitExpr(i, acc, context))
      case None => result
    }
    result = lhs.recordSelect match {
      case Some(rs) => rs.foldLeft(result)((acc, i) => visitIdentifier(i, acc, context))
      case None => result
    }
    result = pass.applyOnLHS(TraversalDirection.Up, lhs, result, context)
    return result
  }
  def visitExpr(e : Expr, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnExpr(TraversalDirection.Down, e, result, context)
    result = e match {
      case i : Identifier => visitIdentifier(i, result, context)
      case lit : Literal => visitLiteral(lit, result, context)
      case rec : Tuple => visitTuple(rec, result, context)
      case opapp : OperatorApplication => visitOperatorApp(opapp, result, context)
      case arrSel : ArraySelectOperation => visitArraySelectOp(arrSel, result, context)
      case arrUpd : ArrayStoreOperation => visitArrayStoreOp(arrUpd, result, context)
      case fapp : FuncApplication => visitFuncApp(fapp, result, context)
      case ite : ITE => visitITE(ite, result, context)
      case lambda : Lambda => visitLambda(lambda, result, context)
    }
    result = pass.applyOnExpr(TraversalDirection.Up, e, result, context)
    return result
  }
  def visitIdentifier(id : Identifier, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnIdentifier(TraversalDirection.Down, id, result, context)
    result = pass.applyOnIdentifier(TraversalDirection.Up, id, result, context)
    return result
  }
  def visitLiteral(lit : Literal, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnLit(TraversalDirection.Down, lit, result, context)
    result = lit match {
      case BoolLit(b) => visitBoolLiteral(lit.asInstanceOf[BoolLit], result, context)
      case IntLit(i) => visitIntLiteral(lit.asInstanceOf[IntLit], result, context)
      case BitVectorLit(bv, w) => visitBitVectorLiteral(lit.asInstanceOf[BitVectorLit], result, context)
    }
    result = pass.applyOnLit(TraversalDirection.Up, lit, result, context)
    return result
  }
  def visitBoolLiteral(b : BoolLit, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnBoolLit(TraversalDirection.Down, b, result, context)
    result = pass.applyOnBoolLit(TraversalDirection.Up, b, result, context)
    return result
  }
  def visitIntLiteral(i : IntLit, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnIntLit(TraversalDirection.Down, i, result, context)
    result = pass.applyOnIntLit(TraversalDirection.Up, i, result, context)
    return result
  }
  def visitBitVectorLiteral(bv : BitVectorLit, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnBitVectorLit(TraversalDirection.Down, bv, result, context)
    result = pass.applyOnBitVectorLit(TraversalDirection.Up, bv, result, context)
    return result
  }
  def visitTuple(rec : Tuple, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnTuple(TraversalDirection.Down, rec, result, context)
    result = rec.values.foldLeft(result)((acc, i) => visitExpr(i, acc, context))
    result = pass.applyOnTuple(TraversalDirection.Up, rec, result, context)
    return result
  }
  def visitOperatorApp(opapp : OperatorApplication, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnOperatorApp(TraversalDirection.Down, opapp, result, context)
    result = visitOperator(opapp.op, result, context)
    result = opapp.operands.foldLeft(result)((acc, i) => visitExpr(i, acc, context))
    result = pass.applyOnOperatorApp(TraversalDirection.Up, opapp, result, context)
    return result
  }
  def visitOperator(op : Operator, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnOperator(TraversalDirection.Down, op, result, context)
    result = pass.applyOnOperator(TraversalDirection.Up, op, result, context)
    return result
  }
  def visitArraySelectOp(arrSel : ArraySelectOperation, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnArraySelect(TraversalDirection.Down, arrSel, result, context)
    result = visitExpr(arrSel.e, result, context)
    result = arrSel.index.foldLeft(result)((acc, arg) => visitExpr(arg, acc, context))
    result = pass.applyOnArraySelect(TraversalDirection.Up, arrSel, result, context)
    return result
  }
  def visitArrayStoreOp(arrStore : ArrayStoreOperation, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnArrayStore(TraversalDirection.Down, arrStore, result, context)
    result = visitExpr(arrStore.e, result, context)
    result = arrStore.index.foldLeft(result)((acc, arg) => visitExpr(arg, acc, context))
    result = visitExpr(arrStore.value, result, context)
    result = pass.applyOnArrayStore(TraversalDirection.Up, arrStore, result, context)
    return result
  }
  def visitFuncApp(fapp : FuncApplication, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnFuncApp(TraversalDirection.Down, fapp, result, context)
    result = visitExpr(fapp.e, result, context)
    result = fapp.args.foldLeft(result)((acc, arg) => visitExpr(arg, acc, context))
    result = pass.applyOnFuncApp(TraversalDirection.Up, fapp, result, context)
    return result
  }
  def visitITE(ite: ITE, in : T, context : ScopeMap) : T = {
    var result : T = in
    result = pass.applyOnITE(TraversalDirection.Down, ite, result, context)
    result = visitExpr(ite.e, result, context)
    result = visitExpr(ite.t, result, context)
    result = visitExpr(ite.f, result, context)
    result = pass.applyOnITE(TraversalDirection.Up, ite, result, context)
    return result
  }
  def visitLambda(lambda: Lambda, in : T, contextIn : ScopeMap) : T = {
    var result : T = in
    val context = contextIn + lambda 
    result = pass.applyOnLambda(TraversalDirection.Down, lambda, result, contextIn)
    result = lambda.ids.foldLeft(result)((acc, arg) => visitIdentifier(arg._1, acc, context))
    result = lambda.ids.foldLeft(result)((acc, arg) => visitType(arg._2, acc, context))
    result = visitExpr(lambda.e, result, context)
    result = pass.applyOnLambda(TraversalDirection.Up, lambda, result, contextIn)
    return result
  }
}

/* AST Visitor that rewrites and generates a new AST. */

trait RewritePass {
  var _analysis : Option[ASTAnalysis] = None
  def analysis : ASTAnalysis = _analysis.get
  def reset() { }
  
  def rewriteModule(module : Module, ctx : ScopeMap) : Option[Module] = { Some(module) }
  def rewriteDecl(decl : Decl, ctx : ScopeMap) : Option[Decl] = { Some(decl) }
  def rewriteCommand(cmd : UclCmd, ctx : ScopeMap) : Option[UclCmd] = { Some(cmd) }
  def rewriteProcedure(proc : ProcedureDecl, ctx : ScopeMap) : Option[ProcedureDecl] = { Some(proc) }
  def rewriteFunction(func : FunctionDecl, ctx : ScopeMap) : Option[FunctionDecl] = { Some(func) }
  def rewriteStateVar(stvar : StateVarDecl, ctx : ScopeMap) : Option[StateVarDecl] = { Some(stvar) }
  def rewriteInputVar(inpvar : InputVarDecl, ctx : ScopeMap) : Option[InputVarDecl] = { Some(inpvar) }
  def rewriteOutputVar(outvar : OutputVarDecl, ctx : ScopeMap) : Option[OutputVarDecl] = { Some(outvar) }
  def rewriteConstant(cnst : ConstantDecl, ctx : ScopeMap) : Option[ConstantDecl] = { Some(cnst) }
  def rewriteSpec(spec : SpecDecl, ctx : ScopeMap) : Option[SpecDecl] = { Some(spec) }
  def rewriteTypeDecl(typDec : TypeDecl, ctx : ScopeMap) : Option[TypeDecl] = { Some(typDec) }
  def rewriteInit(init : InitDecl, ctx : ScopeMap) : Option[InitDecl] = { Some(init) }
  def rewriteNext(next : NextDecl, ctx : ScopeMap) : Option[NextDecl] = { Some(next) }
  def rewriteType(typ: Type, ctx : ScopeMap) : Option[Type] = { Some(typ) }
  def rewriteTemporalType(tempT : TemporalType, context : ScopeMap) : Option[TemporalType] = { Some(tempT) }
  def rewriteBoolType(boolT : BoolType, context : ScopeMap) : Option[BoolType] = { Some(boolT) }
  def rewriteIntType(intT : IntType, context : ScopeMap) : Option[IntType] = { Some(intT)  }
  def rewriteBitVectorType(bvT : BitVectorType, context : ScopeMap) : Option[BitVectorType] = { Some(bvT)  }
  def rewriteEnumType(enumT : EnumType, context : ScopeMap) : Option[EnumType] = { Some(enumT)  }
  def rewriteTupleType(tupleT : TupleType, context : ScopeMap) : Option[TupleType] = { Some(tupleT)  }
  def rewriteRecordType(recordT : RecordType, context : ScopeMap) : Option[RecordType] = { Some(recordT)  }
  def rewriteMapType(mapT : MapType, context : ScopeMap) : Option[MapType] = { Some(mapT)  }
  def rewriteSynonymType(synT : SynonymType, context : ScopeMap) : Option[SynonymType] = { Some(synT)  }
  def rewriteArrayType(arrayT : ArrayType, context : ScopeMap) : Option[ArrayType] = { Some(arrayT)  }
  def rewriteProcedureSig(sig : ProcedureSig, ctx : ScopeMap) : Option[ProcedureSig] = { Some(sig) }
  def rewriteFunctionSig(sig : FunctionSig, ctx : ScopeMap) : Option[FunctionSig] = { Some(sig) }
  def rewriteLocalVar(lvar : LocalVarDecl, ctx : ScopeMap) : Option[LocalVarDecl] = { Some(lvar) }
  def rewriteStatement(st : Statement, ctx : ScopeMap) : Option[Statement] = { Some(st) }
  def rewriteSkip(st : SkipStmt, ctx : ScopeMap) : Option[SkipStmt] = { Some(st) }
  def rewriteAssert(st : AssertStmt, ctx : ScopeMap) : Option[AssertStmt] = { Some(st) }
  def rewriteAssume(st : AssumeStmt, ctx : ScopeMap) : Option[AssumeStmt] = { Some(st) }
  def rewriteHavoc(st : HavocStmt, ctx : ScopeMap) : Option[HavocStmt] = { Some(st) }
  def rewriteAssign(st : AssignStmt, ctx : ScopeMap) : Option[AssignStmt] = { Some(st) }
  def rewriteIfElse(st : IfElseStmt, ctx : ScopeMap) : Option[IfElseStmt] = { Some(st) }
  def rewriteFor(st : ForStmt, ctx : ScopeMap) : Option[ForStmt] = { Some(st) }
  def rewriteCase(st : CaseStmt, ctx : ScopeMap) : Option[CaseStmt] = { Some(st) }
  def rewriteProcedureCall(st : ProcedureCallStmt, ctx : ScopeMap) : Option[ProcedureCallStmt] = { Some(st) }
  def rewriteLHS(lhs : Lhs, ctx : ScopeMap) : Option[Lhs] = { Some(lhs) }
  def rewriteExpr(e : Expr, ctx : ScopeMap) : Option[Expr] = { Some(e) }
  def rewriteIdentifier(id : Identifier, ctx : ScopeMap) : Option[Identifier] = { Some(id) }
  def rewriteLit(lit : Literal, ctx : ScopeMap) : Option[Literal] = { Some(lit) }
  def rewriteBoolLit(b : BoolLit, ctx : ScopeMap) : Option[BoolLit] = { Some(b) }
  def rewriteIntLit(i : IntLit, ctx : ScopeMap) : Option[IntLit] = { Some(i) }
  def rewriteBitVectorLit(bv : BitVectorLit, ctx : ScopeMap) : Option[BitVectorLit] = { Some(bv) }
  def rewriteTuple(rec : Tuple, ctx : ScopeMap) : Option[Tuple] = { Some(rec) }
  def rewriteOperatorApp(opapp : OperatorApplication, ctx : ScopeMap) : Option[OperatorApplication] = { Some(opapp) }
  def rewriteOperator(op : Operator, ctx : ScopeMap) : Option[Operator] = { Some(op) }
  def rewriteArraySelect(arrSel : ArraySelectOperation, ctx : ScopeMap) : Option[ArraySelectOperation] = { Some(arrSel) }
  def rewriteArrayStore(arrStore : ArrayStoreOperation, ctx : ScopeMap) : Option[ArrayStoreOperation] = { Some(arrStore) }
  def rewriteFuncApp(fapp : FuncApplication, ctx : ScopeMap) : Option[FuncApplication] = { Some(fapp) }
  def rewriteITE(ite : ITE, ctx : ScopeMap) : Option[ITE] = { Some(ite) }
  def rewriteLambda(lambda : Lambda, ctx : ScopeMap) : Option[Lambda] = { Some(lambda) }
}


class ASTRewriter (_passName : String, _pass: RewritePass) extends ASTAnalysis {
  // Set a backpointer to here from the pass.
  _pass._analysis = Some(this)
  
  def pass = _pass
  override def passName = _passName
  override def visit(module : Module) : Option[Module] = visitModule(module)
  
  var astChangeFlag = false
  override def astChanged = astChangeFlag

  override def reset() { 
    pass.reset()
    astChangeFlag = false
  }
  
  def visitModule(module : Module) : Option[Module] = {
    astChangeFlag = false
    val emptyContext = new ScopeMap()
    val context = emptyContext + module
    val id = visitIdentifier(module.id, context)
    val decls = module.decls.map(visitDecl(_, context)).flatten
    val cmds = module.cmds.map(visitCommand(_, context)).flatten
    val moduleP = id.flatMap((i) => pass.rewriteModule(Module(i, decls, cmds), emptyContext))
    astChangeFlag = astChangeFlag || (moduleP != Some(module))
    return moduleP
  }
  
  def visitDecl(decl : Decl, context : ScopeMap) : Option[Decl] = {
    val declP = (decl match {
      case procDecl : ProcedureDecl => visitProcedure(procDecl, context)
      case typeDecl : TypeDecl => visitTypeDecl(typeDecl, context)
      case stateVar : StateVarDecl => visitStateVar(stateVar, context)
      case inputVar : InputVarDecl => visitInputVar(inputVar, context)
      case outputVar : OutputVarDecl => visitOutputVar(outputVar, context)
      case constDecl : ConstantDecl => visitConstant(constDecl, context)
      case funcDecl : FunctionDecl => visitFunction(funcDecl, context)
      case initDecl : InitDecl => visitInit(initDecl, context)
      case nextDecl : NextDecl => visitNext(nextDecl, context)
      case specDecl : SpecDecl => visitSpec(specDecl, context)
    }).flatMap(pass.rewriteDecl(_, context))
    astChangeFlag = astChangeFlag || (declP != Some(decl))
    return declP
  }
  def visitProcedure(proc : ProcedureDecl, contextIn : ScopeMap) : Option[ProcedureDecl] = {
    val context = contextIn + proc
    val id = visitIdentifier(proc.id, context)
    val sig = visitProcedureSig(proc.sig, context)
    val decls = proc.decls.map(visitLocalVar(_, context)).flatten
    val stmts = proc.body.map(visitStatement(_, context)).flatten
    val procP = (id, sig) match {
      case (Some(i), Some(s)) => pass.rewriteProcedure(ProcedureDecl(i, s, decls, stmts), contextIn)
      case _ => None 
    }
    astChangeFlag = astChangeFlag || (procP != Some(proc))
    return procP
  }
  
  def visitFunction(func : FunctionDecl, context : ScopeMap) : Option[FunctionDecl] = {
    val id = visitIdentifier(func.id, context)
    val sig = visitFunctionSig(func.sig, context)
    val funcP = (id, sig) match {
      case (Some(i), Some(s)) => pass.rewriteFunction(FunctionDecl(i, s), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (funcP != Some(func))
    return funcP
  }
  
  def visitStateVar(stvar : StateVarDecl, context : ScopeMap) : Option[StateVarDecl] = {
    val idP = visitIdentifier(stvar.id, context)
    val typP = visitType(stvar.typ, context)
    val stateVarP = (idP, typP) match {
      case (Some(id), Some(typ)) => pass.rewriteStateVar(StateVarDecl(id, typ), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (stateVarP != Some(stvar))
    return stateVarP
  }
  
  def visitInputVar(inpvar : InputVarDecl, context : ScopeMap) : Option[InputVarDecl] = {
    val idP = visitIdentifier(inpvar.id, context)
    var typP = visitType(inpvar.typ, context)
    val inpVarP = (idP, typP) match {
      case (Some(id), Some(typ)) => pass.rewriteInputVar(InputVarDecl(id, typ), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (inpVarP != Some(inpvar))
    return inpVarP
  }
  
  def visitOutputVar(outvar : OutputVarDecl, context : ScopeMap) : Option[OutputVarDecl] = {
    val idP = visitIdentifier(outvar.id, context)
    val typP = visitType(outvar.typ, context)
    val outVarP = (idP, typP) match {
      case (Some(id), Some(typ)) => pass.rewriteOutputVar(OutputVarDecl(id, typ), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (outVarP != Some(outvar))
    return outVarP
  }
  
  def visitConstant(cnst : ConstantDecl, context : ScopeMap) : Option[ConstantDecl] = {
    val idP = visitIdentifier(cnst.id, context)
    val typP = visitType(cnst.typ, context)
    val cnstP = (idP, typP) match {
      case (Some(id), Some(typ)) => pass.rewriteConstant(ConstantDecl(id, typ), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (cnstP != Some(cnst))
    return cnstP
  }
  
  def visitSpec(spec : SpecDecl, context : ScopeMap) : Option[SpecDecl] = {
    val idP = visitIdentifier(spec.id, context)
    val exprP = visitExpr(spec.expr, context)
    val specP = (idP, exprP) match {
      case (Some(id), Some(expr)) => pass.rewriteSpec(SpecDecl(id, expr), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (specP != Some(spec))
    return specP
  }
  
  def visitTypeDecl(typDec : TypeDecl, context : ScopeMap) : Option[TypeDecl] = {
    val idP = visitIdentifier(typDec.id, context)
    val typeP = visitType(typDec.typ, context)
    val typDecP = (idP, typeP) match {
      case (Some(id), Some(typ)) => pass.rewriteTypeDecl(TypeDecl(id, typ), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (typDecP != Some(typDec))
    return typDecP
  }
  
  def visitInit(init : InitDecl, context : ScopeMap) : Option[InitDecl] = {
    val body = init.body.map(visitStatement(_, context)).flatten
    val initP = pass.rewriteInit(InitDecl(body), context)
    astChangeFlag = astChangeFlag || (initP != Some(init))
    return initP
  }
  
  def visitNext(next : NextDecl, context : ScopeMap) : Option[NextDecl] = {
    val body = next.body.map(visitStatement(_, context)).flatten
    val nextP = pass.rewriteNext(NextDecl(body), context)
    astChangeFlag = astChangeFlag || (nextP != Some(next))
    return nextP
  }
  
  def visitCommand(cmd : UclCmd, context : ScopeMap) : Option[UclCmd] = {
    val cmdP = pass.rewriteCommand(cmd, context)
    astChangeFlag = astChangeFlag || (cmdP != Some(cmd))
    return cmdP
  }
  
  def visitType(typ: Type, context : ScopeMap) : Option[Type] = {
    val typP = (typ match {
      case tempT : TemporalType => visitTemporalType(tempT, context)
      case boolT : BoolType => visitBoolType(boolT, context)
      case intT : IntType => visitIntType(intT, context)
      case bvT : BitVectorType => visitBitVectorType(bvT, context)
      case enumT : EnumType => visitEnumType(enumT, context)
      case tupleT : TupleType => visitTupleType(tupleT, context)
      case recT : RecordType => visitRecordType(recT, context)
      case mapT : MapType => visitMapType(mapT, context)
      case arrT : ArrayType => visitArrayType(arrT, context)
      case synT : SynonymType => visitSynonymType(synT, context)
    }).flatMap(pass.rewriteType(_, context))
    astChangeFlag = astChangeFlag || (typP != Some(typ))
    return typP
  }
  
  def visitTemporalType(tempT : TemporalType, context : ScopeMap) : Option[TemporalType] = {
    val tempTP = pass.rewriteTemporalType(tempT, context)
    astChangeFlag = astChangeFlag || (tempTP != Some(tempT))
    return tempTP
  }

  def visitBoolType(boolT : BoolType, context : ScopeMap) : Option[BoolType] = {
    val boolTP = pass.rewriteBoolType(boolT, context)
    astChangeFlag = astChangeFlag || (boolTP != Some(boolT))
    return boolTP 
  }

  def visitIntType(intT : IntType, context : ScopeMap) : Option[IntType] = {
    val intTP = pass.rewriteIntType(intT, context)
    astChangeFlag = astChangeFlag || (intTP != Some(intT))
    return intTP 
  }
  
  def visitBitVectorType(bvT : BitVectorType, context : ScopeMap) : Option[BitVectorType] = {
    val bvTP = pass.rewriteBitVectorType(bvT, context)
    astChangeFlag = astChangeFlag || (bvTP != Some(bvT))
    return bvTP 
  }
  
  def visitEnumType(enumT : EnumType, context : ScopeMap) : Option[EnumType] = {
    val idP = enumT.ids.map(visitIdentifier(_, context)).flatten
    val enumTP = pass.rewriteEnumType(EnumType(idP), context)
    astChangeFlag = astChangeFlag || (enumTP != Some(enumT))
    return enumTP 
  }
  
  def visitTupleType(tupleT : TupleType, context : ScopeMap) : Option[TupleType] = {
    val fieldsP = tupleT.fieldTypes.map((t) => visitType(t, context)).flatten
    val tupleTP = pass.rewriteTupleType(TupleType(fieldsP), context)
    astChangeFlag = astChangeFlag || (tupleTP != Some(tupleT))
    return tupleTP 
  }
  
  def visitRecordType(recT : RecordType, context : ScopeMap) : Option[RecordType] = {
    val fieldsP = recT.fields.map((f) => {
      (visitIdentifier(f._1, context), visitType(f._2, context)) match {
        case (Some(i), Some(t)) => Some((i,t))
        case _ => None
      }
    }).flatten
    val recTP = pass.rewriteRecordType(RecordType(fieldsP), context)
    astChangeFlag = astChangeFlag || (recTP != Some(recT))
    return recTP 
  }
  
  def visitMapType(mapT : MapType, context : ScopeMap) : Option[MapType] = {
    val inTypesP = mapT.inTypes.map(visitType(_, context)).flatten
    val mapTP = (visitType(mapT.outType, context)) match {
      case Some(outTypeP) => pass.rewriteMapType(MapType(inTypesP, outTypeP), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (mapTP != Some(mapT))
    return mapTP 
  }
  
  def visitArrayType(arrT : ArrayType, context : ScopeMap) : Option[ArrayType] = {
    val inTypesP = arrT.inTypes.map(visitType(_, context)).flatten
    val arrTP = (visitType(arrT.outType, context)) match {
      case Some(outTypeP) => pass.rewriteArrayType(ArrayType(inTypesP, outTypeP), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (arrTP != Some(arrT))
    return arrTP 
  }
  
  def visitSynonymType(synT : SynonymType, context : ScopeMap) : Option[SynonymType] = {
    val synTP = pass.rewriteSynonymType(synT, context)
    astChangeFlag = astChangeFlag || (synTP != Some(synT))
    return synTP 
  }
  
  def visitProcedureSig(sig : ProcedureSig, context : ScopeMap) : Option[ProcedureSig] = {
    val inParamsP : List[(Identifier, Type)] = sig.inParams.map((inP) => {
      (visitIdentifier(inP._1, context), visitType(inP._2, context)) match {
        case (Some(id), Some(typ)) => Some(id, typ)
        case _ => None
      }
    }).flatten
    
    val outParamsP : List[(Identifier, Type)] = sig.outParams.map((outP) => {
      (visitIdentifier(outP._1, context), visitType(outP._2, context)) match {
        case (Some(id), Some(typ)) => Some(id, typ)
        case _ => None
      }
    }).flatten
    
    val sigP = (inParamsP, outParamsP) match {
      case (in, out) => pass.rewriteProcedureSig(ProcedureSig(in, out), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (sigP != Some(sig))
    return sigP
  }
  
  def visitFunctionSig(sig : FunctionSig, context : ScopeMap) : Option[FunctionSig] = {
    val args : List[(Identifier, Type)] = sig.args.map((inP) => {
      (visitIdentifier(inP._1, context), visitType(inP._2, context)) match {
        case (Some(id), Some(typ)) => Some(id, typ)
        case _ => None
      }
    }).flatten
    val sigP = visitType(sig.retType, context).flatMap((t) => pass.rewriteFunctionSig(FunctionSig(args, t), context))
    astChangeFlag = astChangeFlag || (sigP != Some(sig))
    return sigP
  }
  
  def visitLocalVar(lvar : LocalVarDecl, context : ScopeMap) : Option[LocalVarDecl] = {
    val varP = visitIdentifier(lvar.id, context).flatMap((id) => {
      visitType(lvar.typ, context).flatMap((t) => pass.rewriteLocalVar(LocalVarDecl(id, t), context))
    })
    astChangeFlag = astChangeFlag || (varP != Some(lvar))
    return varP
  }
  
  def visitStatement(st : Statement, context : ScopeMap) : Option[Statement] = {
    val stP = (st match {
      case skipStmt : SkipStmt => visitSkipStatement(skipStmt, context)
      case assertStmt : AssertStmt => visitAssertStatement(assertStmt, context)
      case assumeStmt : AssumeStmt => visitAssumeStatement(assumeStmt, context)
      case havocStmt : HavocStmt => visitHavocStatement(havocStmt, context)
      case assignStmt : AssignStmt => visitAssignStatement(assignStmt, context)
      case ifElseStmt : IfElseStmt => visitIfElseStatement(ifElseStmt, context)
      case forStmt : ForStmt => visitForStatement(forStmt, context)
      case caseStmt : CaseStmt => visitCaseStatement(caseStmt, context)
      case procCallStmt : ProcedureCallStmt => visitProcedureCallStatement(procCallStmt, context)
    }).flatMap(pass.rewriteStatement(_, context))
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }

  def visitSkipStatement(st : SkipStmt, context : ScopeMap) : Option[SkipStmt] = {
    val stP = pass.rewriteSkip(st, context)
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitAssertStatement(st : AssertStmt, context : ScopeMap) : Option[AssertStmt] = {
    val stP = visitExpr(st.e, context).flatMap((e) => {
      pass.rewriteAssert(AssertStmt(e), context)
    })
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitAssumeStatement(st : AssumeStmt, context : ScopeMap) : Option[AssumeStmt] = {
    val stP = visitExpr(st.e, context).flatMap((e) => {
      pass.rewriteAssume(AssumeStmt(e), context)
    })
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitHavocStatement(st: HavocStmt, context : ScopeMap) : Option[HavocStmt] = {
    val stP = visitIdentifier(st.id, context).flatMap((id) => {
      pass.rewriteHavoc(HavocStmt(id), context)
    })
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitAssignStatement(st : AssignStmt, context : ScopeMap) : Option[AssignStmt] = {
    val lhss = st.lhss.map(visitLhs(_, context)).flatten
    val rhss = st.rhss.map(visitExpr(_, context)).flatten
    val stP = pass.rewriteAssign(AssignStmt(lhss, rhss), context)
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitIfElseStatement(st : IfElseStmt, context : ScopeMap) : Option[IfElseStmt] = {
    val cond = visitExpr(st.cond, context)
    val ifblock = st.ifblock.map(visitStatement(_, context)).flatten
    val elseblock = st.elseblock.map(visitStatement(_, context)).flatten
    val stP = cond match {
      case Some(c) => pass.rewriteIfElse(IfElseStmt(c, ifblock, elseblock), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitForStatement(st : ForStmt, context : ScopeMap) : Option[ForStmt] = {
    val idP = visitIdentifier(st.id, context)
    val lit1P = visitIntLiteral(st.range._1, context)
    val lit2P = visitIntLiteral(st.range._2, context)
    val stmts = st.body.map(visitStatement(_, context)).flatten
    
    val stP = (idP, lit1P, lit2P) match {
      case (Some(id), Some(lit1), Some(lit2)) => pass.rewriteFor(ForStmt(id, (lit1, lit2), stmts), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitCaseStatement(st : CaseStmt, context : ScopeMap) : Option[CaseStmt] = {
    val bodyP = st.body.map((c) => {
      // if rewriting the expression doesn't produce None.
      visitExpr(c._1, context).flatMap((e) => {
        // then rewrite each of statements associated with the case expression.
        Some(e, c._2.map(visitStatement(_, context)).flatten)
      })
    }).flatten // and finally get rid of all the Options.
    val stP = pass.rewriteCase(CaseStmt(bodyP), context)
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitProcedureCallStatement(st : ProcedureCallStmt, context : ScopeMap) : Option[ProcedureCallStmt] = {
    val idP = visitIdentifier(st.id, context)
    val lhssP = st.callLhss.map(visitLhs(_, context)).flatten
    val argsP = st.args.map(visitExpr(_, context)).flatten
    val stP = idP.flatMap((id) => pass.rewriteProcedureCall(ProcedureCallStmt(id, lhssP, argsP), context))
    astChangeFlag = astChangeFlag || (stP != Some(st))
    return stP
  }
  
  def visitLhs(lhs : Lhs, context : ScopeMap) : Option[Lhs] = {
    val idP = visitIdentifier(lhs.id, context)
    val arraySelectP = lhs.arraySelect.flatMap((as) => Some(as.map((e) => visitExpr(e, context)).flatten))
    val recordSelectP = lhs.recordSelect.flatMap((rs) => Some(rs.map((i) => visitIdentifier(i, context)).flatten))
    val lhsP = idP.flatMap((id) => {
      Some(Lhs(id, arraySelectP, recordSelectP))
    })
    astChangeFlag = astChangeFlag || (lhsP != Some(lhs))
    return lhsP
  }
  
  def visitExpr(e : Expr, context : ScopeMap) : Option[Expr] = {
    val eP = (e match {
      case i : Identifier => visitIdentifier(i, context)
      case lit : Literal => visitLiteral(lit, context)
      case rec : Tuple => visitTuple(rec, context)
      case opapp : OperatorApplication => visitOperatorApp(opapp, context)
      case arrSel : ArraySelectOperation => visitArraySelectOp(arrSel, context)
      case arrUpd : ArrayStoreOperation => visitArrayStoreOp(arrUpd, context)
      case fapp : FuncApplication => visitFuncApp(fapp, context)
      case ite : ITE => visitITE(ite, context)
      case lambda : Lambda => visitLambda(lambda, context)
    }).flatMap(pass.rewriteExpr(_, context))
    astChangeFlag = astChangeFlag || (eP != Some(e))
    return eP
  }
  
  def visitIdentifier(id : Identifier, context : ScopeMap) : Option[Identifier] = {
    val idP = pass.rewriteIdentifier(id, context)
    astChangeFlag = astChangeFlag || (idP != Some(id))
    return idP
  }
  
  def visitLiteral(lit : Literal, context : ScopeMap) : Option[Literal] = {
    val litP = (lit match {
      case b : BoolLit => visitBoolLiteral(b, context)
      case i : IntLit => visitIntLiteral(i, context)
      case bv : BitVectorLit => visitBitVectorLiteral(bv, context)
    }).flatMap(pass.rewriteLit(_, context))
    astChangeFlag = astChangeFlag || (litP != Some(lit))
    return litP
  }
  
  def visitBoolLiteral(b : BoolLit, context : ScopeMap) : Option[BoolLit] = {
    val bP = pass.rewriteBoolLit(b, context)
    astChangeFlag = astChangeFlag || (bP != Some(b))
    return bP
  }
  
  def visitIntLiteral(i : IntLit, context : ScopeMap) : Option[IntLit] = {
    val iP = pass.rewriteIntLit(i, context)
    astChangeFlag = astChangeFlag || (iP != Some(i))
    return iP
  }
  
  def visitBitVectorLiteral(bv : BitVectorLit, context : ScopeMap) : Option[BitVectorLit] = {
    val bvP = pass.rewriteBitVectorLit(bv, context)
    astChangeFlag = astChangeFlag || (bvP != Some(bv))
    return bvP
  }
  
  def visitTuple(rec : Tuple, context : ScopeMap) : Option[Tuple] = {
    val recP = pass.rewriteTuple(Tuple(rec.values.map(visitExpr(_, context)).flatten), context)
    astChangeFlag = astChangeFlag || (recP != Some(rec))
    return recP
  }
  
  def visitOperatorApp(opapp : OperatorApplication, context : ScopeMap) : Option[OperatorApplication] = {
    val opAppP = visitOperator(opapp.op, context).flatMap((op) => {
      pass.rewriteOperatorApp(OperatorApplication(op, opapp.operands.map(visitExpr(_, context)).flatten), context)
    })
    astChangeFlag = astChangeFlag || (opAppP != Some(opapp))
    return opAppP
  }
  
  def visitOperator(op : Operator, context : ScopeMap) : Option[Operator] = {
    val opP = pass.rewriteOperator(op, context)
    astChangeFlag = astChangeFlag || (opP != Some(op))
    return opP
  }
  
  def visitArraySelectOp(arrSel : ArraySelectOperation, context : ScopeMap) : Option[ArraySelectOperation] = {
    val arrSelP = visitExpr(arrSel.e, context) match {
      case Some(e) => pass.rewriteArraySelect(ArraySelectOperation(e, arrSel.index.map(visitExpr(_, context)).flatten), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (arrSelP != Some(arrSel))
    return arrSelP
  }
  
  def visitArrayStoreOp(arrStore : ArrayStoreOperation, context : ScopeMap) : Option[ArrayStoreOperation] = {
    val eP = visitExpr(arrStore.e, context)
    val ind = arrStore.index.map(visitExpr(_, context)).flatten
    val valP = visitExpr(arrStore.value, context)
    val arrStoreP = (eP, valP) match {
      case (Some(e), Some(value)) => pass.rewriteArrayStore(ArrayStoreOperation(e, ind, value), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (arrStoreP != Some(arrStore))
    return arrStoreP
  }
  
  def visitFuncApp(fapp : FuncApplication, context : ScopeMap) : Option[FuncApplication] = {
    val eP = visitExpr(fapp.e, context)
    val args = fapp.args.map(visitExpr(_, context)).flatten
    val fappP = eP match {
      case Some(e) => pass.rewriteFuncApp(FuncApplication(e, args), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (fappP != Some(fapp))
    return fappP
  }
  
  def visitITE(ite: ITE, context : ScopeMap) : Option[ITE] = {
    val condP = visitExpr(ite.e, context)
    val tP = visitExpr(ite.t, context)
    val fP = visitExpr(ite.f, context)
    
    val iteP = (condP, tP, fP) match {
      case (Some(cond), Some(t), Some(f)) => pass.rewriteITE(ITE(cond, t, f), context)
      case _ => None
    }
    astChangeFlag = astChangeFlag || (iteP != Some(ite))
    return iteP
  }
  
  def visitLambda(lambda: Lambda, contextIn : ScopeMap) : Option[Lambda] = {
    val context = contextIn + lambda
    val idP = lambda.ids.map((arg) => {
      (visitIdentifier(arg._1, context), visitType(arg._2, context)) match {
        case (Some(id), Some(typ)) => Some(id, typ)
        case _ => None
      }
    }).flatten
    val lambdaP = visitExpr(lambda.e, context).flatMap((e) => pass.rewriteLambda(Lambda(idP, e), contextIn))
    astChangeFlag = astChangeFlag || (lambdaP != Some(lambda))
    return lambdaP
  }
}

class ExprRewriterPass(expr: Expr, repl: Expr) extends RewritePass
{
  override def rewriteExpr(e: Expr, context: ScopeMap) : Option[Expr] = {
    if (e == expr) {
      Some(repl)
    } else {
      Some(e)
    }
  }
}

class ExprRewriter(name: String, expr: Expr, repl: Expr) 
  extends ASTRewriter(name, new ExprRewriterPass(expr, repl))

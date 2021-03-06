grammar Euclin;

// Description de l'automate représentant le langage
// Règles du parseur

// Règle de base
codeBlock
    : instructions*
    ;

functionCodeBlock
    : functionInstructions+
    ;

functionInstructions
    : instructions          #InstructionFuncInstruction
    | Return expression     #ReturnFuncInstruction
    ;

// TODO: Bouger les imports dans 'codeBlock'
instructions
    : importDeclaration     #ImportInstruction
    | methodImportDeclaration   #ImportMethodInstruction
    | expression            #ExpressionInstruction
    | variableDeclaration   #DeclareVarInstruction
    | structureDeclaration  #DeclareStructInstruction
    | variableAssign        #AssignVarInstruction
    | memberAssign          #AssignMemberInstruction
    | transformBlock        #TransformBlockInstruction
    | functionDeclaration   #DeclareFuncInstruction
    | expression LeftSquareBracket expression RightSquareBracket Equals expression                                  #ArrayStoreInstruction
    | If LeftBracket expression RightBracket LeftCurlyBracket functionInstructions* RightCurlyBracket elseBlock?    #IfBranchingInstruction
    | While LeftBracket expression RightBracket LeftCurlyBracket functionInstructions* RightCurlyBracket            #WhileLoopInstruction
    ;

importDeclaration
    : Import Identifier (Period Identifier)* renamming?
    ;

methodImportDeclaration
    : ImportMethod Identifier (Period Identifier)* renamming?   #BasicMethodImport
    | ImportMethod Identifier (Period Identifier)* Period Star   #ImportAllMethods
    ;

renamming
    : 'as' Identifier
    ;

structureDeclaration
    : StructStart Identifier LeftCurlyBracket
        (parameter)* // ce sont les membres de cette structure
        (linkage)*
    RightCurlyBracket
    ;

linkage
    : LinkStart Identifier LeftBracket (type (Comma type)*)? RightBracket Colon type
    ;

elseBlock
    : Else LeftCurlyBracket functionInstructions* RightCurlyBracket
    ;

type
    : LeftBracket (type (Comma type)*)? RightBracket LightArrow type    #FunctionType
    | LeftBracket type Comma type RightBracket                          #CoupleType
    | LeftBracket type RightBracket                                     #WrappedType
    | Identifier                                                        #BasicType
    | Star                                                              #WildcardType
    | LeftSquareBracket type RightSquareBracket                         #ArrayType
    ;

parameter
    : Identifier Colon type
    ;

functionDeclaration
    : modifiers* FunctionDefStart Identifier LeftBracket (parameter (Comma parameter)*)? RightBracket Colon type
    LeftCurlyBracket functionCodeBlock RightCurlyBracket
    ;

modifiers
    : Pure
    | Impure
    | Memoized;

functionCall
    : functionIdentifier LeftBracket (expression (Comma expression)*)? RightBracket
    ;

variableDeclaration
    : Var Identifier Equals expression
    ;

variableAssign
    : Identifier Equals expression
    ;

memberAssign
    : expression (Period Identifier)+ Equals expression
    ;

transformBlock
    : TransformBlockStart LeftCurlyBracket codeBlock RightCurlyBracket
    ;

// définies par ordre de précédence
expression
    : LambdaVariable                            #LambdaVarExpr
    | expression LeftSquareBracket expression RightSquareBracket                #AccessArrayExpr
    | LeftSquareBracket (expression (Comma expression)*)? RightSquareBracket    #ArrayExpr
    | expression Colon type                                                     #LoadAndRetypeExpr
    | New type LeftSquareBracket expression RightSquareBracket            #NewArrayExpr
    | New Identifier (LeftBracket (expression (Comma expression)*)? RightBracket)? #NewObjectExpr
    | LeftCurlyBracket functionInstructions+ RightCurlyBracket                  #LambdaFunctionExpr
    | expression (Period Identifier)+           #AccessExpr
    | functionCall                              #CallExpr
    | Identifier                                #VarExpr
    | couple                                    #CoupleExpr
    | Integer                                   #IntExpr
    | FloatNumber                               #FloatExpr
    | LeftBracket expression RightBracket       #WrappedExpr
    | expression DivOperator expression         #DivExpr
    | expression MultOperator expression        #MultExpr
    | expression SubOperator expression         #SubExpr
    | expression AddOperator expression         #AddExpr
    | expression Less expression                #LessExpr
    | expression LessEqual expression           #LessEqualExpr
    | expression Greater expression             #GreaterExpr
    | expression GreaterEqual expression        #GreaterEqualExpr
    | expression Equals Equals expression       #Equality
    | expression Bang Equals expression         #Inequality
    | True                                      #BoolTrueExpr
    | False                                     #BoolFalseExpr
    | StringConstant                            #StringExpr
    | CharConstant                              #CharExpr
    | LeftBracket RightBracket                  #UnitExpr
    | expression RightLightArrow type           #CastExpr
    ;

couple
    : LeftBracket expression Comma expression RightBracket
    ;

functionIdentifier
    : Identifier                                #DirectFunctionIdentifier
    | Identifier (Period Identifier)+           #MemberFunctionIdentifier
    ;

// Mots clés
Return: 'return';
TransformBlockStart: 'transform';
FunctionDefStart: 'func';
Var: 'var';
True: 'true';
False: 'false';
Pure: 'pure';
Impure: 'impure';
Memoized: 'memoized';
Else: 'else';
If: 'if';
While: 'while';
StructStart: 'struct';
New: 'new';
Import: 'import';
ImportMethod: 'import method';
LinkStart: 'link';

// Ponctuation
LambdaVariable: '_';
LeftBracket: '(';
RightBracket: ')';
LeftCurlyBracket: '{';
RightCurlyBracket: '}';
LeftSquareBracket: '[';
RightSquareBracket: ']';
Comma: ',';
Period: '.';
Colon: ':';
SemiColon: ';';
Equals: '=';
LightArrow: '->';
RightLightArrow: '<-';
Bang: '!';
Less: '<';
LessEqual: '<=';
Greater: '>';
GreaterEqual: '>=';
Star: '@';

Identifier: IdentifierStart IdentifierPart*;
Integer: Digits;
FloatNumber
    : Digits Period (Digits)?
    | Period Digits
    ;

MultOperator
    : '*' BinaryOperatorSuffix
    ;

DivOperator
    : '/' BinaryOperatorSuffix
    ;

AddOperator
    : '+' BinaryOperatorSuffix
    ;

SubOperator
    : '-' BinaryOperatorSuffix
    ;

StringConstant
    : '"' ~('"')* '"'
    ;

CharConstant
    : '\'' ~('\'') '\''
    ;
// Fragments: visible que par le lexer
fragment IdentifierStart
    : [a-z] | [A-Z]
    ;

fragment IdentifierPart
    : ([a-z] | [A-Z] | [0-9])
    ;

fragment Digits
    : Digit+
    ;

fragment Digit
    : [0-9]
    ;

fragment BinaryOperatorSuffix
    : '.'?
    ;

// Commentaires et blancs
LineComment
  :  '//' ~( '\r' | '\n' )* -> skip
  ;

MultilineComment
// '/*': début du commentaire
// '*/': fin
// '.*?': n'importe ('.') quel**s** ('*') caractères, ou rien ('?')
  : '/*' .*? '*/' -> skip
  ;

Whitespace:
    [ \t\n\r]+ -> skip;

EuclinCompiler -> reçoit un fichier source et renvoit le bytecode correspondant
; Expliquer les visitors <- parcours en profondeur des arbres syntaxiques
; Montrer arbres syntaxiques
; Explications types génériques ?
; Expliquer les fonctions lambda de Kotlin (rapidement)
"import org.objectweb.asm.Opcodes.*" -> expliquer
TypeConversions -> Expliquer le *<...>.toTypedArray()
; Expliquer ASM "Label" + ASM "Type" (pas forcément en même temps)
; Expliquer les extensions (super pratique pour TypeDefinition)
https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings

javap -p -c -v -constants TestEuclin.class


3 Systèmes de types:
- Kotlin
- ASM (JVM)
- AbstractInference
/ Types d'Euclin (plus maintenant)

Compilation des fonctions lambda: http://blog.takipi.com/compiling-lambda-expressions-scala-vs-java-8/ (fr: http://blog.takipi.com/compilation-des-expressions-lambda-scala-et-java-8/ )
+ http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html
+ https://stackoverflow.com/questions/18971830/generating-working-invokedynamic-instruction-with-
+ https://stackoverflow.com/questions/16827262/how-will-java-lambda-functions-be-compiled


Différence fcmpl/fcmpg
+ http://www.javaworld.com/article/2077625/core-java/control-flow.html (traitement de NaN et comparaisons)

Réfèrence officielle pour les opcodes:
+ http://docs.oracle.com/javase/specs/jvms/se8/html/index.html

A faire:
========
(Compileur) Utiliser ASM-Commons et GeneratorAdaptor pour un code plus lisible/compréhensible ?
(Compileur-Lambda) Mieux inférer le type de l'argument et le type de retour
(Compileur) Optimisations pour la récursivité terminale
(Compileur) Pattern matching (pour le futur lointain, post concours)
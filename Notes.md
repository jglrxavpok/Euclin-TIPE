EuclinCompiler -> reçoit un fichier source et renvoit le bytecode correspondant
; Expliquer les visitors
; Montrer arbres syntaxiques
; Explications types génériques ?
; Expliquer les fonctions lambda de Kotlin (rapidement)
"import org.objectweb.asm.Opcodes.*" -> expliquer
TypeConversions -> Expliquer le *<...>.toTypedArray()
; Expliquer ASM "Label" + ASM "Type" (pas forcément en même temps)
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


A faire:
========
(Compileur) Remplacer les 'assert' et 'error' de Kotlin par un système d'exceptions permettant d'indiquer la position de l'erreur
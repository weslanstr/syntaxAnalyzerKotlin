import java.io.File
import java.io.FileNotFoundException
import java.util.*

object MainClass {
    @JvmStatic
    fun main(args: Array<String>) {
        /* !!! Hit visitElement for element type: class org.jetbrains.kotlin.nj2k.tree.JKErrorExpression !!! */)
        val fileName = Scanner(System.`in`)
        println("\n|\nplease enter directory location of .txt file.....")
        val name = fileName.nextLine()
        print(".....path entered")
        fileName.close()
        val x = File(name)
        if (x.exists()) {
            print("....." + x.name + " exists!" + "\n")
        } else {
            println("......file does not exist")
        }
        println("|")
        try {
            val sc = Scanner(x)
            var text = sc.nextLine()
            print("|\nNext Line: " + text + "\nlength of this line is: " + text.length + "\n")
            var lexeme = " "
            val n = next()
            val p = position()
            val k = kind()
            //value v = new value();
            var i = 0
            var l = 1
            val noError = true

//THE CORE LOOP---------------------------------------------------------------------------------------------------------
            // TODO 1 how do I ommit an empty line between lines? calling nextline() twice just breaks everything
            while (sc.hasNextLine() && noError) {
                val txt = Scanner(text)
                while (txt.hasNext()) {
                    lexeme = n.next(txt) //calls next lexeme
                    print("\nlexeme being read is: $lexeme")
                    i = text.indexOf(lexeme)
                    p.position(i, l) //returns current position of lexeme
                    k.kind(lexeme, txt) //v.value(lexeme) is called inside the kind() class
                    print("\n")
                    if (!txt.hasNext()) { //iterating to the next line
                        text = sc.nextLine()
                        print("|\nNext Line: " + text + "\nlength of this line is: " + text.length + "\n")
                        i = 0
                        l++
                    }
                }
                if (!sc.hasNextLine()) { //internal to make sure the last line is called and ends with "end"
                    if (text.contains("end")) {
                        print(
                            "\nlexeme being read is: " + text +
                                    "\nposition within line is: " + i + " and position is line: " + l +
                                    "\nkind is: end of file declaration: end\n" +
                                    "letter/s read: end\n"
                        )
                    } else {
                        print("ERROR: FILE DOES NOT TERMINATE WITH 'END' KEYWORD ")
                    }
                }
                txt.close()
            }
            /* !!! Hit visitElement for element type: class org.jetbrains.kotlin.nj2k.tree.JKErrorExpression !!! */
            sc.close()
        } catch (e: FileNotFoundException) {
            println("Error: file was not found (exception e)")
        }
    }

}
//THE NEXT METH---------------------------------------------------------------------------------------------------------

public class next(txt: Scanner) : MainClass() {
    init {
        txt.next()
    }
}
//THE POSITION METH-----------------------------------------------------------------------------------------------------

internal class position(i: Int, l: Int) : MainClass() {
    init {
        print("\nposition within line is: $i and position is line: $l")
    }
}
//THE VALUE METH--------------------------------------------------------------------------------------------------------

internal class value(lexeme: String, noError: Boolean) : MainClass() {
    init {
        val result = Boolean("[0-9]+")
        val symbol = lexeme.matches("[(,),{,},:,;]+")
        if (noError) {
            if (result) {
                print("\nvalue: NUM")
            } else if (symbol) {
                print("\nvalue: NULL")
            } else {
                print("\nvalue: ID")
            }
        } else {
            print("\nvalue: ERROR")
            //System.exit(0);
        }
    }
} //THE KIND METH---------------------------------------------------------------------------------------------------------

internal class kind(lexeme: String, txt: Scanner) : MainClass() {
    //TODO 3 I need to store the identifiers for future loops.
    //TODO 4 this does not account for identifiers with names similar to keywords. like 'print' and 'printy'
    var noError = true

    init {
        val k = kind()
        val v = value()
        if (lexeme.contains("//")) {
            v.value(lexeme, noError)
            print("\nkind is: Single comment: $lexeme")
            while (txt.hasNext()) {
                print(" " + txt.next())
            }
        }
        var letter = ""
        var number = ""
        var symbol = ""
        var operator = ""
        val stringBuilder1 = StringBuilder()
        val stringBuilder2 = StringBuilder()
        val stringBuilder3 = StringBuilder()
        val stringBuilder4 = StringBuilder()
        for (i in 0 until lexeme.length) {
            if ((lexeme[i] == 'a') || (lexeme[i] == 'b') || (lexeme[i] == 'c') || (lexeme[i] == 'd'
                        ) || (lexeme[i] == 'e') || (lexeme[i] == 'f') || (lexeme[i] == 'g') || (lexeme[i] == 'h'
                        ) || (lexeme[i] == 'i') || (lexeme[i] == 'j') || (lexeme[i] == 'k') || (lexeme[i] == 'l'
                        ) || (lexeme[i] == 'm') || (lexeme[i] == 'n') || (lexeme[i] == 'o') || (lexeme[i] == 'p'
                        ) || (lexeme[i] == 'q') || (lexeme[i] == 'r') || (lexeme[i] == 's') || (lexeme[i] == 't'
                        ) || (lexeme[i] == 'u') || (lexeme[i] == 'v') || (lexeme[i] == 'w') || (lexeme[i] == 'x'
                        ) || (lexeme[i] == 'y') || (lexeme[i] == 'z'
                        ) || (lexeme[i] == 'A') || (lexeme[i] == 'B') || (lexeme[i] == 'C') || (lexeme[i] == 'D'
                        ) || (lexeme[i] == 'E') || (lexeme[i] == 'F') || (lexeme[i] == 'G') || (lexeme[i] == 'H'
                        ) || (lexeme[i] == 'I') || (lexeme[i] == 'J') || (lexeme[i] == 'K') || (lexeme[i] == 'L'
                        ) || (lexeme[i] == 'M') || (lexeme[i] == 'N') || (lexeme[i] == 'O') || (lexeme[i] == 'P'
                        ) || (lexeme[i] == 'Q') || (lexeme[i] == 'R') || (lexeme[i] == 'S') || (lexeme[i] == 'T'
                        ) || (lexeme[i] == 'U') || (lexeme[i] == 'V') || (lexeme[i] == 'W') || (lexeme[i] == 'X'
                        ) || (lexeme[i] == 'Y') || (lexeme[i] == 'Z')
            ) {
                val chaL = lexeme[i]
                stringBuilder1.append(letter).append(chaL)
            }
            if ((lexeme[i] == '1') || (lexeme[i] == '2') || (lexeme[i] == '3') || (lexeme[i] == '4'
                        ) || (lexeme[i] == '5') || (lexeme[i] == '6') || (lexeme[i] == '7') || (lexeme[i] == '8'
                        ) || (lexeme[i] == '9') || (lexeme[i] == '0')
            ) {
                val chaN = lexeme[i]
                stringBuilder2.append(number).append(chaN)
                v.value(number, noError)
            }
            if ((lexeme[i] == '{') || (lexeme[i] == '}') || (lexeme[i] == '(') || (lexeme[i] == ')'
                        ) || (lexeme[i] == ';') || (lexeme[i] == '[') || (lexeme[i] == ']') || (lexeme[i] == ':')
            ) {
                val chaS = lexeme[i]
                stringBuilder3.append(symbol).append(chaS)
            }
            if ((lexeme[i] == '+') || (lexeme[i] == '-') || (lexeme[i] == '/') || (lexeme[i] == '*'
                        ) || (lexeme[i] == '<') || (lexeme[i] == '>') || (lexeme[i] == '=') || (lexeme[i] == '!'
                        ) || (lexeme[i] == '|') || (lexeme[i] == '%') || (lexeme[i] == ':')
            ) {
                val chaR = lexeme[i]
                stringBuilder4.append(operator).append(chaR)
            }
        }
        letter = stringBuilder1.toString()
        number = stringBuilder2.toString()
        symbol = stringBuilder3.toString()
        operator = stringBuilder4.toString()
        if (letter !== "") {
            print("\nletter/s read: $letter")
            v.value(letter, noError)
        }
        if (number !== "") {
            print("\nnumber/s read: $number")
            v.value(number, noError)
        }
        if (symbol !== "") {
            print("\nsymbol/s read: $symbol")
            v.value(symbol, noError)
        }
        if (operator !== "") {
            print("\noperator/s read: $operator")
            v.value(operator, noError)
        }
        if (lexeme.contains(":") || lexeme.contains("=")) {
            if (!lexeme.matches(":=")) {
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN ':=' ?")
                System.exit(0)
            } else if (lexeme.contains(":=") || lexeme.contains("=<") || lexeme.contains(">=") || lexeme.contains("!=")) {
                print("\nkind is RelationalOperator: $lexeme")
            }
        } else if (letter.contains("program")) {
            print("\nkind is keyword: $letter")
            if (!letter.matches("program")) { //if int is misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'program' ?")
                System.exit(0)
            }
            if (txt.hasNext()) {
                letter = txt.next()
            } else {
                print(" \nSYNTAX ERROR DETECTED, PROGRAM MUST BE IDENTIFIED FOLLOWED BY ':' ")
                System.exit(0)
            }
            if (letter.contains(":")) {
                print("\nidentifier: $letter")
            } else if (!letter.contains(":")) {
                print("\nidentifier: $letter")
                if (txt.hasNext()) {
                    letter = txt.next()
                }
                if (letter.contains(":")) {
                    print(letter)
                } else if (!letter.contains(":")) {
                    print(" \nSYNTAX ERROR DETECTED, PROGRAM IDENTIFIER MUST BE FOLLOWED BY ':' ?")
                    System.exit(0)
                }
            }
        } else if (letter.contains("int") && !letter.contains("print")) { //reads keyword 'int'
            print("\nkind is keyword Declaration: $letter")
            if (!letter.matches("int")) { //if int is misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'int' ?")
                System.exit(0)
            }
            if (!txt.hasNext()) { //if int isn't given a name to initialize.
                print(" \nSYNTAX ERROR DETECTED, 'int' MUST BE USED TO INITIALIZE A IDENTIFIER")
                System.exit(0)
            }
            //while(!letter.contains(";"))
            //if(!txt.hasNext)
            //{} print "error this needs to end with ';'
            //{} somehow loop through each item, and return its value, kind and position
            //if identifier = true and .next() is also an identifier and not an operator, return an error.
        } else if (letter.contains("bool")) { //reads keyword
            print("\nkind is keyword: $letter")
            if (!letter.matches("bool")) {
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'bool' ?")
                System.exit(0)
            }
        } else if (letter.contains("if")) { //reads 'if' statement
            print("\nkind is keyword ConditionalStatement: $letter")
            if (!letter.matches("if")) { //misspell catcher
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'if' ?")
                System.exit(0)
            }
            letter = txt.next()
            if (letter.contains("not")) {
                if (!letter.matches("not")) { //misspell catcher
                    print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'not' ?")
                    System.exit(0)
                }
                while (!letter.contains("then")) { //this is an issue
                    print(" $letter ")
                    letter = txt.next()
                    if (letter.contains("then")) {
                        if (!letter.matches("then")) { //misspell catcher
                            print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'then' ?")
                            System.exit(0)
                        }
                    }
                }
                while (txt.hasNext()) {


                    //add stuff to this so contents are also lexilized
                    print(" $letter ")
                    letter = txt.next()
                }
            } else if (!letter.contains("not")) {
                while (!letter.contains("then")) {
                    print(" $letter ")
                    letter = txt.next()
                    if (letter.contains("then")) {
                        if (!letter.matches("then")) { //misspell catcher
                            print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'then' ?")
                            System.exit(0)
                        }
                    }
                }
                while (txt.hasNext()) {


                    //add stuff to this so contents are also lexilized
                    print(" $letter ")
                    letter = txt.next()
                }
            }
        } else if (letter.contains("else")) {
            print("\nkind is keyword ConditionalStatement: $letter")
            if (!letter.matches("else")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'else' ?")
                System.exit(0)
            }
        } else if (letter.contains("fi")) {
            print("\nkind is keyword ConditionalStatement: $letter")
            if (!letter.matches("fi")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'fi' ?")
                System.exit(0)
            }
        } else if (letter.contains("while")) { //while statements
            print("\nkind is keyword IterativeStatement: $letter")
            if (!letter.matches("while")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'while' ?")
                System.exit(0)
            }
        } else if (letter.contains("od")) {
            print("\nkind is keyword IterativeStatement: $letter")
            if (!letter.matches("od")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'od' ?")
                System.exit(0)
            }
        } else if (letter.contains("print")) {
            print("\nkind is keyword PrintStatement: $letter")
            if (!letter.matches("print")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'print' ?")
                System.exit(0)
            }
        } else if (letter.contains("false")) {
            print("\nkind is keyword BooleanLiteral: $letter")
            if (!letter.matches("false")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'false' ?")
                System.exit(0)
            }
        } else if (letter.contains("true")) {
            print("\nkind is keyword BooleanLiteral: $letter")
            if (!letter.matches("true")) { //if misspelled
                print(" \nSYNTAX ERROR DETECTED, DID YOU MEAN 'true' ?")
                System.exit(0)
            }
        } else if (lexeme.contains(";")) {
            print("\nkind is keyword: $symbol")
            print("\nkind is identifier: $letter")
        } else if (symbol.contains("{")) {
            print("\nkind is symbol: $symbol")
        } else if (symbol.contains("}")) {
            print("\nkind is symbol: $symbol")
        } else if (symbol.contains("[")) {
            print("\nkind is symbol: $symbol")
        } else if (symbol.contains("]")) {
            print("\nkind is symbol: $symbol")
        } else if (symbol.contains("(")) {
            print("\nkind is symbol: (")
            print("\nkind is identifier: $letter")
        } else if (symbol.contains(")")) {
            print("\nkind is symbol: )")
            print("\nkind is identifier: $letter")
        } else if (symbol.contains(";")) {
            print("\nkind is symbol: $symbol")
        } else if (symbol.contains(":")) {
            print("\nkind is symbol: $symbol")
        } else if (operator.contains("|")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("<")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains(">")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("=")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("+")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("-")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("%")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("*")) {
            print("\nkind is operator: $operator")
        } else if (operator.contains("//")) {
        } else {
            print("\nkind is Identifier: $letter")
        }
        return txt
    }

    //TODO N THE AST TREE
    internal inner class ast(contents: String?) : MainClass()
} //LINE 500!! :D

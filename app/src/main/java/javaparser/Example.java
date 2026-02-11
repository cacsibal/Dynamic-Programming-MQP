package javaparser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ThisExpr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        // 1. Create a CompilationUnit (the root of the AST)
        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration("com.example.model");

        // 2. Add a class declaration
        ClassOrInterfaceDeclaration bookClass = cu.addClass("Book", Modifier.Keyword.PUBLIC);

        // 3. Add fields
        bookClass.addField("String", "title", Modifier.Keyword.PRIVATE);
        bookClass.addField("Person", "author", Modifier.Keyword.PRIVATE); // Assuming 'Person' is another class

        // 4. Add a constructor
        bookClass.addConstructor(Modifier.Keyword.PUBLIC)
                .addParameter("String", "title")
                .addParameter("Person", "author")
                .setBody(new BlockStmt()
                        .addStatement(new ExpressionStmt(new AssignExpr(
                                new FieldAccessExpr(new ThisExpr(), "title"), new NameExpr("title"), AssignExpr.Operator.ASSIGN)))
                        .addStatement(new ExpressionStmt(new AssignExpr(
                                new FieldAccessExpr(new ThisExpr(), "author"), new NameExpr("author"), AssignExpr.Operator.ASSIGN))));

        // 5. Add getter methods
        bookClass.addMethod("getTitle", Modifier.Keyword.PUBLIC)
                .setType("String")
                .setBody(new BlockStmt().addStatement(new ReturnStmt(new NameExpr("title"))));

        bookClass.addMethod("getAuthor", Modifier.Keyword.PUBLIC)
                .setType("Person")
                .setBody(new BlockStmt().addStatement(new ReturnStmt(new NameExpr("author"))));

        // 6. Generate the Java code as a string
        String code = cu.toString();
        System.out.println("--- Generated Code ---");
        System.out.println(code);
        System.out.println("----------------------");

        // 7. Write the code to a file
        try {
            String fileName = "Book.java";
            Files.write(Paths.get(fileName), code.getBytes());
            System.out.println("Successfully created file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

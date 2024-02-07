package com.examp_maven.Test_maven;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StudentTests {
    @Test
    public void getAllStudentsTest(){
        // Test inputs
        StudentConnector connector = new StudentConnector("mongodb://localhost:27017/", "StudentDB");
        long actual = connector.database.getCollection(connector.collectionName).countDocuments();
        long predicted = connector.getAllStudents().size();
        assertEquals(predicted, actual);
    }

    @Test
    public void getStudentTest(){
        StudentConnector connector = new StudentConnector("mongodb://localhost:27017/", "StudentDB");
        Student testStu  = connector.getStudent("Ben");
        String actual = "4b";
        String predicted = testStu.studentClass;
        assertEquals(predicted, actual);
    }

    @Test
    public void addStudentTest(){
        StudentConnector connector = new StudentConnector("mongodb://localhost:27017/", "StudentDB");
        long actual = (connector.database.getCollection(connector.collectionName).countDocuments() + 1);

        Student newStu = new Student(4,15,"Jackson","Jackie","4c");
        connector.addStudent(newStu);

        long predicted = connector.database.getCollection(connector.collectionName).countDocuments();
        assertEquals(predicted, actual);
        connector.deleteStudent("Jackie");
    }

    @Test
    public void deleteStudentTest(){
        StudentConnector connector = new StudentConnector("mongodb://localhost:27017/", "StudentDB");
        Student newStu = new Student(4,15,"Brown","Jeffery","4c");
        connector.addStudent(newStu);

        long actual = (connector.database.getCollection(connector.collectionName).countDocuments() - 1);
        connector.deleteStudent("Jeffery");

        long predicted = connector.database.getCollection(connector.collectionName).countDocuments();
        assertEquals(predicted, actual);
    }

    @Test
    public void updateStudentTest(){
        StudentConnector connector = new StudentConnector("mongodb://localhost:27017/", "StudentDB");
        Student newStudent = new Student(6,18,"Munro","Lisa","6a");
        Document query = new Document("name", "Lisa");

        Document doc = connector.database.getCollection(connector.collectionName).find(query).first();
        Double actual = (double) doc.get("age");

        connector.updateStudent(newStudent);

        doc = connector.database.getCollection(connector.collectionName).find(query).first();

        Double predicted = (double) doc.get("age");
        assertNotEquals(predicted, actual);

        Student oldStudent = new Student(6,17,"Munro","Lisa","6a");
        connector.updateStudent(oldStudent);

    }
}

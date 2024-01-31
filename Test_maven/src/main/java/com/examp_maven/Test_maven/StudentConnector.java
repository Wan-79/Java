package com.examp_maven.Test_maven;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

public class StudentConnector {
    public MongoDatabase database;
    public String collectionName = "Students";

    public StudentConnector(String url, String stringCollection) {

        try {
            MongoClient mongoClient = MongoClients.create(url);
            database = mongoClient.getDatabase(stringCollection);
        }
        catch (Exception exception) {
            System.err.println("There is an error" + exception);
        }

    }

    public List<Student> getAllStudents() {

        MongoCollection<Document> collection = database.getCollection(collectionName);
        List<Document> studentsDoc = collection.find().into(new ArrayList<>());
        List<Student> students = new ArrayList<>();

        for(Document studentDoc: studentsDoc){

            int tempYear = studentDoc.getInteger("year");
            int tempAge = studentDoc.getInteger("age");
            String tempSurname = studentDoc.getString("surname");
            String tempName = studentDoc.getString("name");
            String tempClass = studentDoc.getString("studentClass");

            Student studentProfile = new Student(tempYear, tempAge, tempSurname, tempName, tempClass);
            students.add(studentProfile);
        }
        return students;
    }

    public Student getStudent(String studentName) {

        MongoCollection<Document> collection  = database.getCollection(collectionName);

        Document query = new Document("name", studentName);
        Document doc = collection.find(query).first();

        Student stu = new Student(doc.getInteger("year"),doc.getInteger("age"),
                doc.getString("surname"), doc.getString("name"), doc.getString("studentClass"));

        return stu;
    }

    public void addStudent(Student student) {

        MongoCollection<Document> collection  = database.getCollection(collectionName);

        String jsonFormat = "{" + "year" + ":" + student.year +"," + "age" + ":" + student.age + ","
                + "surname" + ":\"" + student.surname + "\"," + "name" + ":\"" + student.name + "\","
                + "studentClass" + ":\"" + student.studentClass + "\"}";

        Document stu = Document.parse(jsonFormat);

        collection.insertOne(stu);

        System.out.println("Student " + student.name + " " + student.surname + " has been added to the database");

    }

    public void deleteStudent(String studentName) {

        MongoCollection<Document> collection  = database.getCollection(collectionName);

        Document query = new Document("name", studentName);

        collection.deleteOne(query);

        System.out.println("Student with name " + studentName + " has been deleted from the database");
    }

    public void updateStudent(Student student) {

        MongoCollection<Document> collection  = database.getCollection(collectionName);

        String jsonFormat = "{" + "year" + ":" + student.year +"," + "age" + ":" + student.age + ","
                + "surname" + ":\"" + student.surname + "\"," + "name" + ":\"" + student.name + "\","
                + "studentClass" + ":\"" + student.studentClass + "\"}";

        Document stu = Document.parse(jsonFormat);
        Document query = new Document("name", student.name);
        Document update = new Document("$set", stu);
        collection.updateOne(query, update);
        System.out.println(student.name + "'s document was successfully updated");
    }
}

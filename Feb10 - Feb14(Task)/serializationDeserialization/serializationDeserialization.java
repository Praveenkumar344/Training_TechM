import java.io.*;
import java.lang.*;
public class serializationDeserialization implements Serializable
{
    int rno;
    String name;
    String email;
    serializationDeserialization(int rno, String name,String email){
    this.rno=rno;
    this.name=name;
    this.email=email;
    
}
public static void main(String[] args){
   try{ FileOutputStream fout=new FileOutputStream("f.txt");
    ObjectOutputStream out=new ObjectOutputStream(fout);
    ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
    serialize(115,"praveen","praveen115@gmail.com",out);
    serialize(117,"sanjay","sanajay1117@gmail.com",out);
    deserialize(in);
    deserialize(in);}
    catch (Exception e){};
}

 static void serialize(int rno, String name,String email,ObjectOutputStream out) {
    try{
    //Creating the object
    serializationDeserialization s1 =new serializationDeserialization( rno,  name, email);
    //Creating stream and writing the object
    out.writeObject(s1);
    // out.flush();
    // //closing the stream
    // out.close();
    System.out.println("success for " + name);
}
catch(Exception e){System.out.println(e);}
}


 static void deserialize( ObjectInputStream in) {
    try{
        //Creating stream to read the object
        serializationDeserialization s=(serializationDeserialization)in.readObject();
        //printing the data of the serialized object
        System.out.println(s.rno+" "+s.name+" "+s.email);
        //closing the stream
        // in.close();
    }catch(Exception e){System.out.println("error ::"+e);}
}

}
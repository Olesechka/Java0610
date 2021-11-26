package lesson11;

import java.io.Closeable;
import java.io.IOException;

public class TryWithResourcesApp {

    public static void main(String[] args) {
        try (
                MyResource resource = new MyResource("resource 1");
                MyResource resource2 = new MyResource("resource 2");
        ){

            resource.read();
            resource2.read();

        } catch (Exception ex){
            //ignore
        } //finally {
//            if (resource != null) {
//                try {
//                    resource.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }

        }


    private static class MyResource implements Closeable {

        private final String name;

        private MyResource(String name) {
            System.out.println(name + " created");
            this.name = name;
        }

        public void read(){
            System.out.println("read from resource");
        }

        @Override
        public void close() throws IOException {
            System.out.println(name + " closed");
        }
    }
}

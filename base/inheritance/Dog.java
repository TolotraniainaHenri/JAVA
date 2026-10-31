
public class Dog  extends Animal {
        Dog(String name){ 
        super(name); // call constructor of Animal
        }

        @Override   // redefinition of method speak()
        void speak(){
                System.out.println("The dog " + name +" goes meaou!");
        }
}

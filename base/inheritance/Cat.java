public class Cat  extends Animal {
	Cat(String name){
	super(name); // call constructor of Animal
	}

	@Override   // redefinition of speak
	void speak(){
		System.out.println("The cat " + name +" goes meaou!");
	}
}

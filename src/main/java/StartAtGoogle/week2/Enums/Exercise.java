package StartAtGoogle.week2.Enums;

public class Exercise {

    enum birds{
        FLAMINGO("Phoentroics"){
            @Override
            public void sing() {
                System.out.println("tiitititititit");
            }
        },
        CANARY("serrinus"){
            @Override
            public void sing() {
                System.out.println("yoooooooooooooooooooo");

            }
        },
        MALLARD("anas playthrophy"){
            @Override
            public void sing() {
                System.out.println("howwwwwwwwwwwwwwwwwwwww");
            }
        },
        ROOSTER("gallus gallus"){
            @Override
            public void sing() {
                System.out.println("krkkrkrkkrkr");

            }
        };

        birds(String name) {
            this.name = name;
        }
        public final String name;
        public abstract void sing();

    }
    public static void main(String[] args){
        birds bird = birds.FLAMINGO;
        bird.sing();

        birds bird2 = birds.MALLARD;
        bird2.sing();
    }

}



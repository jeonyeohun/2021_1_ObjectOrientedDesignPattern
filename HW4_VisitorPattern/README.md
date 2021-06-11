## User Manual

1. Compilation 

   ~~~shell
   javac *.java
   ~~~

2. Run

   ~~~shell
   java RoverSimulator
   ~~~



## Desgin Document 

### Overall Design 

<img src="/Users/jeonyeohun/Library/Application Support/typora-user-images/스크린샷 2021-06-12 오전 1.50.05.png" alt="스크린샷 2021-06-12 오전 1.50.05" style="zoom:50%;" />



- Wheel, Motor, Camera, SolarPanel, Arm 은 RoverElement 를 implement 하는 Rover의 부품들입니다.

- CheckVisitor, BuilVisitor, ResponseVisitor 는 Visitor 를 implement 하는 실제 로직이 구현된 `Visitor Pattern` 객체들입니다.

- Director, Builder, HTMLBuilder 는 `Builder Pattern` 으로 구현된 HTML 작성과 관련된 객체들입니다.

- BlackBox 는 `Singleton Pattern` 으로 운영되는 객체입니다.

- PanelContainer 는 `Flyweight pattern` 으로 새로운 Solar Panel instance 를 제공하는 객체입니다. 

- RoverSimulator는 `main class` 로 Rover instance 를 생성하고 실행합니다.

  

### Visitor pattern

본 프로그램에서는 세 개의 Visitor 객체들이 로직을 수행합니다. 그리고 각 객체들은 다음과 같은 Visitor interface를 구현하는 구현체입니다.

~~~java
public interface Visitor {
    public void visit(Motor motor);
    public void visit(Camera camera);
    public void visit(Wheel wheel);
    public void visit(Arm arm);
    public void visit(SolarPanel solarPanel);
}

~~~

Rover 를 구성하는 각 객체들에 대한 visit가 선언되어 있고 세 개의 Visitor 객체들은 각자의 역할에 맞게 visit method 를 구현합니다.

#### CheckVisitor.java, ResponseVisitor.java, BuildVisitor.java

Visitor 객체들은 다음과 같이 사용됩니다.

~~~java
// Checking Status //
System.out.println("The First Visitor for Checking Components");
System.out.println("\n*** Start Checking Wheel ***\n");
for (Wheel wheel : wheels) {
    wheel.accept(new CheckVisitor());
}

System.out.println("\n### Start Checking Motor ###\n");
for (Motor motor : motors) {
    motor.accept(new CheckVisitor());
}

System.out.println("\n!!! Start Checking Solar Panel !!!\n");
for (SolarPanel solarPanel : panels) {
    solarPanel.accept(new CheckVisitor());
}

System.out.println("\n... Start Checking Robot Arm ...\n");
for (Arm arm : arms) {
    arm.accept(new CheckVisitor());
}

System.out.println("\n... Start Checking Camera ...\n");
camera.accept(new CheckVisitor());
~~~

instance 를  생성한 RoverElement 객체들의 accept method의 인자로 Visitor 객체가 전달됩니다. 그리고,

~~~java
@Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
~~~

각 instance 들은 visitor 객체의 visit method 를 실행하며 자기자신을 인자로 전달합니다. Visitor 객체 내부에는 Overloading 된 visit 메서드가 각 RoverElement 의 구현체에 대해 정의되어 있어, Wheel, Motor, SolarPanel, Arm, Camera 에 대해 다른 로직을 수행합니다.



### Flyweight Pattern

SolarPanel instance 들은 모두 PanelContainer 객체에서 Flyweight Pattern을 통해 생성됩니다. PanelContainer 는 다음과 같이 구현되어 있습니다.

~~~java
private Map<Integer, SolarPanel> map = new HashMap<Integer, SolarPanel>();
    public SolarPanel getPanel(int id) {
        SolarPanel panel = map.get(id);
        if (panel == null) {
            panel = new SolarPanel(id);
            map.put(id, panel);
        }
        return panel;
    }
~~~

만약 요청한 아이디(패널 번호)를 가진 SolarPanel 의 생성 요청이 들어오면 새롭게 생성하지 않고 HashMap에 저장된 기존의 SolarPanel을 반환하고, 없다면 새로운 SolarPanel을 하나 만든 뒤 HashMap 에 저장 후 반환합니다.



### Prototype Pattern

RoverElement 의 구현체들 중 Arm 은 Prototype Pattern 을 통해 생성합니다. Arm 객체는 Clonable 객체를 상속하고, clone 메서드를 아래와 같이 overriding 합니다.

~~~java
@Override
    public Object clone() {
        try {
            Arm copy = (Arm) super.clone();
            return copy;

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }

    }
~~~

Arm 객체의 새로운 생성이 요청되면, new 를 통해 새로운 객체를 생성하는 것이 아니라, 기존 Arm 객체를 복사하여 재사용합니다.



### Singleton Pattern 

Blackbox 객체는 Singleton Pattern 으로 프로그램 시작 시 단 한번만 생성되며, 이곳에 이벤트에 대한 정보를 저장합니다.

~~~java
ArrayList<String> states = new ArrayList<>();
    private static BlackBox blackBox = null;

    public static BlackBox getInstance() {
        if (blackBox == null){
            blackBox = new BlackBox();
        }
        return blackBox;
    }
~~~

위와 같이 states 안에 생성된 Alarm 과 Action을 저장하고, 이벤트가 발생할 때마다, getIntance() method를 호출하여 Blackbox 인스턴스를 전달받습니다. 이를 위해 Blackbox instance 는 static modifier 가 설정되어 있습니다. 만약 instance 가 생성된 적이 없다면 새로 생성하고, 생성된 instance가 존재한다면 해당 instance 를 그대로 반환합니다.



### Builder Pattern 

HTML 문서를 작성하기 위해 Builder Pattern 이 사용됩니다. Builder Pattern 을 위해 HTMLBuilder.java, Director.java 가 사용되는데, Director.java 는 사용하 Builder instance 를 전달받아 지정된 로직을 순서대로 수행하는 역할을 합니다.

~~~java
public Director(Builder builder){
        this.builder = builder;
}
~~~

이렇게 생성자를 통해 사용할 Builder 를 입력받고,

~~~java
builder.makeTitle("Rover Running");

builder.makeText("Each Wheel Turns Adapting to Terrain State");
for (Wheel wheel : wheels){
    wheel.accept(new BuildVisitor(builder));
}

builder.makeText("Each Motor Controls Power Consumption");
for (Motor motor : motors){
    motor.accept(new BuildVisitor(builder));
}

builder.makeText("Solar Panel Generating Electricity");
for (SolarPanel solarPanel : panels){
    solarPanel.accept(new BuildVisitor(builder));
}

builder.makeText("Robot Arm in Operation");
arms.get(0).accept(new BuildVisitor(builder));

builder.makeText("Camera in Operation");
camera.accept(new BuildVisitor(builder));

builder.close();
~~~

각 RoverElement 구현체에 대한 정보를 전달된 Builder instance를 통해 입력합니다. 본 프로그램의 경우에는 HTML을 작성하는 Builder 를 사용합니다.



### Top-Down Approach

가독성 좋은 설계를 위해 Main Class 에는 Rover 를 생성하고 실행하는 코드만을 담았습니다.

~~~java
public class RoverSimulator {
    public static void main (String[] args) {
        Rover rover = new Rover();
        rover.run();
    }
}
~~~



그리고 Rover 객체는 다음과 같이 실행되는 알고리즘을 한 눈에 파악할 수 있도록 구성했습니다.

~~~java
public void run(){
    initRover();
    runCheckVisitor();
    runActionVisitor();
    runBuilderVisitor();
    displayBlackbox();
}
~~~


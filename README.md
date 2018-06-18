# First Grade Math App
First Grade Math App based on Common Core Standards

### Common Core Standards Implemented
* [CCSS.MATH.CONTENT.1.OA.A.1](http://www.corestandards.org/Math/Content/1/OA/A/1/): 
Use addition and subtraction within 20 to solve word problems involving situations of adding to, 
taking from, putting together, taking apart, and comparing, with unknowns in all positions, 
e.g., by using objects, drawings, and equations with a symbol for the unknown number to represent 
the problem.


### Using Zapptitude APIs

**Sample #1: Beginning a task**
```
    /**
     * Beginning a Task for a given context
     */
    void logBeginTaskExample1() {
        String task = "3+3=?";
        String context = "addition";

        Zapptitude.logBeginTask(task, context);
    }
```

**Sample #2: Tracking successful task completion for given task, topic and context.**
    
```
    /**
     * Sample Zapptitude event logged for a given task
     */
    void logSolvedIntTaskExample1() {
        String task = "3+3=?";
        String context = "addition";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 6;
        int actual = 6;

        Zapptitude.logSolveIntTask(task, context,
                topic, expected, actual);
    }

```
**Sample #3: Tracking unsuccessful task completion for given task, topic and context.**
```
    /**
     * Sample Zapptitude event logged for a given task
     */
    void logSolvedIntTaskExample1() {
        String task = "3+3=?";
        String context = "addition";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 6;
        int actual = 8;

        Zapptitude.logSolveIntTask(task, context,
                topic, expected, actual);
    }

```

**Sample #4: Tracking successful task completion for given task, topic and another context.**

```
    void logSolvedIntTaskExample2() {
        String task = "3-1=?";
        String context = "subtraction";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 2;
        int actual = 2;

        Zapptitude.logSolveIntTask(task, context,
                topic, expected, actual);
    }
```

**Sample #5: Requesting Zid**
```
    /**
     * Once Zapptitude is enabled in app, it sends event data anonymously unless a Zid is requested.
     * Zid is important when user wishes to see progress reports at Zapptitude's dashboard.
     */
    void requestZid() {
        Zapptitude.requestZappId();
    }
```

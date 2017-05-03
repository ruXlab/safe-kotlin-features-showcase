package sealed_classes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rux on 03/05/17.
 */
public class JEventDispatcher {
    public static void main(String[] args) {
        new JEventDispatcher().run();
    }

    void run() {
        List<JEventBase> events = Arrays.asList(
            new JMouseClick(42, 200, 1),
            new JMouseMove(46, 203),
            new JMouseMove(50, 210),
            new JMouseClick(40, 210, 3),
            new JKeyPressed('j')
        );

        events.forEach(this::process);
    }

    private void process(JEventBase event) {
        String log = "";
        if (event instanceof JMouseClick) {
            log = "Mouse click button #" +  ((JMouseClick) event).btn + " at "
                + ((JMouseClick) event).x + ", " + ((JMouseClick) event).y;
        } else if (event instanceof JMouseMove) {
            log = "Mouse move to " + ((JMouseMove) event).x + ", " + ((JMouseMove) event).y;
        } else if (event instanceof JKeyPressed) {
            log = "Key '" + ((JKeyPressed) event).key + "' pressed";
        } else throw new IllegalArgumentException("Got unknown event");
        System.out.println(event.getClass().getSimpleName() + "> " + log);
    }
}

abstract class JEventBase { }

class JMouseMove extends JEventBase {
    public int x, y;

    public JMouseMove(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class JMouseClick extends JEventBase {
    public int x, y, btn;

    public JMouseClick(int x, int y, int btn) {
        this.x = x;
        this.y = y;
        this.btn = btn;
    }
}


class JKeyPressed extends JEventBase {
    char key;

    public JKeyPressed(char key) {
        this.key = key;
    }
}


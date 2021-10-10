import org.testng.annotations.Test;

public class MainTest {
    @Test(description = "Тест запуска без аргументов, не должен ничего возвращать и показывать.")
    public void testWithNoArgs() {
        Main.main(new String[0]);
    }

    @Test(description = "Тест запуска с невалидным аргументами.")
    public void testWithInvalid() {
        String[] args = {"invalid"};
        Main.main(args);
    }

    @Test(description = "Запуск с последовательностью СУПЕР СПИН.")
    public void testWithCommands() {
        String[] args = {"U", "R2", "F", "B", "R", "B2", "R", "U2", "L", "B2", "R", "U'", "D'", "R2", "F", "R'", "L", "B2", "U2", "F2"};
        Main.main(args);
    }

    @Test(description = "Запуск с рандомным кубиком, запутанным на 30 поворотов.")
    public void test5RandomMoves() {
        String[] args = {"5"};
        Main.main(args);
    }

    @Test(description = "Запуск с рандомным кубиком, запутанным на 30 поворотов.")
    public void test30RandomMoves() {
        String[] args = {"30"};
        Main.main(args);
    }

    @Test(description = "Запуск с рандомным кубиком, запутанным на 20 поворотов.")
    public void test20RandomMoves() {
        String[] args = {"20"};
        Main.main(args);
    }

    @Test(description = "Запуск отрицаетельным числом поворотов 20 поворотов.")
    public void testRandomMoves() {
        String[] args = {"-20"};
        Main.main(args);
    }
}
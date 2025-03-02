using System;

public class Program
{
    private enum State { START, GAME, PAUSE, EXIT }

    public static void Main()
    {
        State state = State.START;
        string[] screenName = { "START", "GAME", "PAUSE", "EXIT" };

        while (state != State.EXIT)
        {
            Console.WriteLine(screenName[(int)state] + " SCREEN");
            Console.Write("Enter Command: ");
            string command = Console.ReadLine()?.Trim().ToUpper(); // Handling null and case insensitivity

            switch (state)
            {
                case State.START:
                    if (command == "ENTER")
                        state = State.GAME;
                    else if (command == "QUIT")
                        state = State.EXIT;
                    break;

                case State.GAME:
                    if (command == "ESC")
                        state = State.PAUSE;
                    break;

                case State.PAUSE:
                    if (command == "BACK")
                        state = State.GAME;
                    else if (command == "HOME")
                        state = State.START;
                    else if (command == "QUIT")
                        state = State.EXIT;
                    break;
            }
        }
        Console.WriteLine("EXIT SCREEN");
    }
}

# Easy Chat Network

## Compiling

The project was built with maven, only need specify the phase do you want execute (For example mvn install).

## Execution

ChatController has been declared like main class, only need to execute the jar with not arguments (java- jar target/chat-0.0.1-SNAPSHOT.jar).

## Instructions

The chat gives you welcome, then wait for the instructions. These are the instructions:

- **Post something** (posting: <user name> -> <message>)
- **Read another user** (reading: <user name>)
- **Follow a user** (following: <user name> follows <another user>)
- **See your wall** (wall: <user name> wall)
- **Exit application** (exit: <user name>)

Whenever you write a command, the program registre the user if does not exist. Furthermore when use the command "Post", the program save this user like the user in session; this is use when you use the command "Reading", so the program knows who is the user in session.

## Software design

In this case it has been chosen "MVC" because has been thought to be the most interesting pattern for this program and for future modifications that add functionality. It was thought to use "abstract factory" for the diverse commands, but it was to add too much complexity, being able to summarize it in a controller.

## Testing

It has been realized some simple tests with JUnit to verify the correct behavior of some methods.
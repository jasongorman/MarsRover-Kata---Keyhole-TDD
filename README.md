# MarsRover-Kata---Keyhole-TDD
What is the effect of testing through the smallest API possible?

After much debate about how close to the units they're testing our unit tests should be, as well as how much "surface area" should be exposed to the test code, I did a little experiment.

This is the code I produced after TDD-ing the first part of the Mars Rover kata (initialise a rover, tell it to turn left and right, go back and forward). I set the rule that the tests could only instantiate a rover and call a single method (send()). They have no knowledge of any implementation class except Rover.

Pros: 1. The vast majority of the solution design is hidden from the test code, so internal design can change dramatically without rewriting any test code.

Cons: 1. When tests failed, it was hader to see where it had gone wrong. I spent much more time in the debugger.
      2. No dependency injection (since test code could only instantiate one class). Of course, I *could* use a DI framework... Meh.
      3. Let's say, in the future, we decide the Compass would be useful in other vehicles. If I extracted it into a shared library, it has no unit tests of its own - but implements a big chunk of the logic. Testing through an API maybe hinders reusability
      
      
      Conclusions?

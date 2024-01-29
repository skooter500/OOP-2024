# TU856/TU858 Object Oriented Programming 2024

![Logo](images/logo.png)

Teams:

Resources
---------
- [Discord](https://discord.gg/htBfm2VA)
- [Install the software you will need for this module](install.md)
* [Games Fleadh](http://www.gamesfleadh.ie/)
* [The git manual - read the first three chapters](http://git-scm.com/documentation)
* [A video tutorial all about git/github](https://www.youtube.com/watch?v=p_PGUltnB6w)
* [The Processing language reference](http://processing.org/reference/)

## Contact the lecturer
* Email: bryan.duggan@tudublin.ie
* Web: http://bryanduggan.org

## Assignments
- [Assignments](assignments.md)

# Week 1 - Introduction

## Lecture
- [Introduction Slides](https://tudublin-my.sharepoint.com/:p:/g/personal/bryan_duggan_tudublin_ie/EYXKcGlJFllBoLfJ_GjdH8ABu2OQCKyRsXuqlPqb3yXMtA?e=7hN0YC)

- [Recording of the class](https://tudublin-my.sharepoint.com/:v:/g/personal/bryan_duggan_tudublin_ie/EUzKV4H1siFOiSsI8Hv6teUBNBW_aols8cnkJN_MYskBYw?e=nJXD7A&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)

## Tutorial
- [Coding Bat](https://codingbat.com/)

## Lab
## Learning outcomes
- Set up Java, Visual studio code and the Java Extensions
- Fork the repo, configure the upstream remotes
- Write your first Java Program
- Test out Github classroom

## Part 1 - Setup Java, forking and cloning

Install the software you will need for this module and set up your path to the Java Development Kit. [This document explains what you need](install.md).

Fork this repository by clicking the fork button above, so that you get your own copy of the course repo to work on this semester. Now create a new empty folder on your computer somewhere right click on the folder and choose git bash here. Alternatively you can start the bash and cd to the new folder. To clone the repository for your fork:

```bash
git clone https://github.com/YOURGITUSERNAME/OOP-2024
```

Replace YOURGITUSERNAME with your github username. You can also copy the URL to the repo from your browser and paste it into the console. To paste into the bash on Windows is right click. You can use Cmd + C, Cmd + V on the Mac.

Now cd into the repo and check the origin and upstream remotes are set up correctly

```bash
cd OOP-2024
git remote -v
```

You should see something like this:

```bash
origin  https://github.com/YOURGITUSERNAME/OOP-2024 (fetch)
origin  https://github.com/YOURGITUSERNAME/OOP-2024 (push)
upstream  https://github.com/skooter500/OOP-2024 (fetch)
upstream  https://github.com/skooter500/OOP-2024 (push)
```

If you don't see the upstream remote, you can set it up by typing

```bash
git remote add upstream https://github.com/skooter500/OOP-2024
```
You can read more about forking a git repository and setting up the upstream remote in [this article](https://help.github.com/en/github/getting-started-with-github/fork-a-repo)

Once the upstream is setup, you will be able to push code to your own repo and also keep it up to date with the master branch of the changes I make each class.

If you already forked the repo before the lab, you may need to update your master branch from my master branch to get the changes I made:

```bash
git fetch
git checkout master
git pull upstream master
git push
```

Open the OOP-2024 folder in Visual Studio Code. You can run your program by choosing Run | Start Debugger. *Important for users of the Lab computers* In the labs you should use the shell scripts ```compile.sh``` and ```run.sh``` located in the Java folder to compile and run your code. You can run these from the Bash. 

You should see

```
Hello world
Woof. I am Misty
Woof. I am Lucy
cats are from space
```
Congratulations! You have successfully compiled and run your first Java program. 

## Part 2

Accept [this assignment on Github classroom](https://classroom.github.com/a/5nyQb4Oa)

You can open it in Codespaces or clone the repo and open on your computer. 

Submit your solution by doing a commit

- Create a Cat class
- Make a private ```int``` field on the Cat class called numLives.
- Write public accessors for the field (see how I did this for the name field on the Animal class)
- Set the value of this field to 9 in the Cat constructor  
- Write a method (functions are called methods in Java) on the Cat class called kill. It should subtract 1 from numLives if numLives is > 0 and print the message "Ouch!". If numLives is 0, you should just print the message "Dead"
- Create a new instance of the Cat class like this

    ```Java
    Cat ginger = new Cat("Ginger");
    ```
- In the Main class in a loop, call kill on ginger until ginger is dead.
- Compile and run your program until you have no bugs and you get the desired output.

Commit and push your changes:

```bash
git add .
git commit -m "killing the cat"
git push
```
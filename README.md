# Huffman Code

This project gives a simple (i.e. recursive and iterative) implementation of the Huffman code. The project is written in **Java**.

## Setup

### Prerequisites

This project requires a `JDK >= 8`, which can be [Oracle JDK](https://www.oracle.com/java/technologies/downloads/archive/) or [OpenJDK](https://openjdk.java.net/install/).

Please download and install the compatible JDK for your local machine. And make sure the jdk tools are available on path.

```bash
java --version
java 17.0.2 2022-01-18 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
```

### Compiling

To compile the source file, you invoke compiler via the `javac`:

```bash
javac -d bin src/Huffman.java
```

This will compile the source file into `*.class` files under `bin/` directory.

### Executing

To execute the bytecode, you will invoke the java runtime:

```bash
java -cp bin Huffman
```

**Note:** Class path must be specified to include bin directory.

## References

- https://www.programiz.com/dsa/huffman-coding
- UBCO COSC320 Couse Material.

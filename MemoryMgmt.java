JVM, GC, heap vs stack, make 1-page notes

Java Memory management

1 JVM 

JVM is responsible for :

Running java bytecode
Memory Management
Garbage collection
Security

Components of JVM
1.class loader
2.Runtime Data Areas
3.Execution engine
4.GC


2. JVM Memory Areas
Runtime Data Areas

Heap :  stores objects 
Stack : method calls and local variables
Method Area : class-level data
PC register : Tracks instruction
Navtive Stack : Native method calls


3 Heap Memory 🧠
What is Heap?

Shared memory

Stores objects and instance variables

Managed by Garbage Collector

Young Generation
 ├─ Eden
 ├─ Survivor S0
 └─ Survivor S1

Old Generation (Tenured)
Metaspace (Java 8+)

Eden → Survivor → Old Gen → GC

4️ Stack Memory 📚
What is Stack?

* Thread-specific memory
* Stores:
Local variables
Method calls
References

* Characteristics
Faster than heap
Automatically freed
LIFO (Last In First Out)


| Heap           | Stack                   |
| -------------- | ----------------------- |
| Stores objects | Stores method frames    |
| Shared         | Thread-specific         |
| GC managed     | Auto-managed            |
| Slower         | Faster                  |
| Can cause OOM  | Can cause StackOverflow |



6️ Garbage Collection (GC) ♻️
What is GC?
Automatic removal of unused objects from heap.

@n. When Object is Eligible for GC?
No reference pointing to it
obj = null;


❌ OutOfMemoryError
Heap full
Memory leak
Large objects

❌ StackOverflowError
Deep recursion
Infinite method calls

JVM Memory Areas
│
├── Heap
├── Stack
├── Method Area (Metaspace)
├── PC Register
└── Native Method Stack


# What is stored in Heap?
Objects
Instance variables
Arrays

Employee emp = new Employee();
➡ emp object → Heap
➡ reference emp → Stack

# STACK MEMORY
What is Stack?
Each thread has its own stack.

What is stored?
Method calls
Local variables
Object references

ex
void method() {
    int x = 10;      // stack
    Employee e = new Employee(); // reference in stack, object in heap
}

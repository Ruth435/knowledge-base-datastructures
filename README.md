# Generics Knowledge Base Simulation

## Project Overview
This project implements an interactive conceptual Knowledge Base (KB) designed to store, manage, update, and query factual statements using generic structure paradigms. The system processes facts composed of a key phrase (term), a factual statement, and an associated confidence level score. 

The primary engineering objective of this assignment was to implement the system across two entirely distinct backend data structures—an `Array-backed` framework and a `Binary Search Tree (BST)` framework—to explore object encapsulation, object reuse, and interface separation.

---

## System Architecture & Object-Oriented Design

The codebase relies on a modular, decoupled architecture to maximize code reuse and cleanly separate the data storage layers from the user interfaces:

* **`Facts.java` (Core Entity):** The foundational data object representing a single knowledge base entry, storing the key phrase, factual statement, and structural confidence score.
* **Array-Based Paradigm:**
  * **`FactsArray.java`:** Manages an array of `Facts` objects. Implements the underlying algorithmic logic for parsing bulk imports from text files, individual record entry, statement updates, and direct key/phrase search operations.
  * **`GenericsKbArrayApp.java`:** A dedicated CLI interface providing a clean abstraction layer for interacting specifically with the array-backed data structure.
* **Binary Search Tree Paradigm:**
  * **`BinaryTreeNode.java`:** Provides the structural node logic required for hierarchical cell linking, referencing individual `Facts` objects as node payloads.
  * **`FactsBST.java`:** Replicates the functional requirements of the array manager class (loading, insertion, updating, and querying) but translates the execution paths into an optimized Binary Search Tree.
  * **`GenericsKbBSTApp.java`:** A dedicated CLI interface mirroring the array app layout, ensuring a controlled environment for testing the hierarchical data model.

---

## Features & Interface Capabilities

Both storage systems support an interactive menu loop with the following operational capabilities:
1. **Bulk Initialization:** Dynamic loading and validation parsing of knowledge base files (e.g., `Test1.txt`).
2. **Dynamic Entry & Upsertion Logic:** Allows manual runtime additions of new facts. If a term already exists, the program evaluates the query and conditionally handles logic updates.
3. **Term Querying:** Search queries execution based strictly on a target key phrase to return the matching string and confidence value.
4. **Exact Match Verification:** A comprehensive validation query matching both the target key phrase and the literal factual statement to confirm database integrity.

### Notable Adaptations & Robustness
* **Input Validation Guardrails:** The user loops incorporate error-handling checks to gracefully intercept out-of-bounds integer selections or invalid command paths without crashing the engine execution loop.
* **Persistent Update Mechanics:** Refactored runtime state mechanics across both the Array and BST UI variations to guarantee that context updates map correctly down to the database objects.

---

## Sample Execution Log

The system reads formatted entry data organized as tab or newline-delimited records matching a strict metadata pattern:
```text
sea water
Sea water has capacity.
1.0
```

## Example Menu Interface
Choose an action from the menu:
1. Load a knowledge base from a file
2. Add a new statement to the knowledge base
3. Search for an item in the knowledge base by term
4. Search for an item in the knowledge base by term and sentence
5. Quit

Enter your choice: 3 <br>
Enter the term to search: Sea water <br>
Statement found: Sea water Sea water has capacity.. (Confidence score: 1.0) <br>

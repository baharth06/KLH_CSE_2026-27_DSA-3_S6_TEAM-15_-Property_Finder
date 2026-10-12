# 🏡 Property Finder - DSA Project
> **Advanced Real Estate Search Engine powered by String Pattern Matching & Algorithmic Optimization**  
> *Educational Data Structures & Algorithms (DSA) Project — Telangana Edition*
Batch No: 15
---
Batch No: 15
## 👥 Project Team & Mentorship


| **Name** |  Roll Number |
| :--- | :--- |
| **Yashwanth** | `2520030259` |
| **Bharath** | `2520030169` | 
| **Praneeth** | `2520030186` |

---
`Faculty Mentor: Dr. V. Sireesha`
---
## 📑 Table of Contents
1. [Abstract](#-1-abstract)
2. [Problem Statement](#-2-problem-statement)
3. [Why Pattern Matching is Required](#-3-why-pattern-matching-is-required)
4. [Algorithms Implemented](#-4-algorithms-implemented)
5. [How Each Algorithm Works](#-5-how-each-algorithm-works)
6. [Time & Space Complexity Analysis](#-6-time--space-complexity-analysis)
7. [Extended DSA Implementations (CO Integration)](#-7-extended-dsa-implementations-co-integration)
8. [Property Dataset (Telangana Focus)](#-8-property-dataset-telangana-focus)
9. [Project Architecture & Directory Structure](#-9-project-architecture--directory-structure)
10. [Setup & Execution Guide](#-10-setup--execution-guide)
11. [Sample Demonstrations & CLI Walkthrough](#-11-sample-demonstrations--cli-walkthrough)
12. [Future Extensions](#-12-future-extensions)
13. [Current Phase Status](#-13-current-phase-status)
14. [Each Member Contributions](#-14-Contributions)
---

## 📌 1. Abstract
The primary objective of **Property Finder** is to engineer a pure Java-based real estate search prototype designed around manual, from-scratch implementations of fundamental **String Matching and Pattern Matching Algorithms**. 

Unlike conventional applications relying on standard Java utilities (such as `String.indexOf()`, `String.contains()`, or database full-text indexing), this project demonstrates raw algorithmic scanning, state transitions, hashing, heuristic skipping, prefix tree search, graph traversal, and dynamic programming. The solution features zero external search dependencies, complete transparency in computational complexity, and robust handling of real-world search challenges such as fuzzy queries and typos.

---

## ❗ 2. Problem Statement
In commercial property portals (e.g., MagicBricks, NoBroker, 99acres), users continuously query vast catalogs looking for specific locations, amenities, configurations (e.g., "3 BHK", "Swimming Pool"), and structural details.

Key real-world hurdles addressed:
- **High-Volume Scanning**: Traversing multi-attribute property descriptions across hundreds of entries rapidly without excessive CPU overhead.
- **Sub-string & Multi-keyword Extraction**: Pinpointing pattern occurrences inside large concatenated description blocks.
- **Fuzzy Search & Typo Resilience**: Real users frequently mistype regional names (e.g., entering `Gachiboli` instead of `Gachibowli` or `Hydrabad` instead of `Hyderabad`). The system must detect misspellings, compute semantic distances, and provide instant suggestions.

---

## 🎯 3. Why Pattern Matching is Required
- **Sub-linear & Linear Lookups**: To preserve sub-second response times, algorithms like Boyer-Moore and KMP prevent quadratic $O(N \cdot M)$ worst-case bottlenecks.
- **Multiple Keyword Queries**: Efficient pattern detection allows users to query compound constraints (e.g., searching for "Gated Community", "Gachibowli", and "Gym").
- **Zero Library Reliance**: Manual algorithmic implementations offer granular control over comparison counts, shifting logic, and benchmark transparency.
- **Error Tolerance**: Levenshtein Edit Distance enables intelligent query auto-correction, maintaining high user retention and search fidelity.

---

## 🔬 4. Algorithms Implemented

### 🔍 Exact Pattern Matching
1. **Naive String Search** (Brute-Force baseline)
2. **Knuth-Morris-Pratt (KMP)** (Deterministic Finite Automaton / LPS Array)
3. **Z-Algorithm** (Linear Z-box matching)
4. **Rabin-Karp Algorithm** (Rolling Polynomial Hash Matching)
5. **Boyer-Moore Algorithm** (Bad-Character Heuristic)

### 🧩 Approximate & Fuzzy Matching
6. **Levenshtein Edit Distance** (Dynamic Programming Matrix)

### 🌳 Extended DSA Suite
7. **Trie Prefix Tree** (Real-time Location Autocomplete)
8. **Breadth-First Search (BFS) on Graphs** (Telangana Inter-district Proximity)
9. **0/1 Knapsack Optimization (DP)** (Investor Portfolio Area Maximization)
10. **Randomized QuickSort** (Median-of-partition sorting for Price and Area)

---

## ⚙️ 5. How Each Algorithm Works

### 1. Naive Pattern Matcher
- **Mechanism**: Slides the pattern over the target text character-by-character from index $0$ to $(N - M)$.
- **Behavior**: Compares characters until a mismatch occurs. If a mismatch is found, it shifts the pattern forward by exactly $1$ index and starts over.
- **Use Case**: Simple baseline comparison for very short texts.

### 2. Knuth-Morris-Pratt (KMP)
- **Mechanism**: Precomputes a **Longest Prefix Suffix (LPS)** array of length $M$.
- **Behavior**: When a mismatch occurs after $j$ matched characters, the pattern does not restart from index $0$. Instead, it jumps to `LPS[j - 1]`, preventing back-tracking in the main text string.
- **Efficiency**: Guarantees strict $O(N + M)$ linear time complexity.

### 3. Z-Algorithm
- **Mechanism**: Constructs a concatenated string $S = \text{Pattern} + \text{"\$"} + \text{Text}$.
- **Behavior**: Generates a **Z-array** where $Z[i]$ represents the length of the longest substring starting from $S[i]$ that matches the prefix of $S$.
- **Efficiency**: Identifies all occurrences where $Z[i] == M$ in pure linear time using an active $[L, R]$ match box.

### 4. Rabin-Karp Algorithm
- **Mechanism**: Calculates a **rolling polynomial hash** for the pattern and each moving window of length $M$ in the text.
- **Behavior**: Hashes the sliding window in $O(1)$ time by subtracting the leading character and appending the trailing character. Performs explicit character validation only upon hash collision.
- **Efficiency**: High average speed; handles multi-pattern extensions effectively.

### 5. Boyer-Moore Algorithm
- **Mechanism**: Scans pattern characters from **right to left** (tail to head).
- **Behavior**: Utilizes the **Bad-Character Heuristic**: upon a mismatch with text character $c$, shifts the pattern so that the last occurrence of $c$ aligns with the mismatch, skipping large blocks of text.
- **Efficiency**: Achieves sub-linear average time $O(N / M)$ on typical natural language texts.

### 6. Levenshtein Edit Distance (DP)
- **Mechanism**: Constructs a 2D Dynamic Programming table of size $(|S_1| + 1) \times (|S_2| + 1)$.
- **Behavior**: Computes the minimum number of insertions, deletions, and substitutions to transform query string $S_1$ into target string $S_2$:
  $$\text{cost} = \min(D[i-1][j] + 1, \; D[i][j-1] + 1, \; D[i-1][j-1] + \text{cost}_{sub})$$
- **Application**: Triggers when zero exact matches are found, suggesting nearest Telangana landmarks (e.g., `Gachiboli` $\rightarrow$ `Gachibowli` at $90\%$ similarity).

---

## 📊 6. Time & Space Complexity Analysis

| Algorithm | Preprocessing Time | Best / Average Search | Worst Case Search | Space Complexity | Primary Role in PropertyFinder |
| :--- | :---: | :---: | :---: | :---: | :--- |
| **Naive Matcher** | None | $O(N \cdot M)$ | $O(N \cdot M)$ | $O(1)$ | Baseline benchmark comparison |
| **KMP Algorithm** | $O(M)$ | $O(N + M)$ | $O(N + M)$ | $O(M)$ | Text description keyword matching |
| **Z Algorithm** | $O(N + M)$ | $O(N + M)$ | $O(N + M)$ | $O(N + M)$ | Multi-keyword exact scanning |
| **Rabin-Karp** | $O(M)$ | $O(N + M)$ | $O(N \cdot M)$ | $O(1)$ | Hash-based property attribute scan |
| **Boyer-Moore** | $O(M + \Sigma)$ | $O(N / M)$ | $O(N \cdot M)$ | $O(\Sigma)$ | Large descriptive document search |
| **Levenshtein DP**| None | $O(L_1 \cdot L_2)$ | $O(L_1 \cdot L_2)$ | $O(L_1 \cdot L_2)$ | Typo tolerance & Did-You-Mean suggestions |
| **Trie Autocomplete** | $O(\sum L)$ | $O(L)$ | $O(L)$ | $O(\sum L \cdot \Sigma)$| Real-time location search suggestions |
| **District Graph BFS**| $O(V + E)$ | $O(V + E)$ | $O(V + E)$ | $O(V)$ | Proximity & adjacent district locator |
| **0/1 Knapsack (DP)** | None | $O(n \cdot W)$ | $O(n \cdot W)$ | $O(n \cdot W)$ | Investor mode budget optimization |
| **Randomized QuickSort**| None | $O(K \log K)$ | $O(K^2)$ | $O(\log K)$ | Price / Area sorting of matched listings |

*Notation: $N$ = text length, $M$ = pattern length, $\Sigma$ = alphabet size, $L$ = query length, $V, E$ = graph vertices & edges, $W$ = budget capacity, $K$ = number of matched results.*

---

## 💡 7. Extended DSA Implementations (CO Integration)

This project satisfies all Academic Course Outcomes (**CO1 to CO6**):

| Course Outcome | Description | Data Structure / Algorithm | Practical Feature |
| :---: | :--- | :--- | :--- |
| **CO1 & CO2** | Exact String & Pattern Matching | KMP, Z-Algorithm, Rabin-Karp, Boyer-Moore | Dynamic Search Engine with algorithm selector |
| **CO3** | Advanced Dynamic Programming | Levenshtein Distance Matrix | Typo auto-correction & fuzzy suggestion |
| **CO4** | Graph Theory & Traversal | Adjacency List + Breadth-First Search (BFS) | Neighboring district discovery (1-hop / 2-hop) |
| **CO5** | Optimization & DP | 0/1 Knapsack Dynamic Programming | Investor Mode: Maximizing total area within budget |
| **CO6** | Randomized Algorithms | Randomized Pivot QuickSort | Fast, un-skewed sorting of property listings |

---

## 🗺️ 8. Property Dataset (Telangana Focus)
The dataset comprises curated real estate listings spanning major IT corridors and administrative districts in **Telangana**:

- **Hyderabad Urban Nodes**:
  - Gachibowli, Madhapur, Hitec City, Kondapur, Financial District, Jubilee Hills, Banjara Hills, Begumpet, Secunderabad, Kukatpally.
- **Tier-2 & Regional Districts**:
  - Warangal, Hanamkonda, Karimnagar, Nizamabad, Khammam, Nalgonda, Siddipet, Medak, Mahbubnagar, Ranga Reddy.
- **Attributes per Entry**:
  - `Property ID`, `Title`, `Location`, `District`, `Price (INR)`, `Area (sq. ft.)`, `Type (Villa / Apartment / Plot)`, `Amenities (Gym, Pool, Security, Clubhouse, Power Backup, Garden)`.

---

## 🏗️ 9. Project Architecture & Directory Structure

```text
PropertyFinder/
├── run.bat                          # 1-Click Launch Script for Windows
├── run.sh                           # 1-Click Launch Script for Linux / macOS
├── README.md                        # Complete Project Documentation
├── data/                            # Raw data resources
├── docs/                            # Academic notes & diagrams
├── public/                          # Modern Web UI assets (HTML, CSS, JS)
│   ├── index.html
│   ├── style.css
│   └── app.js
├── CO-wise-implementation/          # Standalone implementations for CO evaluation
│   ├── CO1/AlgorithmSelector.java
│   ├── CO2/StringMatching.java
│   ├── CO3/EditDistance.java
│   ├── CO4/BipartiteMatching.java
│   ├── CO5/KnapsackPropertySelection.java
│   └── CO6/RandomizedQuickSort.java
└── src/                             # Production Engine Source Code
    ├── Main.java                    # CLI Entry Point & Interactive Menu
    ├── algorithms/                  # Core Algorithmic Implementations
    │   ├── BoyerMooreMatcher.java
    │   ├── KMPPatternMatcher.java
    │   ├── LevenshteinMatcher.java
    │   ├── LocationGraph.java       # Telangana District Graph & BFS
    │   ├── NaivePatternMatcher.java
    │   ├── QuickSortProperties.java # Randomized QuickSort
    │   ├── RabinKarpMatcher.java
    │   ├── TrieAutocomplete.java    # Location Prefix Trie
    │   └── ZPatternMatcher.java
    ├── data/
    │   └── TelanganaPropertyData.java # Rich Telangana Catalog
    ├── model/
    │   └── Property.java            # Property Entity Definition
    ├── service/
    │   ├── InvestorService.java     # Knapsack Budget Engine
    │   └── PropertySearchService.java # Algorithmic Dispatcher
    ├── utils/
    │   ├── ANSIColor.java           # Terminal Highlighting Engine
    │   └── JsonUtil.java            # JSON Serializer for Web API
    └── web/
        └── WebServer.java           # Embedded HTTP REST & Static Server
```

---

## 🚀 10. Setup & Execution Guide

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher (JDK 17+ recommended).
- **Terminal**: PowerShell / Command Prompt (Windows) or Bash / Zsh (Linux/macOS).

---

### Option A: 1-Click Launcher (Recommended)

#### For Windows:
```cmd
.\run.bat
```
*(Or simply double-click `run.bat` in File Explorer).*

#### For Linux / macOS:
```bash
chmod +x run.sh
./run.sh
```

---

### Option B: Manual Command Line Compilation

1. Navigate to the project root directory:
   ```bash
   cd PropertyFinder
   ```

2. Compile all source files into a `bin` directory:
   ```bash
   # Windows (PowerShell)
   javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName

   # Linux / macOS / Git Bash
   javac -d bin $(find src -name "*.java")
   ```

3. Run the interactive application:
   ```bash
   java -cp bin Main
   ```

---

### Option C: Launch Modern Web Application

1. Start `Main.java` and select **Option 6**, or run directly:
   ```bash
   java -cp bin web.WebServer
   ```
2. Open your browser and navigate to:
   ```text
   http://localhost:8080
   ```

---

## 💻 11. Sample Demonstrations & CLI Walkthrough

### Scenario 1: Fuzzy Typo Correction & KMP Search
```text
============================================================
              PROPERTY FINDER - DSA MODEL
============================================================
1. Search Properties (String Algorithms)
2. Auto-Complete Location Search (Trie)
3. Investor Mode: Maximize Area by Budget (0/1 Knapsack)
4. Explore Nearby Districts (Graph BFS)
5. Show All Properties (QuickSort Available)
6. Launch Web Server UI
7. Exit

Enter choice: 1
Enter search pattern (e.g., 'Pool', 'Gachibowli'): Gachiboli

Did you mean: 'Gachibowli'? (y/n): y
Select algorithm (1: Naive, 2: KMP, 3: Z, 4: Rabin-Karp, 5: Boyer-Moore): 2

[+] Searching using Knuth-Morris-Pratt (KMP) Algorithm...
Found 6 matching properties:
--------------------------------------------------------------------------------
[HYD-101] Luxury 3 BHK High-Rise Apartment
Location: Gachibowli, Hyderabad | Price: ₹1,45,00,000 | Area: 2,150 sq.ft
Amenities: Swimming Pool, Gym, 24/7 Security, Clubhouse
--------------------------------------------------------------------------------
[HYD-104] Premium Gated Community Villa
Location: Gachibowli, Hyderabad | Price: ₹3,20,00,000 | Area: 3,800 sq.ft
Amenities: Private Garden, Pool, Solar Backup, Club
--------------------------------------------------------------------------------
Algorithm Used : Knuth-Morris-Pratt (KMP)
Total Matches  : 6
Execution Time : 0.84 ms

Sort results? (1: Price Low to High, 2: Area High to Low, 3: None): 1
Sorted using: Randomized QuickSort [Pivot Strategy: Uniform Random]
```

---

### Scenario 2: Location Auto-Complete via Trie
```text
Enter choice: 2
Enter prefix to search (e.g., 'Kha', 'Gach', 'War'): Kha

Locations starting with 'Kha':
 -> Khajaguda
 -> Khammam
 -> Kothagudem
```

---

### Scenario 3: Investor Mode (0/1 Knapsack Optimization)
```text
Enter choice: 3
Enter your maximum investment budget (INR): 25000000

============================================================
             INVESTOR PORTFOLIO OPTIMIZATION
============================================================
Budget: ₹2,50,00,000 (~2.50 Cr)
Running 0/1 Knapsack Dynamic Programming Engine...

Selected Properties to Maximize Total Acquired Area:
1. [HYD-108] 2 BHK Smart Flat | Kondapur | ₹75,00,000 | 1,250 sq.ft
2. [WGL-202] Independent Duplex House | Warangal | ₹65,00,000 | 2,400 sq.ft
3. [KMM-401] Commercial Plot | Khammam | ₹95,00,000 | 4,500 sq.ft

Summary:
- Total Budget Utilized : ₹2,35,00,000
- Remaining Funds       : ₹15,00,000
- Maximum Area Acquired : 8,150 sq.ft
```

---

### Scenario 4: Graph BFS District Proximity
```text
Enter choice: 4
Enter district name (e.g., 'Warangal', 'Karimnagar'): Warangal

Adjacent & Neighboring Districts (BFS Hops = 1 to 2):
- Hanamkonda (Direct Neighbor - 1 hop)
- Jangaon (Direct Neighbor - 1 hop)
- Jayashankar Bhupalpally (Direct Neighbor - 1 hop)
- Mahabubabad (Direct Neighbor - 1 hop)
- Karimnagar (2 hops via Hanamkonda)
- Siddipet (2 hops via Jangaon)
```

---

## 🔮 12. Future Extensions
- **Shortest Path Distance Routing**: Integrate **Dijkstra's Algorithm** and **A\* Search** to calculate real road distance and transit times from metro stations and IT hubs.
- **Persistent Database Layer**: Connect to PostgreSQL / SQLite while maintaining native DSA query caching in memory.
- **Spatial Indexing**: Implement **R-Tree / KD-Tree** for 2D spatial coordinate radius lookups (latitude/longitude boundaries).
- **Distributed Benchmark Suite**: Provide real-time latency graphs comparing search throughput under concurrent requests.

---

## 📌 13. Current Phase Status

| Milestone | Status | Description |
| :--- | :---: | :--- |
| **Algorithm Implementations** | ✅ Completed | Naive, KMP, Z, Rabin-Karp, Boyer-Moore written manually from scratch. |
| **Fuzzy Typo Engine** | ✅ Completed | Levenshtein DP Matrix with dynamic similarity thresholding. |
| **Trie Prefix Engine** | ✅ Completed | Prefix tree for instant location autocomplete. |
| **District Graph Network** | ✅ Completed | Graph adjacency model with BFS traversal for Telangana districts. |
| **Investor Optimization** | ✅ Completed | 0/1 Knapsack DP engine for optimal budget-to-area portfolio selection. |
| **Sorting Engine** | ✅ Completed | Randomized QuickSort for price and area criteria. |
| **CLI & Web Interfaces** | ✅ Completed | Interactive ANSI-colored CLI terminal & lightweight Web REST UI. |
| **Current Phase** | 🚀 **Production-Ready / Final Evaluation** | Fully verified, tested, documented, and ready for viva demonstration. |




## 📌 14. Contributions

| Member | Contributions |
|---|---|
| **Yashwanth** | Project architecture, problem statement, property data model, core property search, Naive String Matching, Z Algorithm,. |
| **Bharat** | Levenshtein Distance, typo correction, Trie autocomplete, BFS for nearby districts, 0/1 Knapsack for investor mode, randomized Quicksort, and property optimization. |
| **Pranit** | Frontend development using HTML, CSS, and JavaScript; Java HTTP server API integration, HTTP requests, JSON responses, property cards, system testing, results, and live demonstration,KMP, Rabin-Karp, and Boyer-Moore .|
---

<div align="center">
  <b>Developed for Department of Computer Science & Engineering</b><br>
  <i>Data Structures & Algorithms (DSA-3) Project — Team 15</i>
</div>

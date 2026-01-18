//Reduced claim processing time by 20% by profiling and optimizing slow-performing backend APIs, refining SQL
Profiling = measuring + observing where time and resources are being spent

S – Situation
In our monolithic insurance application, # claim processing APIs were experiencing high response times, which impacted user experience and delayed claim handling.

T - Task

  I was responsible for identifying the performance bottlenecks in the claim processing flow and reducing overall processing time without changing business logic.

  Action:
I profiled the application by logging execution time at controller, service, and database layers to identify slow-performing APIs.

Profiling showed that most of the latency came from inefficient SQL queries and repeated database calls inside service-layer loops.
I analyzed SQL execution plans using activity monitor, added missing indexes on frequently queried columns, optimized joins, and refactored code to eliminate redundant database calls.

Additionally, for frequently accessed and rarely changing data, I implemented application-level caching to avoid repeated database hits.

R – Result

These optimizations reduced SQL execution time significantly and improved overall API response time, resulting in a 20% reduction in claim processing time and a smoother user experience.

  Which CACHING STRATEGY fits here (Monolith)
  ✅ Read-Through Cache (Cache-Aside Pattern)
Why?
Simple
Safe
Most widely used in real projects

  🔹 Cache-Aside (Read-Through) Strategy – Explained Simply
Flow:

Application checks cache first
If data is present → return it
If not present → fetch from DB
Store result in cache
Return response
📌 The application controls the cache, not the DB.

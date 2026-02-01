# Eager Singleton

## Overview
This Singleton is created at class load time.
Thread-safe due to JVM class loading guarantees.

## Pros
- Simple
- Fast
- No synchronization

## Cons
- Instance created even if never used

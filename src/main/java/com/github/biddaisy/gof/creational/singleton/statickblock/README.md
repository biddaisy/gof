# Static Block Singleton

## Overview
Similar to eager initialization but uses a static block.  
Useful when initialization may throw exceptions.

## Pros
- Thread-safe
- Allows exception handling

## Cons
- Still eager

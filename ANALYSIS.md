# Task 2 Analysis

## 1. Cause
ConcurrentModificationException occurs when a collection is modified while iterating.

## 2. Problem Code
for (Transaction t : list) {
    list.remove(t);
}

## 3. Fix
Use iterator:

Iterator<Transaction> it = list.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    it.remove();
}

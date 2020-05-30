package surya.practice.geeks.hashing;

import java.util.HashMap;

/**
 * Difficulty - Easy Though it appears lengthy, implementation is super easy. Only think of the
 * corner cases in terms of head and tail during put and get
 */

/**
 * Runtime: 28 ms, faster than 21.88% of Java online submissions for LRU Cache.
 * Memory Usage: 57.5 MB, less than 61.35% of Java online submissions for LRU Cache.
 */
public class LC146_LRUCache_DLL_HM {

  Node head, tail;
  int capacity;
  HashMap<Integer, Node> map;

  static class Node {

    //Node also needs to have key for bidirectional
    //communication with map
    int key, value;
    Node prev, next;

    Node(int key, int value) {
      this.value = value;
      this.key = key;
    }
  }

  public LC146_LRUCache_DLL_HM(int capacity) {

    map = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node foundNode = map.get(key);
      removeNode(foundNode);
      setHead(foundNode);
      return foundNode.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      //key could remain same but value can change!
      //E.g. you would want to update from (3,5) to (3,10)
      node.value = value;
      //because this node has a recent usage in terms of put,
      //you'll have to set this element as head, and remove it from it's current location
      removeNode(node);
      setHead(node);
    }
    //when map doesn't have the key, if capacity overflows, delete the tail node and tail's keyVal from the map. This is what I call bidirectional communication using key
    //else, mark the new put element as head
    else {
      if (map.size() == capacity) {
        map.remove(tail.key);
        removeNode(tail);
      }
      Node newNode = new Node(key, value);
      setHead(newNode);
      map.put(key, newNode);
    }
  }

  private void setHead(Node node) {
    //since this node should become null, it's head must be null
    node.prev = null;
    node.next = head;
    //current head has previous as null.
    //but after the new node becomes head and head becomes the new node's next, head's prev must store the new node's value
    if (head != null) {
      head.prev = node;
    }

    //initially tail is null. Make tail as current node
    if (tail == null) {
      tail = node;
    }
//make this node as head!
    head = node;
  }

  private void removeNode(Node node) {
    //node.prev.next=node.next
    //node.next.prev=node.prev;

    if (node.next != null) {
      node.next.prev = node.prev;
    }
    //if node's next is null, it means you're deleting the tail element.
    //mark the tail's prev element as the new tail
    else {
      tail = node.prev;
    }

    if (node.prev != null) {
      node.prev.next = node.next;
    }
    //if node's prev is null, then it's the case where you're deleting the head itself.
    //so, mark the next element of head as the new head
    else {
      head = node.next;
    }


  }
}

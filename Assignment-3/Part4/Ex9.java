public class Trie {
    
  Node head;

  public Trie(){
    head = new Node(' ');
  }

  class Node{
    char val;
    Node[] children;
    boolean isWord;

    public Node(char value){
      this.val = value;
      this.children = new Node[26];
      this.isWord = false;
    }
  }

  public void add(String str){
    Node current = head;

    for(int i=0; i < str.length(); i++){
      char letter = str.charAt(i);

      if(current.children[letter-'a'] == null){
        current.children[letter-'a'] = new Node(letter);
      }

      current = current.children[letter-'a'];
    }

    current.isWord = true;
  }

  public int prefixCount(String prefix, int k){
    Node current = head;

    for(int i=0; i < k; i++){
      char letter = prefix.charAt(i);
      if(current.children[letter-'a'] == null){
        return 0;
      }
      current = current.children[letter-'a'];
    }

    int count = 0;
    for(int i=0; i < 26; i++){
      if(current.children[i] != null){
        count++;
      }
    }
    return count;
  }
    
}

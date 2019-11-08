 public class BST{
   
    public boolean search(T toSearch)
      {
         return search(root, toSearch);
      }
      private boolean search(Node<T> p, T toSearch)
      {
         if (p == null)
            return false;
         else
         if (compare(toSearch, p.data) == 0)
         	return true;
         else
         if (compare(toSearch, p.data) < 0)
            return search(p.left, toSearch);
         else
            return search(p.right, toSearch);
      }


   public void insert(T data)
      {
         root = insert(root, data);
      }
   private Node<T> insert(Node<T> p, T toInsert)
      {
         if (p == null)
            return new Node<T>(toInsert);

         if (compare(toInsert, p.data) == 0)
            return p;

         if (compare(toInsert, p.data) < 0)
            p.left = insert(p.left, toInsert);
         else
            p.right = insert(p.right, toInsert);

         return p;
      }

   public void delete(T toDelete)
      {
         root = delete(root, toDelete);
      }
   private Node<T> delete(Node<T> p, T toDelete)
      {
         if (p == null)  throw new RuntimeException("cannot delete.");
         else
         if (compare(toDelete, p.data) < 0)
         p.left = delete (p.left, toDelete);
         else
         if (compare(toDelete, p.data)  > 0)
         p.right = delete (p.right, toDelete);
         else
         {
            if (p.left == null) return p.right;
            else
            if (p.right == null) return p.left;
            else
            {
            // get data from the rightmost node in the left subtree
               p.data = retrieveData(p.left);
            // delete the rightmost node in the left subtree
               p.left =  delete(p.left, p.data) ;
            }
         }
         return p;
      }
   private T retrieveData(Node<T> p)
      {
         while (p.right != null) p = p.right;

         return p.data;
      }

   public String toString()
      {
         StringBuffer sb = new StringBuffer();
         for(T data : this) sb.append(data.toString());

         return sb.toString();
      }


   private class Node<T>
      {
         private T data;
         private Node<T> left, right;

         public Node(T data, Node<T> l, Node<T> r)
         {
            left = l; right = r;
            this.data = data;
         }

         public Node(T data)
         {
            this(data, null, null);
         }

         public String toString()
         {
            return data.toString();
         }
      } //end of Node
   }//end 
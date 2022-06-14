package adt;

public class BinaryTreeOb <K extends Comparable<K>,T> implements BinarySearchTreeOb<K,T> {

    private TreeNode<K,T> raiz=null;

    private TreeNode<K,T> findNode(K key, TreeNode<K,T> root) {
        TreeNode<K, T> result = null;
        if (root.getKey() == key) {
            result = root;
        } else if (root.getLeftChild() != null) {
            result = findNode(key, root.getLeftChild());
        }else if(root.getRightChild()!=null){
            result = findNode(key, root.getRightChild());
        }
        return result;
    }


    @Override
    public void insert(K key, T data, K parentKey) {
        if(raiz==null){
            raiz= new TreeNode<K, T>(key,data);
        }
        TreeNode nodoPadre= findNode(parentKey,raiz);
        if(nodoPadre.key.compareTo(key)<0){
            nodoPadre.rightChild=new TreeNode(key,data);
        }else if(nodoPadre.key.compareTo(key)>0){
            nodoPadre.leftChild=new TreeNode(key,data);
        }else{
            nodoPadre.data=data;
        }
    }

    @Override
    public T find(K key) {
        return findNode(key,raiz).getData();
    }

    @Override
    public void delete(K key) {
        delete(key,raiz);
    }

    @Override
    public int size(TreeNode<K,T> raiz) {
        int count =1;

        if (raiz.leftChild!=null){
            count+=size(raiz.leftChild);
        }
        if (raiz.rightChild!=null){
            count+=size(raiz.rightChild);
        }
        return count;
    }

    private TreeNode<K,T> delete(K key, TreeNode <K,T> raiz){
        if(raiz==null){
            return null;
        }
        TreeNode<K,T> nodoAux= findNode(key,raiz);
        if (nodoAux.getLeftChild() != null) {

            K candidate = getMax(nodoAux.getLeftChild());
            nodoAux.setKey(candidate);
            nodoAux.setLeftChild(delete(candidate, nodoAux.getLeftChild()));

        } else {

            K candidate = getMin(nodoAux);
            nodoAux.setKey(candidate);
            nodoAux.setRightChild(delete(candidate, nodoAux.getRightChild()));

        }
        return nodoAux;
    }

    private K getMin(TreeNode<K,T> root) {
        K result = null;

        if (root.getLeftChild() == null) {
            result = root.getKey();
        } else {
            result = getMin(root.getLeftChild());
        }

        return result;
    }

    private K getMax(TreeNode<K,T> root) {
        K result = null;

        if (root.getRightChild() == null) {
            result = root.getKey();
        } else {
            result = getMax(root.getRightChild());
        }

        return result;
    }

}

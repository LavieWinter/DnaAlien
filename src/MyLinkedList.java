import java.util.HashMap;

public class MyLinkedList {

	private Nodo inicio, fim;
	private int nElementos;

	private class Nodo {
		public Nodo prox, ant;
		public char valor;

		public Nodo(char val) {
			prox = ant = null;
			valor = val;
		}
	}

	public MyLinkedList() {
		inicio = fim = null;
		nElementos = 0;
	}

	public void mutacao(HashMap<String, Character> hashMap) {
		if (this.isEmpty())
			return;
		if (this.size() == 1)
			return;
		Nodo messi = inicio;
		while (messi != null) {
			if (messi.prox != null) {
				String key = "" + messi.valor + messi.prox.valor;
				if (hashMap.containsKey(key)) {
					add(hashMap.get(key));
					messi = remove(messi);
				} else {
					messi = messi.prox;
				}
			} else {
				break;
			}
		}
	}

	// INSERE NA ÚLTIMA POSICAO DA LISTA
	public void add(char valor) {
		Nodo aux = new Nodo(valor);

		if (inicio == null) // ou ainda nElementos==0
			inicio = fim = aux;
		else {
			fim.prox = aux;
			aux.ant = fim;
			fim = aux; // fim=fim.prox;
		}

		nElementos++;

	}

	public Nodo remove(Nodo nodo) {
		if (nodo == null)
			return null;

		Nodo aux = null;
		if (nodo.ant == null && nodo.prox.prox != null) {
			aux = nodo.prox.prox;
			nodo.prox.prox.ant = nodo.ant;
			nodo.prox.prox = nodo.prox.ant = nodo.prox = null;
			inicio = aux;
			nElementos -= 2;
		} else if (nodo.ant != null && nodo.prox.prox != null) {
			aux = nodo.ant;
			nodo.ant.prox = nodo.prox.prox;
			nodo.prox.prox.ant = nodo.ant;
			nodo.ant = nodo.prox.prox = nodo.prox.ant = nodo.prox = null;
			nElementos -= 2;
		}

		return aux;
	}

	public boolean isEmpty() {
		return (nElementos == 0);
	}

	public int size() {
		return nElementos;
	}

	public void print() {
		Nodo aux = inicio;
		int count = 0;
		while (aux != null) {
			System.out.print(aux.valor);
			aux = aux.prox;
			count++;
		}

	}

}
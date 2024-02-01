import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int entrada = sc.nextInt();
            sc.nextLine();
            String formula[] = new String[entrada];
            String respostas[] = new String[entrada];
            String[] primeiroN = new String[1]; // Guarda o primeiro digito da formula
            String[] outrosN = new String[2]; // Gaurda os outros dois digitos
            String[] dados = new String[3]; // Guarda o nome, forumla escolhida, e o simbolo]
            String[] correto = new String[entrada];
            String[] incorreto = new String[entrada];

            for (int i = 0; i < entrada; i++) {
                formula[i] = sc.nextLine();
            }

            for (int i = 0; i < entrada; i++) {
                respostas[i] = sc.nextLine();
            }

            for (int i = 0; i < entrada; i++) {
                String respostaTemp = respostas[i];
                dados = respostaTemp.split(" ");
                int select = Integer.parseInt(dados[1]);

                primeiroN = formula[select - 1].split(" ");
                String temp = primeiroN[1];
                outrosN = temp.split("=");

                int a = Integer.parseInt(primeiroN[0]);
                int b = Integer.parseInt(outrosN[0]);
                int c = Integer.parseInt(outrosN[1]);

                String simbolo = dados[2];
                if (simbolo.equals("I")) {
                    if(a + b != c && a * b != c && a - b !=c){
                        correto[i] = dados[0];
                    }else{
                        incorreto[i] = dados[0];
                    }
                } else if (simbolo.equals("+")) {
                    if (a + b == c) {
                        correto[i] = dados[0];
                    } else {
                        incorreto[i] = dados[0];
                    }
                } else if (simbolo.equals("-")) {
                    if (a - b == c) {
                        correto[i] = dados[0];
                    } else {
                        incorreto[i] = dados[0];
                    }
                } else if (simbolo.equals("*")) {
                    if (a * b == c) {
                        correto[i] = dados[0];
                    } else {
                        incorreto[i] = dados[0];
                    }
                }

            }

            List<String> list = new ArrayList<>();

            for (String s : incorreto) {
                if (s != null && s.length() > 0) {
                    list.add(s);
                }
            }

            if (list.size() < entrada && list.size() > 0) {
                Collections.sort(list);

                for (int i = 0; i < list.size(); i++) {
                    if (i < list.size() - 1) {
                        System.out.print(list.get(i));
                        System.out.print(" ");
                    } else if (i == list.size() - 1) {
                        System.out.println(list.get(i));
                    }
                }
            } else if (list.size() == entrada) {
                System.out.println("None Shall Pass!");
            } else if (list.size() == 0) {
                System.out.println("You Shall All Pass!");
            }

        }

        sc.close();

    }
}

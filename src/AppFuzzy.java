import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class AppFuzzy {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a capacitação: ");
		double capacitacao = entrada.nextDouble();
		
		System.out.println("Digite a experiência: ");
		double experiencia = entrada.nextDouble();
		
		String caminho = ".\\gratificar.fcl";
		FIS fuzzy = FIS.load(caminho);
		
		fuzzy.setVariable("EXPERIENCIA", experiencia);
		fuzzy.setVariable("CAPACITACAO", capacitacao);
		
		fuzzy.evaluate();
		Variable gratificacao = fuzzy.getVariable("GRATIFICACAO");
		JFuzzyChart.get().chart(gratificacao, gratificacao.getDefuzzifier(), true);
		JFuzzyChart.get().chart(fuzzy);
	}

}

package br.com.triway.controle;

import static java.awt.Color.decode;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.constant.HorizontalTextAlignment.CENTER;
import static net.sf.dynamicreports.report.constant.HorizontalTextAlignment.LEFT;
import static net.sf.dynamicreports.report.constant.VerticalTextAlignment.MIDDLE;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.triway.util.FabricaConexao;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

@Named
@RequestScoped
public class ReportBean implements Serializable {
	
	/** Atributo EX_GRAY. */
	public static final String EX_GRAY = "#d8d8d8";

	/** Atributo EX_BLUE. */
	public static final String EX_BLUE = "#c5d9f1";

	/**
	 * Método responsável por gerar o relatório.
	 * 
	 * @author 3way
	 * @return
	 */
	private JasperReportBuilder gerarRelatorio() {
		StyleBuilder stBold = stl.style().setBold(true);
		StyleBuilder stBoder = stl.style().setBorder(stl.pen1Point());
		StyleBuilder stCenter = stl.style().setHorizontalTextAlignment(CENTER).setParentStyle(stBoder).setPadding(5);
		StyleBuilder stHighlight = stl.style().setParentStyle(stCenter).setBackgroundColor(decode(EX_BLUE))
				.setVerticalTextAlignment(MIDDLE);
		StyleBuilder stGrayHeader = stl.style().setParentStyle(stBold).setPadding(5).setBorder(stl.pen1Point())
				.setBackgroundColor(decode(EX_GRAY)).setHorizontalTextAlignment(LEFT);
		StyleBuilder stTitle = stl.style().setParentStyle(stBold).setFontSize(14);

		Connection connection = null;
		try {
			connection = FabricaConexao.getConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JasperReportBuilder builder = report()
				.columns(Columns.column("AUTOR", "AUTOR", DataTypes.integerType()),
						Columns.column("TITULO", "TITULO", DataTypes.stringType()),
						Columns.column("PRECO", "PRECO", DataTypes.stringType()),
						Columns.column("DESCRICAO", "DESCRICAO", DataTypes.dateType()))
				.title(// title of the report
						Components.text("SimpleReportExample").setHorizontalAlignment(HorizontalAlignment.CENTER))
				.pageFooter(Components.pageXofY())// show page number on the
													// page footer
				.setDataSource("select AUTOR, TITULO, COD_LIVRO, IMAGEM, PRECO, DESCRICAO from ESTOQUE", connection);
		return builder;
	}

	public void relatorio() {
		JasperReportBuilder report = gerarRelatorio();
		try {
			// show the report
			report.show();

			// export the report to a pdf file
			report.toPdf(new FileOutputStream("c:/report.pdf"));
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

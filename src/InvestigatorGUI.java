/** @author Dario Guth
	 *  @copyright Dario Guth, 20210801
	 *  @version 0.9  
	 */

package investigator;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import com.google.gson.Gson;
import com.licensespring.License;
import com.licensespring.LicenseManager;
import com.licensespring.LicenseSpringConfiguration;
import com.licensespring.identity.HardwareIdStrategy;
import com.licensespring.model.ActivationLicense;

import net.miginfocom.swing.MigLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;

public class InvestigatorGUI extends JFrame {
	private static final long serialVersionUID = -1494079816172444259L;

	/**
	 * Launch the application.
	 */
	//Anlage einer leeren Company beim Start des Programms als Ausgangsbasis
	
	Company temporary = new Company();
	double[] year = new double[] {-3,-2,-1,0,1,2,3,4,5}; //Initialisierung fuer alle Charts die Jahre auf der x-Achse verwenden
	
	//Initialisierung Chart fuer Verschuldungsgrad
	
	double[] leverage = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart leverageChart = new XYChartBuilder().width(400).height(400).title("Debt ratio in % per year").build();
	
	//Initialisierung Chart fuer Anlagenintensität
	
	double[] assetIntensity = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart assetIntensityChart = new XYChartBuilder().width(400).height(400).title("Asset intensity in % per year").build();
	
	//Initialisierung Chart fuer Umlaufintensität
		
	double[] circulatingIntensity = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart circulatingIntensityChart = new XYChartBuilder().width(400).height(400).title("Circulation intensity in % per year").build();

	//Initialisierung Chart fuer Umschlagshaeufigkeit der Vorräte
	
	double[] inventoryTurnover = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart inventoryTurnoverChart = new XYChartBuilder().width(400).height(400).title("Turnover rate inventories per year").build();
	
	//Initialisierung Chart fuer Umschlagshaeufigkeit der Forderungen
	
	double[] receivablesTurnover = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart receivablesTurnoverChart = new XYChartBuilder().width(400).height(400).title("Turnover rate receivables per year").build();
	
	//Initialisierung Chart fuer Umschlagshaeufigkeit der Verbindlichkeiten
	
	double[] payablesTurnover = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart payablesTurnoverChart = new XYChartBuilder().width(400).height(400).title("Turnover rate trade payables per year").build();
	
	//Initialisierung Chart fuer Umsatz
	
	double[] revenue = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart revenueChart = new XYChartBuilder().width(400).height(400).title("Revenue in Mio. per year").build();
	
	//Initialisierung Chart fuer Gewinn
	
	double[] totalIncome = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart totalIncomeChart = new XYChartBuilder().width(400).height(400).title("Profit in Mio. per year").build();
	
	//Initialisierung Chart fuer Umsatzrendite
	
	double[] returnOnSales = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart returnOnSalesChart = new XYChartBuilder().width(400).height(400).title("Return on sales in % per year").build();

	//Initialisierung Chart fuer EBITDA-Marge
	
	double[] returnOnEBITDA = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart returnOnEBITDAChart = new XYChartBuilder().width(400).height(400).title("EBITDA margin in % per year").build();
	
	//Initialisierung Chart fuer Eigenkapitalrendite
	
	double[] returnOnEquity = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart returnOnEquityChart = new XYChartBuilder().width(400).height(400).title("Return on equity in % per year").build();
	
	//Initialisierung Chart fuer Eigenkapitalrendite
	
	double[] totalReturnOnInvest = new double[] {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
	XYChart totalReturnOnInvestChart = new XYChartBuilder().width(400).height(400).title("Return on total assets in % per year").build();
	
	private JPanel contentPane;
	private JPanel pnlGraphics;
	private JPanel pnlKeyPerformanceIndicators;
	private JPanel pnlCashFlow;
	private JTextField tfShareCapitalPY03;
	private JTextField tfShareCapitalPY02;
	private JTextField tfShareCapitalPY01;
	private JTextField tfReservesPY03;
	private JTextField tfReservesPY02;
	private JTextField tfReservesPY01;
	private JTextField tfTotalEquityPY03;
	private JTextField tfTotalEquityPY02;
	private JTextField tfTotalEquityPY01;
	private JTextField tfLongTermBankDebtPY03;
	private JTextField tfLongTermBankDebtPY02;
	private JTextField tfLongTermBankDebtPY01;
	private JTextField tfAccrualsPY03;
	private JTextField tfAccrualsPY02;
	private JTextField tfAccrualsPY01;
	private JTextField tfTotalLongTermLiabilitiesPY03;
	private JTextField tfTotalLongTermLiabilitiesPY02;
	private JTextField tfTotalLongTermLiabilitiesPY01;
	private JTextField tfShortTermBankDebtPY03;
	private JTextField tfShortTermBankDebtPY02;
	private JTextField tfShortTermBankDebtPY01;
	private JTextField tfTradePayablesPY03;
	private JTextField tfTradePayablesPY02;
	private JTextField tfTradePayablesPY01;
	private JTextField tfOtherShortTermLiabilitiesPY02;
	private JTextField tfOtherShortTermLiabilitiesPY01;
	private JTextField tfOtherShortTermLiabilitiesY00;
	private JTextField tfTotalShortTermLiabilitiesY00;
	private JTextField tfTotalShortTermLiabilitiesPY03;
	private JTextField tfTotalShortTermLiabilitiesPY02;
	private JTextField tfTotalLiabilitiesPY03;
	private JTextField tfTotalLiabilitiesPY02;
	private JTextField tfTotalLiabilitiesPY01;
	private JPanel pnlAssets;
	private JLabel lblAssets;
	private JTextField tfAssetsPY02;
	private JLabel lblAssetsPY02;
	private JLabel lblAssetsPY01;
	private JTextField tfAssetsPY01;
	private JLabel lblAssetsY00;
	private JTextField tfAssetsY00;
	private JLabel lblFinancialAssets;
	private JLabel lblPropertyAssets;
	private JLabel lblIntangibleAssets;
	private JTextField tfFinancialAssetsPY02;
	private JTextField tfFinancialAssetsPY01;
	private JTextField tfFinancialAssetsY00;
	private JTextField tfPropertyAssetsPY02;
	private JTextField tfPropertyAssetsPY01;
	private JTextField tfPropertyAssetsY00;
	private JTextField tfIntangibleAssetsPY02;
	private JTextField tfIntangibleAssetsPY01;
	private JTextField tfIntangibleAssetsY00;
	private JLabel lblInventory;
	private JLabel lblReceivables;
	private JLabel lblOtherNCA;
	private JLabel lblNCA;
	private JLabel lblCash;
	private JTextField tfInventoryPY02;
	private JTextField tfInventoryPY01;
	private JTextField tfInventoryY00;
	private JTextField tfReceivablesPY02;
	private JTextField tfReceivablesPY01;
	private JTextField tfReceivablesY00;
	private JTextField tfOtherNCAPY02;
	private JTextField tfOtherNCAPY01;
	private JTextField tfOtherNCAY00;
	private JTextField tfNCAPY02;
	private JLabel lblTotalAssets;
	private JTextField tfNCAPY01;
	private JTextField tfNCAY00;
	private JTextField tfCashPY02;
	private JTextField tfCashPY01;
	private JTextField tfCashY00;
	private JTextField tfTotalAssetsPY02;
	private JTextField tfTotalAssetsPY01;
	private JTextField tfTotalAssetsY00;
	private JLabel lblAssetsPY03;
	private JTextField tfFinancialAssetsPY03;
	private JTextField tfPropertyAssetsPY03;
	private JTextField tfIntangibleAssetsPY03;
	private JTextField tfAssetsPY03;
	private JTextField tfInventoryPY03;
	private JTextField tfReceivablesPY03;
	private JTextField tfOtherNCAPY03;
	private JTextField tfNCAPY03;
	private JTextField tfCashPY03;
	private JTextField tfTotalAssetsPY03;
	private JLabel lblFinancialAssetsChange;
	private JLabel lblPropertyAssetsChange;
	private JLabel lblIntangibleAssetsChange;
	private JSeparator separator_3_11;
	private JSeparator separator_3_12;
	private JTextField tfFinancialAssetsChangePY02;
	private JTextField tfFinancialAssetsChangePY01;
	private JTextField tfFinancialAssetsChangeY00;
	private JTextField tfPropertyAssetsChangePY02;
	private JTextField tfPropertyAssetsChangePY01;
	private JTextField tfPropertyAssetsChangeY00;
	private JTextField tfIntangibleAssetsChangePY02;
	private JTextField tfIntangibleAssetsChangePY01;
	private JTextField tfIntangibleAssetsChangeY00;
	private JLabel lblInventoryTurnover;
	private JTextField tfInventoryTurnoverPY03;
	private JTextField tfInventoryTurnoverPY02;
	private JTextField tfInventoryTurnoverPY01;
	private JTextField tfInventoryTurnoverY00;
	private JLabel lblReceivablesTurnover;
	private JTextField tfReceivablesTurnoverPY03;
	private JTextField tfReceivablesTurnoverPY02;
	private JTextField tfReceivablesTurnoverPY01;
	private JTextField tfReceivablesTurnoverY00;
	private JLabel lblOtherNCAFromNCA;
	private JTextField tfOtherNCAFromNCAPY02;
	private JTextField tfOtherNCAFromNCAPY01;
	private JTextField tfOtherNCAFromNCAY00;
	private JSeparator separator_3_13;
	private JTextField tfShareCapitalY00;
	private JTextField tfShareCapitalChangePY02;
	private JTextField tfShareCapitalChangePY01;
	private JTextField tfShareCapitalChangeY00;
	private JTextField tfReservesY00;
	private JTextField tfTotalEquityY00;
	private JLabel lblDividendsPaidRate;
	private JTextField tfDividendsPaidRatePY03;
	private JTextField tfDividendsPaidRatePY02;
	private JTextField tfDividendsPaidRatePY01;
	private JTextField tfDividendsPaidRateY00;
	private JTextField tfLongTermBankDebtY00;
	private JLabel lblLongTermBankDebtChange;
	private JTextField tfLongTermBankDebtChangePY02;
	private JTextField tfLongTermBankDebtChangePY01;
	private JTextField tfLongTermBankDebtChangeY00;
	private JTextField tfAccrualsY00;
	private JLabel lblAccrualsChange;
	private JTextField tfAccrualsChangePY02;
	private JTextField tfAccrualsChangePY01;
	private JTextField tfAccrualsChangeY00;
	private JTextField tfTotalLongTermLiabilitiesY00;
	private JTextField tfShortTermBankDebtY00;
	private JLabel lblShortTermBankDebtChange;
	private JTextField tfShortTermBankDebtChangePY02;
	private JTextField tfShortTermBankDebtChangePY01;
	private JTextField tfShortTermBankDebtChangeY00;
	private JTextField tfTradePayablesY00;
	private JLabel lblPayablesTurnover;
	private JTextField tfDaysPayablesOutstandingPY03;
	private JTextField tfDaysPayablesOutstandingPY02;
	private JTextField tfDaysPayablesOutstandingPY01;
	private JTextField tfDaysPayablesOutstandingY00;
	private JTextField tfOtherShortTermLiabilitiesPY03;
	private JTextField tfTotalShortTermLiabilitiesPY01;
	private JTextField tfTotalLiabilitiesY00;
	private JLabel lblOtherShortTermLiabilitiesChange;
	private JTextField tfOtherShortTermLiabilitiesChangePY02;
	private JTextField tfOtherShortTermLiabilitiesChangePY01;
	private JTextField tfOtherShortTermLiabilitiesChangeY00;
	private JTextField tfRevenuePY02;
	private JTextField tfRevenuePY01;
	private JTextField tfRevenueY00;
	private JTextField tfRevenuePY03;
	private JTextField tfRevenueChangePY01;
	private JTextField tfRevenueChangeY00;
	private JTextField tfEbitdaPY03;
	private JTextField tfEbitdaPY02;
	private JTextField tfEbitdaPY01;
	private JTextField tfEbitdaY00;
	private JTextField tfEbitdaFromRevenuePY02;
	private JTextField tfEbitdaFromRevenuePY01;
	private JTextField tfEbitdaFromRevenueY00;
	private JTextField tfDepreciationPY03;
	private JTextField tfDepreciationPY02;
	private JTextField tfDepreciationPY01;
	private JTextField tfDepreciationY00;
	private JTextField tfInterestGainsFromFinancialAssetsY00;
	private JTextField tfInterestGainsFromFinancialAssetsPY01;
	private JTextField tfInterestGainsFromFinancialAssetsPY02;
	private JTextField tfInterestGainsPY03;
	private JTextField tfInterestGainsPY02;
	private JTextField tfInterestGainsPY01;
	private JTextField tfInterestGainsY00;
	private JTextField tfInterestLossPY03;
	private JTextField tfInterestLossPY02;
	private JTextField tfInterestLossPY01;
	private JTextField tfInterestLossY00;
	private JTextField tfInterestLossFromBankDebtPY02;
	private JTextField tfInterestLossFromBankDebtPY01;
	private JTextField tfInterestLossFromBankDebtY00;
	private JTextField tfEbtPY03;
	private JTextField tfEbtPY02;
	private JTextField tfEbtPY01;
	private JTextField tfEbtY00;
	private JTextField tfTotalIncomePY03;
	private JTextField tfTotalIncomePY02;
	private JTextField tfTotalIncomePY01;
	private JTextField tfTotalIncomeY00;
	private JTextField tfIncomeTaxPY03;
	private JTextField tfIncomeTaxPY02;
	private JTextField tfIncomeTaxPY01;
	private JTextField tfIncomeTaxY00;
	private JTextField tfIncomeTaxFromEbtPY02;
	private JTextField tfIncomeTaxFromEbtPY01;
	private JTextField tfIncomeTaxFromEbtY00;
	private JTextField tfIncomeTaxFromEbtPY03;
	private JTextField tfEbitdaFromRevenuePY03;
	private JTextField tfInterestGainsFromFinancialAssetsPY03;
	private JTextField tfInterestLossFromBankDebtPY03;
	private JPanel pnlMasterData;
	private JLabel lblCompanyName;
	private JTextField tfCompanyName;
	private JLabel lblShareVolume;
	private JLabel lblCurrentSharePrice;
	private JTextField tfCurrentSharePrice;
	private JTextField tfRevenueChangePY02;
	private JTextField tfRiskFreeInterestRate;
	private JTextField tfMarketRiskPremium;
	private JTextField tfShareVolume;
	private JMenuBar menuBar;
	private JMenu mnMen;
	private JMenuItem mntmCreateNewCompany;
	private JMenuItem mntmLoad;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JLabel lblOtherAssets;
	private JTextField tfOtherAssetsPY03;
	private JTextField tfOtherAssetsPY02;
	private JTextField tfOtherAssetsPY01;
	private JTextField tfOtherAssetsY00;
	private JTextField tfOtherAssetsChangeY00;
	private JTextField tfOtherAssetsChangePY01;
	private JTextField tfOtherAssetsChangePY02;
	private JLabel lblOtherAssetsChange;
	private JPanel backgroundProfitLoss;
	private JPanel mainPanel;
	private JPanel sidepanel;
	private JScrollPane scrollPaneMasterData;
	private JScrollPane scrollPaneLiabilities;
	private JScrollPane scrollPaneKeyPerformanceIndicators;
	private JScrollPane scrollPaneAssets;
	private JScrollPane scrollPaneProfitLoss;
	private JScrollPane scrollPaneCashFlow;
	private JScrollPane scrollPaneGraphics;
	private JPanel btnMasterData;
	private JPanel btnProfitLoss;
	private JLabel lblAssets_1;
	private JPanel btnAssets;
	private JLabel lblLiabilities;
	private JPanel btnLiabilities;
	private JLabel lblProfitLoss;
	private JPanel btnCashFlow;
	private JLabel lblCF;
	private JPanel btnKeyPerformanceIndicators;
	private JLabel lblKPI;
	private JPanel btnGraphics;
	private JLabel lblGraph;
	private JLabel lblLogo;
	private JPanel logoBackground;
	private JPanel backgroundAssets;
	private JPanel backgroundLiabilities;
	private JPanel backgroundCashFlow;
	private JPanel backgroundKeyPerformanceIndicators;
	private JSeparator separator_3_6;
	private JSeparator separator_3_7;
	private JTextField tfDepreciationFromPropertyAssetsPY03;
	private JTextField tfDepreciationFromPropertyAssetsPY02;
	private JTextField tfDepreciationFromPropertyAssetsPY01;
	private JTextField tfDepreciationFromPropertyAssetsY00;
	private JTextField tfOtherEquityPY03;
	private JTextField tfOtherEquityPY02;
	private JTextField tfOtherEquityPY01;
	private JTextField tfOtherEquityY00;
	private JTextField tfOtherEquityChangeY00;
	private JTextField tfOtherEquityChangePY01;
	private JTextField tfOtherEquityChangePY02;
	private JLabel lblDepreciationIntangible;
	private JTextField tfDepreciationIntangiblePY03;
	private JTextField tfDepreciationIntangiblePY02;
	private JTextField tfDepreciationIntangiblePY01;
	private JTextField tfDepreciationIntangibleY00;
	private JLabel lblDepreciationFromIntangibleAssets;
	private JTextField tfDepreciationFromIntangibleAssetsPY03;
	private JTextField tfDepreciationFromIntangibleAssetsPY02;
	private JTextField tfDepreciationFromIntangibleAssetsPY01;
	private JTextField tfDepreciationFromIntangibleAssetsY00;
	private JSeparator separator_3_13_2;
	private JTextField tfCFTotalIncomeFY01;
	private JTextField tfCFTotalIncomeFY02;
	private JTextField tfCFTotalIncomeFY03;
	private JTextField tfCFTotalIncomeFY04;
	private JTextField tfDividendsPaidPY03;
	private JLabel lblDividendsPaidPY02;
	private JTextField tfDividendsPaidPY02;
	private JLabel lblDividendsPaidPY01;
	private JTextField tfDividendsPaidPY01;
	private JLabel lblDividendsPaidY00;
	private JTextField tfDividendsPaidY00;
	private JLabel lblCashFlowFY03;
	private JLabel lblCashFlowFY02;
	private JLabel lblCashFlowFY01;
	private JLabel lblCashFlowFY04;
	private JLabel lblCashFlowFY05;
	private JTextField tfCFTotalIncomeFY05;
	private JLabel lblCFDepreciation;
	private JTextField CFDepreciationFY01;
	private JTextField CFDepreciationFY02;
	private JTextField CFDepreciationFY03;
	private JTextField CFDepreciationFY04;
	private JTextField CFDepreciationFY05;
	private JLabel lblCFDepreciationIntangible;
	private JTextField tfCFDepreciationIntangibleFY01;
	private JTextField tfCFDepreciationIntangibleFY02;
	private JTextField tfCFDepreciationIntangibleFY03;
	private JTextField tfCFDepreciationIntangibleFY04;
	private JTextField tfCFDepreciationIntangibleFY05;
	private JTextField tfCFAssetsInvestFY01;
	private JTextField tfCFAssetsInvestFY02;
	private JTextField tfCFAssetsInvestFY03;
	private JTextField tfCFAssetsInvestFY04;
	private JTextField tfCFAssetsInvestFY05;
	private JTextField tfCFWorkingCapitalInvestFY01;
	private JTextField tfCFWorkingCapitalInvestFY02;
	private JTextField tfCFWorkingCapitalInvestFY03;
	private JTextField tfCFWorkingCapitalInvestFY04;
	private JTextField tfCFWorkingCapitalInvestFY05;
	private JTextField tfCFDebtChangeFY01;
	private JTextField tfCFDebtChangeFY02;
	private JTextField tfCFDebtChangeFY03;
	private JTextField tfCFDebtChangeFY04;
	private JTextField tfCFDebtChangeFY05;
	private JTextField tfCashflowToEquityFY01;
	private JTextField tfCashflowToEquityFY02;
	private JTextField tfCashflowToEquityFY03;
	private JTextField tfCashflowToEquityFY04;
	private JTextField tfCashflowToEquityFY05;
	private JTextField tfGrowthRateEndValue;
	private JTextField tfDiscountedCashflowFY01;
	private JTextField tfDiscountedCashflowFY02;
	private JTextField tfDiscountedCashflowFY03;
	private JTextField tfDiscountedCashflowFY04;
	private JTextField tfDiscountedCashflowFY05;
	private JTextField tfFairValue;
	private JTextField tfFairValuePerShare;
	private JTextField tfCFCash;
	private JTextField tfReservesChangePY02;
	private JTextField tfReservesChangePY01;
	private JTextField tfReservesChangeY00;
	private JTextField tfRevenueFY01;
	private JTextField tfRevenueFY02;
	private JTextField tfRevenueFY03;
	private JTextField tfRevenueFY04;
	private JTextField tfRevenueFY05;
	private JTextField tfRevenueChangeFY01;
	private JTextField tfRevenueChangeFY02;
	private JTextField tfRevenueChangeFY03;
	private JTextField tfRevenueChangeFY04;
	private JTextField tfRevenueChangeFY05;
	private JTextField tfEbitdaFY01;
	private JTextField tfEbitdaFY02;
	private JTextField tfEbitdaFY03;
	private JTextField tfEbitdaFY04;
	private JTextField tfEbitdaFromRevenueFY01;
	private JTextField tfEbitdaFromRevenueFY02;
	private JTextField tfEbitdaFromRevenueFY03;
	private JTextField tfEbitdaFromRevenueFY04;
	private JTextField tfEbitdaFY05;
	private JTextField tfEbitdaFromRevenueFY05;
	private JTextField tfDepreciationFY01;
	private JTextField tfDepreciationFY02;
	private JTextField tfDepreciationFY03;
	private JTextField tfDepreciationFY04;
	private JTextField tfDepreciationFromPropertyAssetsFY01;
	private JTextField tfDepreciationFromPropertyAssetsFY02;
	private JTextField tfDepreciationFromPropertyAssetsFY03;
	private JTextField tfDepreciationFromPropertyAssetsFY04;
	private JTextField tfDepreciationFY05;
	private JTextField tfDepreciationFromPropertyAssetsFY05;
	private JTextField tfDepreciationIntangibleFY01;
	private JTextField tfDepreciationIntangibleFY02;
	private JTextField tfDepreciationIntangibleFY03;
	private JTextField tfDepreciationIntangibleFY04;
	private JTextField tfDepreciationFromIntangibleAssetsFY01;
	private JTextField tfDepreciationFromIntangibleAssetsFY02;
	private JTextField tfDepreciationFromIntangibleAssetsFY03;
	private JTextField tfDepreciationFromIntangibleAssetsFY04;
	private JTextField tfDepreciationIntangibleFY05;
	private JTextField tfDepreciationFromIntangibleAssetsFY05;
	private JTextField tfInterestGainsFY01;
	private JTextField tfInterestGainsFY02;
	private JTextField tfInterestGainsFY03;
	private JTextField tfInterestGainsFY04;
	private JTextField tfInterestGainsFY05;
	private JTextField tfInterestGainsFromFinancialAssetsFY01;
	private JTextField tfInterestGainsFromFinancialAssetsFY02;
	private JTextField tfInterestGainsFromFinancialAssetsFY03;
	private JTextField tfInterestGainsFromFinancialAssetsFY04;
	private JTextField tfInterestGainsFromFinancialAssetsFY05;
	private JTextField tfInterestLossFY01;
	private JTextField tfInterestLossFY02;
	private JTextField tfInterestLossFY03;
	private JTextField tfInterestLossFY04;
	private JTextField tfInterestLossFY05;
	private JTextField tfInterestLossFromBankDebtFY05;
	private JTextField tfInterestLossFromBankDebtFY04;
	private JTextField tfInterestLossFromBankDebtFY03;
	private JTextField tfInterestLossFromBankDebtFY02;
	private JTextField tfInterestLossFromBankDebtFY01;
	private JTextField tfEbtFY01;
	private JTextField tfEbtFY02;
	private JTextField tfEbtFY03;
	private JTextField tfEbtFY04;
	private JTextField tfEbtFY05;
	private JTextField tfIncomeTaxFY01;
	private JTextField tfIncomeTaxFY02;
	private JTextField tfIncomeTaxFY03;
	private JTextField tfIncomeTaxFY04;
	private JTextField tfIncomeTaxFY05;
	private JTextField tfIncomeTaxFromEbtFY01;
	private JTextField tfIncomeTaxFromEbtFY02;
	private JTextField tfIncomeTaxFromEbtFY03;
	private JTextField tfIncomeTaxFromEbtFY04;
	private JTextField tfIncomeTaxFromEbtFY05;
	private JTextField tfTotalIncomeFY01;
	private JTextField tfTotalIncomeFY02;
	private JTextField tfTotalIncomeFY03;
	private JTextField tfTotalIncomeFY04;
	private JTextField tfTotalIncomeFY05;
	private JTextField tfDividendsPaidRateFY01;
	private JTextField tfDividendsPaidRateFY02;
	private JTextField tfDividendsPaidRateFY03;
	private JTextField tfDividendsPaidRateFY04;
	private JTextField tfDividendsPaidRateFY05;
	private JPanel backgroundPnLPlanning;
	private JLabel lblCogs;
	private JTextField tfCogsPY03;
	private JTextField tfCogsPY02;
	private JTextField tfCogsPY01;
	private JTextField tfCogsY00;
	private JTextField tfCogsFY01;
	private JTextField tfCogsFY02;
	private JTextField tfCogsFY03;
	private JTextField tfCogsFY04;
	private JTextField tfCogsFY05;
	private JLabel lblCogsFromRevenue;
	private JTextField tfCogsFromRevenuePY03;
	private JTextField tfCogsFromRevenuePY02;
	private JTextField tfCogsFromRevenuePY01;
	private JTextField tfCogsFromRevenueY00;
	private JTextField tfCogsFromRevenueFY01;
	private JTextField tfCogsFromRevenueFY02;
	private JTextField tfCogsFromRevenueFY03;
	private JTextField tfCogsFromRevenueFY04;
	private JTextField tfCogsFromRevenueFY05;
	private JTextField tfOtherCostsPY03;
	private JTextField tfOtherCostsPY02;
	private JTextField tfOtherCostsPY01;
	private JTextField tfOtherCostsY00;
	private JTextField tfOtherCostsFY01;
	private JTextField tfOtherCostsFY02;
	private JTextField tfOtherCostsFY03;
	private JTextField tfOtherCostsFY04;
	private JTextField tfOtherCostsFY05;
	private JTextField tfOtherCostsFromRevenuePY03;
	private JTextField tfOtherCostsFromRevenuePY02;
	private JTextField tfOtherCostsFromRevenuePY01;
	private JTextField tfOtherCostsFromRevenueY00;
	private JTextField tfOtherCostsFromRevenueFY01;
	private JTextField tfOtherCostsFromRevenueFY02;
	private JTextField tfOtherCostsFromRevenueFY03;
	private JTextField tfOtherCostsFromRevenueFY04;
	private JTextField tfOtherCostsFromRevenueFY05;
	private JTextField tfFinancialAssetsFY01;
	private JTextField tfFinancialAssetsFY02;
	private JTextField tfFinancialAssetsFY03;
	private JTextField tfFinancialAssetsFY04;
	private JTextField tfFinancialAssetsFY05;
	private JTextField tfFinancialAssetsChangeFY01;
	private JTextField tfFinancialAssetsChangeFY02;
	private JTextField tfFinancialAssetsChangeFY03;
	private JTextField tfFinancialAssetsChangeFY04;
	private JTextField tfFinancialAssetsChangeFY05;
	private JTextField tfPropertyAssetsFY01;
	private JTextField tfPropertyAssetsFY02;
	private JTextField tfPropertyAssetsFY03;
	private JTextField tfPropertyAssetsFY04;
	private JTextField tfPropertyAssetsFY05;
	private JTextField tfPropertyAssetsChangeFY01;
	private JTextField tfPropertyAssetsChangeFY02;
	private JTextField tfPropertyAssetsChangeFY03;
	private JTextField tfPropertyAssetsChangeFY04;
	private JTextField tfPropertyAssetsChangeFY05;
	private JTextField tfIntangibleAssetsFY01;
	private JTextField tfIntangibleAssetsFY02;
	private JTextField tfIntangibleAssetsFY03;
	private JTextField tfIntangibleAssetsFY04;
	private JTextField tfIntangibleAssetsFY05;
	private JTextField tfIntangibleAssetsChangeFY01;
	private JTextField tfIntangibleAssetsChangeFY02;
	private JTextField tfIntangibleAssetsChangeFY03;
	private JTextField tfIntangibleAssetsChangeFY04;
	private JTextField tfIntangibleAssetsChangeFY05;
	private JTextField tfOtherAssetsFY01;
	private JTextField tfOtherAssetsFY02;
	private JTextField tfOtherAssetsFY03;
	private JTextField tfOtherAssetsFY04;
	private JTextField tfOtherAssetsFY05;
	private JTextField tfOtherAssetsChangeFY01;
	private JTextField tfOtherAssetsChangeFY02;
	private JTextField tfOtherAssetsChangeFY03;
	private JTextField tfOtherAssetsChangeFY04;
	private JTextField tfOtherAssetsChangeFY05;
	private JTextField tfAssetsFY01;
	private JTextField tfAssetsFY02;
	private JTextField tfAssetsFY03;
	private JTextField tfAssetsFY04;
	private JTextField tfAssetsFY05;
	private JTextField tfInventoryFY01;
	private JTextField tfInventoryFY02;
	private JTextField tfInventoryFY03;
	private JTextField tfInventoryFY04;
	private JTextField tfInventoryFY05;
	private JTextField tfInventoryTurnoverFY01;
	private JTextField tfInventoryTurnoverFY02;
	private JTextField tfInventoryTurnoverFY03;
	private JTextField tfInventoryTurnoverFY04;
	private JTextField tfInventoryTurnoverFY05;
	private JTextField tfReceivablesFY01;
	private JTextField tfReceivablesFY02;
	private JTextField tfReceivablesFY03;
	private JTextField tfReceivablesFY04;
	private JTextField tfReceivablesFY05;
	private JTextField tfReceivablesTurnoverFY01;
	private JTextField tfReceivablesTurnoverFY02;
	private JTextField tfReceivablesTurnoverFY03;
	private JTextField tfReceivablesTurnoverFY04;
	private JTextField tfReceivablesTurnoverFY05;
	private JTextField tfOtherNCAFY01;
	private JTextField tfOtherNCAFY02;
	private JTextField tfOtherNCAFY03;
	private JTextField tfOtherNCAFY04;
	private JTextField tfOtherNCAFY05;
	private JTextField tfOtherNCAFromNCAFY01;
	private JTextField tfOtherNCAFromNCAFY02;
	private JTextField tfOtherNCAFromNCAFY03;
	private JTextField tfOtherNCAFromNCAFY04;
	private JTextField tfOtherNCAFromNCAFY05;
	private JTextField tfNCAFY01;
	private JTextField tfNCAFY02;
	private JTextField tfNCAFY03;
	private JTextField tfNCAFY04;
	private JTextField tfNCAFY05;
	private JTextField tfCashFY01;
	private JTextField tfCashFY02;
	private JTextField tfCashFY03;
	private JTextField tfCashFY04;
	private JTextField tfCashFY05;
	private JTextField tfTotalAssetsFY01;
	private JTextField tfTotalAssetsFY02;
	private JTextField tfTotalAssetsFY03;
	private JTextField tfTotalAssetsFY04;
	private JTextField tfTotalAssetsFY05;
	private JTextField tfShareCapitalFY01;
	private JTextField tfShareCapitalFY02;
	private JTextField tfShareCapitalFY03;
	private JTextField tfShareCapitalFY04;
	private JTextField tfShareCapitalChangeFY02;
	private JTextField tfShareCapitalChangeFY03;
	private JTextField tfShareCapitalChangeFY04;
	private JTextField tfShareCapitalFY05;
	private JTextField tfShareCapitalChangeFY05;
	private JTextField tfShareCapitalChangeFY01;
	private JTextField tfReservesFY01;
	private JTextField tfReservesFY02;
	private JTextField tfReservesFY03;
	private JTextField tfReservesFY04;
	private JTextField tfReservesFY05;
	private JTextField tfReservesChangeFY01;
	private JTextField tfReservesChangeFY02;
	private JTextField tfReservesChangeFY03;
	private JTextField tfReservesChangeFY04;
	private JTextField tfReservesChangeFY05;
	private JTextField tfOtherEquityFY01;
	private JTextField tfOtherEquityFY02;
	private JTextField tfOtherEquityFY03;
	private JTextField tfOtherEquityFY04;
	private JTextField tfOtherEquityFY05;
	private JTextField tfOtherEquityChangeFY01;
	private JTextField tfOtherEquityChangeFY02;
	private JTextField tfOtherEquityChangeFY03;
	private JTextField tfOtherEquityChangeFY04;
	private JTextField tfOtherEquityChangeFY05;
	private JTextField tfTotalEquityFY01;
	private JTextField tfTotalEquityFY02;
	private JTextField tfTotalEquityFY03;
	private JTextField tfTotalEquityFY04;
	private JTextField tfTotalEquityFY05;
	private JTextField tfLongTermBankDebtFY01;
	private JTextField tfLongTermBankDebtFY02;
	private JTextField tfLongTermBankDebtFY03;
	private JTextField tfLongTermBankDebtFY04;
	private JTextField tfLongTermBankDebtFY05;
	private JTextField tfLongTermBankDebtChangeFY01;
	private JTextField tfLongTermBankDebtChangeFY02;
	private JTextField tfLongTermBankDebtChangeFY03;
	private JTextField tfLongTermBankDebtChangeFY04;
	private JTextField tfLongTermBankDebtChangeFY05;
	private JTextField tfAccrualsFY01;
	private JTextField tfAccrualsFY02;
	private JTextField tfAccrualsFY03;
	private JTextField tfAccrualsFY04;
	private JTextField tfAccrualsFY05;
	private JTextField tfAccrualsChangeFY01;
	private JTextField tfAccrualsChangeFY02;
	private JTextField tfAccrualsChangeFY03;
	private JTextField tfAccrualsChangeFY04;
	private JTextField tfAccrualsChangeFY05;
	private JTextField tfTotalLongTermLiabilitiesFY01;
	private JTextField tfTotalLongTermLiabilitiesFY02;
	private JTextField tfTotalLongTermLiabilitiesFY03;
	private JTextField tfTotalLongTermLiabilitiesFY04;
	private JTextField tfTotalLongTermLiabilitiesFY05;
	private JTextField tfShortTermBankDebtFY01;
	private JTextField tfShortTermBankDebtFY02;
	private JTextField tfShortTermBankDebtFY03;
	private JTextField tfShortTermBankDebtFY04;
	private JTextField tfShortTermBankDebtFY05;
	private JTextField tfShortTermBankDebtChangeFY01;
	private JTextField tfShortTermBankDebtChangeFY02;
	private JTextField tfShortTermBankDebtChangeFY03;
	private JTextField tfShortTermBankDebtChangeFY04;
	private JTextField tfShortTermBankDebtChangeFY05;
	private JTextField tfTradePayablesFY01;
	private JTextField tfTradePayablesFY02;
	private JTextField tfTradePayablesFY03;
	private JTextField tfTradePayablesFY04;
	private JTextField tfTradePayablesFY05;
	private JTextField tfDaysPayablesOutstandingFY01;
	private JTextField tfDaysPayablesOutstandingFY02;
	private JTextField tfDaysPayablesOutstandingFY03;
	private JTextField tfDaysPayablesOutstandingFY04;
	private JTextField tfDaysPayablesOutstandingFY05;
	private JTextField tfOtherShortTermLiabilitiesFY01;
	private JTextField tfOtherShortTermLiabilitiesFY02;
	private JTextField tfOtherShortTermLiabilitiesFY03;
	private JTextField tfOtherShortTermLiabilitiesFY04;
	private JTextField tfOtherShortTermLiabilitiesFY05;
	private JTextField tfOtherShortTermLiabilitiesChangeFY01;
	private JTextField tfOtherShortTermLiabilitiesChangeFY02;
	private JTextField tfOtherShortTermLiabilitiesChangeFY03;
	private JTextField tfOtherShortTermLiabilitiesChangeFY04;
	private JTextField tfOtherShortTermLiabilitiesChangeFY05;
	private JTextField tfTotalShortTermLiabilitiesFY01;
	private JTextField tfTotalShortTermLiabilitiesFY02;
	private JTextField tfTotalShortTermLiabilitiesFY03;
	private JTextField tfTotalShortTermLiabilitiesFY04;
	private JTextField tfTotalShortTermLiabilitiesFY05;
	private JTextField tfTotalLiabilitiesFY01;
	private JTextField tfTotalLiabilitiesFY02;
	private JTextField tfTotalLiabilitiesFY03;
	private JTextField tfTotalLiabilitiesFY04;
	private JTextField tfTotalLiabilitiesFY05;
	private JPanel pnlBackgroundLiabilities;
	private JLabel lblEndwert;
	private JTextField tfCFTotalIncomeTV;
	private JTextField CFDepreciationTV;
	private JTextField tfCFDepreciationIntangibleTV;
	private JTextField tfCFAssetsInvestTV;
	private JTextField tfCFWorkingCapitalInvestTV;
	private JTextField tfCFDebtChangeTV;
	private JTextField tfCashflowToEquityTV;
	private JTextField tfDiscountedCashflowTV;
	private JPanel chartPanelRevenue;
	private JPanel chartPanelLeverage;
	private JPanel chartPanelAssetIntensity;
	private JPanel chartPanelCirculatingIntensity;
	private JPanel chartPanelInventoryTurnover;
	private JPanel chartPanelReceivablesTurnover;
	private JPanel chartPanelPayablesTurnover;
	private JPanel chartPanelTotalIncome;
	private JPanel chartPanelReturnOnSales;
	private JPanel chartPanelReturnOnEBITDA;
	private JPanel chartPanelReturnOnEquity;
	private JPanel chartPanelTotalReturnOnInvest;
	private JTextField tfCFAccrualsFY01;
	private JTextField tfCFAccrualsFY02;
	private JTextField tfCFAccrualsFY03;
	private JTextField tfCFAccrualsFY04;
	private JTextField tfCFAccrualsFY05;
	private JTextField tfCFAccrualsTV;
	private JTextField tfFairValueFromSharePrice;
	private JLabel lblNachdemSieDie;
	private JLabel lblDetailliertereInformationenZu;
	private JLabel lblEsStehtEine;
	private JLabel lblWelcheRegelmigNur;
	private JLabel lblUnternehmensUndZb;
	private JLabel lblSchrittZuknftige;
	private JLabel lblRechnerischeUnternehmenswertSich;
	private JLabel lblAlsAnhalteNutzen;
	private JLabel lblUnternehmensUndZb_1;
	private JLabel lblUnternehmensUndZb_2;
	private JLabel lblPositiveEntwicklungenUnd;
	private JMenu mnHelp;

		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
							InvestigatorGUI frame = new InvestigatorGUI();
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
												
				} 
		});
	}

	/**
	 * Create the frame.
	 */
	
	public InvestigatorGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				int ret = JOptionPane.showConfirmDialog (null, "Nicht gespeicherter Fortschritt geht verloren. Das Programm wirklich beenden?", "Wirklich Beenden?", JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.NO_OPTION) {
					return;
				}
				
				else if(ret==JOptionPane.YES_OPTION) {
					System.exit(0);
					
				}

			}
		});
		setMaximizedBounds(new Rectangle(10, 10, 1920,915));
		setLocationByPlatform(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Finance Investigator" + " - " + temporary.getCompanyName());
		setBounds(10, 10, 1920,915);
		setUndecorated(false);
		ImageIcon img = new ImageIcon("res/investigatorIcon.png");
		setIconImage(img.getImage());
		setPreferredSize(new Dimension(1920,900));

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		mnMen = new JMenu("Menü");
		menuBar.add(mnMen);
		
		mntmCreateNewCompany = new JMenuItem("Create new company");
		mntmCreateNewCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompany();
			}
		});
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveCompany();
			}
		});
		mnMen.add(mntmSave);
		
		mntmLoad = new JMenuItem("Open");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadCompany();
				
			}
		});
		mnMen.add(mntmLoad);
		mnMen.add(mntmCreateNewCompany);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ret = JOptionPane.showConfirmDialog (null, "Unsaved content willl be lost. Really close FinanceInvestigator?", "Really close?", JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.NO_OPTION) {
					return;
				}
				
				else if(ret==JOptionPane.YES_OPTION) {
					System.exit(0);
					
				}
			}
		});
		mnMen.add(mntmExit);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmOnlineHelp = new JMenuItem("Online Help");
		mntmOnlineHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.finance-investigator.com/hilfe/online-hilfe"));
				} catch(IOException err) {
					err.printStackTrace();
					
				} catch (URISyntaxException err) {
					err.printStackTrace();
		}
			}
		});
		mnHelp.add(mntmOnlineHelp);
		
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setPreferredSize(new Dimension(1920,900));
		int dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();
		dismissDelay = Integer.MAX_VALUE;
	    ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
	    UIManager.put("ToolTip.background", Color.black);
	    UIManager.put("ToolTip.foreground", Color.white);
	    UIManager.put("ScrollBar.background", Color.white);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("res\\INVESTIGATOR_LOGO.png").getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
		contentPane.setLayout(new MigLayout("", "[1904px]", "[838px]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		JPanel platform = new JPanel();
		platform.setBackground(Color.WHITE);
		scrollPane.setViewportView(platform);
		platform.setLayout(null);
		platform.setPreferredSize(new Dimension (1920,900));
		
		sidepanel = new JPanel();
		sidepanel.setBounds(0, 0, 343, 838);
		platform.add(sidepanel);
		sidepanel.setBackground(new Color(0, 0, 0));
		sidepanel.setLayout(null);
		
		logoBackground = new JPanel();
		logoBackground.setBorder(new LineBorder(Color.WHITE));
		logoBackground.setBackground(Color.WHITE);
		logoBackground.setBounds(0, 0, 343, 197);
		sidepanel.add(logoBackground);
		logoBackground.setLayout(null);
		
		
		// Setzen des Investigator Logos in einem Label mit dynamischer Groesse
				
		lblLogo = new JLabel("");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(0, 0, 343, 197);
		logoBackground.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(imageIcon);
		
		
		mainPanel = new JPanel();
		mainPanel.setBounds(341, 0, 1571, 838);
		platform.add(mainPanel);
		mainPanel.setBackground(Color.WHITE);
		CardLayout cardLayout = new CardLayout(0,0);
		mainPanel.setLayout(cardLayout);
		
		btnMasterData = new JPanel();
		btnMasterData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "MasterData");
				activateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				deactivateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
				
			}
		});
		btnMasterData.setBounds(0, 233, 341, 63);
		sidepanel.add(btnMasterData);
		btnMasterData.setLayout(null);
		btnMasterData.setBackground(new Color(0, 0, 0));
		activateButton(btnMasterData);
		
		JLabel lblMasterData = new JLabel("Basic Data");
		lblMasterData.setBounds(48, 0, 286, 63);
		btnMasterData.add(lblMasterData);
		lblMasterData.setForeground(Color.WHITE);
		lblMasterData.setFont(new Font("Segoe UI", Font.BOLD, 21));
		
		btnProfitLoss = new JPanel();
		btnProfitLoss.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "ProfitLoss");
				deactivateButton(btnMasterData);
				activateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				deactivateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
			}
		});
		btnProfitLoss.setLayout(null);
		btnProfitLoss.setBackground(new Color(0, 0, 0));
		btnProfitLoss.setBounds(0, 308, 341, 63);
		sidepanel.add(btnProfitLoss);
		
		lblProfitLoss = new JLabel("Profit and Loss");
		lblProfitLoss.setBounds(48, 0, 286, 63);
		btnProfitLoss.add(lblProfitLoss);
		lblProfitLoss.setForeground(Color.WHITE);
		lblProfitLoss.setFont(new Font("Segoe UI", Font.BOLD, 21));
		
		btnAssets = new JPanel();
		btnAssets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "Assets");
				deactivateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				activateButton(btnAssets);
				deactivateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
			}
		});
		btnAssets.setLayout(null);
		btnAssets.setBackground(new Color(0, 0, 0));
		btnAssets.setBounds(0, 383, 341, 63);
		sidepanel.add(btnAssets);
		
		lblAssets_1 = new JLabel("Balance Sheet - Assets");
		lblAssets_1.setBounds(48, 0, 286, 63);
		btnAssets.add(lblAssets_1);
		lblAssets_1.setForeground(Color.WHITE);
		lblAssets_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
		
		btnLiabilities = new JPanel();
		btnLiabilities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "Liabilities");
				deactivateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				activateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
				
			}
		});
		btnLiabilities.setLayout(null);
		btnLiabilities.setBackground(new Color(0, 0, 0));
		btnLiabilities.setBounds(0, 458, 341, 63);
		sidepanel.add(btnLiabilities);
		
		lblLiabilities = new JLabel("Balance Sheet - Liabilities");
		lblLiabilities.setBounds(48, 0, 286, 63);
		btnLiabilities.add(lblLiabilities);
		lblLiabilities.setForeground(Color.WHITE);
		lblLiabilities.setFont(new Font("Segoe UI", Font.BOLD, 21));
		
		btnCashFlow = new JPanel();
		btnCashFlow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "CashFlow");
				deactivateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				deactivateButton(btnLiabilities);
				activateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
			}
		});
		btnCashFlow.setLayout(null);
		btnCashFlow.setBackground(new Color(0, 0, 0));
		btnCashFlow.setBounds(0, 533, 341, 63);
		sidepanel.add(btnCashFlow);
		
		lblCF = new JLabel("Fair Value");
		lblCF.setForeground(Color.WHITE);
		lblCF.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblCF.setBounds(48, 0, 286, 63);
		btnCashFlow.add(lblCF);
		
		btnKeyPerformanceIndicators = new JPanel();
		btnKeyPerformanceIndicators.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "KeyPerformanceIndicators");
				deactivateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				deactivateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				activateButton(btnKeyPerformanceIndicators);
				deactivateButton(btnGraphics);
				SaveAssetValues();
			}
		});
		btnKeyPerformanceIndicators.setLayout(null);
		btnKeyPerformanceIndicators.setBackground(new Color(0, 0, 0));
		btnKeyPerformanceIndicators.setBounds(0, 608, 341, 63);
		sidepanel.add(btnKeyPerformanceIndicators);
		
		lblKPI = new JLabel("Financial Situation");
		lblKPI.setForeground(Color.WHITE);
		lblKPI.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblKPI.setBounds(48, 0, 286, 63);
		btnKeyPerformanceIndicators.add(lblKPI);
		
		btnGraphics = new JPanel();
		btnGraphics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainPanel, "Graphics");
				deactivateButton(btnMasterData);
				deactivateButton(btnProfitLoss);
				deactivateButton(btnAssets);
				deactivateButton(btnLiabilities);
				deactivateButton(btnCashFlow);
				deactivateButton(btnKeyPerformanceIndicators);
				activateButton(btnGraphics);
				SaveAssetValues();
			}
		});
		btnGraphics.setLayout(null);
		btnGraphics.setBackground(new Color(0, 0, 0));
		btnGraphics.setBounds(0, 683, 341, 63);
		sidepanel.add(btnGraphics);
		
		lblGraph = new JLabel("Earnings Situation");
		lblGraph.setForeground(Color.WHITE);
		lblGraph.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblGraph.setBounds(48, 0, 286, 63);
		btnGraphics.add(lblGraph);
		
		scrollPaneMasterData = new JScrollPane();
		scrollPaneMasterData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneMasterData.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneMasterData, "MasterData");
		scrollPaneMasterData.setPreferredSize(new Dimension(1920,1080));
		
		pnlMasterData = new JPanel();
		scrollPaneMasterData.setViewportView(pnlMasterData);
		pnlMasterData.setBorder(null);
		pnlMasterData.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlMasterData.setBackground(UIManager.getColor("Panel.background"));
		pnlMasterData.setPreferredSize(new Dimension(1920,1080));
		pnlMasterData.setLayout(null);
		
		//Definition der Eingabe und Ausgabefelder
		
		JPanel background1 = new JPanel();
		background1.setBounds(10, 11, 520, 807);
		background1.setBackground(Color.WHITE);
		pnlMasterData.add(background1);
		background1.setLayout(null);
		
		lblCompanyName = new JLabel("Company Name:");
		designLabel(lblCompanyName);
		lblCompanyName.setBounds(10, 88, 256, 20);
		background1.add(lblCompanyName);
		
		tfCompanyName = new JTextField("Unnamed");
		designEditableTextField(tfCompanyName);
		tfCompanyName.setBounds(314, 88, 176, 22);
		background1.add(tfCompanyName);
		tfCompanyName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfShareVolume.requestFocus();
				   }
			}
		});
		tfCompanyName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCompanyName.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShareVolume = new JTextField("1");
		tfShareVolume.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfCurrentSharePrice.requestFocus();
				   }
			}
		});
		designEditableTextField(tfShareVolume);
		tfShareVolume.setBounds(314, 174, 176, 20);
		background1.add(tfShareVolume);
		tfShareVolume.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
			@Override
			public void focusGained(FocusEvent e) {
				tfShareVolume.selectAll();
			}
		});
		
		lblShareVolume = new JLabel("Amount of shares in Mio.:");
		designLabel(lblShareVolume);
		lblShareVolume.setBounds(10, 175, 279, 20);
		background1.add(lblShareVolume);
		
		lblCurrentSharePrice = new JLabel("Current price per share:");
		designLabel(lblCurrentSharePrice);
		lblCurrentSharePrice.setBounds(10, 207, 256, 20);
		background1.add(lblCurrentSharePrice);
		
		tfCurrentSharePrice = new JTextField("0,00");
		tfCurrentSharePrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfDividendsPaidPY03.requestFocus();
				   }
			}
		});
		designEditableTextField(tfCurrentSharePrice);
		tfCurrentSharePrice.setBounds(314, 207, 176, 20);
		background1.add(tfCurrentSharePrice);
		tfCurrentSharePrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCurrentSharePrice.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		JLabel lblDividendsPaidPY03 = new JLabel("Paid dividends (Mio.) year -3:");
		designLabel(lblDividendsPaidPY03);
		lblDividendsPaidPY03.setBounds(10, 264, 279, 20);
		background1.add(lblDividendsPaidPY03);
		
		tfDividendsPaidPY03 = new JTextField("0,00");
		tfDividendsPaidPY03.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfDividendsPaidPY02.requestFocus();
				   }
			}
		});
		designEditableTextField(tfDividendsPaidPY03);
		tfDividendsPaidPY03.setBounds(314, 264, 176, 20);
		background1.add(tfDividendsPaidPY03);
		tfDividendsPaidPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		lblDividendsPaidPY02 = new JLabel("Paid dividends (Mio.) year -2:");
		designLabel(lblDividendsPaidPY02);
		lblDividendsPaidPY02.setBounds(10, 295, 279, 20);
		background1.add(lblDividendsPaidPY02);
		
		tfDividendsPaidPY02 = new JTextField("0,00");
		tfDividendsPaidPY02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfDividendsPaidPY01.requestFocus();
				   }
			}
		});
		designEditableTextField(tfDividendsPaidPY02);
		tfDividendsPaidPY02.setBounds(314, 295, 176, 20);
		background1.add(tfDividendsPaidPY02);
		tfDividendsPaidPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		lblDividendsPaidPY01 = new JLabel("Paid dividends (Mio.) year -1:");
		designLabel(lblDividendsPaidPY01);
		lblDividendsPaidPY01.setBounds(10, 326, 279, 20);
		background1.add(lblDividendsPaidPY01);
		
		tfDividendsPaidPY01 = new JTextField("0,00");
		tfDividendsPaidPY01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfDividendsPaidY00.requestFocus();
				   }
			}
		});
		designEditableTextField(tfDividendsPaidPY01);
		tfDividendsPaidPY01.setBounds(314, 326, 176, 20);
		background1.add(tfDividendsPaidPY01);
		tfDividendsPaidPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		lblDividendsPaidY00 = new JLabel("Paid dividends (Mio.) current year:");
		designLabel(lblDividendsPaidY00);
		lblDividendsPaidY00.setBounds(10, 357, 279, 20);
		background1.add(lblDividendsPaidY00);
		
		tfDividendsPaidY00 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidY00);
		tfDividendsPaidY00.setBounds(314, 357, 176, 20);
		background1.add(tfDividendsPaidY00);
		
		Button button = new Button("Start Smart Simulation Helper");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tfDividendsPaidPY01.requestFocus();
				tfDividendsPaidPY01.selectAll();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulationHelper();
			}
		});
		button.setBounds(87, 482, 331, 28);
		background1.add(button);
		tfDividendsPaidY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		JPanel background2 = new JPanel();
		background2.setBounds(538, 11, 1007, 807);
		background2.setBackground(Color.WHITE);
		pnlMasterData.add(background2);
		background2.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Finance Investigator");
		lblWelcome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblWelcome.setBounds(10, 29, 504, 41);
		background2.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Dear Customer,");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 88, 966, 20);
		background2.add(lblNewLabel);
		
		JLabel lblWirFreuenUns = new JLabel("We are pleased that you have chosen our software and would like to show you the first steps with the software below");
		lblWirFreuenUns.setVerticalAlignment(SwingConstants.TOP);
		lblWirFreuenUns.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblWirFreuenUns.setBounds(10, 119, 966, 20);
		background2.add(lblWirFreuenUns);
		
		JLabel lblErluternDieseKnnen = new JLabel("You can also use these points as a checklist for each new analysis:");
		lblErluternDieseKnnen.setVerticalAlignment(SwingConstants.TOP);
		lblErluternDieseKnnen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblErluternDieseKnnen.setBounds(10, 150, 966, 20);
		background2.add(lblErluternDieseKnnen);
		
		JLabel lblSchrittDaten = new JLabel("Step 1: Obtain historical financial company data");
		lblSchrittDaten.setVerticalAlignment(SwingConstants.TOP);
		lblSchrittDaten.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblSchrittDaten.setBounds(10, 194, 966, 28);
		background2.add(lblSchrittDaten);
		
		JLabel lblDieFinanzdatninsbesondere = new JLabel("You can easily find the financial data (especially of listed companies) on the internet. To do this, enter the company name in a search engine");
		lblDieFinanzdatninsbesondere.setVerticalAlignment(SwingConstants.TOP);
		lblDieFinanzdatninsbesondere.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblDieFinanzdatninsbesondere.setBounds(10, 225, 966, 20);
		background2.add(lblDieFinanzdatninsbesondere);
		
		JLabel lblDesUnternehmensUnd = new JLabel("and add \"Annual Report\" or \"Investor Relations\". Download the annual report from this year and the last 3 years.");
		lblDesUnternehmensUnd.setVerticalAlignment(SwingConstants.TOP);
		lblDesUnternehmensUnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblDesUnternehmensUnd.setBounds(10, 256, 966, 20);
		background2.add(lblDesUnternehmensUnd);
		
		JLabel lblJahrenHerunter = new JLabel("The necessary data can be found in the annual report in the sections \"Income Statement\", \"Balance Sheet\" and \"Cash Flow\",");
		lblJahrenHerunter.setVerticalAlignment(SwingConstants.TOP);
		lblJahrenHerunter.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblJahrenHerunter.setBounds(10, 287, 966, 20);
		background2.add(lblJahrenHerunter);
		
		JLabel lblSchrittHistorische = new JLabel("Step 2: Enter historical financial data (last 3 years and current year) into the software");
		lblSchrittHistorische.setVerticalAlignment(SwingConstants.TOP);
		lblSchrittHistorische.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblSchrittHistorische.setBounds(10, 400, 966, 28);
		background2.add(lblSchrittHistorische);
		
		JLabel lblDieInSchritt = new JLabel("You can now enter the data obtained in step 1 into the software. Start on this side and then work from top to bottom (or use the Excel import helper)");
		lblDieInSchritt.setVerticalAlignment(SwingConstants.TOP);
		lblDieInSchritt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblDieInSchritt.setBounds(10, 431, 966, 20);
		background2.add(lblDieInSchritt);
		
		JLabel lblReiterDurch = new JLabel("Proceed with all tabs listed on the left. Since a simplified form of balance sheet and income statement is used, individual items are to be added maually.");
		lblReiterDurch.setVerticalAlignment(SwingConstants.TOP);
		lblReiterDurch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblReiterDurch.setBounds(10, 462, 966, 20);
		background2.add(lblReiterDurch);
		
		JLabel lblHinweise = new JLabel("Disclaimer:");
		lblHinweise.setForeground(Color.GRAY);
		lblHinweise.setVerticalAlignment(SwingConstants.TOP);
		lblHinweise.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblHinweise.setBounds(10, 751, 966, 20);
		background2.add(lblHinweise);
		
		JLabel lblDieSchtzungVon = new JLabel("Estimating company values ​​using this software should never form the basis for an investment and does not replace professional investment advice.");
		lblDieSchtzungVon.setForeground(Color.GRAY);
		lblDieSchtzungVon.setVerticalAlignment(SwingConstants.TOP);
		lblDieSchtzungVon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDieSchtzungVon.setBounds(10, 769, 966, 20);
		background2.add(lblDieSchtzungVon);
		
		JLabel lblDieSchtzungVon_1 = new JLabel("We assume no liability for any financial losses resulting from financial decisions which are solely based on the usage of this software.");
		lblDieSchtzungVon_1.setForeground(Color.GRAY);
		lblDieSchtzungVon_1.setVerticalAlignment(SwingConstants.TOP);
		lblDieSchtzungVon_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDieSchtzungVon_1.setBounds(10, 787, 966, 20);
		background2.add(lblDieSchtzungVon_1);
		
		lblNachdemSieDie = new JLabel("Having successfully implemented steps 1 and 2, you can estimate the future development of the company and analyze the indicative company value");
		lblNachdemSieDie.setVerticalAlignment(SwingConstants.TOP);
		lblNachdemSieDie.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNachdemSieDie.setBounds(10, 606, 966, 20);
		background2.add(lblNachdemSieDie);
		
		lblDetailliertereInformationenZu = new JLabel("More detailed information on the individual items can be found in our online help. The data is usually given in millions of the respective currency, except");
		lblDetailliertereInformationenZu.setVerticalAlignment(SwingConstants.TOP);
		lblDetailliertereInformationenZu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblDetailliertereInformationenZu.setBounds(10, 493, 966, 20);
		background2.add(lblDetailliertereInformationenZu);
		
		lblEsStehtEine = new JLabel("there is another unit requested in the respective position of the software (e.g. \"in %\"). If necessary, negative positions can be stated with a minus -.");
		lblEsStehtEine.setVerticalAlignment(SwingConstants.TOP);
		lblEsStehtEine.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblEsStehtEine.setBounds(10, 524, 966, 20);
		background2.add(lblEsStehtEine);
		
		lblWelcheRegelmigNur = new JLabel("which regularly consist of only a few pages. You can also find the number of shares using a search engine with the terms \"company name\"");
		lblWelcheRegelmigNur.setVerticalAlignment(SwingConstants.TOP);
		lblWelcheRegelmigNur.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblWelcheRegelmigNur.setBounds(10, 318, 966, 20);
		background2.add(lblWelcheRegelmigNur);
		
		lblUnternehmensUndZb = new JLabel("and \"number of shares\".");
		lblUnternehmensUndZb.setVerticalAlignment(SwingConstants.TOP);
		lblUnternehmensUndZb.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUnternehmensUndZb.setBounds(10, 349, 966, 20);
		background2.add(lblUnternehmensUndZb);
		
		lblSchrittZuknftige = new JLabel("Step 3: Estimate future developments over the next 5 years");
		lblSchrittZuknftige.setVerticalAlignment(SwingConstants.TOP);
		lblSchrittZuknftige.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblSchrittZuknftige.setBounds(10, 575, 966, 28);
		background2.add(lblSchrittZuknftige);
		
		lblRechnerischeUnternehmenswertSich = new JLabel("resulting from the forecasts you have made. In a first step, you can use the ratios from the past as a hint to check what happens if ");
		lblRechnerischeUnternehmenswertSich.setVerticalAlignment(SwingConstants.TOP);
		lblRechnerischeUnternehmenswertSich.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblRechnerischeUnternehmenswertSich.setBounds(10, 637, 966, 20);
		background2.add(lblRechnerischeUnternehmenswertSich);
		
		lblAlsAnhalteNutzen = new JLabel("\"everything goes on as before\". After that you can change single positions to simulate best and worst cases.");
		lblAlsAnhalteNutzen.setVerticalAlignment(SwingConstants.TOP);
		lblAlsAnhalteNutzen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAlsAnhalteNutzen.setBounds(10, 668, 966, 20);
		background2.add(lblAlsAnhalteNutzen);
		
		lblUnternehmensUndZb_1 = new JLabel("-");
		lblUnternehmensUndZb_1.setVerticalAlignment(SwingConstants.TOP);
		lblUnternehmensUndZb_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUnternehmensUndZb_1.setBounds(10, 380, 966, 9);
		background2.add(lblUnternehmensUndZb_1);
		
		lblUnternehmensUndZb_2 = new JLabel("-");
		lblUnternehmensUndZb_2.setVerticalAlignment(SwingConstants.TOP);
		lblUnternehmensUndZb_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUnternehmensUndZb_2.setBounds(10, 555, 966, 9);
		background2.add(lblUnternehmensUndZb_2);
		
		lblPositiveEntwicklungenUnd = new JLabel("Hint: The software initially shows how a company could perform based on the average historical data.");
		lblPositiveEntwicklungenUnd.setVerticalAlignment(SwingConstants.TOP);
		lblPositiveEntwicklungenUnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPositiveEntwicklungenUnd.setBounds(10, 699, 966, 20);
		background2.add(lblPositiveEntwicklungenUnd);
		
		//Design des Panel Gewinn und Verlustrechnung
		
		scrollPaneProfitLoss = new JScrollPane();
		scrollPaneProfitLoss.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneProfitLoss.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneProfitLoss.setBackground(UIManager.getColor("Button.background"));
		mainPanel.add(scrollPaneProfitLoss, "ProfitLoss");
		scrollPaneProfitLoss.setPreferredSize(new Dimension(1920,900));
		
		JPanel pnlProfitLoss = new JPanel();
		scrollPaneProfitLoss.setViewportView(pnlProfitLoss);
		pnlProfitLoss.setBorder(null);
		pnlProfitLoss.setBackground(UIManager.getColor("Button.background"));
		pnlProfitLoss.setPreferredSize(new Dimension(1920,900));
		pnlProfitLoss.setLayout(null);
		
		backgroundProfitLoss = new JPanel();
		backgroundProfitLoss.setBounds(10, 11, 1535, 803);
		backgroundProfitLoss.setBackground(Color.WHITE);
		pnlProfitLoss.add(backgroundProfitLoss);
		backgroundProfitLoss.setLayout(null);
		
		JLabel lblProfitLossPY03 = new JLabel("Year -3");
		designLabelR(lblProfitLossPY03);
		lblProfitLossPY03.setBounds(292, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossPY03);
		
		JLabel lblProfitLossPY02 = new JLabel("Year -2 ");
		designLabelR(lblProfitLossPY02);
		lblProfitLossPY02.setBounds(428, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossPY02);
		
		JLabel lblProfitLossPY01 = new JLabel("Year -1");
		designLabelR(lblProfitLossPY01);
		lblProfitLossPY01.setBounds(564, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossPY01);
		
		JLabel lblProfitLossY00 = new JLabel("Current Year");
		designLabelR(lblProfitLossY00);
		lblProfitLossY00.setBounds(698, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossY00);
		
		JLabel lblProfitLossFY01 = new JLabel("Year +1");
		designLabelR(lblProfitLossFY01);
		lblProfitLossFY01.setBounds(832, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossFY01);
		
		JLabel lblProfitLossFY02 = new JLabel("Year +2 ");
		designLabelR(lblProfitLossFY02);
		lblProfitLossFY02.setBounds(968, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossFY02);
		
		JLabel lblProfitLossFY03 = new JLabel("Year +3");
		designLabelR(lblProfitLossFY03);
		lblProfitLossFY03.setBounds(1104, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossFY03);
		
		JLabel lblProfitLossFY04 = new JLabel("Year +4 ");
		designLabelR(lblProfitLossFY04);
		lblProfitLossFY04.setBounds(1238, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossFY04);
		
		JLabel lblProfitLossFY05 = new JLabel("Year +5");
		designLabelR(lblProfitLossFY05);
		lblProfitLossFY05.setBounds(1374, 24, 124, 16);
		backgroundProfitLoss.add(lblProfitLossFY05);
		
		JLabel lblRevenue = new JLabel("Revenue:");
		designLabel(lblRevenue);
		lblRevenue.setBounds(10, 52, 208, 20);
		backgroundProfitLoss.add(lblRevenue);
		lblRevenue.setToolTipText("");
		
		tfRevenuePY03 = new JTextField("0,00");
		tfRevenuePY03.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRevenuePY02.requestFocus();
				   }
			}
		});
		designEditableTextField(tfRevenuePY03);
		tfRevenuePY03.setBounds(292, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenuePY03);
		tfRevenuePY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenuePY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfRevenuePY02 = new JTextField("0,00");
		tfRevenuePY02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRevenuePY01.requestFocus();
				   }
			}
		});
		designEditableTextField(tfRevenuePY02);
		tfRevenuePY02.setBounds(428, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenuePY02);
		tfRevenuePY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenuePY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfRevenuePY01 = new JTextField("0,00");
		tfRevenuePY01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRevenueY00.requestFocus();
				   }
			}
		});
		designEditableTextField(tfRevenuePY01);
		tfRevenuePY01.setBounds(564, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenuePY01);
		tfRevenuePY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenuePY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfRevenueY00 = new JTextField("0,00");
		tfRevenueY00.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRevenueChangeFY01.requestFocus();
				   }
			}
		});
		designEditableTextField(tfRevenueY00);
		tfRevenueY00.setBounds(698, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueY00);
		tfRevenueY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfRevenueFY01 = new JTextField("0,00");
		designNonEditableTextField(tfRevenueFY01);
		tfRevenueFY01.setBounds(832, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueFY01);
		
		tfRevenueFY02 = new JTextField("0,00");
		designNonEditableTextField(tfRevenueFY02);
		tfRevenueFY02.setBounds(968, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueFY02);
		
		tfRevenueFY03 = new JTextField("0,00");
		designNonEditableTextField(tfRevenueFY03);
		tfRevenueFY03.setBounds(1104, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueFY03);
		
		tfRevenueFY04 = new JTextField("0,00");
		designNonEditableTextField(tfRevenueFY04);
		tfRevenueFY04.setBounds(1238, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueFY04);
		
		tfRevenueFY05 = new JTextField("0,00");
		designNonEditableTextField(tfRevenueFY05);
		tfRevenueFY05.setBounds(1374, 52, 124, 20);
		backgroundProfitLoss.add(tfRevenueFY05);
		
		JLabel lblRevenueChange = new JLabel("Change in % to prev. year:");
		designLabel(lblRevenueChange);
		lblRevenueChange.setBounds(51, 84, 191, 20);
		backgroundProfitLoss.add(lblRevenueChange);
		
		tfRevenueChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfRevenueChangePY02);
		tfRevenueChangePY02.setBounds(362, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangePY02);
		
		tfRevenueChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfRevenueChangePY01);
		tfRevenueChangePY01.setBounds(496, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangePY01);
		
		tfRevenueChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfRevenueChangeY00);
		tfRevenueChangeY00.setHorizontalAlignment(SwingConstants.CENTER);
		tfRevenueChangeY00.setBounds(630, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeY00);
		
		tfRevenueChangeFY01 = new JTextField("0,00");
		designEditableTextFieldC(tfRevenueChangeFY01);
		tfRevenueChangeFY01.setBounds(768, 84, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeFY01);
		tfRevenueChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfRevenueChangeFY02 = new JTextField("0,00");
		designEditableTextFieldC(tfRevenueChangeFY02);
		tfRevenueChangeFY02.setBounds(902, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeFY02);
		tfRevenueChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfRevenueChangeFY03 = new JTextField("0,00");
		designEditableTextFieldC(tfRevenueChangeFY03);
		tfRevenueChangeFY03.setBounds(1036, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeFY03);
		tfRevenueChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfRevenueChangeFY04 = new JTextField("0,00");
		designEditableTextFieldC(tfRevenueChangeFY04);
		tfRevenueChangeFY04.setBounds(1170, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeFY04);
		tfRevenueChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfRevenueChangeFY05 = new JTextField("0,00");
		tfRevenueChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRevenueChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfRevenueChangeFY05);
		tfRevenueChangeFY05.setBounds(1304, 83, 124, 20);
		backgroundProfitLoss.add(tfRevenueChangeFY05);
		
		lblCogs = new JLabel("- Cost of goods sold / manufactured:");
		designLabel(lblCogs);
		lblCogs.setToolTipText("");
		lblCogs.setBounds(10, 115, 272, 20);
		backgroundProfitLoss.add(lblCogs);
		
		tfCogsPY03 = new JTextField("0,00");
		designEditableTextField(tfCogsPY03);
		tfCogsPY03.setBounds(292, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsPY03);
		tfCogsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfCogsPY02 = new JTextField("0,00");
		designEditableTextField(tfCogsPY02);
		tfCogsPY02.setBounds(428, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsPY02);
		tfCogsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfCogsPY01 = new JTextField("0,00");
		designEditableTextField(tfCogsPY01);
		tfCogsPY01.setBounds(564, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsPY01);
		tfCogsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfCogsY00 = new JTextField("0,00");
		designEditableTextField(tfCogsY00);
		tfCogsY00.setBounds(698, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsY00);
		tfCogsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfCogsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFY01);
		tfCogsFY01.setBounds(832, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsFY01);
		
		tfCogsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFY02);
		tfCogsFY02.setBounds(968, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsFY02);
		
		tfCogsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFY03);
		tfCogsFY03.setBounds(1104, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsFY03);
		
		tfCogsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFY04);
		tfCogsFY04.setBounds(1238, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsFY04);
		
		tfCogsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFY05);
		tfCogsFY05.setBounds(1374, 115, 124, 20);
		backgroundProfitLoss.add(tfCogsFY05);
		
		lblCogsFromRevenue = new JLabel("In % of revenue:");
		designLabel(lblCogsFromRevenue);
		lblCogsFromRevenue.setBounds(51, 146, 191, 20);
		backgroundProfitLoss.add(lblCogsFromRevenue);
		
		tfCogsFromRevenuePY03 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFromRevenuePY03);
		tfCogsFromRevenuePY03.setBounds(292, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenuePY03);
		
		tfCogsFromRevenuePY02 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFromRevenuePY02);
		tfCogsFromRevenuePY02.setBounds(428, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenuePY02);
		
		tfCogsFromRevenuePY01 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFromRevenuePY01);
		tfCogsFromRevenuePY01.setBounds(564, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenuePY01);
		
		tfCogsFromRevenueY00 = new JTextField("0,00");
		designNonEditableTextField(tfCogsFromRevenueY00);
		tfCogsFromRevenueY00.setBounds(698, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueY00);
		
		tfCogsFromRevenueFY01 = new JTextField("0,00");
		designEditableTextField(tfCogsFromRevenueFY01);
		tfCogsFromRevenueFY01.setBounds(832, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueFY01);
		tfCogsFromRevenueFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsFromRevenueFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfCogsFromRevenueFY02 = new JTextField("0,00");
		designEditableTextField(tfCogsFromRevenueFY02);
		tfCogsFromRevenueFY02.setBounds(968, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueFY02);
		tfCogsFromRevenueFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsFromRevenueFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfCogsFromRevenueFY03 = new JTextField("0,00");
		designEditableTextField(tfCogsFromRevenueFY03);
		tfCogsFromRevenueFY03.setBounds(1104, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueFY03);
		tfCogsFromRevenueFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsFromRevenueFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfCogsFromRevenueFY04 = new JTextField("0,00");
		designEditableTextField(tfCogsFromRevenueFY04);
		tfCogsFromRevenueFY04.setBounds(1238, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueFY04);
		tfCogsFromRevenueFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsFromRevenueFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfCogsFromRevenueFY05 = new JTextField("0,00");
		tfCogsFromRevenueFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCogsFromRevenueFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfCogsFromRevenueFY05);
		tfCogsFromRevenueFY05.setBounds(1374, 146, 124, 20);
		backgroundProfitLoss.add(tfCogsFromRevenueFY05);
		
		JLabel lblOtherCosts = new JLabel("- Other earnings and expenses:");
		lblOtherCosts.setToolTipText("");
		designLabel(lblOtherCosts);
		lblOtherCosts.setBounds(10, 177, 272, 20);
		backgroundProfitLoss.add(lblOtherCosts);
		
		tfOtherCostsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsPY03);
		tfOtherCostsPY03.setBounds(292, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsPY03);
		
		tfOtherCostsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsPY02);
		tfOtherCostsPY02.setBounds(428, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsPY02);
		
		tfOtherCostsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsPY01);
		tfOtherCostsPY01.setBounds(564, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsPY01);
		
		tfOtherCostsY00 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsY00);
		tfOtherCostsY00.setBounds(698, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsY00);
		
		tfOtherCostsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFY01);
		tfOtherCostsFY01.setBounds(832, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFY01);
		
		tfOtherCostsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFY02);
		tfOtherCostsFY02.setBounds(968, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFY02);
		
		tfOtherCostsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFY03);
		tfOtherCostsFY03.setBounds(1104, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFY03);
		
		tfOtherCostsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFY04);
		tfOtherCostsFY04.setBounds(1238, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFY04);
		
		tfOtherCostsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFY05);
		tfOtherCostsFY05.setBounds(1374, 177, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFY05);
		
		JLabel lblOtherCostsFromRevenue = new JLabel("In % of revenue:");
		designLabel(lblOtherCostsFromRevenue);
		lblOtherCostsFromRevenue.setBounds(51, 208, 191, 20);
		backgroundProfitLoss.add(lblOtherCostsFromRevenue);
		
		tfOtherCostsFromRevenuePY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFromRevenuePY03);
		tfOtherCostsFromRevenuePY03.setBounds(292, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenuePY03);
		
		tfOtherCostsFromRevenuePY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFromRevenuePY02);
		tfOtherCostsFromRevenuePY02.setBounds(428, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenuePY02);
		
		tfOtherCostsFromRevenuePY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFromRevenuePY01);
		tfOtherCostsFromRevenuePY01.setBounds(564, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenuePY01);
		
		tfOtherCostsFromRevenueY00 = new JTextField("0,00");
		designNonEditableTextField(tfOtherCostsFromRevenueY00);
		tfOtherCostsFromRevenueY00.setBounds(698, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueY00);
		
		tfOtherCostsFromRevenueFY01 = new JTextField("0,00");
		designEditableTextField(tfOtherCostsFromRevenueFY01);
		tfOtherCostsFromRevenueFY01.setBounds(832, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueFY01);
		tfOtherCostsFromRevenueFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherCostsFromRevenueFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfOtherCostsFromRevenueFY02 = new JTextField("0,00");
		designEditableTextField(tfOtherCostsFromRevenueFY02);
		tfOtherCostsFromRevenueFY02.setBounds(968, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueFY02);
		tfOtherCostsFromRevenueFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherCostsFromRevenueFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherCostsFromRevenueFY03 = new JTextField("0,00");
		designEditableTextField(tfOtherCostsFromRevenueFY03);
		tfOtherCostsFromRevenueFY03.setBounds(1104, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueFY03);
		tfOtherCostsFromRevenueFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherCostsFromRevenueFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfOtherCostsFromRevenueFY04 = new JTextField("0,00");
		designEditableTextField(tfOtherCostsFromRevenueFY04);
		tfOtherCostsFromRevenueFY04.setBounds(1238, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueFY04);
		tfOtherCostsFromRevenueFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherCostsFromRevenueFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherCostsFromRevenueFY05 = new JTextField("0,00");
		tfOtherCostsFromRevenueFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherCostsFromRevenueFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfOtherCostsFromRevenueFY05);
		tfOtherCostsFromRevenueFY05.setBounds(1374, 208, 124, 20);
		backgroundProfitLoss.add(tfOtherCostsFromRevenueFY05);
		
		JLabel lblEbitda = new JLabel("Operating results (EBITDA):");
		designLabel(lblEbitda);
		lblEbitda.setBounds(10, 252, 208, 20);
		backgroundProfitLoss.add(lblEbitda);
		
		tfEbitdaPY03 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaPY03);
		tfEbitdaPY03.setBounds(292, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaPY03);
		
		tfEbitdaPY02 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaPY02);
		tfEbitdaPY02.setBounds(428, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaPY02);
		
		tfEbitdaPY01 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaPY01);
		tfEbitdaPY01.setBounds(564, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaPY01);
		
		tfEbitdaY00 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaY00);
		tfEbitdaY00.setBounds(698, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaY00);
		
		tfEbitdaFY01 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFY01);
		tfEbitdaFY01.setBounds(832, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFY01);
		
		tfEbitdaFY02 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFY02);
		tfEbitdaFY02.setBounds(968, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFY02);
		
		tfEbitdaFY03 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFY03);
		tfEbitdaFY03.setBounds(1104, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFY03);
		
		tfEbitdaFY04 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFY04);
		tfEbitdaFY04.setBounds(1238, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFY04);
		
		tfEbitdaFY05 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFY05);
		tfEbitdaFY05.setBounds(1374, 252, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFY05);
		
		JLabel lblEbitdaFromRevenue = new JLabel("In % of revenue:");
		designLabel(lblEbitdaFromRevenue);
		lblEbitdaFromRevenue.setBounds(51, 284, 191, 20);
		backgroundProfitLoss.add(lblEbitdaFromRevenue);
		
		tfEbitdaFromRevenuePY03 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenuePY03);
		tfEbitdaFromRevenuePY03.setBounds(292, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenuePY03);
		
		tfEbitdaFromRevenuePY02 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenuePY02);
		tfEbitdaFromRevenuePY02.setBounds(428, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenuePY02);
		
		tfEbitdaFromRevenuePY01 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenuePY01);
		tfEbitdaFromRevenuePY01.setBounds(564, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenuePY01);
		
		tfEbitdaFromRevenueY00 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueY00);
		tfEbitdaFromRevenueY00.setBounds(698, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueY00);
		
		tfEbitdaFromRevenueFY01 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueFY01);
		tfEbitdaFromRevenueFY01.setBounds(832, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueFY01);

		tfEbitdaFromRevenueFY02 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueFY02);
		tfEbitdaFromRevenueFY02.setBounds(968, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueFY02);

		tfEbitdaFromRevenueFY03 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueFY03);
		tfEbitdaFromRevenueFY03.setBounds(1104, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueFY03);

		tfEbitdaFromRevenueFY04 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueFY04);
		tfEbitdaFromRevenueFY04.setBounds(1238, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueFY04);

		tfEbitdaFromRevenueFY05 = new JTextField("0,00");
		designNonEditableTextField(tfEbitdaFromRevenueFY05);
		tfEbitdaFromRevenueFY05.setBounds(1374, 284, 124, 20);
		backgroundProfitLoss.add(tfEbitdaFromRevenueFY05);
		
		JLabel lblDepreciation = new JLabel("- Depreciation:");
		designLabel(lblDepreciation);
		lblDepreciation.setToolTipText("");
		lblDepreciation.setBounds(10, 328, 208, 20);
		backgroundProfitLoss.add(lblDepreciation);
		
		tfDepreciationPY03 = new JTextField("0,00");
		designEditableTextField(tfDepreciationPY03);
		tfDepreciationPY03.setBounds(292, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationPY03);
		tfDepreciationPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		
		tfDepreciationPY02 = new JTextField("0,00");
		designEditableTextField(tfDepreciationPY02);
		tfDepreciationPY02.setBounds(428, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationPY02);
		tfDepreciationPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfDepreciationPY01 = new JTextField("0,00");
		designEditableTextField(tfDepreciationPY01);
		tfDepreciationPY01.setBounds(564, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationPY01);
		tfDepreciationPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDepreciationY00 = new JTextField("0,00");
		designEditableTextField(tfDepreciationY00);
		tfDepreciationY00.setBounds(698, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationY00);
		tfDepreciationY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfDepreciationFY01 = new JTextField("0,00");
		tfDepreciationFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationFY01);
		tfDepreciationFY01.setBounds(832, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFY01);
		
		tfDepreciationFY02 = new JTextField("0,00");
		tfDepreciationFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationFY02);
		tfDepreciationFY02.setBounds(968, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFY02);
		
		tfDepreciationFY03 = new JTextField("0,00");
		tfDepreciationFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationFY03);
		tfDepreciationFY03.setBounds(1104, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFY03);
		
		tfDepreciationFY04 = new JTextField("0,00");
		tfDepreciationFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationFY04);
		tfDepreciationFY04.setBounds(1238, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFY04);
		
		tfDepreciationFY05 = new JTextField("0,00");
		tfDepreciationFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationFY05);
		tfDepreciationFY05.setBounds(1374, 328, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFY05);
		
		JLabel lblDepreciationFromPropertyAssets = new JLabel("Deprec. in % of assets:");
		lblDepreciationFromPropertyAssets.setBounds(51, 359, 231, 20);
		backgroundProfitLoss.add(lblDepreciationFromPropertyAssets);
		designLabel(lblDepreciationFromPropertyAssets);
		
		tfDepreciationFromPropertyAssetsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsPY03);
		tfDepreciationFromPropertyAssetsPY03.setBounds(292, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsPY03);
		
		tfDepreciationFromPropertyAssetsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsPY02);
		tfDepreciationFromPropertyAssetsPY02.setBounds(428, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsPY02);
		
		tfDepreciationFromPropertyAssetsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsPY01);
		tfDepreciationFromPropertyAssetsPY01.setBounds(564, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsPY01);
		
		tfDepreciationFromPropertyAssetsY00 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsY00);
		tfDepreciationFromPropertyAssetsY00.setBounds(698, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsY00);
		
		tfDepreciationFromPropertyAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsFY01);
		tfDepreciationFromPropertyAssetsFY01.setBounds(832, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsFY01);

		tfDepreciationFromPropertyAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsFY02);
		tfDepreciationFromPropertyAssetsFY02.setBounds(968, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsFY02);
		
		tfDepreciationFromPropertyAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsFY03);
		tfDepreciationFromPropertyAssetsFY03.setBounds(1104, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsFY03);
		
		tfDepreciationFromPropertyAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsFY04);
		tfDepreciationFromPropertyAssetsFY04.setBounds(1238, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsFY04);

		tfDepreciationFromPropertyAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromPropertyAssetsFY05);
		tfDepreciationFromPropertyAssetsFY05.setBounds(1374, 359, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromPropertyAssetsFY05);
		
		lblDepreciationIntangible = new JLabel("- Depreciation intangible assets:");
		designLabel(lblDepreciationIntangible);
		lblDepreciationIntangible.setToolTipText("");
		lblDepreciationIntangible.setBounds(10, 391, 232, 20);
		backgroundProfitLoss.add(lblDepreciationIntangible);
		
		tfDepreciationIntangiblePY03 = new JTextField("0,00");
		designEditableTextField(tfDepreciationIntangiblePY03);
		tfDepreciationIntangiblePY03.setBounds(292, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangiblePY03);
		tfDepreciationIntangiblePY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangiblePY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDepreciationIntangiblePY02 = new JTextField("0,00");
		designEditableTextField(tfDepreciationIntangiblePY02);
		tfDepreciationIntangiblePY02.setBounds(428, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangiblePY02);
		tfDepreciationIntangiblePY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangiblePY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfDepreciationIntangiblePY01 = new JTextField("0,00");
		designEditableTextField(tfDepreciationIntangiblePY01);
		tfDepreciationIntangiblePY01.setBounds(564, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangiblePY01);
		tfDepreciationIntangiblePY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangiblePY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfDepreciationIntangibleY00 = new JTextField("0,00");
		designEditableTextField(tfDepreciationIntangibleY00);
		tfDepreciationIntangibleY00.setBounds(698, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleY00);
		tfDepreciationIntangibleY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDepreciationIntangibleFY01 = new JTextField("0,00");
		tfDepreciationIntangibleFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationIntangibleFY01);
		tfDepreciationIntangibleFY01.setBounds(832, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleFY01);
		
		tfDepreciationIntangibleFY02 = new JTextField("0,00");
		tfDepreciationIntangibleFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationIntangibleFY02);
		tfDepreciationIntangibleFY02.setBounds(968, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleFY02);
		
		tfDepreciationIntangibleFY03 = new JTextField("0,00");
		tfDepreciationIntangibleFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationIntangibleFY03);
		tfDepreciationIntangibleFY03.setBounds(1104, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleFY03);
		
		tfDepreciationIntangibleFY04 = new JTextField("0,00");
		tfDepreciationIntangibleFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationIntangibleFY04);
		tfDepreciationIntangibleFY04.setBounds(1238, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleFY04);
		
		tfDepreciationIntangibleFY05 = new JTextField("0,00");
		tfDepreciationIntangibleFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDepreciationIntangibleFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDepreciationIntangibleFY05);
		tfDepreciationIntangibleFY05.setBounds(1374, 391, 124, 20);
		backgroundProfitLoss.add(tfDepreciationIntangibleFY05);
		
		lblDepreciationFromIntangibleAssets = new JLabel("Deprec. in % of intangible assets:");
		designLabel(lblDepreciationFromIntangibleAssets);
		lblDepreciationFromIntangibleAssets.setBounds(51, 422, 231, 20);
		backgroundProfitLoss.add(lblDepreciationFromIntangibleAssets);
		
		tfDepreciationFromIntangibleAssetsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsPY03);
		tfDepreciationFromIntangibleAssetsPY03.setBounds(292, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsPY03);
		
		tfDepreciationFromIntangibleAssetsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsPY02);
		tfDepreciationFromIntangibleAssetsPY02.setBounds(428, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsPY02);
		
		tfDepreciationFromIntangibleAssetsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsPY01);
		tfDepreciationFromIntangibleAssetsPY01.setBounds(564, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsPY01);
		
		tfDepreciationFromIntangibleAssetsY00 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsY00);
		tfDepreciationFromIntangibleAssetsY00.setBounds(698, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsY00);
		
		tfDepreciationFromIntangibleAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsFY01);
		tfDepreciationFromIntangibleAssetsFY01.setBounds(832, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsFY01);
		
		tfDepreciationFromIntangibleAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsFY02);
		tfDepreciationFromIntangibleAssetsFY02.setBounds(968, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsFY02);
		
		tfDepreciationFromIntangibleAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsFY03);
		tfDepreciationFromIntangibleAssetsFY03.setBounds(1104, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsFY03);
		
		tfDepreciationFromIntangibleAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsFY04);
		tfDepreciationFromIntangibleAssetsFY04.setBounds(1238, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsFY04);
		
		tfDepreciationFromIntangibleAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfDepreciationFromIntangibleAssetsFY05);
		tfDepreciationFromIntangibleAssetsFY05.setBounds(1374, 422, 124, 20);
		backgroundProfitLoss.add(tfDepreciationFromIntangibleAssetsFY05);
		
		JLabel lblInterestGains = new JLabel("+ Interest/financial income:");
		designLabel(lblInterestGains);
		lblInterestGains.setToolTipText("");
		lblInterestGains.setBounds(10, 453, 208, 20);
		backgroundProfitLoss.add(lblInterestGains);
		
		tfInterestGainsPY03 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsPY03);
		tfInterestGainsPY03.setBounds(292, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsPY03);
		tfInterestGainsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsPY02 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsPY02);
		tfInterestGainsPY02.setBounds(428, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsPY02);
		tfInterestGainsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsPY01 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsPY01);
		tfInterestGainsPY01.setBounds(564, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsPY01);
		tfInterestGainsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsY00 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsY00);
		tfInterestGainsY00.setBounds(698, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsY00);
		tfInterestGainsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFY01);
		tfInterestGainsFY01.setBounds(832, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFY01);
		
		tfInterestGainsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFY02);
		tfInterestGainsFY02.setBounds(968, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFY02);
		
		tfInterestGainsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFY03);
		tfInterestGainsFY03.setBounds(1104, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFY03);
		
		tfInterestGainsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFY04);
		tfInterestGainsFY04.setBounds(1238, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFY04);
		
		tfInterestGainsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFY05);
		tfInterestGainsFY05.setBounds(1374, 453, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFY05);
		
		JLabel lblInterestGainsFromFinancialAssets = new JLabel("Income in % of financial assets:");
		designLabel(lblInterestGainsFromFinancialAssets);
		lblInterestGainsFromFinancialAssets.setBounds(51, 484, 231, 20);
		backgroundProfitLoss.add(lblInterestGainsFromFinancialAssets);
		
		tfInterestGainsFromFinancialAssetsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFromFinancialAssetsPY03);
		tfInterestGainsFromFinancialAssetsPY03.setBounds(292, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsPY03);
		
		tfInterestGainsFromFinancialAssetsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFromFinancialAssetsPY02);
		tfInterestGainsFromFinancialAssetsPY02.setBounds(428, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsPY02);
		
		tfInterestGainsFromFinancialAssetsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFromFinancialAssetsPY01);
		tfInterestGainsFromFinancialAssetsPY01.setBounds(564, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsPY01);
		
		tfInterestGainsFromFinancialAssetsY00 = new JTextField("0,00");
		designNonEditableTextField(tfInterestGainsFromFinancialAssetsY00);
		tfInterestGainsFromFinancialAssetsY00.setBounds(698, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsY00);
		
		tfInterestGainsFromFinancialAssetsFY01 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsFromFinancialAssetsFY01);
		tfInterestGainsFromFinancialAssetsFY01.setBounds(832, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsFY01);
		tfInterestGainsFromFinancialAssetsFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsFromFinancialAssetsFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsFromFinancialAssetsFY02 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsFromFinancialAssetsFY02);
		tfInterestGainsFromFinancialAssetsFY02.setBounds(968, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsFY02);
		tfInterestGainsFromFinancialAssetsFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsFromFinancialAssetsFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsFromFinancialAssetsFY03 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsFromFinancialAssetsFY03);
		tfInterestGainsFromFinancialAssetsFY03.setBounds(1104, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsFY03);
		tfInterestGainsFromFinancialAssetsFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsFromFinancialAssetsFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestGainsFromFinancialAssetsFY04 = new JTextField("0,00");
		designEditableTextField(tfInterestGainsFromFinancialAssetsFY04);
		tfInterestGainsFromFinancialAssetsFY04.setBounds(1238, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsFY04);
		tfInterestGainsFromFinancialAssetsFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsFromFinancialAssetsFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
			
		tfInterestGainsFromFinancialAssetsFY05 = new JTextField("0,00");
		tfInterestGainsFromFinancialAssetsFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestGainsFromFinancialAssetsFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInterestGainsFromFinancialAssetsFY05);
		tfInterestGainsFromFinancialAssetsFY05.setBounds(1374, 484, 124, 20);
		backgroundProfitLoss.add(tfInterestGainsFromFinancialAssetsFY05);
		
		JLabel lblInterestLoss = new JLabel("- Interest/Finance expenses:");
		designLabel(lblInterestLoss);
		lblInterestLoss.setToolTipText("");
		lblInterestLoss.setBounds(10, 515, 208, 20);
		backgroundProfitLoss.add(lblInterestLoss);
		
		tfInterestLossPY03 = new JTextField("0,00");
		designEditableTextField(tfInterestLossPY03);
		tfInterestLossPY03.setBounds(292, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossPY03);
		tfInterestLossPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossPY02 = new JTextField("0,00");
		designEditableTextField(tfInterestLossPY02);
		tfInterestLossPY02.setBounds(428, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossPY02);
		tfInterestLossPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossPY01 = new JTextField("0,00");
		designEditableTextField(tfInterestLossPY01);
		tfInterestLossPY01.setBounds(564, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossPY01);
		tfInterestLossPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossY00 = new JTextField("0,00");
		designEditableTextField(tfInterestLossY00);
		tfInterestLossY00.setBounds(698, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossY00);
		tfInterestLossY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossFY01 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFY01);
		tfInterestLossFY01.setBounds(832, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFY01);
		
		tfInterestLossFY02 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFY02);
		tfInterestLossFY02.setBounds(968, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFY02);
		
		tfInterestLossFY03 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFY03);
		tfInterestLossFY03.setBounds(1104, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFY03);
		
		tfInterestLossFY04 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFY04);
		tfInterestLossFY04.setBounds(1238, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFY04);
		
		tfInterestLossFY05 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFY05);
		tfInterestLossFY05.setBounds(1374, 515, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFY05);
		
		JLabel lblInterestLossFromBankDebt = new JLabel("Expenses in % of liabilities:");
		designLabel(lblInterestLossFromBankDebt);
		lblInterestLossFromBankDebt.setBounds(51, 546, 231, 20);
		backgroundProfitLoss.add(lblInterestLossFromBankDebt);
		lblInterestLossFromBankDebt.setToolTipText("");
		
		tfInterestLossFromBankDebtPY03 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFromBankDebtPY03);
		tfInterestLossFromBankDebtPY03.setBounds(292, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtPY03);
		
		tfInterestLossFromBankDebtPY02 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFromBankDebtPY02);
		tfInterestLossFromBankDebtPY02.setBounds(428, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtPY02);
		
		tfInterestLossFromBankDebtPY01 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFromBankDebtPY01);
		tfInterestLossFromBankDebtPY01.setBounds(564, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtPY01);
		
		tfInterestLossFromBankDebtY00 = new JTextField("0,00");
		designNonEditableTextField(tfInterestLossFromBankDebtY00);
		tfInterestLossFromBankDebtY00.setBounds(698, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtY00);
		
		tfInterestLossFromBankDebtFY01 = new JTextField("0,00");
		designEditableTextField(tfInterestLossFromBankDebtFY01);
		tfInterestLossFromBankDebtFY01.setBounds(832, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtFY01);
		tfInterestLossFromBankDebtFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossFromBankDebtFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossFromBankDebtFY02 = new JTextField("0,00");
		designEditableTextField(tfInterestLossFromBankDebtFY02);
		tfInterestLossFromBankDebtFY02.setBounds(968, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtFY02);
		tfInterestLossFromBankDebtFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossFromBankDebtFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossFromBankDebtFY03 = new JTextField("0,00");
		designEditableTextField(tfInterestLossFromBankDebtFY03);
		tfInterestLossFromBankDebtFY03.setBounds(1104, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtFY03);
		tfInterestLossFromBankDebtFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossFromBankDebtFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfInterestLossFromBankDebtFY04 = new JTextField("0,00");
		designEditableTextField(tfInterestLossFromBankDebtFY04);
		tfInterestLossFromBankDebtFY04.setBounds(1238, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtFY04);
		tfInterestLossFromBankDebtFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossFromBankDebtFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInterestLossFromBankDebtFY05 = new JTextField("0,00");
		tfInterestLossFromBankDebtFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInterestLossFromBankDebtFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInterestLossFromBankDebtFY05);
		tfInterestLossFromBankDebtFY05.setBounds(1374, 546, 124, 20);
		backgroundProfitLoss.add(tfInterestLossFromBankDebtFY05);
		
		JLabel lblEbt = new JLabel("Earnings before taxes (EBT):");
		designLabel(lblEbt);
		lblEbt.setBounds(10, 590, 208, 20);
		backgroundProfitLoss.add(lblEbt);
		
		tfEbtPY03 = new JTextField("0,00");
		designEditableTextField(tfEbtPY03);
		tfEbtPY03.setBounds(292, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtPY03);
		tfEbtPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEbtPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfEbtPY02 = new JTextField("0,00");
		designEditableTextField(tfEbtPY02);
		tfEbtPY02.setBounds(428, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtPY02);
		tfEbtPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEbtPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfEbtPY01 = new JTextField("0,00");
		designEditableTextField(tfEbtPY01);
		tfEbtPY01.setBounds(564, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtPY01);
		tfEbtPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEbtPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfEbtY00 = new JTextField("0,00");
		designEditableTextField(tfEbtY00);
		tfEbtY00.setBounds(698, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtY00);
		tfEbtY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEbtY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfEbtFY01 = new JTextField("0,00");
		designNonEditableTextField(tfEbtFY01);
		tfEbtFY01.setBounds(832, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtFY01);
		
		tfEbtFY02 = new JTextField("0,00");
		designNonEditableTextField(tfEbtFY02);
		tfEbtFY02.setBounds(968, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtFY02);
		
		tfEbtFY03 = new JTextField("0,00");
		designNonEditableTextField(tfEbtFY03);
		tfEbtFY03.setBounds(1104, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtFY03);
		
		tfEbtFY04 = new JTextField("0,00");
		designNonEditableTextField(tfEbtFY04);
		tfEbtFY04.setBounds(1238, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtFY04);
		
		tfEbtFY05 = new JTextField("0,00");
		designNonEditableTextField(tfEbtFY05);
		tfEbtFY05.setBounds(1374, 590, 124, 20);
		backgroundProfitLoss.add(tfEbtFY05);
		
		JLabel lblIncomeTax = new JLabel("- Taxes on income and earnings:");
		designLabel(lblIncomeTax);
		lblIncomeTax.setBounds(10, 622, 255, 20);
		backgroundProfitLoss.add(lblIncomeTax);
		
		tfIncomeTaxPY03 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxPY03);
		tfIncomeTaxPY03.setBounds(292, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxPY03);
		tfIncomeTaxPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxPY02 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxPY02);
		tfIncomeTaxPY02.setBounds(428, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxPY02);
		tfIncomeTaxPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfIncomeTaxPY01 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxPY01);
		tfIncomeTaxPY01.setBounds(564, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxPY01);
		tfIncomeTaxPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxY00 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxY00);
		tfIncomeTaxY00.setBounds(698, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxY00);
		tfIncomeTaxY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfIncomeTaxFY01 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFY01);
		tfIncomeTaxFY01.setBounds(832, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFY01);
		
		tfIncomeTaxFY02 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFY02);
		tfIncomeTaxFY02.setBounds(968, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFY02);
		
		tfIncomeTaxFY03 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFY03);
		tfIncomeTaxFY03.setBounds(1104, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFY03);
		
		tfIncomeTaxFY04 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFY04);
		tfIncomeTaxFY04.setBounds(1238, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFY04);
		
		tfIncomeTaxFY05 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFY05);
		tfIncomeTaxFY05.setBounds(1374, 622, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFY05);
		
		JLabel lblIncomeTaxFromEbt = new JLabel("In % of earnings (EBT):");
		designLabel(lblIncomeTaxFromEbt);
		lblIncomeTaxFromEbt.setBounds(51, 654, 191, 20);
		backgroundProfitLoss.add(lblIncomeTaxFromEbt);
		
		tfIncomeTaxFromEbtPY03 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFromEbtPY03);
		tfIncomeTaxFromEbtPY03.setBounds(292, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtPY03);
		
		tfIncomeTaxFromEbtPY02 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFromEbtPY02);
		tfIncomeTaxFromEbtPY02.setBounds(428, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtPY02);
		
		tfIncomeTaxFromEbtPY01 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFromEbtPY01);
		tfIncomeTaxFromEbtPY01.setBounds(564, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtPY01);
		
		tfIncomeTaxFromEbtY00 = new JTextField("0,00");
		designNonEditableTextField(tfIncomeTaxFromEbtY00);
		tfIncomeTaxFromEbtY00.setBounds(698, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtY00);

		tfIncomeTaxFromEbtFY01 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxFromEbtFY01);
		tfIncomeTaxFromEbtFY01.setBounds(832, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtFY01);
		tfIncomeTaxFromEbtFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxFromEbtFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxFromEbtFY02 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxFromEbtFY02);
		tfIncomeTaxFromEbtFY02.setBounds(968, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtFY02);
		tfIncomeTaxFromEbtFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxFromEbtFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxFromEbtFY03 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxFromEbtFY03);
		tfIncomeTaxFromEbtFY03.setBounds(1104, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtFY03);
		tfIncomeTaxFromEbtFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxFromEbtFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxFromEbtFY04 = new JTextField("0,00");
		designEditableTextField(tfIncomeTaxFromEbtFY04);
		tfIncomeTaxFromEbtFY04.setBounds(1238, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtFY04);
		tfIncomeTaxFromEbtFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxFromEbtFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIncomeTaxFromEbtFY05 = new JTextField("0,00");
		tfIncomeTaxFromEbtFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIncomeTaxFromEbtFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfIncomeTaxFromEbtFY05);
		tfIncomeTaxFromEbtFY05.setBounds(1374, 654, 124, 20);
		backgroundProfitLoss.add(tfIncomeTaxFromEbtFY05);
		
		JLabel lblTotalIncome = new JLabel("Profit/Loss:");
		designLabel(lblTotalIncome);
		lblTotalIncome.setToolTipText("");
		lblTotalIncome.setBounds(10, 698, 208, 20);
		backgroundProfitLoss.add(lblTotalIncome);
		
		tfTotalIncomePY03 = new JTextField("0,00");
		designEditableTextField(tfTotalIncomePY03);
		tfTotalIncomePY03.setBounds(292, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomePY03);
		tfTotalIncomePY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTotalIncomePY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTotalIncomePY02 = new JTextField("0,00");
		designEditableTextField(tfTotalIncomePY02);
		tfTotalIncomePY02.setBounds(428, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomePY02);
		tfTotalIncomePY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTotalIncomePY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfTotalIncomePY01 = new JTextField("0,00");
		designEditableTextField(tfTotalIncomePY01);
		tfTotalIncomePY01.setBounds(564, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomePY01);
		tfTotalIncomePY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTotalIncomePY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTotalIncomeY00 = new JTextField("0,00");
		designEditableTextField(tfTotalIncomeY00);
		tfTotalIncomeY00.setBounds(698, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeY00);
		tfTotalIncomeY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTotalIncomeY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTotalIncomeFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalIncomeFY01);
		tfTotalIncomeFY01.setBounds(832, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeFY01);
		
		tfTotalIncomeFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalIncomeFY02);
		tfTotalIncomeFY02.setBounds(968, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeFY02);
		
		tfTotalIncomeFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalIncomeFY03);
		tfTotalIncomeFY03.setBounds(1104, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeFY03);
		
		tfTotalIncomeFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalIncomeFY04);
		tfTotalIncomeFY04.setBounds(1238, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeFY04);
		
		tfTotalIncomeFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalIncomeFY05);
		tfTotalIncomeFY05.setBounds(1374, 698, 124, 20);
		backgroundProfitLoss.add(tfTotalIncomeFY05);
		
		lblDividendsPaidRate = new JLabel("Payout ratio in %:");
		designLabel(lblDividendsPaidRate);
		lblDividendsPaidRate.setBounds(51, 729, 231, 20);
		backgroundProfitLoss.add(lblDividendsPaidRate);
		lblDividendsPaidRate.setToolTipText("");
		
		tfDividendsPaidRatePY03 = new JTextField("0,00");
		designNonEditableTextField(tfDividendsPaidRatePY03);
		tfDividendsPaidRatePY03.setBounds(292, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRatePY03);
		
		tfDividendsPaidRatePY02 = new JTextField("0,00");
		designNonEditableTextField(tfDividendsPaidRatePY02);
		tfDividendsPaidRatePY02.setBounds(428, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRatePY02);
		
		tfDividendsPaidRatePY01 = new JTextField("0,00");
		designNonEditableTextField(tfDividendsPaidRatePY01);
		tfDividendsPaidRatePY01.setBounds(564, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRatePY01);
		
		tfDividendsPaidRateY00 = new JTextField("0,00");
		designNonEditableTextField(tfDividendsPaidRateY00);
		tfDividendsPaidRateY00.setBounds(698, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateY00);
		
		tfDividendsPaidRateFY01 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidRateFY01);
		tfDividendsPaidRateFY01.setBounds(832, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateFY01);
		tfDividendsPaidRateFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidRateFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDividendsPaidRateFY02 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidRateFY02);
		tfDividendsPaidRateFY02.setBounds(968, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateFY02);
		tfDividendsPaidRateFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidRateFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDividendsPaidRateFY03 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidRateFY03);
		tfDividendsPaidRateFY03.setBounds(1104, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateFY03);
		tfDividendsPaidRateFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidRateFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDividendsPaidRateFY04 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidRateFY04);
		tfDividendsPaidRateFY04.setBounds(1238, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateFY04);
		tfDividendsPaidRateFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidRateFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfDividendsPaidRateFY05 = new JTextField("0,00");
		designEditableTextField(tfDividendsPaidRateFY05);
		tfDividendsPaidRateFY05.setBounds(1374, 729, 124, 20);
		backgroundProfitLoss.add(tfDividendsPaidRateFY05);
		tfDividendsPaidRateFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDividendsPaidRateFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		JSeparator separator_3_13_1 = new JSeparator();
		separator_3_13_1.setBounds(10, 239, 1496, 2);
		backgroundProfitLoss.add(separator_3_13_1);
		
		JSeparator separator_3_13_1_1 = new JSeparator();
		separator_3_13_1_1.setBounds(10, 577, 1496, 2);
		backgroundProfitLoss.add(separator_3_13_1_1);
		
		JSeparator separator_3_13_1_2 = new JSeparator();
		separator_3_13_1_2.setBounds(10, 685, 1496, 2);
		backgroundProfitLoss.add(separator_3_13_1_2);
		
		separator_3_13_2 = new JSeparator();
		separator_3_13_2.setBounds(10, 315, 1496, 2);
		backgroundProfitLoss.add(separator_3_13_2);
		
		backgroundPnLPlanning = new JPanel();
		backgroundPnLPlanning.setBackground(new Color(244, 255, 235));
		backgroundPnLPlanning.setBounds(826, 0, 709, 803);
		backgroundProfitLoss.add(backgroundPnLPlanning);
		
		scrollPaneAssets = new JScrollPane();
		scrollPaneAssets.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneAssets.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneAssets, "Assets");
		
		pnlAssets = new JPanel();
		scrollPaneAssets.setViewportView(pnlAssets);
		pnlAssets.setBackground(UIManager.getColor("Button.background"));
		pnlAssets.setPreferredSize(new Dimension(1920,900));
		pnlAssets.setLayout(null);
		pnlAssets.setBounds(10,6,1920,900);
		
		backgroundAssets = new JPanel();
		backgroundAssets.setBackground(Color.WHITE);
		backgroundAssets.setBounds(10, 11, 1535, 803);
		pnlAssets.add(backgroundAssets);
		backgroundAssets.setLayout(null);
		
		lblAssetsPY03 = new JLabel("Year -3");
		designLabelR(lblAssetsPY03);
		lblAssetsPY03.setBounds(292, 24, 124, 16);
		backgroundAssets.add(lblAssetsPY03);
		
		lblAssetsPY02 = new JLabel("Year -2 ");
		designLabelR(lblAssetsPY02);
		lblAssetsPY02.setBounds(428, 24, 124, 16);
		backgroundAssets.add(lblAssetsPY02);
		
		lblAssetsPY01 = new JLabel("Year -1");
		designLabelR(lblAssetsPY01);
		lblAssetsPY01.setBounds(564, 24, 124, 16);
		backgroundAssets.add(lblAssetsPY01);
				
		lblAssetsY00 = new JLabel("Current year");
		designLabelR(lblAssetsY00);
		lblAssetsY00.setBounds(698, 24, 124, 16);
		backgroundAssets.add(lblAssetsY00);
				
		JLabel lblAssetsFY01 = new JLabel("Year +1");
		designLabelR(lblAssetsFY01);
		lblAssetsFY01.setBounds(832, 24, 124, 16);
		backgroundAssets.add(lblAssetsFY01);
		
		JLabel lblAssetsFY02 = new JLabel("Year +2 ");
		designLabelR(lblAssetsFY02);
		lblAssetsFY02.setBounds(968, 24, 124, 16);
		backgroundAssets.add(lblAssetsFY02);
		
		JLabel lblAssetsFY03 = new JLabel("Year +3");
		designLabelR(lblAssetsFY03);
		lblAssetsFY03.setBounds(1104, 24, 124, 16);
		backgroundAssets.add(lblAssetsFY03);
		
		JLabel lblAssetsFY04 = new JLabel("Year +4 ");
		designLabelR(lblAssetsFY04);
		lblAssetsFY04.setBounds(1238, 24, 124, 16);
		backgroundAssets.add(lblAssetsFY04);
		
		JLabel lblAssetsFY05 = new JLabel("Year +5");
		designLabelR(lblAssetsFY05);
		lblAssetsFY05.setBounds(1374, 24, 124, 16);
		backgroundAssets.add(lblAssetsFY05);
		
		lblFinancialAssets = new JLabel("Financial assets:");
		designLabel(lblFinancialAssets);
		lblFinancialAssets.setToolTipText("");
		lblFinancialAssets.setBounds(10, 52, 272, 20);
		backgroundAssets.add(lblFinancialAssets);
		
		tfFinancialAssetsPY03 = new JTextField("0,00");
		designEditableTextField(tfFinancialAssetsPY03);
		tfFinancialAssetsPY03.setBounds(292, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsPY03);
		tfFinancialAssetsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfFinancialAssetsPY02 = new JTextField("0,00");
		designEditableTextField(tfFinancialAssetsPY02);
		tfFinancialAssetsPY02.setBounds(428, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsPY02);
		tfFinancialAssetsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfFinancialAssetsPY01 = new JTextField("0,00");
		designEditableTextField(tfFinancialAssetsPY01);
		tfFinancialAssetsPY01.setBounds(564, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsPY01);
		tfFinancialAssetsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfFinancialAssetsY00 = new JTextField("0,00");
		designEditableTextField(tfFinancialAssetsY00);
		tfFinancialAssetsY00.setBounds(698, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsY00);
		tfFinancialAssetsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfFinancialAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfFinancialAssetsFY01);
		tfFinancialAssetsFY01.setBounds(832, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsFY01);
		
		tfFinancialAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfFinancialAssetsFY02);
		tfFinancialAssetsFY02.setBounds(968, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsFY02);
		
		tfFinancialAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfFinancialAssetsFY03);
		tfFinancialAssetsFY03.setBounds(1104, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsFY03);
		
		tfFinancialAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfFinancialAssetsFY04);
		tfFinancialAssetsFY04.setBounds(1238, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsFY04);
		
		tfFinancialAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfFinancialAssetsFY05);
		tfFinancialAssetsFY05.setBounds(1374, 52, 124, 20);
		backgroundAssets.add(tfFinancialAssetsFY05);
		
		lblFinancialAssetsChange = new JLabel("Investment in financial assets:");
		designLabel(lblFinancialAssetsChange);
		lblFinancialAssetsChange.setBounds(51, 83, 231, 20);
		backgroundAssets.add(lblFinancialAssetsChange);
		lblFinancialAssetsChange.setToolTipText("");
		
		tfFinancialAssetsChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfFinancialAssetsChangePY02);
		tfFinancialAssetsChangePY02.setBounds(362, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangePY02);
		
		tfFinancialAssetsChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfFinancialAssetsChangePY01);
		tfFinancialAssetsChangePY01.setBounds(496, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangePY01);
		
		tfFinancialAssetsChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfFinancialAssetsChangeY00);
		tfFinancialAssetsChangeY00.setBounds(630, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeY00);
		
		tfFinancialAssetsChangeFY01 = new JTextField("0,00");
		tfFinancialAssetsChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfFinancialAssetsChangeFY01);
		tfFinancialAssetsChangeFY01.setBounds(768, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeFY01);

		
		tfFinancialAssetsChangeFY02 = new JTextField("0,00");
		tfFinancialAssetsChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfFinancialAssetsChangeFY02);
		tfFinancialAssetsChangeFY02.setBounds(902, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeFY02);
		
		tfFinancialAssetsChangeFY03 = new JTextField("0,00");
		tfFinancialAssetsChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfFinancialAssetsChangeFY03);
		tfFinancialAssetsChangeFY03.setBounds(1036, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeFY03);
		
		tfFinancialAssetsChangeFY04 = new JTextField("0,00");
		tfFinancialAssetsChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfFinancialAssetsChangeFY04);
		tfFinancialAssetsChangeFY04.setBounds(1170, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeFY04);
		
		tfFinancialAssetsChangeFY05 = new JTextField("0,00");
		tfFinancialAssetsChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFinancialAssetsChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfFinancialAssetsChangeFY05);
		tfFinancialAssetsChangeFY05.setBounds(1304, 83, 124, 20);
		backgroundAssets.add(tfFinancialAssetsChangeFY05);
		
		lblPropertyAssets = new JLabel("Property, plant and equipment:");
		designLabel(lblPropertyAssets);
		lblPropertyAssets.setToolTipText("");
		lblPropertyAssets.setBounds(10, 115, 272, 20);
		backgroundAssets.add(lblPropertyAssets);
		
		tfPropertyAssetsPY03 = new JTextField("0,00");
		designEditableTextField(tfPropertyAssetsPY03);
		tfPropertyAssetsPY03.setBounds(292, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsPY03);
		tfPropertyAssetsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfPropertyAssetsPY02 = new JTextField("0,00");
		designEditableTextField(tfPropertyAssetsPY02);
		tfPropertyAssetsPY02.setBounds(428, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsPY02);
		tfPropertyAssetsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfPropertyAssetsPY01 = new JTextField("0,00");
		designEditableTextField(tfPropertyAssetsPY01);
		tfPropertyAssetsPY01.setBounds(564, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsPY01);
		tfPropertyAssetsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfPropertyAssetsY00 = new JTextField("0,00");
		designEditableTextField(tfPropertyAssetsY00);
		tfPropertyAssetsY00.setBounds(698, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsY00);
		tfPropertyAssetsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfPropertyAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfPropertyAssetsFY01);
		tfPropertyAssetsFY01.setBounds(832, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsFY01);
		
		tfPropertyAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfPropertyAssetsFY02);
		tfPropertyAssetsFY02.setBounds(968, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsFY02);
		
		tfPropertyAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfPropertyAssetsFY03);
		tfPropertyAssetsFY03.setBounds(1104, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsFY03);
		
		tfPropertyAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfPropertyAssetsFY04);
		tfPropertyAssetsFY04.setBounds(1238, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsFY04);
		
		tfPropertyAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfPropertyAssetsFY05);
		tfPropertyAssetsFY05.setBounds(1374, 115, 124, 20);
		backgroundAssets.add(tfPropertyAssetsFY05);
		
		lblPropertyAssetsChange = new JLabel("Investment in property, plant and equipment:");
		designLabel(lblPropertyAssetsChange);
		lblPropertyAssetsChange.setBounds(51, 147, 231, 20);
		backgroundAssets.add(lblPropertyAssetsChange);
		lblPropertyAssetsChange.setToolTipText("");
		
		tfPropertyAssetsChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfPropertyAssetsChangePY02);
		tfPropertyAssetsChangePY02.setBounds(362, 147, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangePY02);
		
		tfPropertyAssetsChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfPropertyAssetsChangePY01);
		tfPropertyAssetsChangePY01.setBounds(496, 147, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangePY01);
		
		tfPropertyAssetsChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfPropertyAssetsChangeY00);
		tfPropertyAssetsChangeY00.setBounds(630, 147, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangeY00);
		
		tfPropertyAssetsChangeFY01 = new JTextField("0,00");
		tfPropertyAssetsChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfPropertyAssetsChangeFY01);
		tfPropertyAssetsChangeFY01.setBounds(768, 146, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangeFY01);

		tfPropertyAssetsChangeFY02 = new JTextField("0,00");
		tfPropertyAssetsChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfPropertyAssetsChangeFY02);
		tfPropertyAssetsChangeFY02.setBounds(902, 146, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangeFY02);
		
		tfPropertyAssetsChangeFY03 = new JTextField("0,00");
		tfPropertyAssetsChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfPropertyAssetsChangeFY03);
		tfPropertyAssetsChangeFY03.setBounds(1036, 146, 122, 20);
		backgroundAssets.add(tfPropertyAssetsChangeFY03);
		
		tfPropertyAssetsChangeFY04 = new JTextField("0,00");
		tfPropertyAssetsChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfPropertyAssetsChangeFY04);
		tfPropertyAssetsChangeFY04.setBounds(1170, 146, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangeFY04);
		
		tfPropertyAssetsChangeFY05 = new JTextField("0,00");
		tfPropertyAssetsChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfPropertyAssetsChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfPropertyAssetsChangeFY05);
		tfPropertyAssetsChangeFY05.setBounds(1304, 146, 124, 20);
		backgroundAssets.add(tfPropertyAssetsChangeFY05);
		
		lblIntangibleAssets = new JLabel("Intangible assets and goodwill:");
		designLabel(lblIntangibleAssets);
		lblIntangibleAssets.setToolTipText("");
		lblIntangibleAssets.setBounds(10, 178, 272, 20);
		backgroundAssets.add(lblIntangibleAssets);
		
		tfIntangibleAssetsPY03 = new JTextField("0,00");
		designEditableTextField(tfIntangibleAssetsPY03);
		tfIntangibleAssetsPY03.setBounds(292, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsPY03);
		tfIntangibleAssetsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIntangibleAssetsPY02 = new JTextField("0,00");
		designEditableTextField(tfIntangibleAssetsPY02);
		tfIntangibleAssetsPY02.setBounds(428, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsPY02);
		tfIntangibleAssetsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIntangibleAssetsPY01 = new JTextField("0,00");
		designEditableTextField(tfIntangibleAssetsPY01);
		tfIntangibleAssetsPY01.setBounds(564, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsPY01);
		tfIntangibleAssetsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIntangibleAssetsY00 = new JTextField("0,00");
		designEditableTextField(tfIntangibleAssetsY00);
		tfIntangibleAssetsY00.setBounds(698, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsY00);
		tfIntangibleAssetsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfIntangibleAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfIntangibleAssetsFY01);
		tfIntangibleAssetsFY01.setBounds(832, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsFY01);
		
		tfIntangibleAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfIntangibleAssetsFY02);
		tfIntangibleAssetsFY02.setBounds(968, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsFY02);
		
		tfIntangibleAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfIntangibleAssetsFY03);
		tfIntangibleAssetsFY03.setBounds(1104, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsFY03);
		
		tfIntangibleAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfIntangibleAssetsFY04);
		tfIntangibleAssetsFY04.setBounds(1238, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsFY04);
		
		tfIntangibleAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfIntangibleAssetsFY05);
		tfIntangibleAssetsFY05.setBounds(1374, 178, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsFY05);
		
		lblIntangibleAssetsChange = new JLabel("Investment in intangible assets:");
		designLabel(lblIntangibleAssetsChange);
		lblIntangibleAssetsChange.setBounds(51, 210, 231, 20);
		backgroundAssets.add(lblIntangibleAssetsChange);
		lblIntangibleAssetsChange.setToolTipText("");
		
		tfIntangibleAssetsChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfIntangibleAssetsChangePY02);
		tfIntangibleAssetsChangePY02.setBounds(362, 210, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangePY02);
		
		tfIntangibleAssetsChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfIntangibleAssetsChangePY01);
		tfIntangibleAssetsChangePY01.setBounds(496, 210, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangePY01);
		
		tfIntangibleAssetsChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfIntangibleAssetsChangeY00);
		tfIntangibleAssetsChangeY00.setBounds(630, 210, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeY00);
		
		tfIntangibleAssetsChangeFY01 = new JTextField("0,00");
		tfIntangibleAssetsChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfIntangibleAssetsChangeFY01);
		tfIntangibleAssetsChangeFY01.setBounds(768, 209, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeFY01);
		
		tfIntangibleAssetsChangeFY02 = new JTextField("0,00");
		tfIntangibleAssetsChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfIntangibleAssetsChangeFY02);
		tfIntangibleAssetsChangeFY02.setBounds(902, 209, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeFY02);
		
		tfIntangibleAssetsChangeFY03 = new JTextField("0,00");
		tfIntangibleAssetsChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfIntangibleAssetsChangeFY03);
		tfIntangibleAssetsChangeFY03.setBounds(1036, 209, 122, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeFY03);
		
		tfIntangibleAssetsChangeFY04 = new JTextField("0,00");
		tfIntangibleAssetsChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfIntangibleAssetsChangeFY04);
		tfIntangibleAssetsChangeFY04.setBounds(1170, 209, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeFY04);
		
		tfIntangibleAssetsChangeFY05 = new JTextField("0,00");
		tfIntangibleAssetsChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfIntangibleAssetsChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfIntangibleAssetsChangeFY05);
		tfIntangibleAssetsChangeFY05.setBounds(1304, 209, 124, 20);
		backgroundAssets.add(tfIntangibleAssetsChangeFY05);
		
		lblOtherAssets = new JLabel("Other assets:");
		designLabel(lblOtherAssets);
		lblOtherAssets.setToolTipText("");
		lblOtherAssets.setBounds(10, 241, 272, 20);
		backgroundAssets.add(lblOtherAssets);
		
		tfOtherAssetsPY03 = new JTextField("0,00");
		designEditableTextField(tfOtherAssetsPY03);
		tfOtherAssetsPY03.setBounds(292, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsPY03);
		tfOtherAssetsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherAssetsPY02 = new JTextField("0,00");
		designEditableTextField(tfOtherAssetsPY02);
		tfOtherAssetsPY02.setBounds(428, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsPY02);
		tfOtherAssetsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherAssetsPY01 = new JTextField("0,00");
		designEditableTextField(tfOtherAssetsPY01);
		tfOtherAssetsPY01.setBounds(564, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsPY01);
		tfOtherAssetsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherAssetsY00 = new JTextField("0,00");
		designEditableTextField(tfOtherAssetsY00);
		tfOtherAssetsY00.setBounds(698, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsY00);
		tfOtherAssetsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherAssetsFY01);
		tfOtherAssetsFY01.setBounds(832, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsFY01);
		
		tfOtherAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherAssetsFY02);
		tfOtherAssetsFY02.setBounds(968, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsFY02);
		
		tfOtherAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherAssetsFY03);
		tfOtherAssetsFY03.setBounds(1104, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsFY03);
		
		tfOtherAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfOtherAssetsFY04);
		tfOtherAssetsFY04.setBounds(1238, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsFY04);
		
		tfOtherAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfOtherAssetsFY05);
		tfOtherAssetsFY05.setBounds(1374, 241, 124, 20);
		backgroundAssets.add(tfOtherAssetsFY05);
		
		lblOtherAssetsChange = new JLabel("Changes in other assets:");
		designLabel(lblOtherAssetsChange);
		lblOtherAssetsChange.setBounds(51, 273, 231, 20);
		backgroundAssets.add(lblOtherAssetsChange);
		lblOtherAssetsChange.setToolTipText("");
		
		tfOtherAssetsChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherAssetsChangePY02);
		tfOtherAssetsChangePY02.setBounds(362, 273, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangePY02);
		
		tfOtherAssetsChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherAssetsChangePY01);
		tfOtherAssetsChangePY01.setBounds(496, 273, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangePY01);
		
		tfOtherAssetsChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherAssetsChangeY00);
		tfOtherAssetsChangeY00.setBounds(630, 273, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangeY00);
		
		tfOtherAssetsChangeFY01 = new JTextField("0,00");
		tfOtherAssetsChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherAssetsChangeFY01);
		tfOtherAssetsChangeFY01.setBounds(768, 272, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangeFY01);
		
		tfOtherAssetsChangeFY02 = new JTextField("0,00");
		tfOtherAssetsChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherAssetsChangeFY02);
		tfOtherAssetsChangeFY02.setBounds(902, 272, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangeFY02);
		
		tfOtherAssetsChangeFY03 = new JTextField("0,00");
		tfOtherAssetsChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherAssetsChangeFY03);
		tfOtherAssetsChangeFY03.setBounds(1036, 272, 122, 20);
		backgroundAssets.add(tfOtherAssetsChangeFY03);
		
		tfOtherAssetsChangeFY04 = new JTextField("0,00");
		tfOtherAssetsChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherAssetsChangeFY04);
		tfOtherAssetsChangeFY04.setBounds(1170, 272, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangeFY04);
		
		tfOtherAssetsChangeFY05 = new JTextField("0,00");
		tfOtherAssetsChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherAssetsChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherAssetsChangeFY05);
		tfOtherAssetsChangeFY05.setBounds(1304, 272, 124, 20);
		backgroundAssets.add(tfOtherAssetsChangeFY05);
		
		lblAssets = new JLabel("Total non-current assets:");
		designLabel(lblAssets);
		lblAssets.setBounds(10, 317, 272, 20);
		backgroundAssets.add(lblAssets);
				
		tfAssetsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsPY03);
		tfAssetsPY03.setBounds(292, 317, 124, 20);
		backgroundAssets.add(tfAssetsPY03);
		
		tfAssetsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsPY02);
		tfAssetsPY02.setBounds(428, 317, 124, 20);
		backgroundAssets.add(tfAssetsPY02);
		
		tfAssetsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsPY01);
		tfAssetsPY01.setBounds(564, 317, 124, 20);
		backgroundAssets.add(tfAssetsPY01);
		
		tfAssetsY00 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsY00);
		tfAssetsY00.setBounds(698, 317, 124, 20);
		backgroundAssets.add(tfAssetsY00);
		
		tfAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsFY01);
		tfAssetsFY01.setBounds(832, 317, 124, 20);
		backgroundAssets.add(tfAssetsFY01);
		
		tfAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsFY02);
		tfAssetsFY02.setBounds(968, 317, 124, 20);
		backgroundAssets.add(tfAssetsFY02);
		
		tfAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsFY03);
		tfAssetsFY03.setBounds(1104, 317, 124, 20);
		backgroundAssets.add(tfAssetsFY03);
		
		tfAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsFY04);
		tfAssetsFY04.setBounds(1238, 317, 124, 20);
		backgroundAssets.add(tfAssetsFY04);
		
		tfAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfAssetsFY05);
		tfAssetsFY05.setBounds(1374, 317, 124, 20);
		backgroundAssets.add(tfAssetsFY05);
		
		lblInventory = new JLabel("Inventories");
		designLabel(lblInventory);
		lblInventory.setBounds(10, 359, 272, 20);
		backgroundAssets.add(lblInventory);
		
		tfInventoryPY03 = new JTextField("0,00");
		designEditableTextField(tfInventoryPY03);
		tfInventoryPY03.setBounds(292, 359, 124, 20);
		backgroundAssets.add(tfInventoryPY03);
		tfInventoryPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInventoryPY02 = new JTextField("0,00");
		designEditableTextField(tfInventoryPY02);
		tfInventoryPY02.setBounds(428, 359, 124, 20);
		backgroundAssets.add(tfInventoryPY02);
		tfInventoryPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfInventoryPY01 = new JTextField("0,00");
		designEditableTextField(tfInventoryPY01);
		tfInventoryPY01.setBounds(564, 359, 124, 20);
		backgroundAssets.add(tfInventoryPY01);
		tfInventoryPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfInventoryY00 = new JTextField("0,00");
		designEditableTextField(tfInventoryY00);
		tfInventoryY00.setBounds(698, 359, 124, 20);
		backgroundAssets.add(tfInventoryY00);
		tfInventoryY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfInventoryFY01 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryFY01);
		tfInventoryFY01.setBounds(832, 359, 124, 20);
		backgroundAssets.add(tfInventoryFY01);
		
		tfInventoryFY02 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryFY02);
		tfInventoryFY02.setBounds(968, 359, 124, 20);
		backgroundAssets.add(tfInventoryFY02);
		
		tfInventoryFY03 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryFY03);
		tfInventoryFY03.setBounds(1104, 359, 124, 20);
		backgroundAssets.add(tfInventoryFY03);
		
		tfInventoryFY04 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryFY04);
		tfInventoryFY04.setBounds(1238, 359, 124, 20);
		backgroundAssets.add(tfInventoryFY04);
		
		tfInventoryFY05 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryFY05);
		tfInventoryFY05.setBounds(1374, 359, 124, 20);
		backgroundAssets.add(tfInventoryFY05);
		
		lblInventoryTurnover = new JLabel("Turnover rate:");
		designLabel(lblInventoryTurnover);
		lblInventoryTurnover.setBounds(51, 391, 231, 20);
		backgroundAssets.add(lblInventoryTurnover);
		lblInventoryTurnover.setToolTipText("");
		
		tfInventoryTurnoverPY03 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryTurnoverPY03);
		tfInventoryTurnoverPY03.setBounds(292, 391, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverPY03);
		
		tfInventoryTurnoverPY02 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryTurnoverPY02);
		tfInventoryTurnoverPY02.setBounds(428, 391, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverPY02);
		
		tfInventoryTurnoverPY01 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryTurnoverPY01);
		tfInventoryTurnoverPY01.setBounds(564, 391, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverPY01);
		
		tfInventoryTurnoverY00 = new JTextField("0,00");
		designNonEditableTextField(tfInventoryTurnoverY00);
		tfInventoryTurnoverY00.setBounds(698, 391, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverY00);
		
		tfInventoryTurnoverFY01 = new JTextField("0,00");
		tfInventoryTurnoverFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryTurnoverFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInventoryTurnoverFY01);
		tfInventoryTurnoverFY01.setBounds(832, 390, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverFY01);
		
		tfInventoryTurnoverFY02 = new JTextField("0,00");
		tfInventoryTurnoverFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryTurnoverFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInventoryTurnoverFY02);
		tfInventoryTurnoverFY02.setBounds(968, 390, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverFY02);
		
		tfInventoryTurnoverFY03 = new JTextField("0,00");
		tfInventoryTurnoverFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryTurnoverFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInventoryTurnoverFY03);
		tfInventoryTurnoverFY03.setBounds(1104, 390, 122, 20);
		backgroundAssets.add(tfInventoryTurnoverFY03);
		
		tfInventoryTurnoverFY04 = new JTextField("0,00");
		tfInventoryTurnoverFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryTurnoverFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInventoryTurnoverFY04);
		tfInventoryTurnoverFY04.setBounds(1238, 390, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverFY04);
		
		tfInventoryTurnoverFY05 = new JTextField("0,00");
		tfInventoryTurnoverFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInventoryTurnoverFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfInventoryTurnoverFY05);
		tfInventoryTurnoverFY05.setBounds(1374, 390, 124, 20);
		backgroundAssets.add(tfInventoryTurnoverFY05);
		
		lblReceivables = new JLabel("Receivables:");
		designLabel(lblReceivables);
		lblReceivables.setToolTipText("");
		lblReceivables.setBounds(10, 423, 272, 20);
		backgroundAssets.add(lblReceivables);
		
		tfReceivablesPY03 = new JTextField("0,00");
		designEditableTextField(tfReceivablesPY03);
		tfReceivablesPY03.setBounds(292, 423, 124, 20);
		backgroundAssets.add(tfReceivablesPY03);
		tfReceivablesPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReceivablesPY02 = new JTextField("0,00");
		designEditableTextField(tfReceivablesPY02);
		tfReceivablesPY02.setBounds(428, 423, 124, 20);
		backgroundAssets.add(tfReceivablesPY02);
		tfReceivablesPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReceivablesPY01 = new JTextField("0,00");
		designEditableTextField(tfReceivablesPY01);
		tfReceivablesPY01.setBounds(564, 423, 124, 20);
		backgroundAssets.add(tfReceivablesPY01);
		tfReceivablesPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfReceivablesY00 = new JTextField("0,00");
		designEditableTextField(tfReceivablesY00);
		tfReceivablesY00.setBounds(698, 423, 124, 20);
		backgroundAssets.add(tfReceivablesY00);
		tfReceivablesY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReceivablesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesFY01);
		tfReceivablesFY01.setBounds(832, 423, 124, 20);
		backgroundAssets.add(tfReceivablesFY01);
		
		tfReceivablesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesFY02);
		tfReceivablesFY02.setBounds(968, 423, 124, 20);
		backgroundAssets.add(tfReceivablesFY02);
		
		tfReceivablesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesFY03);
		tfReceivablesFY03.setBounds(1104, 423, 124, 20);
		backgroundAssets.add(tfReceivablesFY03);
		
		tfReceivablesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesFY04);
		tfReceivablesFY04.setBounds(1238, 423, 124, 20);
		backgroundAssets.add(tfReceivablesFY04);
		
		tfReceivablesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesFY05);
		tfReceivablesFY05.setBounds(1374, 423, 124, 20);
		backgroundAssets.add(tfReceivablesFY05);
		
		lblReceivablesTurnover = new JLabel("Turnover rate:");
		designLabel(lblReceivablesTurnover);
		lblReceivablesTurnover.setBounds(51, 455, 231, 20);
		backgroundAssets.add(lblReceivablesTurnover);
		lblReceivablesTurnover.setToolTipText("");
		
		tfReceivablesTurnoverPY03 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesTurnoverPY03);
		tfReceivablesTurnoverPY03.setBounds(292, 455, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverPY03);
		
		tfReceivablesTurnoverPY02 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesTurnoverPY02);
		tfReceivablesTurnoverPY02.setBounds(428, 455, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverPY02);
		
		tfReceivablesTurnoverPY01 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesTurnoverPY01);
		tfReceivablesTurnoverPY01.setBounds(564, 455, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverPY01);
		
		tfReceivablesTurnoverY00 = new JTextField("0,00");
		designNonEditableTextField(tfReceivablesTurnoverY00);
		tfReceivablesTurnoverY00.setBounds(698, 455, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverY00);
		
		tfReceivablesTurnoverFY01 = new JTextField("0,00");
		tfReceivablesTurnoverFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesTurnoverFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfReceivablesTurnoverFY01);
		tfReceivablesTurnoverFY01.setBounds(832, 454, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverFY01);
		
		tfReceivablesTurnoverFY02 = new JTextField("0,00");
		tfReceivablesTurnoverFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesTurnoverFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfReceivablesTurnoverFY02);
		tfReceivablesTurnoverFY02.setBounds(968, 454, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverFY02);
		
		tfReceivablesTurnoverFY03 = new JTextField("0,00");
		tfReceivablesTurnoverFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesTurnoverFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfReceivablesTurnoverFY03);
		tfReceivablesTurnoverFY03.setBounds(1104, 454, 122, 20);
		backgroundAssets.add(tfReceivablesTurnoverFY03);
		
		tfReceivablesTurnoverFY04 = new JTextField("0,00");
		tfReceivablesTurnoverFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesTurnoverFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfReceivablesTurnoverFY04);
		tfReceivablesTurnoverFY04.setBounds(1238, 454, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverFY04);
		
		tfReceivablesTurnoverFY05 = new JTextField("0,00");
		tfReceivablesTurnoverFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReceivablesTurnoverFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfReceivablesTurnoverFY05);
		tfReceivablesTurnoverFY05.setBounds(1374, 454, 124, 20);
		backgroundAssets.add(tfReceivablesTurnoverFY05);
		
		lblOtherNCA = new JLabel("Other current assets:");
		designLabel(lblOtherNCA);
		lblOtherNCA.setToolTipText("");
		lblOtherNCA.setBounds(10, 487, 272, 20);
		backgroundAssets.add(lblOtherNCA);
		
		tfOtherNCAPY03 = new JTextField("0,00");
		designEditableTextField(tfOtherNCAPY03);
		tfOtherNCAPY03.setBounds(292, 487, 124, 20);
		backgroundAssets.add(tfOtherNCAPY03);
		tfOtherNCAPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherNCAPY02 = new JTextField("0,00");
		designEditableTextField(tfOtherNCAPY02);
		tfOtherNCAPY02.setBounds(428, 487, 124, 20);
		backgroundAssets.add(tfOtherNCAPY02);
		tfOtherNCAPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherNCAPY01 = new JTextField("0,00");
		designEditableTextField(tfOtherNCAPY01);
		tfOtherNCAPY01.setBounds(564, 487, 124, 20);
		backgroundAssets.add(tfOtherNCAPY01);
		tfOtherNCAPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAPY01.selectAll();				
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherNCAY00 = new JTextField("0,00");
		designEditableTextField(tfOtherNCAY00);
		tfOtherNCAY00.setBounds(698, 487, 124, 20);
		backgroundAssets.add(tfOtherNCAY00);
		tfOtherNCAY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherNCAFY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherNCAFY01);
		tfOtherNCAFY01.setBounds(832, 488, 124, 20);
		backgroundAssets.add(tfOtherNCAFY01);
		
		tfOtherNCAFY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherNCAFY02);
		tfOtherNCAFY02.setBounds(968, 488, 124, 20);
		backgroundAssets.add(tfOtherNCAFY02);
		
		tfOtherNCAFY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherNCAFY03);
		tfOtherNCAFY03.setBounds(1104, 488, 124, 20);
		backgroundAssets.add(tfOtherNCAFY03);
		
		tfOtherNCAFY04 = new JTextField("0,00");
		designNonEditableTextField(tfOtherNCAFY04);
		tfOtherNCAFY04.setBounds(1238, 488, 124, 20);
		backgroundAssets.add(tfOtherNCAFY04);
		
		tfOtherNCAFY05 = new JTextField("0,00");
		designNonEditableTextField(tfOtherNCAFY05);
		tfOtherNCAFY05.setBounds(1374, 488, 124, 20);
		backgroundAssets.add(tfOtherNCAFY05);
		
		lblOtherNCAFromNCA = new JLabel("Changes in other current assets:");
		designLabel(lblOtherNCAFromNCA);
		lblOtherNCAFromNCA.setBounds(51, 519, 231, 20);
		backgroundAssets.add(lblOtherNCAFromNCA);
		lblOtherNCAFromNCA.setToolTipText("");
		
		tfOtherNCAFromNCAPY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherNCAFromNCAPY02);
		tfOtherNCAFromNCAPY02.setBounds(362, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAPY02);
		
		tfOtherNCAFromNCAPY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherNCAFromNCAPY01);
		tfOtherNCAFromNCAPY01.setBounds(496, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAPY01);
		
		tfOtherNCAFromNCAY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherNCAFromNCAY00);
		tfOtherNCAFromNCAY00.setBounds(630, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAY00);
		
		tfOtherNCAFromNCAFY01 = new JTextField("0,00");
		tfOtherNCAFromNCAFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAFromNCAFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherNCAFromNCAFY01);
		tfOtherNCAFromNCAFY01.setBounds(768, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAFY01);
		
		tfOtherNCAFromNCAFY02 = new JTextField("0,00");
		tfOtherNCAFromNCAFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAFromNCAFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherNCAFromNCAFY02);
		tfOtherNCAFromNCAFY02.setBounds(902, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAFY02);
		
		tfOtherNCAFromNCAFY03 = new JTextField("0,00");
		tfOtherNCAFromNCAFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAFromNCAFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherNCAFromNCAFY03);
		tfOtherNCAFromNCAFY03.setBounds(1036, 519, 122, 20);
		backgroundAssets.add(tfOtherNCAFromNCAFY03);
		
		tfOtherNCAFromNCAFY04 = new JTextField("0,00");
		tfOtherNCAFromNCAFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAFromNCAFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherNCAFromNCAFY04);
		tfOtherNCAFromNCAFY04.setBounds(1170, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAFY04);
		
		tfOtherNCAFromNCAFY05 = new JTextField("0,00");
		tfOtherNCAFromNCAFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherNCAFromNCAFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherNCAFromNCAFY05);
		tfOtherNCAFromNCAFY05.setBounds(1304, 519, 124, 20);
		backgroundAssets.add(tfOtherNCAFromNCAFY05);
		
		lblNCA = new JLabel("Total current assets:");
		designLabel(lblNCA);
		lblNCA.setBounds(10, 565, 272, 20);
		backgroundAssets.add(lblNCA);
		
		tfNCAPY03 = new JTextField("0,00");
		designNonEditableTextField(tfNCAPY03);
		tfNCAPY03.setBounds(292, 565, 124, 20);
		backgroundAssets.add(tfNCAPY03);
		
		tfNCAPY02 = new JTextField("0,00");
		designNonEditableTextField(tfNCAPY02);
		tfNCAPY02.setBounds(428, 565, 124, 20);
		backgroundAssets.add(tfNCAPY02);
		
		tfNCAPY01 = new JTextField("0,00");
		designNonEditableTextField(tfNCAPY01);
		tfNCAPY01.setBounds(564, 565, 124, 20);
		backgroundAssets.add(tfNCAPY01);
		
		tfNCAY00 = new JTextField("0,00");
		designNonEditableTextField(tfNCAY00);
		tfNCAY00.setBounds(698, 565, 124, 20);
		backgroundAssets.add(tfNCAY00);
		
		tfNCAFY01 = new JTextField("0,00");
		designNonEditableTextField(tfNCAFY01);
		tfNCAFY01.setBounds(832, 565, 124, 20);
		backgroundAssets.add(tfNCAFY01);
		
		tfNCAFY02 = new JTextField("0,00");
		designNonEditableTextField(tfNCAFY02);
		tfNCAFY02.setBounds(968, 565, 124, 20);
		backgroundAssets.add(tfNCAFY02);
		
		tfNCAFY03 = new JTextField("0,00");
		designNonEditableTextField(tfNCAFY03);
		tfNCAFY03.setBounds(1104, 565, 124, 20);
		backgroundAssets.add(tfNCAFY03);
		
		tfNCAFY04 = new JTextField("0,00");
		designNonEditableTextField(tfNCAFY04);
		tfNCAFY04.setBounds(1238, 565, 124, 20);
		backgroundAssets.add(tfNCAFY04);
		
		tfNCAFY05 = new JTextField("0,00");
		designNonEditableTextField(tfNCAFY05);
		tfNCAFY05.setBounds(1374, 565, 124, 20);
		backgroundAssets.add(tfNCAFY05);
		
		lblCash = new JLabel("Cash:");
		designLabel(lblCash);
		lblCash.setToolTipText("");
		lblCash.setBounds(10, 611, 272, 20);
		backgroundAssets.add(lblCash);
			
		tfCashPY03 = new JTextField("0,00");
		designNonEditableTextField(tfCashPY03);
		tfCashPY03.setBounds(292, 611, 124, 20);
		backgroundAssets.add(tfCashPY03);
		
		tfCashPY02 = new JTextField("0,00");
		designNonEditableTextField(tfCashPY02);
		tfCashPY02.setBounds(428, 611, 124, 20);
		backgroundAssets.add(tfCashPY02);
		
		tfCashPY01 = new JTextField("0,00");
		designNonEditableTextField(tfCashPY01);
		tfCashPY01.setBounds(564, 611, 124, 20);
		backgroundAssets.add(tfCashPY01);
		
		tfCashY00 = new JTextField("0,00");
		designNonEditableTextField(tfCashY00);
		tfCashY00.setBounds(698, 611, 124, 20);
		backgroundAssets.add(tfCashY00);
		
		tfCashFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCashFY01);
		tfCashFY01.setBounds(832, 611, 124, 20);
		backgroundAssets.add(tfCashFY01);
		
		tfCashFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCashFY02);
		tfCashFY02.setBounds(968, 611, 124, 20);
		backgroundAssets.add(tfCashFY02);
		
		tfCashFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCashFY03);
		tfCashFY03.setBounds(1104, 611, 124, 20);
		backgroundAssets.add(tfCashFY03);
		
		tfCashFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCashFY04);
		tfCashFY04.setBounds(1238, 611, 124, 20);
		backgroundAssets.add(tfCashFY04);
		
		tfCashFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCashFY05);
		tfCashFY05.setBounds(1374, 611, 124, 20);
		backgroundAssets.add(tfCashFY05);
		
		lblTotalAssets = new JLabel("Total assets:");
		designLabel(lblTotalAssets);
		lblTotalAssets.setToolTipText("");
		lblTotalAssets.setBounds(10, 657, 272, 20);
		backgroundAssets.add(lblTotalAssets);
		
		tfTotalAssetsPY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsPY03);
		tfTotalAssetsPY03.setBounds(292, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsPY03);
		
		tfTotalAssetsPY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsPY02);
		tfTotalAssetsPY02.setBounds(428, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsPY02);
		
		tfTotalAssetsPY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsPY01);
		tfTotalAssetsPY01.setBounds(564, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsPY01);
		
		tfTotalAssetsY00 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsY00);
		tfTotalAssetsY00.setBounds(698, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsY00);
		
		tfTotalAssetsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsFY01);
		tfTotalAssetsFY01.setBounds(832, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsFY01);
		
		tfTotalAssetsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsFY02);
		tfTotalAssetsFY02.setBounds(968, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsFY02);
		
		tfTotalAssetsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsFY03);
		tfTotalAssetsFY03.setBounds(1104, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsFY03);
		
		tfTotalAssetsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsFY04);
		tfTotalAssetsFY04.setBounds(1238, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsFY04);
		
		tfTotalAssetsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalAssetsFY05);
		tfTotalAssetsFY05.setBounds(1374, 657, 124, 20);
		backgroundAssets.add(tfTotalAssetsFY05);
		
		separator_3_11 = new JSeparator();
		separator_3_11.setBounds(10, 304, 1488, 2);
		backgroundAssets.add(separator_3_11);
		
		separator_3_12 = new JSeparator();
		separator_3_12.setBounds(10, 350, 1488, 2);
		backgroundAssets.add(separator_3_12);
		
		separator_3_13 = new JSeparator();
		separator_3_13.setBounds(10, 556, 1488, 2);
		backgroundAssets.add(separator_3_13);
		
		separator_3_6 = new JSeparator();
		separator_3_6.setBounds(10, 596, 1488, 2);
		backgroundAssets.add(separator_3_6);
		
		separator_3_7 = new JSeparator();
		separator_3_7.setBounds(10, 642, 1488, 2);
		backgroundAssets.add(separator_3_7);
		
		JPanel pnlBackgroundAssets = new JPanel();
		pnlBackgroundAssets.setBackground(new Color(244, 255, 235));
		pnlBackgroundAssets.setBounds(826, 0, 709, 803);
		pnlBackgroundAssets.setLayout(null);
		backgroundAssets.add(pnlBackgroundAssets);

		
		scrollPaneLiabilities = new JScrollPane();
		scrollPaneLiabilities.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneLiabilities.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneLiabilities, "Liabilities");
		
		JPanel pnlLiabilities = new JPanel();
		scrollPaneLiabilities.setViewportView(pnlLiabilities);
		pnlLiabilities.setBackground(UIManager.getColor("Button.background"));
		pnlLiabilities.setPreferredSize(new Dimension(2560,1440));
		pnlLiabilities.setLayout(null);
		
		backgroundLiabilities = new JPanel();
		backgroundLiabilities.setBackground(Color.WHITE);
		backgroundLiabilities.setBounds(10, 11, 1535, 803);
		pnlLiabilities.add(backgroundLiabilities);
		backgroundLiabilities.setLayout(null);
		
		JLabel lblLiabilitiesPY03 = new JLabel("Year -3");
		designLabelR(lblLiabilitiesPY03);
		lblLiabilitiesPY03.setBounds(292, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesPY03);
		
		JLabel lblLiabilitiesPY02 = new JLabel("Year -2 ");
		designLabelR(lblLiabilitiesPY02);
		lblLiabilitiesPY02.setBounds(428, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesPY02);
		
		JLabel lblLiabilitiesPY01 = new JLabel("Year -1");
		designLabelR(lblLiabilitiesPY01);
		lblLiabilitiesPY01.setBounds(564, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesPY01);
		
		JLabel lblLiabilitiesY00 = new JLabel("Current year");
		designLabelR(lblLiabilitiesY00);
		lblLiabilitiesY00.setBounds(698, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesY00);
		
		JLabel lblLiabilitiesFY01 = new JLabel("Year +1");
		designLabelR(lblLiabilitiesFY01);
		lblLiabilitiesFY01.setBounds(832, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesFY01);
		
		JLabel lblLiabilitiesFY02 = new JLabel("Year +2 ");
		designLabelR(lblLiabilitiesFY02);
		lblLiabilitiesFY02.setBounds(968, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesFY02);
		
		JLabel lblLiabilitiesFY03 = new JLabel("Year +3");
		designLabelR(lblLiabilitiesFY03);
		lblLiabilitiesFY03.setBounds(1104, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesFY03);
		
		JLabel lblLiabilitiesFY04 = new JLabel("Year +4 ");
		designLabelR(lblLiabilitiesFY04);
		lblLiabilitiesFY04.setBounds(1238, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesFY04);
		
		JLabel lblLiabilitiesFY05 = new JLabel("Year +5");
		designLabelR(lblLiabilitiesFY05);
		lblLiabilitiesFY05.setBounds(1374, 24, 124, 16);
		backgroundLiabilities.add(lblLiabilitiesFY05);
		
		JLabel lblShareCapital = new JLabel("Share capital:");
		designLabel(lblShareCapital);
		lblShareCapital.setBounds(10, 52, 208, 20);
		backgroundLiabilities.add(lblShareCapital);
		lblShareCapital.setToolTipText("");
		
		tfShareCapitalPY03 = new JTextField("0,00");
		designEditableTextField(tfShareCapitalPY03);
		tfShareCapitalPY03.setBounds(292, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalPY03);
		tfShareCapitalPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShareCapitalPY02 = new JTextField("0,00");
		designEditableTextField(tfShareCapitalPY02);
		tfShareCapitalPY02.setBounds(428, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalPY02);
		tfShareCapitalPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShareCapitalPY01 = new JTextField("0,00");
		designEditableTextField(tfShareCapitalPY01);
		tfShareCapitalPY01.setBounds(564, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalPY01);
		tfShareCapitalPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShareCapitalY00 = new JTextField("0,00");
		designEditableTextField(tfShareCapitalY00);
		tfShareCapitalY00.setBounds(698, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalY00);
		tfShareCapitalY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShareCapitalFY01 = new JTextField("0,00");
		designNonEditableTextField(tfShareCapitalFY01);
		tfShareCapitalFY01.setBounds(832, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalFY01);
		
		tfShareCapitalFY02 = new JTextField("0,00");
		designNonEditableTextField(tfShareCapitalFY02);
		tfShareCapitalFY02.setBounds(968, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalFY02);
		
		tfShareCapitalFY03 = new JTextField("0,00");
		designNonEditableTextField(tfShareCapitalFY03);
		tfShareCapitalFY03.setBounds(1104, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalFY03);
		
		tfShareCapitalFY04 = new JTextField("0,00");
		designNonEditableTextField(tfShareCapitalFY04);
		tfShareCapitalFY04.setBounds(1238, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalFY04);
		
		tfShareCapitalFY05 = new JTextField("0,00");
		designNonEditableTextField(tfShareCapitalFY05);
		tfShareCapitalFY05.setBounds(1374, 52, 124, 20);
		backgroundLiabilities.add(tfShareCapitalFY05);
		
		JLabel lblShareCapitalChange = new JLabel("Change in % to prev. year:");
		designLabel(lblShareCapitalChange);
		lblShareCapitalChange.setBounds(51, 84, 191, 20);
		backgroundLiabilities.add(lblShareCapitalChange);
		
		tfShareCapitalChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShareCapitalChangePY02);
		tfShareCapitalChangePY02.setBounds(362, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangePY02);
		
		tfShareCapitalChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShareCapitalChangePY01);
		tfShareCapitalChangePY01.setBounds(496, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangePY01);
		
		tfShareCapitalChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShareCapitalChangeY00);
		tfShareCapitalChangeY00.setBounds(630, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeY00);
		
		tfShareCapitalChangeFY01 = new JTextField("0,00");
		tfShareCapitalChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShareCapitalChangeFY01);
		tfShareCapitalChangeFY01.setBounds(768, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeFY01);
		
		tfShareCapitalChangeFY02 = new JTextField("0,00");
		tfShareCapitalChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShareCapitalChangeFY02);
		tfShareCapitalChangeFY02.setBounds(902, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeFY02);
		
		tfShareCapitalChangeFY03 = new JTextField("0,00");
		tfShareCapitalChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShareCapitalChangeFY03);
		tfShareCapitalChangeFY03.setBounds(1036, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeFY03);
		
		tfShareCapitalChangeFY04 = new JTextField("0,00");
		tfShareCapitalChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShareCapitalChangeFY04);
		tfShareCapitalChangeFY04.setBounds(1170, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeFY04);
		
		tfShareCapitalChangeFY05 = new JTextField("0,00");
		tfShareCapitalChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShareCapitalChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShareCapitalChangeFY05);
		tfShareCapitalChangeFY05.setBounds(1304, 83, 124, 20);
		backgroundLiabilities.add(tfShareCapitalChangeFY05);
		
		JLabel lblReserves = new JLabel("Reserves:");
		designLabel(lblReserves);
		lblReserves.setBounds(10, 115, 176, 20);
		backgroundLiabilities.add(lblReserves);
		lblReserves.setToolTipText("");
		
		tfReservesPY03 = new JTextField("0,00");
		designEditableTextField(tfReservesPY03);
		tfReservesPY03.setBounds(292, 115, 124, 20);
		backgroundLiabilities.add(tfReservesPY03);
		tfReservesPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReservesPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReservesPY02 = new JTextField("0,00");
		designEditableTextField(tfReservesPY02);
		tfReservesPY02.setBounds(428, 115, 124, 20);
		backgroundLiabilities.add(tfReservesPY02);
		tfReservesPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReservesPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReservesPY01 = new JTextField("0,00");
		designEditableTextField(tfReservesPY01);
		tfReservesPY01.setBounds(564, 115, 124, 20);
		backgroundLiabilities.add(tfReservesPY01);
		tfReservesPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReservesPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReservesY00 = new JTextField("0,00");
		designEditableTextField(tfReservesY00);
		tfReservesY00.setBounds(698, 115, 124, 20);
		backgroundLiabilities.add(tfReservesY00);
		tfReservesY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfReservesY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfReservesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfReservesFY01);
		tfReservesFY01.setBounds(832, 114, 124, 20);
		backgroundLiabilities.add(tfReservesFY01);
		
		tfReservesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfReservesFY02);
		tfReservesFY02.setBounds(968, 114, 124, 20);
		backgroundLiabilities.add(tfReservesFY02);
		
		tfReservesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfReservesFY03);
		tfReservesFY03.setBounds(1104, 114, 124, 20);
		backgroundLiabilities.add(tfReservesFY03);
		
		tfReservesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfReservesFY04);
		tfReservesFY04.setBounds(1238, 114, 124, 20);
		backgroundLiabilities.add(tfReservesFY04);
		
		tfReservesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfReservesFY05);
		tfReservesFY05.setBounds(1374, 114, 124, 20);
		backgroundLiabilities.add(tfReservesFY05);
		
		JLabel lblReservesChange = new JLabel("Change in % to prev. year:");
		designLabel(lblReservesChange);
		lblReservesChange.setBounds(51, 146, 191, 20);
		backgroundLiabilities.add(lblReservesChange);
		
		tfReservesChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangePY02);
		tfReservesChangePY02.setBounds(362, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangePY02);
		
		tfReservesChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangePY01);
		tfReservesChangePY01.setBounds(496, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangePY01);
		
		tfReservesChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeY00);
		tfReservesChangeY00.setBounds(630, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeY00);
		
		tfReservesChangeFY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeFY01);
		tfReservesChangeFY01.setBounds(768, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeFY01);
		
		tfReservesChangeFY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeFY02);
		tfReservesChangeFY02.setBounds(902, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeFY02);
		
		tfReservesChangeFY03 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeFY03);
		tfReservesChangeFY03.setBounds(1036, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeFY03);
		
		tfReservesChangeFY04 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeFY04);
		tfReservesChangeFY04.setBounds(1170, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeFY04);
		
		tfReservesChangeFY05 = new JTextField("0,00");
		designNonEditableTextFieldC(tfReservesChangeFY05);
		tfReservesChangeFY05.setBounds(1304, 146, 124, 20);
		backgroundLiabilities.add(tfReservesChangeFY05);
		
		JLabel lblOtherEquity = new JLabel("Other equity:");
		designLabel(lblOtherEquity);
		lblOtherEquity.setToolTipText("");
		lblOtherEquity.setBounds(10, 177, 176, 20);
		backgroundLiabilities.add(lblOtherEquity);
		
		tfOtherEquityPY03 = new JTextField("0,00");
		designEditableTextField(tfOtherEquityPY03);
		tfOtherEquityPY03.setBounds(292, 177, 124, 20);
		backgroundLiabilities.add(tfOtherEquityPY03);
		tfOtherEquityPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherEquityPY02 = new JTextField("0,00");
		designEditableTextField(tfOtherEquityPY02);
		tfOtherEquityPY02.setBounds(428, 177, 124, 20);
		backgroundLiabilities.add(tfOtherEquityPY02);
		tfOtherEquityPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityPY02 .selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfOtherEquityPY01 = new JTextField("0,00");
		designEditableTextField(tfOtherEquityPY01);
		tfOtherEquityPY01.setBounds(564, 177, 124, 20);
		backgroundLiabilities.add(tfOtherEquityPY01);
		tfOtherEquityPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfOtherEquityY00 = new JTextField("0,00");
		designEditableTextField(tfOtherEquityY00);
		tfOtherEquityY00.setBounds(698, 177, 124, 20);
		backgroundLiabilities.add(tfOtherEquityY00);
		tfOtherEquityY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherEquityFY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherEquityFY01);
		tfOtherEquityFY01.setBounds(832, 176, 124, 20);
		backgroundLiabilities.add(tfOtherEquityFY01);
		
		tfOtherEquityFY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherEquityFY02);
		tfOtherEquityFY02.setBounds(968, 176, 124, 20);
		backgroundLiabilities.add(tfOtherEquityFY02);
		
		tfOtherEquityFY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherEquityFY03);
		tfOtherEquityFY03.setBounds(1104, 176, 124, 20);
		backgroundLiabilities.add(tfOtherEquityFY03);
		
		tfOtherEquityFY04 = new JTextField("0,00");
		designNonEditableTextField(tfOtherEquityFY04);
		tfOtherEquityFY04.setBounds(1238, 176, 124, 20);
		backgroundLiabilities.add(tfOtherEquityFY04);
		
		tfOtherEquityFY05 = new JTextField("0,00");
		designNonEditableTextField(tfOtherEquityFY05);
		tfOtherEquityFY05.setBounds(1374, 176, 124, 20);
		backgroundLiabilities.add(tfOtherEquityFY05);
		
		JLabel lblOtherEquityChange = new JLabel("Change in % to prev. year:");
		designLabel(lblOtherEquityChange);
		lblOtherEquityChange.setToolTipText("");
		lblOtherEquityChange.setBounds(51, 208, 191, 20);
		backgroundLiabilities.add(lblOtherEquityChange);
		
		tfOtherEquityChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherEquityChangePY02);
		tfOtherEquityChangePY02.setBounds(362, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangePY02);
		
		tfOtherEquityChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherEquityChangePY01);
		tfOtherEquityChangePY01.setBounds(496, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangePY01);
		
		tfOtherEquityChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherEquityChangeY00);
		tfOtherEquityChangeY00.setBounds(630, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeY00);
		
		tfOtherEquityChangeFY01 = new JTextField("0,00");
		tfOtherEquityChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherEquityChangeFY01);
		tfOtherEquityChangeFY01.setBounds(768, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeFY01);
		
		tfOtherEquityChangeFY02 = new JTextField("0,00");
		tfOtherEquityChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherEquityChangeFY02);
		tfOtherEquityChangeFY02.setBounds(902, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeFY02);
		
		tfOtherEquityChangeFY03 = new JTextField("0,00");
		tfOtherEquityChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherEquityChangeFY03);
		tfOtherEquityChangeFY03.setBounds(1036, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeFY03);
		
		tfOtherEquityChangeFY04 = new JTextField("0,00");
		tfOtherEquityChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherEquityChangeFY04);
		tfOtherEquityChangeFY04.setBounds(1170, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeFY04);
		
		tfOtherEquityChangeFY05 = new JTextField("0,00");
		tfOtherEquityChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherEquityChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherEquityChangeFY05);
		tfOtherEquityChangeFY05.setBounds(1304, 208, 124, 20);
		backgroundLiabilities.add(tfOtherEquityChangeFY05);
		
		JLabel lblTotalEquity = new JLabel("Total equity:");
		designLabel(lblTotalEquity);
		lblTotalEquity.setBounds(10, 257, 176, 20);
		backgroundLiabilities.add(lblTotalEquity);
		
		tfTotalEquityPY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityPY03);
		tfTotalEquityPY03.setBounds(292, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityPY03);
		
		tfTotalEquityPY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityPY02);
		tfTotalEquityPY02.setBounds(428, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityPY02);
		
		tfTotalEquityPY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityPY01);
		tfTotalEquityPY01.setBounds(564, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityPY01);
		
		tfTotalEquityY00 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityY00);
		tfTotalEquityY00.setBounds(698, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityY00);
		
		tfTotalEquityFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityFY01);
		tfTotalEquityFY01.setBounds(832, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityFY01);
		
		tfTotalEquityFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityFY02);
		tfTotalEquityFY02.setBounds(968, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityFY02);
		
		tfTotalEquityFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityFY03);
		tfTotalEquityFY03.setBounds(1104, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityFY03);
		
		tfTotalEquityFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityFY04);
		tfTotalEquityFY04.setBounds(1238, 256, 124, 20);
		backgroundLiabilities.add(tfTotalEquityFY04);
		
		tfTotalEquityFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalEquityFY05);
		tfTotalEquityFY05.setBounds(1374, 255, 124, 20);
		backgroundLiabilities.add(tfTotalEquityFY05);
		
		JLabel lblLongTermBankDebt = new JLabel("Long term bank debt:");
		designLabel(lblLongTermBankDebt);
		lblLongTermBankDebt.setToolTipText("");
		lblLongTermBankDebt.setBounds(10, 302, 272, 20);
		backgroundLiabilities.add(lblLongTermBankDebt);
		
		tfLongTermBankDebtPY03 = new JTextField("0,00");
		designEditableTextField(tfLongTermBankDebtPY03);
		tfLongTermBankDebtPY03.setBounds(292, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtPY03);
		tfLongTermBankDebtPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfLongTermBankDebtPY02 = new JTextField("0,00");
		designEditableTextField(tfLongTermBankDebtPY02);
		tfLongTermBankDebtPY02.setBounds(428, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtPY02);
		tfLongTermBankDebtPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfLongTermBankDebtPY01 = new JTextField("0,00");
		designEditableTextField(tfLongTermBankDebtPY01);
		tfLongTermBankDebtPY01.setBounds(564, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtPY01);
		tfLongTermBankDebtPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfLongTermBankDebtY00 = new JTextField("0,00");
		designEditableTextField(tfLongTermBankDebtY00);
		tfLongTermBankDebtY00.setBounds(698, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtY00);
		tfLongTermBankDebtY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfLongTermBankDebtFY01 = new JTextField("0,00");
		designNonEditableTextField(tfLongTermBankDebtFY01);
		tfLongTermBankDebtFY01.setBounds(832, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtFY01);
		
		tfLongTermBankDebtFY02 = new JTextField("0,00");
		designNonEditableTextField(tfLongTermBankDebtFY02);
		tfLongTermBankDebtFY02.setBounds(968, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtFY02);
		
		tfLongTermBankDebtFY03 = new JTextField("0,00");
		designNonEditableTextField(tfLongTermBankDebtFY03);
		tfLongTermBankDebtFY03.setBounds(1104, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtFY03);
		
		tfLongTermBankDebtFY04 = new JTextField("0,00");
		designNonEditableTextField(tfLongTermBankDebtFY04);
		tfLongTermBankDebtFY04.setBounds(1238, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtFY04);
		
		tfLongTermBankDebtFY05 = new JTextField("0,00");
		designNonEditableTextField(tfLongTermBankDebtFY05);
		tfLongTermBankDebtFY05.setBounds(1374, 302, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtFY05);
		
		lblLongTermBankDebtChange = new JLabel("Change in % to prev. year:");
		designLabel(lblLongTermBankDebtChange);
		lblLongTermBankDebtChange.setBounds(51, 333, 231, 20);
		backgroundLiabilities.add(lblLongTermBankDebtChange);
		lblLongTermBankDebtChange.setToolTipText("");
		
		tfLongTermBankDebtChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfLongTermBankDebtChangePY02);
		tfLongTermBankDebtChangePY02.setBounds(362, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangePY02);;
		
		tfLongTermBankDebtChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfLongTermBankDebtChangePY01);
		tfLongTermBankDebtChangePY01.setBounds(496, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangePY01);
		
		tfLongTermBankDebtChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfLongTermBankDebtChangeY00);
		tfLongTermBankDebtChangeY00.setBounds(630, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeY00);
		
		tfLongTermBankDebtChangeFY01 = new JTextField("0,00");
		tfLongTermBankDebtChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfLongTermBankDebtChangeFY01);
		tfLongTermBankDebtChangeFY01.setBounds(768, 334, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeFY01);
		
		tfLongTermBankDebtChangeFY02 = new JTextField("0,00");
		tfLongTermBankDebtChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfLongTermBankDebtChangeFY02);
		tfLongTermBankDebtChangeFY02.setBounds(902, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeFY02);
		
		tfLongTermBankDebtChangeFY03 = new JTextField("0,00");
		tfLongTermBankDebtChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfLongTermBankDebtChangeFY03);
		tfLongTermBankDebtChangeFY03.setBounds(1036, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeFY03);
		
		tfLongTermBankDebtChangeFY04 = new JTextField("0,00");
		tfLongTermBankDebtChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfLongTermBankDebtChangeFY04);
		tfLongTermBankDebtChangeFY04.setBounds(1170, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeFY04);
		
		tfLongTermBankDebtChangeFY05 = new JTextField("0,00");
		tfLongTermBankDebtChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfLongTermBankDebtChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfLongTermBankDebtChangeFY05);
		tfLongTermBankDebtChangeFY05.setBounds(1304, 333, 124, 20);
		backgroundLiabilities.add(tfLongTermBankDebtChangeFY05);
		
		JLabel lblAccruals = new JLabel("Accruals:");
		designLabel(lblAccruals);
		lblAccruals.setToolTipText("");
		lblAccruals.setBounds(10, 365, 176, 20);
		backgroundLiabilities.add(lblAccruals);
		
		tfAccrualsPY03 = new JTextField("0,00");
		designEditableTextField(tfAccrualsPY03);
		tfAccrualsPY03.setBounds(292, 365, 124, 20);
		backgroundLiabilities.add(tfAccrualsPY03);
		tfAccrualsPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfAccrualsPY02 = new JTextField("0,00");
		designEditableTextField(tfAccrualsPY02);
		tfAccrualsPY02.setBounds(428, 365, 124, 20);
		backgroundLiabilities.add(tfAccrualsPY02);
		tfAccrualsPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfAccrualsPY01 = new JTextField("0,00");
		designEditableTextField(tfAccrualsPY01);
		tfAccrualsPY01.setBounds(564, 365, 124, 20);
		backgroundLiabilities.add(tfAccrualsPY01);
		tfAccrualsPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});

		tfAccrualsY00 = new JTextField("0,00");
		designEditableTextField(tfAccrualsY00);
		tfAccrualsY00.setBounds(698, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsY00);
		tfAccrualsY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfAccrualsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfAccrualsFY01);
		tfAccrualsFY01.setBounds(832, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsFY01);
		
		tfAccrualsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfAccrualsFY02);
		tfAccrualsFY02.setBounds(968, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsFY02);
		
		tfAccrualsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfAccrualsFY03);
		tfAccrualsFY03.setBounds(1104, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsFY03);
		
		tfAccrualsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfAccrualsFY04);
		tfAccrualsFY04.setBounds(1238, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsFY04);
		
		tfAccrualsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfAccrualsFY05);
		tfAccrualsFY05.setBounds(1374, 364, 124, 20);
		backgroundLiabilities.add(tfAccrualsFY05);
		
		lblAccrualsChange = new JLabel("Change in % to prev. year:");
		designLabel(lblAccrualsChange);
		lblAccrualsChange.setBounds(51, 396, 231, 20);
		backgroundLiabilities.add(lblAccrualsChange);
		lblAccrualsChange.setToolTipText("");
		
		tfAccrualsChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfAccrualsChangePY02);
		tfAccrualsChangePY02.setBounds(362, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangePY02);
		
		tfAccrualsChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfAccrualsChangePY01);
		tfAccrualsChangePY01.setBounds(496, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangePY01);
		
		tfAccrualsChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfAccrualsChangeY00);
		tfAccrualsChangeY00.setBounds(630, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeY00);
		
		tfAccrualsChangeFY01 = new JTextField("0,00");
		tfAccrualsChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfAccrualsChangeFY01);
		tfAccrualsChangeFY01.setBounds(768, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeFY01);
		
		tfAccrualsChangeFY02 = new JTextField("0,00");
		tfAccrualsChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfAccrualsChangeFY02);
		tfAccrualsChangeFY02.setBounds(902, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeFY02);
		
		tfAccrualsChangeFY03 = new JTextField("0,00");
		tfAccrualsChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfAccrualsChangeFY03);
		tfAccrualsChangeFY03.setBounds(1036, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeFY03);
		
		tfAccrualsChangeFY04 = new JTextField("0,00");
		tfAccrualsChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfAccrualsChangeFY04);
		tfAccrualsChangeFY04.setBounds(1170, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeFY04);
		
		tfAccrualsChangeFY05 = new JTextField("0,00");
		tfAccrualsChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfAccrualsChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfAccrualsChangeFY05);
		tfAccrualsChangeFY05.setBounds(1304, 396, 124, 20);
		backgroundLiabilities.add(tfAccrualsChangeFY05);
		
		JLabel lblTotalLongTermLiabilities = new JLabel("Total long term liabilities");
		designLabel(lblTotalLongTermLiabilities);
		lblTotalLongTermLiabilities.setBounds(10, 440, 272, 20);
		backgroundLiabilities.add(lblTotalLongTermLiabilities);
		
		tfTotalLongTermLiabilitiesPY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesPY03);
		tfTotalLongTermLiabilitiesPY03.setBounds(292, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesPY03);
		
		tfTotalLongTermLiabilitiesPY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesPY02);
		tfTotalLongTermLiabilitiesPY02.setBounds(428, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesPY02);

		
		tfTotalLongTermLiabilitiesPY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesPY01);
		tfTotalLongTermLiabilitiesPY01.setBounds(564, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesPY01);
		
		tfTotalLongTermLiabilitiesY00 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesY00);
		tfTotalLongTermLiabilitiesY00.setBounds(698, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesY00);
		
		tfTotalLongTermLiabilitiesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesFY01);
		tfTotalLongTermLiabilitiesFY01.setBounds(832, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesFY01);
		
		tfTotalLongTermLiabilitiesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesFY02);
		tfTotalLongTermLiabilitiesFY02.setBounds(968, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesFY02);
		
		tfTotalLongTermLiabilitiesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesFY03);
		tfTotalLongTermLiabilitiesFY03.setBounds(1104, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesFY03);
		
		tfTotalLongTermLiabilitiesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesFY04);
		tfTotalLongTermLiabilitiesFY04.setBounds(1238, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesFY04);
		
		tfTotalLongTermLiabilitiesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLongTermLiabilitiesFY05);
		tfTotalLongTermLiabilitiesFY05.setBounds(1374, 440, 124, 20);
		backgroundLiabilities.add(tfTotalLongTermLiabilitiesFY05);
		
		JLabel lblShortTermBankDebt = new JLabel("Short term debt:");
		designLabel(lblShortTermBankDebt);
		lblShortTermBankDebt.setToolTipText("");
		lblShortTermBankDebt.setBounds(10, 484, 232, 20);
		backgroundLiabilities.add(lblShortTermBankDebt);
			
		tfShortTermBankDebtPY03 = new JTextField("0,00");
		designEditableTextField(tfShortTermBankDebtPY03);
		tfShortTermBankDebtPY03.setBounds(292, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtPY03);
		tfShortTermBankDebtPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShortTermBankDebtPY02 = new JTextField("0,00");
		designEditableTextField(tfShortTermBankDebtPY02);
		tfShortTermBankDebtPY02.setBounds(428, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtPY02);
		tfShortTermBankDebtPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShortTermBankDebtPY01 = new JTextField("0,00");
		designEditableTextField(tfShortTermBankDebtPY01);
		tfShortTermBankDebtPY01.setBounds(564, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtPY01);
		tfShortTermBankDebtPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShortTermBankDebtY00 = new JTextField("0,00");
		designEditableTextField(tfShortTermBankDebtY00);
		tfShortTermBankDebtY00.setBounds(698, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtY00);
		tfShortTermBankDebtY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfShortTermBankDebtFY01 = new JTextField("0,00");
		designNonEditableTextField(tfShortTermBankDebtFY01);
		tfShortTermBankDebtFY01.setBounds(832, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtFY01);
		
		tfShortTermBankDebtFY02 = new JTextField("0,00");
		designNonEditableTextField(tfShortTermBankDebtFY02);
		tfShortTermBankDebtFY02.setBounds(968, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtFY02);
		
		tfShortTermBankDebtFY03 = new JTextField("0,00");
		designNonEditableTextField(tfShortTermBankDebtFY03);
		tfShortTermBankDebtFY03.setBounds(1104, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtFY03);
		
		tfShortTermBankDebtFY04 = new JTextField("0,00");
		designNonEditableTextField(tfShortTermBankDebtFY04);
		tfShortTermBankDebtFY04.setBounds(1238, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtFY04);
		
		tfShortTermBankDebtFY05 = new JTextField("0,00");
		designNonEditableTextField(tfShortTermBankDebtFY05);
		tfShortTermBankDebtFY05.setBounds(1374, 484, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtFY05);
		
		lblShortTermBankDebtChange = new JLabel("Change in % to prev. year:");
		designLabel(lblShortTermBankDebtChange);
		lblShortTermBankDebtChange.setBounds(51, 515, 231, 20);
		backgroundLiabilities.add(lblShortTermBankDebtChange);
		lblShortTermBankDebtChange.setToolTipText("");
		
		tfShortTermBankDebtChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShortTermBankDebtChangePY02);
		tfShortTermBankDebtChangePY02.setBounds(362, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangePY02);
		
		tfShortTermBankDebtChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShortTermBankDebtChangePY01);
		tfShortTermBankDebtChangePY01.setBounds(496, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangePY01);
		
		tfShortTermBankDebtChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfShortTermBankDebtChangeY00);
		tfShortTermBankDebtChangeY00.setBounds(630, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeY00);
		
		tfShortTermBankDebtChangeFY01 = new JTextField("0,00");
		tfShortTermBankDebtChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShortTermBankDebtChangeFY01);
		tfShortTermBankDebtChangeFY01.setBounds(768, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeFY01);
		
		tfShortTermBankDebtChangeFY02 = new JTextField("0,00");
		tfShortTermBankDebtChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShortTermBankDebtChangeFY02);
		tfShortTermBankDebtChangeFY02.setBounds(902, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeFY02);
		
		tfShortTermBankDebtChangeFY03 = new JTextField("0,00");
		tfShortTermBankDebtChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShortTermBankDebtChangeFY03);
		tfShortTermBankDebtChangeFY03.setBounds(1036, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeFY03);
		
		tfShortTermBankDebtChangeFY04 = new JTextField("0,00");
		tfShortTermBankDebtChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShortTermBankDebtChangeFY04);
		tfShortTermBankDebtChangeFY04.setBounds(1170, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeFY04);
		
		tfShortTermBankDebtChangeFY05 = new JTextField("0,00");
		tfShortTermBankDebtChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfShortTermBankDebtChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfShortTermBankDebtChangeFY05);
		tfShortTermBankDebtChangeFY05.setBounds(1304, 515, 124, 20);
		backgroundLiabilities.add(tfShortTermBankDebtChangeFY05);
		
		JLabel lblTradePayables = new JLabel("Trade payables:");
		designLabel(lblTradePayables);
		lblTradePayables.setToolTipText("");
		lblTradePayables.setBounds(10, 548, 176, 20);
		backgroundLiabilities.add(lblTradePayables);
		
		tfTradePayablesPY03 = new JTextField("0,00");
		designEditableTextField(tfTradePayablesPY03);
		tfTradePayablesPY03.setBounds(292, 547, 124, 20);
		backgroundLiabilities.add(tfTradePayablesPY03);
		tfTradePayablesPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTradePayablesPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTradePayablesPY02 = new JTextField("0,00");
		designEditableTextField(tfTradePayablesPY02);
		tfTradePayablesPY02.setBounds(428, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesPY02);
		tfTradePayablesPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTradePayablesPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTradePayablesPY01 = new JTextField("0,00");
		designEditableTextField(tfTradePayablesPY01);
		tfTradePayablesPY01.setBounds(564, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesPY01);
		tfTradePayablesPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTradePayablesPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTradePayablesY00 = new JTextField("0,00");
		designEditableTextField(tfTradePayablesY00);
		tfTradePayablesY00.setBounds(698, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesY00);
		tfTradePayablesY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTradePayablesY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfTradePayablesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTradePayablesFY01);
		tfTradePayablesFY01.setBounds(832, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesFY01);
		
		tfTradePayablesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTradePayablesFY02);
		tfTradePayablesFY02.setBounds(968, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesFY02);
		
		tfTradePayablesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTradePayablesFY03);
		tfTradePayablesFY03.setBounds(1104, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesFY03);
		
		tfTradePayablesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTradePayablesFY04);
		tfTradePayablesFY04.setBounds(1238, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesFY04);
		
		tfTradePayablesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTradePayablesFY05);
		tfTradePayablesFY05.setBounds(1374, 546, 124, 20);
		backgroundLiabilities.add(tfTradePayablesFY05);
		
		lblPayablesTurnover = new JLabel("Turnover rate:");
		designLabel(lblPayablesTurnover);
		lblPayablesTurnover.setBounds(51, 579, 231, 20);
		backgroundLiabilities.add(lblPayablesTurnover);
		lblPayablesTurnover.setToolTipText("");
		
		tfDaysPayablesOutstandingPY03 = new JTextField("0,00");
		designNonEditableTextField(tfDaysPayablesOutstandingPY03);
		tfDaysPayablesOutstandingPY03.setBounds(292, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingPY03);
		
		tfDaysPayablesOutstandingPY02 = new JTextField("0,00");
		designNonEditableTextField(tfDaysPayablesOutstandingPY02);
		tfDaysPayablesOutstandingPY02.setBounds(428, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingPY02);
		
		tfDaysPayablesOutstandingPY01 = new JTextField("0,00");
		designNonEditableTextField(tfDaysPayablesOutstandingPY01);
		tfDaysPayablesOutstandingPY01.setBounds(564, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingPY01);
		
		tfDaysPayablesOutstandingY00 = new JTextField("0,00");
		designNonEditableTextField(tfDaysPayablesOutstandingY00);
		tfDaysPayablesOutstandingY00.setBounds(698, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingY00);
		
		tfDaysPayablesOutstandingFY01 = new JTextField("0,00");
		tfDaysPayablesOutstandingFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDaysPayablesOutstandingFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDaysPayablesOutstandingFY01);
		tfDaysPayablesOutstandingFY01.setBounds(832, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingFY01);
		
		tfDaysPayablesOutstandingFY02 = new JTextField("0,00");
		tfDaysPayablesOutstandingFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDaysPayablesOutstandingFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDaysPayablesOutstandingFY02);
		tfDaysPayablesOutstandingFY02.setBounds(968, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingFY02);
		
		tfDaysPayablesOutstandingFY03 = new JTextField("0,00");
		tfDaysPayablesOutstandingFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDaysPayablesOutstandingFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDaysPayablesOutstandingFY03);
		tfDaysPayablesOutstandingFY03.setBounds(1104, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingFY03);
		
		tfDaysPayablesOutstandingFY04 = new JTextField("0,00");
		tfDaysPayablesOutstandingFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDaysPayablesOutstandingFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDaysPayablesOutstandingFY04);
		tfDaysPayablesOutstandingFY04.setBounds(1238, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingFY04);
		
		tfDaysPayablesOutstandingFY05 = new JTextField("0,00");
		tfDaysPayablesOutstandingFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfDaysPayablesOutstandingFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfDaysPayablesOutstandingFY05);
		tfDaysPayablesOutstandingFY05.setBounds(1374, 579, 124, 20);
		backgroundLiabilities.add(tfDaysPayablesOutstandingFY05);
		
		JLabel lblOtherShortTermLiabilities = new JLabel("Other short term liabilities:");
		designLabel(lblOtherShortTermLiabilities);
		lblOtherShortTermLiabilities.setToolTipText("");
		lblOtherShortTermLiabilities.setBounds(10, 611, 272, 20);
		backgroundLiabilities.add(lblOtherShortTermLiabilities);
		
		tfOtherShortTermLiabilitiesPY03 = new JTextField("0,00");
		designEditableTextField(tfOtherShortTermLiabilitiesPY03);
		tfOtherShortTermLiabilitiesPY03.setBounds(292, 610, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesPY03);
		tfOtherShortTermLiabilitiesPY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesPY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherShortTermLiabilitiesPY02 = new JTextField("0,00");
		designEditableTextField(tfOtherShortTermLiabilitiesPY02);
		tfOtherShortTermLiabilitiesPY02.setBounds(428, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesPY02);
		tfOtherShortTermLiabilitiesPY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesPY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherShortTermLiabilitiesPY01 = new JTextField("0,00");
		designEditableTextField(tfOtherShortTermLiabilitiesPY01);
		tfOtherShortTermLiabilitiesPY01.setBounds(564, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesPY01);
		tfOtherShortTermLiabilitiesPY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesPY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherShortTermLiabilitiesY00 = new JTextField("0,00");
		designEditableTextField(tfOtherShortTermLiabilitiesY00);
		tfOtherShortTermLiabilitiesY00.setBounds(698, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesY00);
		tfOtherShortTermLiabilitiesY00.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesY00.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		tfOtherShortTermLiabilitiesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfOtherShortTermLiabilitiesFY01);
		tfOtherShortTermLiabilitiesFY01.setBounds(832, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesFY01);
		
		tfOtherShortTermLiabilitiesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfOtherShortTermLiabilitiesFY02);
		tfOtherShortTermLiabilitiesFY02.setBounds(968, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesFY02);
		
		tfOtherShortTermLiabilitiesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfOtherShortTermLiabilitiesFY03);
		tfOtherShortTermLiabilitiesFY03.setBounds(1104, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesFY03);
		
		tfOtherShortTermLiabilitiesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfOtherShortTermLiabilitiesFY04);
		tfOtherShortTermLiabilitiesFY04.setBounds(1238, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesFY04);
		
		tfOtherShortTermLiabilitiesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfOtherShortTermLiabilitiesFY05);
		tfOtherShortTermLiabilitiesFY05.setBounds(1374, 611, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesFY05);
		
		lblOtherShortTermLiabilitiesChange = new JLabel("Change in % to prev. year:");
		designLabel(lblOtherShortTermLiabilitiesChange);
		lblOtherShortTermLiabilitiesChange.setBounds(51, 642, 231, 20);
		backgroundLiabilities.add(lblOtherShortTermLiabilitiesChange);
		lblOtherShortTermLiabilitiesChange.setToolTipText("");
		
		tfOtherShortTermLiabilitiesChangePY02 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherShortTermLiabilitiesChangePY02);
		tfOtherShortTermLiabilitiesChangePY02.setBounds(362, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangePY02);
		
		tfOtherShortTermLiabilitiesChangePY01 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherShortTermLiabilitiesChangePY01);
		tfOtherShortTermLiabilitiesChangePY01.setBounds(496, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangePY01);
		
		tfOtherShortTermLiabilitiesChangeY00 = new JTextField("0,00");
		designNonEditableTextFieldC(tfOtherShortTermLiabilitiesChangeY00);
		tfOtherShortTermLiabilitiesChangeY00.setBounds(630, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeY00);
		
		tfOtherShortTermLiabilitiesChangeFY01 = new JTextField("0,00");
		tfOtherShortTermLiabilitiesChangeFY01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesChangeFY01.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherShortTermLiabilitiesChangeFY01);
		tfOtherShortTermLiabilitiesChangeFY01.setBounds(768, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeFY01);
		
		tfOtherShortTermLiabilitiesChangeFY02 = new JTextField("0,00");
		tfOtherShortTermLiabilitiesChangeFY02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesChangeFY02.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherShortTermLiabilitiesChangeFY02);
		tfOtherShortTermLiabilitiesChangeFY02.setBounds(902, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeFY02);
		
		tfOtherShortTermLiabilitiesChangeFY03 = new JTextField("0,00");
		tfOtherShortTermLiabilitiesChangeFY03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesChangeFY03.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherShortTermLiabilitiesChangeFY03);
		tfOtherShortTermLiabilitiesChangeFY03.setBounds(1036, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeFY03);
		
		tfOtherShortTermLiabilitiesChangeFY04 = new JTextField("0,00");
		tfOtherShortTermLiabilitiesChangeFY04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesChangeFY04.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherShortTermLiabilitiesChangeFY04);
		tfOtherShortTermLiabilitiesChangeFY04.setBounds(1170, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeFY04);
		
		tfOtherShortTermLiabilitiesChangeFY05 = new JTextField("0,00");
		tfOtherShortTermLiabilitiesChangeFY05.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfOtherShortTermLiabilitiesChangeFY05.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextFieldC(tfOtherShortTermLiabilitiesChangeFY05);
		tfOtherShortTermLiabilitiesChangeFY05.setBounds(1304, 642, 124, 20);
		backgroundLiabilities.add(tfOtherShortTermLiabilitiesChangeFY05);
		
		JLabel lblTotalShortTermLiabilities = new JLabel("Total short term liabilities:");
		designLabel(lblTotalShortTermLiabilities);
		lblTotalShortTermLiabilities.setToolTipText("");
		lblTotalShortTermLiabilities.setBounds(10, 686, 272, 20);
		backgroundLiabilities.add(lblTotalShortTermLiabilities);
		
		tfTotalShortTermLiabilitiesPY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesPY03);
		tfTotalShortTermLiabilitiesPY03.setBounds(292, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesPY03);
		
		tfTotalShortTermLiabilitiesPY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesPY02);
		tfTotalShortTermLiabilitiesPY02.setBounds(428, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesPY02);
		
		tfTotalShortTermLiabilitiesPY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesPY01);
		tfTotalShortTermLiabilitiesPY01.setBounds(564, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesPY01);
		
		tfTotalShortTermLiabilitiesY00 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesY00);
		tfTotalShortTermLiabilitiesY00.setBounds(698, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesY00);
		
		tfTotalShortTermLiabilitiesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesFY01);
		tfTotalShortTermLiabilitiesFY01.setBounds(832, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesFY01);
		
		tfTotalShortTermLiabilitiesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesFY02);
		tfTotalShortTermLiabilitiesFY02.setBounds(968, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesFY02);
		
		tfTotalShortTermLiabilitiesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesFY03);
		tfTotalShortTermLiabilitiesFY03.setBounds(1104, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesFY03);
		
		tfTotalShortTermLiabilitiesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesFY04);
		tfTotalShortTermLiabilitiesFY04.setBounds(1238, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesFY04);
		
		tfTotalShortTermLiabilitiesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalShortTermLiabilitiesFY05);
		tfTotalShortTermLiabilitiesFY05.setBounds(1374, 686, 124, 20);
		backgroundLiabilities.add(tfTotalShortTermLiabilitiesFY05);
		
		JLabel lblTotalLiabilities = new JLabel("Total liabilities:");
		designLabel(lblTotalLiabilities);
		lblTotalLiabilities.setBounds(10, 730, 176, 20);
		backgroundLiabilities.add(lblTotalLiabilities);
		
		tfTotalLiabilitiesPY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesPY03);
		tfTotalLiabilitiesPY03.setBounds(292, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesPY03);
		
		tfTotalLiabilitiesPY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesPY02);
		tfTotalLiabilitiesPY02.setBounds(428, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesPY02);
		
		tfTotalLiabilitiesPY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesPY01);
		tfTotalLiabilitiesPY01.setBounds(564, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesPY01);
		
		tfTotalLiabilitiesY00 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesY00);
		tfTotalLiabilitiesY00.setBounds(698, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesY00);
		
		tfTotalLiabilitiesFY01 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesFY01);
		tfTotalLiabilitiesFY01.setBounds(832, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesFY01);
		
		tfTotalLiabilitiesFY02 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesFY02);
		tfTotalLiabilitiesFY02.setBounds(968, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesFY02);
		
		tfTotalLiabilitiesFY03 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesFY03);
		tfTotalLiabilitiesFY03.setBounds(1104, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesFY03);
		
		tfTotalLiabilitiesFY04 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesFY04);
		tfTotalLiabilitiesFY04.setBounds(1238, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesFY04);
		
		tfTotalLiabilitiesFY05 = new JTextField("0,00");
		designNonEditableTextField(tfTotalLiabilitiesFY05);
		tfTotalLiabilitiesFY05.setBounds(1374, 730, 124, 20);
		backgroundLiabilities.add(tfTotalLiabilitiesFY05);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 242, 1488, 2);
		backgroundLiabilities.add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 288, 1488, 3);
		backgroundLiabilities.add(separator_3_1);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(10, 427, 1488, 2);
		backgroundLiabilities.add(separator_3_2);
		
		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setBounds(10, 471, 1488, 2);
		backgroundLiabilities.add(separator_3_3);
		
		JSeparator separator_3_4 = new JSeparator();
		separator_3_4.setBounds(10, 673, 1488, 2);
		backgroundLiabilities.add(separator_3_4);
		
		JSeparator separator_3_5 = new JSeparator();
		separator_3_5.setBounds(10, 717, 1488, 2);
		backgroundLiabilities.add(separator_3_5);
		
		pnlBackgroundLiabilities = new JPanel();
		pnlBackgroundLiabilities.setBackground(new Color(244, 255, 235));
		pnlBackgroundLiabilities.setBounds(826, 0, 709, 803);
		pnlBackgroundLiabilities.setLayout(null);
		backgroundLiabilities.add(pnlBackgroundLiabilities);
		
		scrollPaneCashFlow = new JScrollPane();
		scrollPaneCashFlow.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneCashFlow.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneCashFlow, "CashFlow");
		
		pnlCashFlow = new JPanel();
		scrollPaneCashFlow.setViewportView(pnlCashFlow);
		pnlCashFlow.setBackground(UIManager.getColor("Button.background"));
		pnlCashFlow.setPreferredSize(new Dimension(2560,1440));
		pnlCashFlow.setLayout(null);
		
		backgroundCashFlow = new JPanel();
		backgroundCashFlow.setBackground(Color.WHITE);
		backgroundCashFlow.setBounds(10, 11, 1535, 803);
		pnlCashFlow.add(backgroundCashFlow);
		backgroundCashFlow.setLayout(null);
		
		JLabel lblRiskFreeInterestRate = new JLabel("Risk free interest rate in %:");
		designLabel(lblRiskFreeInterestRate);
		lblRiskFreeInterestRate.setBounds(10, 80, 256, 20);
		backgroundCashFlow.add(lblRiskFreeInterestRate);
		
		tfRiskFreeInterestRate = new JTextField("4,50");
		designEditableTextField(tfRiskFreeInterestRate);
		tfRiskFreeInterestRate.setBounds(292, 80, 176, 20);
		backgroundCashFlow.add(tfRiskFreeInterestRate);
		tfRiskFreeInterestRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfRiskFreeInterestRate.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		JLabel lblMarketRiskPremium = new JLabel("Market risk premium in %:");
		designLabel(lblMarketRiskPremium);
		lblMarketRiskPremium.setBounds(10, 111, 256, 20);
		backgroundCashFlow.add(lblMarketRiskPremium);
		
		tfMarketRiskPremium = new JTextField("7,00");
		designEditableTextField(tfMarketRiskPremium);
		tfMarketRiskPremium.setBounds(292, 111, 176, 20);
		backgroundCashFlow.add(tfMarketRiskPremium);
		tfMarketRiskPremium.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfMarketRiskPremium.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		
		JLabel lblGrowthRateEndValue = new JLabel("Growth rate terminal value %:");
		designLabel(lblGrowthRateEndValue);
		lblGrowthRateEndValue.setBounds(10, 142, 256, 20);
		backgroundCashFlow.add(lblGrowthRateEndValue);
		
		tfGrowthRateEndValue = new JTextField("0,5");
		tfGrowthRateEndValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfGrowthRateEndValue.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				SaveAssetValues();
				DisplayAssetValues();
			}
		});
		designEditableTextField(tfGrowthRateEndValue);
		tfGrowthRateEndValue.setBounds(292, 142, 176, 20);
		backgroundCashFlow.add(tfGrowthRateEndValue);
		
		JLabel lblTotalIncomeCF = new JLabel("Adjust. operat. earnings after taxes:");
		designLabel(lblTotalIncomeCF);
		lblTotalIncomeCF.setBounds(10, 243, 272, 20);
		backgroundCashFlow.add(lblTotalIncomeCF);
		
		lblCashFlowFY01 = new JLabel("Year +1 ");
		designLabelR(lblCashFlowFY01);
		lblCashFlowFY01.setBounds(292, 203, 124, 16);
		backgroundCashFlow.add(lblCashFlowFY01);
		
		lblCashFlowFY02 = new JLabel("Year +2 ");
		designLabelR(lblCashFlowFY02);
		lblCashFlowFY02.setBounds(428, 203, 124, 16);
		backgroundCashFlow.add(lblCashFlowFY02);
		
		lblCashFlowFY03 = new JLabel("Year +3");
		designLabelR(lblCashFlowFY03);
		lblCashFlowFY03.setBounds(564, 203, 124, 16);
		backgroundCashFlow.add(lblCashFlowFY03);
		
		lblCashFlowFY04 = new JLabel("Year +4");
		designLabelR(lblCashFlowFY04);
		lblCashFlowFY04.setBounds(698, 203, 124, 16);
		backgroundCashFlow.add(lblCashFlowFY04);
		
		lblCashFlowFY05 = new JLabel("Year +5");
		designLabelR(lblCashFlowFY05);
		lblCashFlowFY05.setBounds(832, 203, 124, 16);
		backgroundCashFlow.add(lblCashFlowFY05);
		
		lblEndwert = new JLabel("Terminal value");
		designLabelR(lblEndwert);
		lblEndwert.setBounds(966, 203, 124, 16);
		backgroundCashFlow.add(lblEndwert);
		
		tfCFTotalIncomeFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeFY01);
		tfCFTotalIncomeFY01.setBounds(292, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeFY01);
		
		tfCFTotalIncomeFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeFY02);
		tfCFTotalIncomeFY02.setBounds(428, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeFY02);
		
		tfCFTotalIncomeFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeFY03);
		tfCFTotalIncomeFY03.setBounds(564, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeFY03);
		
		tfCFTotalIncomeFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeFY04);
		tfCFTotalIncomeFY04.setBounds(698, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeFY04);
		
		tfCFTotalIncomeFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeFY05);
		tfCFTotalIncomeFY05.setBounds(832, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeFY05);
		
		tfCFTotalIncomeTV = new JTextField("0,00");
		designNonEditableTextField(tfCFTotalIncomeTV);
		tfCFTotalIncomeTV.setBounds(966, 243, 124, 20);
		backgroundCashFlow.add(tfCFTotalIncomeTV);
		
		lblCFDepreciation = new JLabel("+ Depreciation:");
		designLabel(lblCFDepreciation);
		lblCFDepreciation.setBounds(10, 274, 272, 20);
		backgroundCashFlow.add(lblCFDepreciation);
		
		CFDepreciationFY01 = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationFY01);
		CFDepreciationFY01.setBounds(292, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationFY01);
		
		CFDepreciationFY02 = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationFY02);
		CFDepreciationFY02.setBounds(428, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationFY02);
		
		CFDepreciationFY03 = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationFY03);
		CFDepreciationFY03.setBounds(564, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationFY03);
		
		CFDepreciationFY04 = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationFY04);
		CFDepreciationFY04.setBounds(698, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationFY04);
		
		CFDepreciationFY05 = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationFY05);
		CFDepreciationFY05.setBounds(832, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationFY05);
		
		CFDepreciationTV = new JTextField("0,00");
		designNonEditableTextField(CFDepreciationTV);
		CFDepreciationTV.setBounds(966, 274, 124, 20);
		backgroundCashFlow.add(CFDepreciationTV);
		
		lblCFDepreciationIntangible = new JLabel("+ Depreciation intangible assets:");
		designLabel(lblCFDepreciationIntangible);
		lblCFDepreciationIntangible.setToolTipText("");
		lblCFDepreciationIntangible.setBounds(10, 305, 272, 20);
		backgroundCashFlow.add(lblCFDepreciationIntangible);
		
		tfCFDepreciationIntangibleFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleFY01);
		tfCFDepreciationIntangibleFY01.setBounds(292, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleFY01);
		
		tfCFDepreciationIntangibleFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleFY02);
		tfCFDepreciationIntangibleFY02.setBounds(428, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleFY02);
		
		tfCFDepreciationIntangibleFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleFY03);
		tfCFDepreciationIntangibleFY03.setBounds(564, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleFY03);
		
		tfCFDepreciationIntangibleFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleFY04);
		tfCFDepreciationIntangibleFY04.setBounds(698, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleFY04);
		
		tfCFDepreciationIntangibleFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleFY05);
		tfCFDepreciationIntangibleFY05.setBounds(832, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleFY05);
		
		tfCFDepreciationIntangibleTV = new JTextField("0,00");
		designNonEditableTextField(tfCFDepreciationIntangibleTV);
		tfCFDepreciationIntangibleTV.setBounds(966, 305, 124, 20);
		backgroundCashFlow.add(tfCFDepreciationIntangibleTV);
		
		JLabel lblCFAccruals = new JLabel("+ Changes in accruals:");
		designLabel(lblCFAccruals);
		lblCFAccruals.setToolTipText("");
		lblCFAccruals.setBounds(10, 336, 272, 20);
		backgroundCashFlow.add(lblCFAccruals);
		
		tfCFAccrualsFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsFY01);
		tfCFAccrualsFY01.setBounds(292, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsFY01);
		
		tfCFAccrualsFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsFY02);
		tfCFAccrualsFY02.setBounds(428, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsFY02);
		
		tfCFAccrualsFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsFY03);
		tfCFAccrualsFY03.setBounds(564, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsFY03);
		
		tfCFAccrualsFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsFY04);
		tfCFAccrualsFY04.setBounds(698, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsFY04);
		
		tfCFAccrualsFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsFY05);
		tfCFAccrualsFY05.setBounds(832, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsFY05);
		
		tfCFAccrualsTV = new JTextField("0,00");
		designNonEditableTextField(tfCFAccrualsTV);
		tfCFAccrualsTV.setBounds(966, 336, 124, 20);
		backgroundCashFlow.add(tfCFAccrualsTV);
		
		JLabel lblCFAssetsInvest = new JLabel("- Investments in assets:");
		designLabel(lblCFAssetsInvest);
		lblCFAssetsInvest.setToolTipText("");
		lblCFAssetsInvest.setBounds(10, 367, 272, 20);
		backgroundCashFlow.add(lblCFAssetsInvest);
		
		tfCFAssetsInvestFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestFY01);
		tfCFAssetsInvestFY01.setBounds(292, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestFY01);
		
		tfCFAssetsInvestFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestFY02);
		tfCFAssetsInvestFY02.setBounds(428, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestFY02);
		
		tfCFAssetsInvestFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestFY03);
		tfCFAssetsInvestFY03.setBounds(564, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestFY03);
		
		tfCFAssetsInvestFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestFY04);
		tfCFAssetsInvestFY04.setBounds(698, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestFY04);
		
		tfCFAssetsInvestFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestFY05);
		tfCFAssetsInvestFY05.setBounds(832, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestFY05);
		
		tfCFAssetsInvestTV = new JTextField("0,00");
		designNonEditableTextField(tfCFAssetsInvestTV);
		tfCFAssetsInvestTV.setBounds(966, 367, 124, 20);
		backgroundCashFlow.add(tfCFAssetsInvestTV);
		
		JLabel lblCFWorkingCapitalInvest = new JLabel("- Investments in working capital:");
		designLabel(lblCFWorkingCapitalInvest);
		lblCFWorkingCapitalInvest.setToolTipText("");
		lblCFWorkingCapitalInvest.setBounds(10, 398, 272, 20);
		backgroundCashFlow.add(lblCFWorkingCapitalInvest);
		
		tfCFWorkingCapitalInvestFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestFY01);
		tfCFWorkingCapitalInvestFY01.setBounds(292, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestFY01);
		
		tfCFWorkingCapitalInvestFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestFY02);
		tfCFWorkingCapitalInvestFY02.setBounds(428, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestFY02);
		
		tfCFWorkingCapitalInvestFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestFY03);
		tfCFWorkingCapitalInvestFY03.setBounds(564, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestFY03);
		
		tfCFWorkingCapitalInvestFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestFY04);
		tfCFWorkingCapitalInvestFY04.setBounds(698, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestFY04);
		
		tfCFWorkingCapitalInvestFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestFY05);
		tfCFWorkingCapitalInvestFY05.setBounds(832, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestFY05);
		
		tfCFWorkingCapitalInvestTV = new JTextField("0,00");
		designNonEditableTextField(tfCFWorkingCapitalInvestTV);
		tfCFWorkingCapitalInvestTV.setBounds(966, 398, 124, 20);
		backgroundCashFlow.add(tfCFWorkingCapitalInvestTV);
		
		JLabel lblCFShortTermBankDebtChange = new JLabel("+ Change in interest-bearing liabilities:");
		designLabel(lblCFShortTermBankDebtChange);
		lblCFShortTermBankDebtChange.setToolTipText("");
		lblCFShortTermBankDebtChange.setBounds(10, 429, 272, 20);
		backgroundCashFlow.add(lblCFShortTermBankDebtChange);
		
		tfCFDebtChangeFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeFY01);
		tfCFDebtChangeFY01.setBounds(292, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeFY01);
		
		tfCFDebtChangeFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeFY02);
		tfCFDebtChangeFY02.setBounds(428, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeFY02);
		
		tfCFDebtChangeFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeFY03);
		tfCFDebtChangeFY03.setBounds(564, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeFY03);
		
		tfCFDebtChangeFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeFY04);
		tfCFDebtChangeFY04.setBounds(698, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeFY04);
		
		tfCFDebtChangeFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeFY05);
		tfCFDebtChangeFY05.setBounds(832, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeFY05);
		
		tfCFDebtChangeTV = new JTextField("0,00");
		designNonEditableTextField(tfCFDebtChangeTV);
		tfCFDebtChangeTV.setBounds(966, 429, 124, 20);
		backgroundCashFlow.add(tfCFDebtChangeTV);
		
		JLabel lblCashflowToEquity = new JLabel("Cash Flow to Equity & terminal value:");
		designLabel(lblCashflowToEquity);
		lblCashflowToEquity.setToolTipText("");
		lblCashflowToEquity.setBounds(10, 473, 256, 20);
		backgroundCashFlow.add(lblCashflowToEquity);
		
		tfCashflowToEquityFY01 = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityFY01);
		tfCashflowToEquityFY01.setBounds(292, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityFY01);
		
		tfCashflowToEquityFY02 = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityFY02);
		tfCashflowToEquityFY02.setBounds(428, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityFY02);
		
		tfCashflowToEquityFY03 = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityFY03);
		tfCashflowToEquityFY03.setBounds(564, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityFY03);
		
		tfCashflowToEquityFY04 = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityFY04);
		tfCashflowToEquityFY04.setBounds(698, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityFY04);
		
		tfCashflowToEquityFY05 = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityFY05);
		tfCashflowToEquityFY05.setBounds(832, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityFY05);
		
		tfCashflowToEquityTV = new JTextField("0,00");
		designNonEditableTextField(tfCashflowToEquityTV);
		tfCashflowToEquityTV.setBounds(966, 473, 124, 20);
		backgroundCashFlow.add(tfCashflowToEquityTV);
		
		JLabel lblDiscountedCashflow = new JLabel("Discounted cash flows:");
		designLabel(lblDiscountedCashflow);
		lblDiscountedCashflow.setToolTipText("");
		lblDiscountedCashflow.setBounds(10, 517, 256, 20);
		backgroundCashFlow.add(lblDiscountedCashflow);
		
		tfDiscountedCashflowFY01 = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowFY01);
		tfDiscountedCashflowFY01.setBounds(292, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowFY01);
		
		tfDiscountedCashflowFY02 = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowFY02);
		tfDiscountedCashflowFY02.setBounds(428, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowFY02);
		
		tfDiscountedCashflowFY03 = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowFY03);
		tfDiscountedCashflowFY03.setBounds(564, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowFY03);
		
		tfDiscountedCashflowFY04 = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowFY04);
		tfDiscountedCashflowFY04.setBounds(698, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowFY04);
		
		tfDiscountedCashflowFY05 = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowFY05);
		tfDiscountedCashflowFY05.setBounds(832, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowFY05);
		
		tfDiscountedCashflowTV = new JTextField("0,00");
		designNonEditableTextField(tfDiscountedCashflowTV);
		tfDiscountedCashflowTV.setBounds(966, 517, 124, 20);
		backgroundCashFlow.add(tfDiscountedCashflowTV);
		
		JLabel lblCFCash = new JLabel("+ Cash:");
		designLabel(lblCFCash);
		lblCFCash.setBounds(10, 561, 208, 20);
		backgroundCashFlow.add(lblCFCash);
		
		tfCFCash = new JTextField("0,00");
		designNonEditableTextField(tfCFCash);
		tfCFCash.setBounds(292, 561, 124, 20);
		backgroundCashFlow.add(tfCFCash);
		
		JLabel lblFairValue = new JLabel("Indicated Fair Value of company*:");
		designLabel(lblFairValue);
		lblFairValue.setToolTipText("");
		lblFairValue.setBounds(10, 591, 284, 20);
		backgroundCashFlow.add(lblFairValue);
		
		tfFairValue = new JTextField("0,00");
		designNonEditableTextField(tfFairValue);
		tfFairValue.setBounds(292, 591, 124, 20);
		backgroundCashFlow.add(tfFairValue);
		
		JLabel lblFairValuePerShare = new JLabel("Indicated Fair Value per share*:");
		designLabel(lblFairValuePerShare);
		lblFairValuePerShare.setToolTipText("");
		lblFairValuePerShare.setBounds(10, 622, 256, 20);
		backgroundCashFlow.add(lblFairValuePerShare);
		
		tfFairValuePerShare = new JTextField("0,00");
		designNonEditableTextField(tfFairValuePerShare);
		tfFairValuePerShare.setBounds(292, 622, 124, 20);
		backgroundCashFlow.add(tfFairValuePerShare);
		
		JLabel lblFairValueFromSharePrice = new JLabel("Indicated Margin of Safety in %:");
		designLabel(lblFairValueFromSharePrice);
		lblFairValueFromSharePrice.setBounds(10, 653, 256, 20);
		backgroundCashFlow.add(lblFairValueFromSharePrice);
		
		tfFairValueFromSharePrice = new JTextField("0,00");
		designNonEditableTextField(tfFairValueFromSharePrice);
		tfFairValueFromSharePrice.setBounds(292, 653, 124, 20);
		backgroundCashFlow.add(tfFairValueFromSharePrice);
		
		JSeparator separator_3_8 = new JSeparator();
		separator_3_8.setBounds(10, 460, 1080, 2);
		backgroundCashFlow.add(separator_3_8);
		
		JSeparator separator_3_8_1 = new JSeparator();
		separator_3_8_1.setBounds(10, 504, 1080, 2);
		backgroundCashFlow.add(separator_3_8_1);
		
		JSeparator separator_3_8_1_1 = new JSeparator();
		separator_3_8_1_1.setBounds(10, 548, 1080, 2);
		backgroundCashFlow.add(separator_3_8_1_1);
		
		JButton btnAktualisieren = new JButton("Refresh");
		btnAktualisieren.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnAktualisieren.setBackground(UIManager.getColor("Button.background"));
		btnAktualisieren.setBounds(505, 141, 137, 21);
		backgroundCashFlow.add(btnAktualisieren);
		
		JLabel lblHintValues = new JLabel("*Disclaimer: Please note that these are calculated, approximate values. The company can trade significantly higher or lower in the market. Under certain circumstances, the calculated values ​​on the market will never be reached.");
		lblHintValues.setVerticalAlignment(SwingConstants.TOP);
		lblHintValues.setForeground(Color.GRAY);
		lblHintValues.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblHintValues.setBounds(10, 772, 1357, 20);
		backgroundCashFlow.add(lblHintValues);
		
		JPanel backgroundFairValue = new JPanel();
		backgroundFairValue.setBackground(new Color(240, 230, 140));
		backgroundFairValue.setBounds(0, 585, 423, 97);
		backgroundCashFlow.add(backgroundFairValue);
		backgroundFairValue.setLayout(null);
		
		scrollPaneKeyPerformanceIndicators = new JScrollPane();
		scrollPaneKeyPerformanceIndicators.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneKeyPerformanceIndicators.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneKeyPerformanceIndicators, "KeyPerformanceIndicators");
		
		pnlKeyPerformanceIndicators = new JPanel();
		scrollPaneKeyPerformanceIndicators.setViewportView(pnlKeyPerformanceIndicators);
		pnlKeyPerformanceIndicators.setBackground(UIManager.getColor("Button.background"));
		pnlKeyPerformanceIndicators.setPreferredSize(new Dimension(2560,1440));
		pnlKeyPerformanceIndicators.setLayout(null);
		
		backgroundKeyPerformanceIndicators = new JPanel();
		backgroundKeyPerformanceIndicators.setBackground(Color.WHITE);
		backgroundKeyPerformanceIndicators.setBounds(10, 11, 1535, 803);
		pnlKeyPerformanceIndicators.add(backgroundKeyPerformanceIndicators);
		backgroundKeyPerformanceIndicators.setLayout(null);
		
		leverageChart.addSeries("Leverage",year,leverage).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelLeverage = new XChartPanel<XYChart>(leverageChart);
		designChart(leverageChart);
		chartPanelLeverage.setBounds(45, 15, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelLeverage);
		
		assetIntensityChart.addSeries("Asset Intensity", year, assetIntensity).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelAssetIntensity = new XChartPanel<XYChart>(assetIntensityChart);
		designChart(assetIntensityChart);
		chartPanelAssetIntensity.setBounds(522, 15, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelAssetIntensity);
		
		circulatingIntensityChart.addSeries("Circulating Intensity", year, circulatingIntensity).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelCirculatingIntensity = new XChartPanel<XYChart>(circulatingIntensityChart);
		designChart(circulatingIntensityChart);
		chartPanelCirculatingIntensity.setBounds(999, 15, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelCirculatingIntensity);
		
		inventoryTurnoverChart.addSeries("Inventory Turnover", year, inventoryTurnover).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelInventoryTurnover = new XChartPanel<XYChart>(inventoryTurnoverChart);
		designChart(inventoryTurnoverChart);
		chartPanelInventoryTurnover.setBounds(45, 415, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelInventoryTurnover);
		
		receivablesTurnoverChart.addSeries("Receivables Turnover", year, receivablesTurnover).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelReceivablesTurnover = new XChartPanel<XYChart>(receivablesTurnoverChart);
		designChart(receivablesTurnoverChart);
		chartPanelReceivablesTurnover.setBounds(522, 415, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelReceivablesTurnover);
		
		payablesTurnoverChart.addSeries("Payables Turnover", year, payablesTurnover).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelPayablesTurnover = new XChartPanel<XYChart>(payablesTurnoverChart);
		designChart(payablesTurnoverChart);
		chartPanelPayablesTurnover.setBounds(999, 415, 420, 368);
		backgroundKeyPerformanceIndicators.add(chartPanelPayablesTurnover);
		
		scrollPaneGraphics = new JScrollPane();
		scrollPaneGraphics.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneGraphics.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPaneGraphics, "Graphics");
		
		pnlGraphics = new JPanel();
		scrollPaneGraphics.setViewportView(pnlGraphics);
		pnlGraphics.setBackground(UIManager.getColor("Button.background"));
		pnlGraphics.setPreferredSize(new Dimension(2560,1440));
		pnlGraphics.setLayout(null);
		
		JPanel backgroundGraphics = new JPanel();
		backgroundGraphics.setBackground(Color.WHITE);
		backgroundGraphics.setBounds(10, 11, 1535, 803);
		pnlGraphics.add(backgroundGraphics);
		backgroundGraphics.setLayout(null);
		
		
		revenueChart.addSeries("Revenue",year, revenue).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelRevenue = new XChartPanel<XYChart>(revenueChart);
		//revenueChart.setXAxisTitle("Jahr");
		//revenueChart.setYAxisTitle("Umsatz");
		designChart(revenueChart);
		chartPanelRevenue.setBounds(45,15,420,368);
		backgroundGraphics.add(chartPanelRevenue);		
		
		totalIncomeChart.addSeries("Total Income", year, totalIncome).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelTotalIncome = new XChartPanel<XYChart>(totalIncomeChart);
		designChart(totalIncomeChart);
		chartPanelTotalIncome.setBounds(522, 15, 420, 368);
		backgroundGraphics.add(chartPanelTotalIncome);
		
		returnOnSalesChart.addSeries("Return on Sales", year, returnOnSales).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelReturnOnSales = new XChartPanel<XYChart>(returnOnSalesChart);
		designChart(returnOnSalesChart);
		chartPanelReturnOnSales.setBounds(999, 15, 420, 368);
		backgroundGraphics.add(chartPanelReturnOnSales);
		
		returnOnEBITDAChart.addSeries("Return on EBITDA", year, returnOnEBITDA).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelReturnOnEBITDA = new XChartPanel<XYChart>(returnOnEBITDAChart);
		designChart(returnOnEBITDAChart);
		chartPanelReturnOnEBITDA.setBounds(45, 415, 420, 368);
		backgroundGraphics.add(chartPanelReturnOnEBITDA);
		
		returnOnEquityChart.addSeries("Return on Equity", year, returnOnEquity).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelReturnOnEquity = new XChartPanel<XYChart>(returnOnEquityChart);
		designChart(returnOnEquityChart);
		chartPanelReturnOnEquity.setBounds(522, 415, 420, 368);
		backgroundGraphics.add(chartPanelReturnOnEquity);
		
		totalReturnOnInvestChart.addSeries("Total Return on Investment", year, totalReturnOnInvest).setMarkerColor(new Color(191,155,48)).setLineColor(new Color(191,155,48));
		chartPanelTotalReturnOnInvest = new XChartPanel<XYChart>(totalReturnOnInvestChart);
		designChart(totalReturnOnInvestChart);
		chartPanelTotalReturnOnInvest.setBounds(999, 415, 420, 368);
		backgroundGraphics.add(chartPanelTotalReturnOnInvest);

	}
	
	
// GUIMethoden
	
	// Neue Company ueber das Menue anlegen, vollständiger Reset auf Default Werte
	
	public void NewCompany() {
			
		temporary.setDefaultValues();
		DisplayAssetValues();
		SaveAssetValues();
				
		
	}
	
	// SmartSimulation Helper
	
	public void simulationHelper() {
		
		temporary.smartSimulationHelper();
		DisplayAssetValues();
		SaveAssetValues();
		
	}

	
	// Methoden welche die Buttons auf dem Sidepanel highlighten und wieder zurücksetzen
	
	public void activateButton (JPanel pane) {
		
		pane.setBackground(new Color(191,155,48));
		
	}
	
	
	public void deactivateButton (JPanel pane) {
		
		
		pane.setBackground(new Color(0, 0, 0));
		
	}
	
	//Methode fuer das Design von Labels
	
	public void designLabel(JLabel label) {
		
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		
	}
	
	public void designLabelR(JLabel label) {
		
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
	}
	
	//Methode fuer das Design von Charts
	
	public void designChart(XYChart chart) {
		
		Font font = new Font("Segoe UI Semibold", Font.PLAIN, 15);
		
		chart.getStyler().setChartBackgroundColor(Color.WHITE);
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
		chart.getStyler().setChartTitleVisible(true);
		chart.getStyler().setXAxisTitleVisible(false);
		chart.getStyler().setYAxisTitleVisible(false);
		chart.getStyler().setLegendVisible(false);
		chart.getStyler().setPlotGridLinesVisible(false);
		chart.getStyler().setAxisTitleFont(font);
		chart.getStyler().setAxisTickLabelsFont(font);
		chart.getStyler().setPlotBorderVisible(false);
		
	}
	
	
	//Methode fuer das Design von editierbaren Textfeldern
	
	public void designEditableTextField (JTextField editableTextField) {
		
		editableTextField.setForeground(Color.BLACK);
		editableTextField.setBackground(new Color(240, 230, 140));
		editableTextField.setBorder(null);
		editableTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		editableTextField.setColumns(10);
		editableTextField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		editableTextField.setEditable(true);
		
	}
	
	public void designEditableTextFieldC (JTextField editableTextField) {
		
		editableTextField.setForeground(Color.BLACK);
		editableTextField.setBackground(new Color(240, 230, 140));
		editableTextField.setBorder(null);
		editableTextField.setHorizontalAlignment(SwingConstants.CENTER);
		editableTextField.setColumns(10);
		editableTextField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		editableTextField.setEditable(true);
		
	}
	
	//Methoden fuer das Design von nicht editierbaren Textfeldern
	
	public void designNonEditableTextField (JTextField nonEditableTextField) {
		
		nonEditableTextField.setForeground(Color.BLACK);
		nonEditableTextField.setBackground(Color.WHITE);
		nonEditableTextField.setBorder(null);
		nonEditableTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		nonEditableTextField.setColumns(10);
		nonEditableTextField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		nonEditableTextField.setEditable(false);
		
	}
	
	public void designNonEditableTextFieldC (JTextField nonEditableTextField) {
		
		nonEditableTextField.setForeground(Color.BLACK);
		nonEditableTextField.setBackground(Color.WHITE);
		nonEditableTextField.setBorder(null);
		nonEditableTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nonEditableTextField.setColumns(10);
		nonEditableTextField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		nonEditableTextField.setEditable(false);
		
	}
	

	//Methode, welche die Eingabedaten aus den Textfeldern im Company Objekt setzt
	
	public void SaveAssetValues() {
		int i = 0;
		for (i = 0; i<3; i++) {
		try {
			
			//Definition des Number Format zum parsen der eingegebenen Zahlen nach landesspezifischer Eingabe in DE mit Komma statt Punkt
			
			NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
			
			//Grunddaten des Unternehmens im Objekt setzen
			
			temporary.setCompanyName(tfCompanyName.getText());
			setTitle("Finance Investigator" + " - " + temporary.getCompanyName());
			temporary.setShareVolume(nf.parse(tfShareVolume.getText()).doubleValue());
			temporary.setCurrentSharePrice(nf.parse(tfCurrentSharePrice.getText()).doubleValue());
			temporary.setFairValueFromSharePrice();
			
			temporary.setDividendsPaidPY03(nf.parse(tfDividendsPaidPY03.getText()).doubleValue());
			temporary.setDividendsPaidPY02(nf.parse(tfDividendsPaidPY02.getText()).doubleValue());
			temporary.setDividendsPaidPY01(nf.parse(tfDividendsPaidPY01.getText()).doubleValue());
			temporary.setDividendsPaidY00(nf.parse(tfDividendsPaidY00.getText()).doubleValue());
			
			//GuV Daten des Unternehmens im Objekt setzen und berechnete Werte für Gewinne und Verhältniskennzahlen anzeigen
			
			temporary.setRevenuePY03(nf.parse(tfRevenuePY03.getText()).doubleValue());
			temporary.setRevenuePY02(nf.parse(tfRevenuePY02.getText()).doubleValue());
			temporary.setRevenuePY01(nf.parse(tfRevenuePY01.getText()).doubleValue());
			temporary.setRevenueY00(nf.parse(tfRevenueY00.getText()).doubleValue());
			temporary.setRevenueFY01();
			temporary.setRevenueFY02();
			temporary.setRevenueFY03();
			temporary.setRevenueFY04();
			temporary.setRevenueFY05();

			temporary.setRevenueChangePY02();
			temporary.setRevenueChangePY01();
			temporary.setRevenueChangeY00();
			temporary.setRevenueChangeFY01(nf.parse(tfRevenueChangeFY01.getText()).doubleValue());
			temporary.setRevenueChangeFY02(nf.parse(tfRevenueChangeFY02.getText()).doubleValue());
			temporary.setRevenueChangeFY03(nf.parse(tfRevenueChangeFY03.getText()).doubleValue());
			temporary.setRevenueChangeFY04(nf.parse(tfRevenueChangeFY04.getText()).doubleValue());
			temporary.setRevenueChangeFY05(nf.parse(tfRevenueChangeFY05.getText()).doubleValue());
			
			temporary.setCogsPY03(nf.parse(tfCogsPY03.getText()).doubleValue());
			temporary.setCogsPY02(nf.parse(tfCogsPY02.getText()).doubleValue());
			temporary.setCogsPY01(nf.parse(tfCogsPY01.getText()).doubleValue());
			temporary.setCogsY00(nf.parse(tfCogsY00.getText()).doubleValue());
			temporary.setCogsFY01();
			temporary.setCogsFY02();
			temporary.setCogsFY03();
			temporary.setCogsFY04();
			temporary.setCogsFY05();
			
			temporary.setCogsFromRevenuePY03();
			temporary.setCogsFromRevenuePY02();
			temporary.setCogsFromRevenuePY01();
			temporary.setCogsFromRevenueY00();
			temporary.setCogsFromRevenueFY01(nf.parse(tfCogsFromRevenueFY01.getText()).doubleValue());	
			temporary.setCogsFromRevenueFY02(nf.parse(tfCogsFromRevenueFY02.getText()).doubleValue());	
			temporary.setCogsFromRevenueFY03(nf.parse(tfCogsFromRevenueFY03.getText()).doubleValue());	
			temporary.setCogsFromRevenueFY04(nf.parse(tfCogsFromRevenueFY04.getText()).doubleValue());	
			temporary.setCogsFromRevenueFY05(nf.parse(tfCogsFromRevenueFY05.getText()).doubleValue());	
			
			temporary.setOtherCostsPY03();
			temporary.setOtherCostsPY02();
			temporary.setOtherCostsPY01();
			temporary.setOtherCostsY00();
			temporary.setOtherCostsFY01();
			temporary.setOtherCostsFY02();
			temporary.setOtherCostsFY03();
			temporary.setOtherCostsFY04();
			temporary.setOtherCostsFY05();
			
			temporary.setOtherCostsFromRevenuePY03();
			temporary.setOtherCostsFromRevenuePY02();
			temporary.setOtherCostsFromRevenuePY01();
			temporary.setOtherCostsFromRevenueY00();
			temporary.setOtherCostsFromRevenueFY01(nf.parse(tfOtherCostsFromRevenueFY01.getText()).doubleValue());
			temporary.setOtherCostsFromRevenueFY02(nf.parse(tfOtherCostsFromRevenueFY02.getText()).doubleValue());
			temporary.setOtherCostsFromRevenueFY03(nf.parse(tfOtherCostsFromRevenueFY03.getText()).doubleValue());
			temporary.setOtherCostsFromRevenueFY04(nf.parse(tfOtherCostsFromRevenueFY04.getText()).doubleValue());
			temporary.setOtherCostsFromRevenueFY05(nf.parse(tfOtherCostsFromRevenueFY05.getText()).doubleValue());
			
			temporary.setEbitdaPY03();
			temporary.setEbitdaPY02();
			temporary.setEbitdaPY01();
			temporary.setEbitdaY00();
			temporary.setEbitdaFY01();
			temporary.setEbitdaFY02();
			temporary.setEbitdaFY03();
			temporary.setEbitdaFY04();
			temporary.setEbitdaFY05();		
						
			temporary.setEbitdaFromRevenuePY03();
			temporary.setEbitdaFromRevenuePY02();
			temporary.setEbitdaFromRevenuePY01();
			temporary.setEbitdaFromRevenueY00();
			temporary.setEbitdaFromRevenueFY01();
			temporary.setEbitdaFromRevenueFY02();
			temporary.setEbitdaFromRevenueFY03();
			temporary.setEbitdaFromRevenueFY04();
			temporary.setEbitdaFromRevenueFY05();					
			
			temporary.setDepreciationPY03(nf.parse(tfDepreciationPY03.getText()).doubleValue());
			temporary.setDepreciationPY02(nf.parse(tfDepreciationPY02.getText()).doubleValue());
			temporary.setDepreciationPY01(nf.parse(tfDepreciationPY01.getText()).doubleValue());
			temporary.setDepreciationY00(nf.parse(tfDepreciationY00.getText()).doubleValue());
			temporary.setDepreciationFY01(nf.parse(tfDepreciationFY01.getText()).doubleValue());
			temporary.setDepreciationFY02(nf.parse(tfDepreciationFY02.getText()).doubleValue());
			temporary.setDepreciationFY03(nf.parse(tfDepreciationFY03.getText()).doubleValue());
			temporary.setDepreciationFY04(nf.parse(tfDepreciationFY04.getText()).doubleValue());
			temporary.setDepreciationFY05(nf.parse(tfDepreciationFY05.getText()).doubleValue());
			
			temporary.setDepreciationIntangiblePY03(nf.parse(tfDepreciationIntangiblePY03.getText()).doubleValue());
			temporary.setDepreciationIntangiblePY02(nf.parse(tfDepreciationIntangiblePY02.getText()).doubleValue());
			temporary.setDepreciationIntangiblePY01(nf.parse(tfDepreciationIntangiblePY01.getText()).doubleValue());
			temporary.setDepreciationIntangibleY00(nf.parse(tfDepreciationIntangibleY00.getText()).doubleValue());
			temporary.setDepreciationIntangibleFY01(nf.parse(tfDepreciationIntangibleFY01.getText()).doubleValue());
			temporary.setDepreciationIntangibleFY02(nf.parse(tfDepreciationIntangibleFY02.getText()).doubleValue());
			temporary.setDepreciationIntangibleFY03(nf.parse(tfDepreciationIntangibleFY03.getText()).doubleValue());
			temporary.setDepreciationIntangibleFY04(nf.parse(tfDepreciationIntangibleFY04.getText()).doubleValue());
			temporary.setDepreciationIntangibleFY05(nf.parse(tfDepreciationIntangibleFY05.getText()).doubleValue());
						
			temporary.setInterestGainsPY03(nf.parse(tfInterestGainsPY03.getText()).doubleValue());
			temporary.setInterestGainsPY02(nf.parse(tfInterestGainsPY02.getText()).doubleValue());
			temporary.setInterestGainsPY01(nf.parse(tfInterestGainsPY01.getText()).doubleValue());
			temporary.setInterestGainsY00(nf.parse(tfInterestGainsY00.getText()).doubleValue());
			temporary.setInterestGainsFY01();
			temporary.setInterestGainsFY02();
			temporary.setInterestGainsFY03();
			temporary.setInterestGainsFY04();
			temporary.setInterestGainsFY05();
						
			temporary.setInterestLossPY03(nf.parse(tfInterestLossPY03.getText()).doubleValue());
			temporary.setInterestLossPY02(nf.parse(tfInterestLossPY02.getText()).doubleValue());
			temporary.setInterestLossPY01(nf.parse(tfInterestLossPY01.getText()).doubleValue());
			temporary.setInterestLossY00(nf.parse(tfInterestLossY00.getText()).doubleValue());
			temporary.setInterestLossFY01();
			temporary.setInterestLossFY02();
			temporary.setInterestLossFY03();
			temporary.setInterestLossFY04();
			temporary.setInterestLossFY05();
			
			temporary.setEbtPY03(nf.parse(tfEbtPY03.getText()).doubleValue());
			temporary.setEbtPY02(nf.parse(tfEbtPY02.getText()).doubleValue());
			temporary.setEbtPY01(nf.parse(tfEbtPY01.getText()).doubleValue());
			temporary.setEbtY00(nf.parse(tfEbtY00.getText()).doubleValue());
			temporary.setEbtFY01();
			temporary.setEbtFY02();
			temporary.setEbtFY03();
			temporary.setEbtFY04();
			temporary.setEbtFY05();

			temporary.setIncomeTaxPY03(nf.parse(tfIncomeTaxPY03.getText()).doubleValue());
			temporary.setIncomeTaxPY02(nf.parse(tfIncomeTaxPY02.getText()).doubleValue());
			temporary.setIncomeTaxPY01(nf.parse(tfIncomeTaxPY01.getText()).doubleValue());
			temporary.setIncomeTaxY00(nf.parse(tfIncomeTaxY00.getText()).doubleValue());
			temporary.setIncomeTaxFY01();
			temporary.setIncomeTaxFY02();
			temporary.setIncomeTaxFY03();
			temporary.setIncomeTaxFY04();
			temporary.setIncomeTaxFY05();
						
			temporary.setIncomeTaxFromEbtPY03();
			temporary.setIncomeTaxFromEbtPY02();
			temporary.setIncomeTaxFromEbtPY01();
			temporary.setIncomeTaxFromEbtY00();
			temporary.setIncomeTaxFromEbtFY01(nf.parse(tfIncomeTaxFromEbtFY01.getText()).doubleValue());
			temporary.setIncomeTaxFromEbtFY02(nf.parse(tfIncomeTaxFromEbtFY02.getText()).doubleValue());
			temporary.setIncomeTaxFromEbtFY03(nf.parse(tfIncomeTaxFromEbtFY03.getText()).doubleValue());
			temporary.setIncomeTaxFromEbtFY04(nf.parse(tfIncomeTaxFromEbtFY04.getText()).doubleValue());
			temporary.setIncomeTaxFromEbtFY05(nf.parse(tfIncomeTaxFromEbtFY05.getText()).doubleValue());

			temporary.setTotalIncomePY03(nf.parse(tfTotalIncomePY03.getText()).doubleValue());
			temporary.setTotalIncomePY02(nf.parse(tfTotalIncomePY02.getText()).doubleValue());
			temporary.setTotalIncomePY01(nf.parse(tfTotalIncomePY01.getText()).doubleValue());
			temporary.setTotalIncomeY00(nf.parse(tfTotalIncomeY00.getText()).doubleValue());
			temporary.setTotalIncomeFY01();
			temporary.setTotalIncomeFY02();
			temporary.setTotalIncomeFY03();
			temporary.setTotalIncomeFY04();
			temporary.setTotalIncomeFY05();
				
			//Finanzvermoegen und Aenderungen sowie Zinsen (Ausgabe in Guv) im Objekt setzen
			
			temporary.setFinAssetsPY03(nf.parse(tfFinancialAssetsPY03.getText()).doubleValue());
			temporary.setFinAssetsPY02(nf.parse(tfFinancialAssetsPY02.getText()).doubleValue());
			temporary.setFinAssetsPY01(nf.parse(tfFinancialAssetsPY01.getText()).doubleValue());
			temporary.setFinAssetsY00(nf.parse(tfFinancialAssetsY00.getText()).doubleValue());
			temporary.setFinAssetsFY01();
			temporary.setFinAssetsFY02();
			temporary.setFinAssetsFY03();
			temporary.setFinAssetsFY04();
			temporary.setFinAssetsFY05();
			
			temporary.setFinancialAssetsChangePY02();
			temporary.setFinancialAssetsChangePY01();
			temporary.setFinancialAssetsChangeY00();
			temporary.setFinancialAssetsChangeFY01(nf.parse(tfFinancialAssetsChangeFY01.getText()).doubleValue());
			temporary.setFinancialAssetsChangeFY02(nf.parse(tfFinancialAssetsChangeFY02.getText()).doubleValue());
			temporary.setFinancialAssetsChangeFY03(nf.parse(tfFinancialAssetsChangeFY03.getText()).doubleValue());
			temporary.setFinancialAssetsChangeFY04(nf.parse(tfFinancialAssetsChangeFY04.getText()).doubleValue());
			temporary.setFinancialAssetsChangeFY05(nf.parse(tfFinancialAssetsChangeFY05.getText()).doubleValue());

			temporary.setInterestGainsFromFinancialAssetsPY03();
			temporary.setInterestGainsFromFinancialAssetsPY02();
			temporary.setInterestGainsFromFinancialAssetsPY01();
			temporary.setInterestGainsFromFinancialAssetsY00();
			temporary.setInterestGainsFromFinancialAssetsFY01(nf.parse(tfInterestGainsFromFinancialAssetsFY01.getText()).doubleValue());
			temporary.setInterestGainsFromFinancialAssetsFY02(nf.parse(tfInterestGainsFromFinancialAssetsFY02.getText()).doubleValue());
			temporary.setInterestGainsFromFinancialAssetsFY03(nf.parse(tfInterestGainsFromFinancialAssetsFY03.getText()).doubleValue());
			temporary.setInterestGainsFromFinancialAssetsFY04(nf.parse(tfInterestGainsFromFinancialAssetsFY04.getText()).doubleValue());
			temporary.setInterestGainsFromFinancialAssetsFY05(nf.parse(tfInterestGainsFromFinancialAssetsFY05.getText()).doubleValue());
			
			//Sachanlagevermoegen und Aenderungen sowie Abschreibungen im Objekt setzen
			
			temporary.setPropAssetsPY03(nf.parse(tfPropertyAssetsPY03.getText()).doubleValue());
			temporary.setPropAssetsPY02(nf.parse(tfPropertyAssetsPY02.getText()).doubleValue());
			temporary.setPropAssetsPY01(nf.parse(tfPropertyAssetsPY01.getText()).doubleValue());
			temporary.setPropAssetsY00(nf.parse(tfPropertyAssetsY00.getText()).doubleValue());	
			temporary.setPropAssetsFY01();
			temporary.setPropAssetsFY02();
			temporary.setPropAssetsFY03();
			temporary.setPropAssetsFY04();
			temporary.setPropAssetsFY05();
			
			temporary.setPropertyAssetsChangePY02();
			temporary.setPropertyAssetsChangePY01();
			temporary.setPropertyAssetsChangeY00();
			temporary.setPropertyAssetsChangeFY01(nf.parse(tfPropertyAssetsChangeFY01.getText()).doubleValue());
			temporary.setPropertyAssetsChangeFY02(nf.parse(tfPropertyAssetsChangeFY02.getText()).doubleValue());	
			temporary.setPropertyAssetsChangeFY03(nf.parse(tfPropertyAssetsChangeFY03.getText()).doubleValue());	
			temporary.setPropertyAssetsChangeFY04(nf.parse(tfPropertyAssetsChangeFY04.getText()).doubleValue());	
			temporary.setPropertyAssetsChangeFY05(nf.parse(tfPropertyAssetsChangeFY05.getText()).doubleValue());	
			
			temporary.setDepreciationFromPropertyAssetsPY03();
			temporary.setDepreciationFromPropertyAssetsPY02();
			temporary.setDepreciationFromPropertyAssetsPY01();
			temporary.setDepreciationFromPropertyAssetsY00();
			temporary.setDepreciationFromPropertyAssetsFY01();
			temporary.setDepreciationFromPropertyAssetsFY02();
			temporary.setDepreciationFromPropertyAssetsFY03();
			temporary.setDepreciationFromPropertyAssetsFY04();
			temporary.setDepreciationFromPropertyAssetsFY05();
			
			//Immaterielles Vermoegen und Aenderungen sowie Abschreibungen im Objekt setzen
			
			temporary.setIntAssetsPY03(nf.parse(tfIntangibleAssetsPY03.getText()).doubleValue());
			temporary.setIntAssetsPY02(nf.parse(tfIntangibleAssetsPY02.getText()).doubleValue());
			temporary.setIntAssetsPY01(nf.parse(tfIntangibleAssetsPY01.getText()).doubleValue());
			temporary.setIntAssetsY00(nf.parse(tfIntangibleAssetsY00.getText()).doubleValue());
			temporary.setIntAssetsFY01();
			temporary.setIntAssetsFY02();
			temporary.setIntAssetsFY03();
			temporary.setIntAssetsFY04();
			temporary.setIntAssetsFY05();
			
			temporary.setIntangibleAssetsChangePY02();
			temporary.setIntangibleAssetsChangePY01();
			temporary.setIntangibleAssetsChangeY00();
			temporary.setIntangibleAssetsChangeFY01(nf.parse(tfIntangibleAssetsChangeFY01.getText()).doubleValue());
			temporary.setIntangibleAssetsChangeFY02(nf.parse(tfIntangibleAssetsChangeFY02.getText()).doubleValue());
			temporary.setIntangibleAssetsChangeFY03(nf.parse(tfIntangibleAssetsChangeFY03.getText()).doubleValue());
			temporary.setIntangibleAssetsChangeFY04(nf.parse(tfIntangibleAssetsChangeFY04.getText()).doubleValue());
			temporary.setIntangibleAssetsChangeFY05(nf.parse(tfIntangibleAssetsChangeFY05.getText()).doubleValue());

			temporary.setDepreciationFromIntangibleAssetsPY03();
			temporary.setDepreciationFromIntangibleAssetsPY02();
			temporary.setDepreciationFromIntangibleAssetsPY01();
			temporary.setDepreciationFromIntangibleAssetsY00();
			temporary.setDepreciationFromIntangibleAssetsFY01();
			temporary.setDepreciationFromIntangibleAssetsFY02();
			temporary.setDepreciationFromIntangibleAssetsFY03();
			temporary.setDepreciationFromIntangibleAssetsFY04();
			temporary.setDepreciationFromIntangibleAssetsFY05();
			
			// Sonstiges Anlagevermoegen und Aenderungen im Objekt setzen
			
			temporary.setOtherAssetsPY03(nf.parse(tfOtherAssetsPY03.getText()).doubleValue());
			temporary.setOtherAssetsPY02(nf.parse(tfOtherAssetsPY02.getText()).doubleValue());
			temporary.setOtherAssetsPY01(nf.parse(tfOtherAssetsPY01.getText()).doubleValue());
			temporary.setOtherAssetsY00(nf.parse(tfOtherAssetsY00.getText()).doubleValue());
			temporary.setOtherAssetsFY01();
			temporary.setOtherAssetsFY02();
			temporary.setOtherAssetsFY03();
			temporary.setOtherAssetsFY04();
			temporary.setOtherAssetsFY05();
			
			temporary.setOtherAssetsChangePY02();
			temporary.setOtherAssetsChangePY01();
			temporary.setOtherAssetsChangeY00();
			temporary.setOtherAssetsChangeFY01(nf.parse(tfOtherAssetsChangeFY01.getText()).doubleValue());
			temporary.setOtherAssetsChangeFY02(nf.parse(tfOtherAssetsChangeFY02.getText()).doubleValue());
			temporary.setOtherAssetsChangeFY03(nf.parse(tfOtherAssetsChangeFY03.getText()).doubleValue());
			temporary.setOtherAssetsChangeFY04(nf.parse(tfOtherAssetsChangeFY04.getText()).doubleValue());
			temporary.setOtherAssetsChangeFY05(nf.parse(tfOtherAssetsChangeFY05.getText()).doubleValue());

			//Summe des Anlagevermoegens im Objekt setzen 
			
			temporary.setAssetsPY03();
			temporary.setAssetsPY02();
			temporary.setAssetsPY01();
			temporary.setAssetsY00();
			temporary.setAssetsFY01();
			temporary.setAssetsFY02();
			temporary.setAssetsFY03();
			temporary.setAssetsFY04();
			temporary.setAssetsFY05();

			// Vorräte im Objekt setzen
			
			temporary.setInventoryPY03(nf.parse(tfInventoryPY03.getText()).doubleValue());
			temporary.setInventoryPY02(nf.parse(tfInventoryPY02.getText()).doubleValue());
			temporary.setInventoryPY01(nf.parse(tfInventoryPY01.getText()).doubleValue());
			temporary.setInventoryY00(nf.parse(tfInventoryY00.getText()).doubleValue());
			temporary.setInventoryFY01();
			temporary.setInventoryFY02();
			temporary.setInventoryFY03();
			temporary.setInventoryFY04();
			temporary.setInventoryFY05();
			
			temporary.setInventoryTurnoverPY03();
			temporary.setInventoryTurnoverPY02();
			temporary.setInventoryTurnoverPY01();
			temporary.setInventoryTurnoverY00();
			temporary.setInventoryTurnoverFY01(nf.parse(tfInventoryTurnoverFY01.getText()).doubleValue());
			temporary.setInventoryTurnoverFY02(nf.parse(tfInventoryTurnoverFY02.getText()).doubleValue());
			temporary.setInventoryTurnoverFY03(nf.parse(tfInventoryTurnoverFY03.getText()).doubleValue());
			temporary.setInventoryTurnoverFY04(nf.parse(tfInventoryTurnoverFY04.getText()).doubleValue());
			temporary.setInventoryTurnoverFY05(nf.parse(tfInventoryTurnoverFY05.getText()).doubleValue());

			//Forderungen im Objekt setzen
			
			temporary.setReceivablesPY03(nf.parse(tfReceivablesPY03.getText()).doubleValue());
			temporary.setReceivablesPY02(nf.parse(tfReceivablesPY02.getText()).doubleValue());
			temporary.setReceivablesPY01(nf.parse(tfReceivablesPY01.getText()).doubleValue());
			temporary.setReceivablesY00(nf.parse(tfReceivablesY00.getText()).doubleValue());
			temporary.setReceivablesFY01();
			temporary.setReceivablesFY02();
			temporary.setReceivablesFY03();
			temporary.setReceivablesFY04();
			temporary.setReceivablesFY05();
			
			temporary.setReceivablesTurnoverPY03();
			temporary.setReceivablesTurnoverPY02();
			temporary.setReceivablesTurnoverPY01();
			temporary.setReceivablesTurnoverY00();
			temporary.setReceivablesTurnoverFY01(nf.parse(tfReceivablesTurnoverFY01.getText()).doubleValue());
			temporary.setReceivablesTurnoverFY02(nf.parse(tfReceivablesTurnoverFY02.getText()).doubleValue());
			temporary.setReceivablesTurnoverFY03(nf.parse(tfReceivablesTurnoverFY03.getText()).doubleValue());
			temporary.setReceivablesTurnoverFY04(nf.parse(tfReceivablesTurnoverFY04.getText()).doubleValue());
			temporary.setReceivablesTurnoverFY05(nf.parse(tfReceivablesTurnoverFY05.getText()).doubleValue());
			
			//sonstiges Umlaufvermoegen im Objekt setzen
			
			temporary.setOtherNCAPY03(nf.parse(tfOtherNCAPY03.getText()).doubleValue());
			temporary.setOtherNCAPY02(nf.parse(tfOtherNCAPY02.getText()).doubleValue());
			temporary.setOtherNCAPY01(nf.parse(tfOtherNCAPY01.getText()).doubleValue());
			temporary.setOtherNCAY00(nf.parse(tfOtherNCAY00.getText()).doubleValue());
			temporary.setOtherNCAFY01();
			temporary.setOtherNCAFY02();
			temporary.setOtherNCAFY03();
			temporary.setOtherNCAFY04();
			temporary.setOtherNCAFY05();
			
			temporary.setOtherNCAFromNCAPY02();
			temporary.setOtherNCAFromNCAPY01();
			temporary.setOtherNCAFromNCAY00();
			temporary.setOtherNCAFromNCAFY01(nf.parse(tfOtherNCAFromNCAFY01.getText()).doubleValue());
			temporary.setOtherNCAFromNCAFY02(nf.parse(tfOtherNCAFromNCAFY02.getText()).doubleValue());
			temporary.setOtherNCAFromNCAFY03(nf.parse(tfOtherNCAFromNCAFY03.getText()).doubleValue());
			temporary.setOtherNCAFromNCAFY04(nf.parse(tfOtherNCAFromNCAFY04.getText()).doubleValue());
			temporary.setOtherNCAFromNCAFY05(nf.parse(tfOtherNCAFromNCAFY05.getText()).doubleValue());

			//Summe des Umlaufvermoegens im Objekt setzen 
			
			temporary.setNcaPY03();
			temporary.setNcaPY02();
			temporary.setNcaPY01();
			temporary.setNcaY00();
			temporary.setNcaFY01();
			temporary.setNcaFY02();
			temporary.setNcaFY03();
			temporary.setNcaFY04();
			temporary.setNcaFY05();

			//liquide Mittel im Objekt setzen 
			
			temporary.setCashPY03();
			temporary.setCashPY02();
			temporary.setCashPY01();
			temporary.setCashY00();
			temporary.setCashFY01();
			temporary.setCashFY02();
			temporary.setCashFY03();
			temporary.setCashFY04();
			temporary.setCashFY05();

			// Summe der Aktiva im Objekt setzen 
			
			temporary.setTotalAssetsPY03();
			temporary.setTotalAssetsPY02();
			temporary.setTotalAssetsPY01();
			temporary.setTotalAssetsY00();
			temporary.setTotalAssetsFY01();
			temporary.setTotalAssetsFY02();
			temporary.setTotalAssetsFY03();
			temporary.setTotalAssetsFY04();
			temporary.setTotalAssetsFY05();

			// Grundkapital und Veraenderung im Objekt setzen 
			
			temporary.setShareCapitalPY03(nf.parse(tfShareCapitalPY03.getText()).doubleValue());
			temporary.setShareCapitalPY02(nf.parse(tfShareCapitalPY02.getText()).doubleValue());
			temporary.setShareCapitalPY01(nf.parse(tfShareCapitalPY01.getText()).doubleValue());
			temporary.setShareCapitalY00(nf.parse(tfShareCapitalY00.getText()).doubleValue());
			temporary.setShareCapitalFY01();
			temporary.setShareCapitalFY02();
			temporary.setShareCapitalFY03();
			temporary.setShareCapitalFY04();
			temporary.setShareCapitalFY05();
			
			temporary.setShareCapitalChangePY02();
			temporary.setShareCapitalChangePY01();
			temporary.setShareCapitalChangeY00();
			temporary.setShareCapitalChangeFY01(nf.parse(tfShareCapitalChangeFY01.getText()).doubleValue());
			temporary.setShareCapitalChangeFY02(nf.parse(tfShareCapitalChangeFY02.getText()).doubleValue());
			temporary.setShareCapitalChangeFY03(nf.parse(tfShareCapitalChangeFY03.getText()).doubleValue());
			temporary.setShareCapitalChangeFY04(nf.parse(tfShareCapitalChangeFY04.getText()).doubleValue());
			temporary.setShareCapitalChangeFY05(nf.parse(tfShareCapitalChangeFY05.getText()).doubleValue());
			
			// Ruecklagen, Veraenderung und Gewinnausschuettungsquote (Ausgabe in GuV) im Objekt setzen
			
			temporary.setReservesPY03(nf.parse(tfReservesPY03.getText()).doubleValue());
			temporary.setReservesPY02(nf.parse(tfReservesPY02.getText()).doubleValue());
			temporary.setReservesPY01(nf.parse(tfReservesPY01.getText()).doubleValue());
			temporary.setReservesY00(nf.parse(tfReservesY00.getText()).doubleValue());
			temporary.setReservesFY01();
			temporary.setReservesFY02();
			temporary.setReservesFY03();
			temporary.setReservesFY04();
			temporary.setReservesFY05();
			
			temporary.setReservesChangePY02();
			temporary.setReservesChangePY01();
			temporary.setReservesChangeY00();
			temporary.setReservesChangeFY01();
			temporary.setReservesChangeFY02();
			temporary.setReservesChangeFY03();
			temporary.setReservesChangeFY04();
			temporary.setReservesChangeFY05();
			
			temporary.setDividendsPaidRatePY03();
			temporary.setDividendsPaidRatePY02();
			temporary.setDividendsPaidRatePY01();
			temporary.setDividendsPaidRateY00();
			temporary.setDividendsPaidRateFY01(nf.parse(tfDividendsPaidRateFY01.getText()).doubleValue());
			temporary.setDividendsPaidRateFY02(nf.parse(tfDividendsPaidRateFY02.getText()).doubleValue());
			temporary.setDividendsPaidRateFY03(nf.parse(tfDividendsPaidRateFY03.getText()).doubleValue());
			temporary.setDividendsPaidRateFY04(nf.parse(tfDividendsPaidRateFY04.getText()).doubleValue());
			temporary.setDividendsPaidRateFY05(nf.parse(tfDividendsPaidRateFY05.getText()).doubleValue());
			
			// Sonstiges Eigenkapital und Veraenderung im Objekt setzen 
			
			temporary.setOtherEquityPY03(nf.parse(tfOtherEquityPY03.getText()).doubleValue());
			temporary.setOtherEquityPY02(nf.parse(tfOtherEquityPY02.getText()).doubleValue());
			temporary.setOtherEquityPY01(nf.parse(tfOtherEquityPY01.getText()).doubleValue());
			temporary.setOtherEquityY00(nf.parse(tfOtherEquityY00.getText()).doubleValue());
			temporary.setOtherEquityFY01();
			temporary.setOtherEquityFY02();
			temporary.setOtherEquityFY03();
			temporary.setOtherEquityFY04();
			temporary.setOtherEquityFY05();
			
			temporary.setOtherEquityChangePY02();
			temporary.setOtherEquityChangePY01();
			temporary.setOtherEquityChangeY00();
			temporary.setOtherEquityChangeFY01(nf.parse(tfOtherEquityChangeFY01.getText()).doubleValue());
			temporary.setOtherEquityChangeFY02(nf.parse(tfOtherEquityChangeFY02.getText()).doubleValue());
			temporary.setOtherEquityChangeFY03(nf.parse(tfOtherEquityChangeFY03.getText()).doubleValue());
			temporary.setOtherEquityChangeFY04(nf.parse(tfOtherEquityChangeFY04.getText()).doubleValue());
			temporary.setOtherEquityChangeFY05(nf.parse(tfOtherEquityChangeFY05.getText()).doubleValue());

			//  Summe Eigenkapital im Objekt setzen 
			
			temporary.setTotalEquityPY03();
			temporary.setTotalEquityPY02();
			temporary.setTotalEquityPY01();
			temporary.setTotalEquityY00();
			temporary.setTotalEquityFY01();
			temporary.setTotalEquityFY02();
			temporary.setTotalEquityFY03();
			temporary.setTotalEquityFY04();
			temporary.setTotalEquityFY05();

			// Langfristiges Fremdkapital, Veraenderung und Zinsanteil (Ausgabe in GuV) im Objekt setzen 
			
			temporary.setLongTermBankDebtPY03(nf.parse(tfLongTermBankDebtPY03.getText()).doubleValue());
			temporary.setLongTermBankDebtPY02(nf.parse(tfLongTermBankDebtPY02.getText()).doubleValue());
			temporary.setLongTermBankDebtPY01(nf.parse(tfLongTermBankDebtPY01.getText()).doubleValue());
			temporary.setLongTermBankDebtY00(nf.parse(tfLongTermBankDebtY00.getText()).doubleValue());
			temporary.setLongTermBankDebtFY01();
			temporary.setLongTermBankDebtFY02();
			temporary.setLongTermBankDebtFY03();
			temporary.setLongTermBankDebtFY04();
			temporary.setLongTermBankDebtFY05();
			
			temporary.setLongTermBankDebtChangePY02();
			temporary.setLongTermBankDebtChangePY01();
			temporary.setLongTermBankDebtChangeY00();
			temporary.setLongTermBankDebtChangeFY01(nf.parse(tfLongTermBankDebtChangeFY01.getText()).doubleValue());
			temporary.setLongTermBankDebtChangeFY02(nf.parse(tfLongTermBankDebtChangeFY02.getText()).doubleValue());
			temporary.setLongTermBankDebtChangeFY03(nf.parse(tfLongTermBankDebtChangeFY03.getText()).doubleValue());
			temporary.setLongTermBankDebtChangeFY04(nf.parse(tfLongTermBankDebtChangeFY04.getText()).doubleValue());
			temporary.setLongTermBankDebtChangeFY05(nf.parse(tfLongTermBankDebtChangeFY05.getText()).doubleValue());

			temporary.setInterestLossFromBankDebtPY03();
			temporary.setInterestLossFromBankDebtPY02();
			temporary.setInterestLossFromBankDebtPY01();
			temporary.setInterestLossFromBankDebtY00();
			temporary.setInterestLossFromBankDebtFY01(nf.parse(tfInterestLossFromBankDebtFY01.getText()).doubleValue());
			temporary.setInterestLossFromBankDebtFY02(nf.parse(tfInterestLossFromBankDebtFY02.getText()).doubleValue());
			temporary.setInterestLossFromBankDebtFY03(nf.parse(tfInterestLossFromBankDebtFY03.getText()).doubleValue());
			temporary.setInterestLossFromBankDebtFY04(nf.parse(tfInterestLossFromBankDebtFY04.getText()).doubleValue());
			temporary.setInterestLossFromBankDebtFY05(nf.parse(tfInterestLossFromBankDebtFY05.getText()).doubleValue());
						
			//Rueckstellungen und Veraenderung im Objekt setzen 
						
			temporary.setAccrualsPY03(nf.parse(tfAccrualsPY03.getText()).doubleValue());
			temporary.setAccrualsPY02(nf.parse(tfAccrualsPY02.getText()).doubleValue());
			temporary.setAccrualsPY01(nf.parse(tfAccrualsPY01.getText()).doubleValue());
			temporary.setAccrualsY00(nf.parse(tfAccrualsY00.getText()).doubleValue());
			temporary.setAccrualsFY01();
			temporary.setAccrualsFY02();
			temporary.setAccrualsFY03();
			temporary.setAccrualsFY04();
			temporary.setAccrualsFY05();
			
			temporary.setAccrualsChangePY02();
			temporary.setAccrualsChangePY01();
			temporary.setAccrualsChangeY00();
			temporary.setAccrualsChangeFY01(nf.parse(tfAccrualsChangeFY01.getText()).doubleValue());
			temporary.setAccrualsChangeFY02(nf.parse(tfAccrualsChangeFY02.getText()).doubleValue());
			temporary.setAccrualsChangeFY03(nf.parse(tfAccrualsChangeFY03.getText()).doubleValue());
			temporary.setAccrualsChangeFY04(nf.parse(tfAccrualsChangeFY04.getText()).doubleValue());
			temporary.setAccrualsChangeFY05(nf.parse(tfAccrualsChangeFY05.getText()).doubleValue());
			
			//Summe der langfristigen Schulden im Objekt setzen 
			
			temporary.setTotalLongTermLiabilitiesPY03();
			temporary.setTotalLongTermLiabilitiesPY02();
			temporary.setTotalLongTermLiabilitiesPY01();
			temporary.setTotalLongTermLiabilitiesY00();
			temporary.setTotalLongTermLiabilitiesFY01();
			temporary.setTotalLongTermLiabilitiesFY02();
			temporary.setTotalLongTermLiabilitiesFY03();
			temporary.setTotalLongTermLiabilitiesFY04();
			temporary.setTotalLongTermLiabilitiesFY05();
			
			//kurzfristige Finanzverbindlichkeiten und Veraenderung im Objekt setzen 
			
			temporary.setShortTermBankDebtPY03(nf.parse(tfShortTermBankDebtPY03.getText()).doubleValue());
			temporary.setShortTermBankDebtPY02(nf.parse(tfShortTermBankDebtPY02.getText()).doubleValue());
			temporary.setShortTermBankDebtPY01(nf.parse(tfShortTermBankDebtPY01.getText()).doubleValue());
			temporary.setShortTermBankDebtY00(nf.parse(tfShortTermBankDebtY00.getText()).doubleValue());
			temporary.setShortTermBankDebtFY01();
			temporary.setShortTermBankDebtFY02();
			temporary.setShortTermBankDebtFY03();
			temporary.setShortTermBankDebtFY04();
			temporary.setShortTermBankDebtFY05();
			
			temporary.setShortTermBankDebtChangePY02();
			temporary.setShortTermBankDebtChangePY01();
			temporary.setShortTermBankDebtChangeY00();
			temporary.setShortTermBankDebtChangeFY01(nf.parse(tfShortTermBankDebtChangeFY01.getText()).doubleValue());
			temporary.setShortTermBankDebtChangeFY02(nf.parse(tfShortTermBankDebtChangeFY02.getText()).doubleValue());
			temporary.setShortTermBankDebtChangeFY03(nf.parse(tfShortTermBankDebtChangeFY03.getText()).doubleValue());
			temporary.setShortTermBankDebtChangeFY04(nf.parse(tfShortTermBankDebtChangeFY04.getText()).doubleValue());
			temporary.setShortTermBankDebtChangeFY05(nf.parse(tfShortTermBankDebtChangeFY05.getText()).doubleValue());

			//Verbindlichkeiten aus L.u.L und Veraenderung im Objekt setzen 
			
			temporary.setTradePayablesPY03(nf.parse(tfTradePayablesPY03.getText()).doubleValue());
			temporary.setTradePayablesPY02(nf.parse(tfTradePayablesPY02.getText()).doubleValue());
			temporary.setTradePayablesPY01(nf.parse(tfTradePayablesPY01.getText()).doubleValue());
			temporary.setTradePayablesY00(nf.parse(tfTradePayablesY00.getText()).doubleValue());
			temporary.setTradePayablesFY01();
			temporary.setTradePayablesFY02();
			temporary.setTradePayablesFY03();
			temporary.setTradePayablesFY04();
			temporary.setTradePayablesFY05();
			
			temporary.setDaysPayablesOutstandingPY03();
			temporary.setDaysPayablesOutstandingPY02();
			temporary.setDaysPayablesOutstandingPY01();
			temporary.setDaysPayablesOutstandingY00();
			temporary.setDaysPayablesOutstandingFY01(nf.parse(tfDaysPayablesOutstandingFY01.getText()).doubleValue());
			temporary.setDaysPayablesOutstandingFY02(nf.parse(tfDaysPayablesOutstandingFY02.getText()).doubleValue());
			temporary.setDaysPayablesOutstandingFY03(nf.parse(tfDaysPayablesOutstandingFY03.getText()).doubleValue());
			temporary.setDaysPayablesOutstandingFY04(nf.parse(tfDaysPayablesOutstandingFY04.getText()).doubleValue());
			temporary.setDaysPayablesOutstandingFY05(nf.parse(tfDaysPayablesOutstandingFY05.getText()).doubleValue());

			//sonstige kurzfr. Verbindlichkeiten und Veraenderung im Objekt setzen 
			
			temporary.setOtherShortTermLiabilitiesPY03(nf.parse(tfOtherShortTermLiabilitiesPY03.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesPY02(nf.parse(tfOtherShortTermLiabilitiesPY02.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesPY01(nf.parse(tfOtherShortTermLiabilitiesPY01.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesY00(nf.parse(tfOtherShortTermLiabilitiesY00.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesFY01();
			temporary.setOtherShortTermLiabilitiesFY02();
			temporary.setOtherShortTermLiabilitiesFY03();
			temporary.setOtherShortTermLiabilitiesFY04();
			temporary.setOtherShortTermLiabilitiesFY05();
			
			temporary.setOtherShortTermLiabilitiesChangePY02();
			temporary.setOtherShortTermLiabilitiesChangePY01();
			temporary.setOtherShortTermLiabilitiesChangeY00();
			temporary.setOtherShortTermLiabilitiesChangeFY01(nf.parse(tfOtherShortTermLiabilitiesChangeFY01.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesChangeFY02(nf.parse(tfOtherShortTermLiabilitiesChangeFY02.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesChangeFY03(nf.parse(tfOtherShortTermLiabilitiesChangeFY03.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesChangeFY04(nf.parse(tfOtherShortTermLiabilitiesChangeFY04.getText()).doubleValue());
			temporary.setOtherShortTermLiabilitiesChangeFY05(nf.parse(tfOtherShortTermLiabilitiesChangeFY05.getText()).doubleValue());
			
			// Summe der kurzfr. Verbindlichkeiten im Objekt setzen 
			
			temporary.setTotalShortTermLiabilitiesPY03();
			temporary.setTotalShortTermLiabilitiesPY02();
			temporary.setTotalShortTermLiabilitiesPY01();
			temporary.setTotalShortTermLiabilitiesY00();
			temporary.setTotalShortTermLiabilitiesFY01();
			temporary.setTotalShortTermLiabilitiesFY02();
			temporary.setTotalShortTermLiabilitiesFY03();
			temporary.setTotalShortTermLiabilitiesFY04();
			temporary.setTotalShortTermLiabilitiesFY05();

			// Summe der Passiva im Objekt setzen 
			
			temporary.setTotalLiabilitiesPY03();
			temporary.setTotalLiabilitiesPY02();
			temporary.setTotalLiabilitiesPY01();
			temporary.setTotalLiabilitiesY00();
			temporary.setTotalLiabilitiesFY01();
			temporary.setTotalLiabilitiesFY02();
			temporary.setTotalLiabilitiesFY03();
			temporary.setTotalLiabilitiesFY04();
			temporary.setTotalLiabilitiesFY05();
			
			//Zinssätze der CashFlow-Rechnung im Objekt setzen
			
			temporary.setRiskFreeInterestRate(nf.parse(tfRiskFreeInterestRate.getText()).doubleValue());
			temporary.setMarketRiskPremium(nf.parse(tfMarketRiskPremium.getText()).doubleValue());
			temporary.setGrowthRateEndValue(nf.parse(tfGrowthRateEndValue.getText()).doubleValue());
			
			//adjustierten Gewinn im Objekt setzen
			
			temporary.setCfTotalIncomeFY01();
			temporary.setCfTotalIncomeFY02();
			temporary.setCfTotalIncomeFY03();
			temporary.setCfTotalIncomeFY04();
			temporary.setCfTotalIncomeFY05();
			temporary.setCfTotalIncomeTV();
		
			
			//Terminal Value der Abschreibungen auf Sachanlagen im Objekt setzen
			
			temporary.setCfDepreciationTV();
			
			//Terminal Value der Abschreibungen auf immat. Vermoegen im Objekt setzen
			
			temporary.setCfDepreciationIntangibleTV();
			
			//Veraenderung der Rueckstellungen im Objekt setzen
			
			temporary.setCfAccrualsFY01();
			temporary.setCfAccrualsFY02();
			temporary.setCfAccrualsFY03();
			temporary.setCfAccrualsFY04();
			temporary.setCfAccrualsFY05();
			temporary.setCfAccrualsTV();
			
			//Investitionen in das Anlagevermoegen fuer die CashFlow-Rechnung im Objekt setzen
			
			temporary.setCfAssetsInvestFY01();
			temporary.setCfAssetsInvestFY02();
			temporary.setCfAssetsInvestFY03();
			temporary.setCfAssetsInvestFY04();
			temporary.setCfAssetsInvestFY05();
			temporary.setCfAssetsInvestTV();
			
			//Investitionen in das Working Capital fuer die CashFlow-Rechnung im Objekt setzen
			
			temporary.setCfWorkingCapitalInvestFY01();
			temporary.setCfWorkingCapitalInvestFY02();
			temporary.setCfWorkingCapitalInvestFY03();
			temporary.setCfWorkingCapitalInvestFY04();
			temporary.setCfWorkingCapitalInvestFY05();
			temporary.setCfWorkingCapitalInvestTV();
			
			//Veraenderung der zinstragenden Verbindlichkeiten fuer die CashFlow-Rechnung im Objekt setzen
			
			temporary.setCfDebtChangeFY01();
			temporary.setCfDebtChangeFY02();
			temporary.setCfDebtChangeFY03();
			temporary.setCfDebtChangeFY04();
			temporary.setCfDebtChangeFY05();
			temporary.setCfDebtChangeTV();
			
			//Cash Flows to Equity im Objekt setzen
			
			temporary.setCashflowToEquityFY01();
			temporary.setCashflowToEquityFY02();
			temporary.setCashflowToEquityFY03();
			temporary.setCashflowToEquityFY04();
			temporary.setCashflowToEquityFY05();
			temporary.setCashflowToEquityTV();
			
			//Discounted Cash Flows to Equity im Objekt setzen
			
			temporary.setDiscountedCashflowFY01();
			temporary.setDiscountedCashflowFY02();
			temporary.setDiscountedCashflowFY03();
			temporary.setDiscountedCashflowFY04();
			temporary.setDiscountedCashflowFY05();
			temporary.setDiscountedCashflowTV();
			
			//FairValues im Objekt setzen
			
			temporary.setFairValue();
			temporary.setFairValuePerShare();
			
//Zusaetzliche Werte fuer Grafiken im Objekt setzen
			
			//Verschuldungsgrad im Objekt setzen
			
			temporary.setLeveragePY03();
			temporary.setLeveragePY02();
			temporary.setLeveragePY01();
			temporary.setLeverageY00();
			temporary.setLeverageFY01();
			temporary.setLeverageFY02();
			temporary.setLeverageFY03();
			temporary.setLeverageFY04();
			temporary.setLeverageFY05();
			
			// Anlagenintensitaet im Objekt setzen
			
			temporary.setAssetIntensityPY03();
			temporary.setAssetIntensityPY02();
			temporary.setAssetIntensityPY01();
			temporary.setAssetIntensityY00();
			temporary.setAssetIntensityFY01();
			temporary.setAssetIntensityFY02();
			temporary.setAssetIntensityFY03();
			temporary.setAssetIntensityFY04();
			temporary.setAssetIntensityFY05();
			
			// Umlaufintensitaet im Objekt setzen
			
			temporary.setCirculatingIntensityPY03();
			temporary.setCirculatingIntensityPY02();
			temporary.setCirculatingIntensityPY01();
			temporary.setCirculatingIntensityY00();
			temporary.setCirculatingIntensityFY01();
			temporary.setCirculatingIntensityFY02();
			temporary.setCirculatingIntensityFY03();
			temporary.setCirculatingIntensityFY04();
			temporary.setCirculatingIntensityFY05();
			
			//Umsatzrendite im Objekt setzen
			
			temporary.setReturnOnSalesPY03();
			temporary.setReturnOnSalesPY02();
			temporary.setReturnOnSalesPY01();
			temporary.setReturnOnSalesY00();
			temporary.setReturnOnSalesFY01();
			temporary.setReturnOnSalesFY02();
			temporary.setReturnOnSalesFY03();
			temporary.setReturnOnSalesFY04();
			temporary.setReturnOnSalesFY05();
			
			//EBITDA Marge im Objekt setzen
			
			temporary.setReturnOnEBITDAPY03();
			temporary.setReturnOnEBITDAPY02();
			temporary.setReturnOnEBITDAPY01();
			temporary.setReturnOnEBITDAY00();
			temporary.setReturnOnEBITDAFY01();
			temporary.setReturnOnEBITDAFY02();
			temporary.setReturnOnEBITDAFY03();
			temporary.setReturnOnEBITDAFY04();
			temporary.setReturnOnEBITDAFY05();
			
			//Eigenkapitalrendite im Objekt setzen
			
			temporary.setReturnOnEquityPY03();
			temporary.setReturnOnEquityPY02();
			temporary.setReturnOnEquityPY01();
			temporary.setReturnOnEquityY00();
			temporary.setReturnOnEquityFY01();
			temporary.setReturnOnEquityFY02();
			temporary.setReturnOnEquityFY03();
			temporary.setReturnOnEquityFY04();
			temporary.setReturnOnEquityFY05();
			
			//Gesamtkapitalrendite im Objekt setzen
			
			temporary.setTotalReturnOnInvestPY03();
			temporary.setTotalReturnOnInvestPY02();
			temporary.setTotalReturnOnInvestPY01();
			temporary.setTotalReturnOnInvestY00();
			temporary.setTotalReturnOnInvestFY01();
			temporary.setTotalReturnOnInvestFY02();
			temporary.setTotalReturnOnInvestFY03();
			temporary.setTotalReturnOnInvestFY04();
			temporary.setTotalReturnOnInvestFY05();
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		}
		
			
	}
	
	public void DisplayAssetValues() {

		try {
			
						
			//Anzeigen des Titels und der Unternehmensgrunddaten
			
			setTitle("Finance Investigator" + " - " + temporary.getCompanyName());
			tfCompanyName.setText(temporary.getCompanyName());
			tfShareVolume.setText(String.format("%,.4f",temporary.getShareVolume()));
			tfCurrentSharePrice.setText(String.format("%,.2f",temporary.getCurrentSharePrice()));
			tfFairValueFromSharePrice.setText(String.format("%,.2f",temporary.getFairValueFromSharePrice()));
			
			
			tfDividendsPaidPY03.setText(String.format("%,.2f",temporary.getDividendsPaidPY03()));
			tfDividendsPaidPY02.setText(String.format("%,.2f",temporary.getDividendsPaidPY02()));
			tfDividendsPaidPY01.setText(String.format("%,.2f",temporary.getDividendsPaidPY01()));
			tfDividendsPaidY00.setText(String.format("%,.2f",temporary.getDividendsPaidY00()));
			
			//Anzeigen der geladenen Werte fuer die GuV
			
			tfRevenuePY03.setText(String.format("%,.2f", temporary.getRevenuePY03()));
			tfRevenuePY02.setText(String.format("%,.2f", temporary.getRevenuePY02()));
			tfRevenuePY01.setText(String.format("%,.2f", temporary.getRevenuePY01()));
			tfRevenueY00.setText(String.format("%,.2f", temporary.getRevenueY00()));
			tfRevenueFY01.setText(String.format("%,.2f", temporary.getRevenueFY01()));
			tfRevenueFY02.setText(String.format("%,.2f", temporary.getRevenueFY02()));
			tfRevenueFY03.setText(String.format("%,.2f", temporary.getRevenueFY03()));
			tfRevenueFY04.setText(String.format("%,.2f", temporary.getRevenueFY04()));
			tfRevenueFY05.setText(String.format("%,.2f", temporary.getRevenueFY05()));
			
			tfRevenueChangePY02.setText(String.format("%,.5f", temporary.getRevenueChangePY02()));
			tfRevenueChangePY01.setText(String.format("%,.5f", temporary.getRevenueChangePY01()));
			tfRevenueChangeY00.setText(String.format("%,.5f", temporary.getRevenueChangeY00()));
			tfRevenueChangeFY01.setText(String.format("%,.5f", temporary.getRevenueChangeFY01()));
			tfRevenueChangeFY02.setText(String.format("%,.5f", temporary.getRevenueChangeFY02()));
			tfRevenueChangeFY03.setText(String.format("%,.5f", temporary.getRevenueChangeFY03()));
			tfRevenueChangeFY04.setText(String.format("%,.5f", temporary.getRevenueChangeFY04()));
			tfRevenueChangeFY05.setText(String.format("%,.5f", temporary.getRevenueChangeFY05()));
			
			tfCogsPY03.setText(String.format("%,.2f", temporary.getCogsPY03()));
			tfCogsPY02.setText(String.format("%,.2f", temporary.getCogsPY02()));
			tfCogsPY01.setText(String.format("%,.2f", temporary.getCogsPY01()));
			tfCogsY00.setText(String.format("%,.2f", temporary.getCogsY00()));
			tfCogsFY01.setText(String.format("%,.2f", temporary.getCogsFY01()));
			tfCogsFY02.setText(String.format("%,.2f", temporary.getCogsFY02()));
			tfCogsFY03.setText(String.format("%,.2f", temporary.getCogsFY03()));
			tfCogsFY04.setText(String.format("%,.2f", temporary.getCogsFY04()));
			tfCogsFY05.setText(String.format("%,.2f", temporary.getCogsFY05()));
			
			tfCogsFromRevenuePY03.setText(String.format("%,.5f", temporary.getCogsFromRevenuePY03()));
			tfCogsFromRevenuePY02.setText(String.format("%,.5f", temporary.getCogsFromRevenuePY02()));
			tfCogsFromRevenuePY01.setText(String.format("%,.5f", temporary.getCogsFromRevenuePY01()));
			tfCogsFromRevenueY00.setText(String.format("%,.5f", temporary.getCogsFromRevenueY00()));
			tfCogsFromRevenueFY01.setText(String.format("%,.5f", temporary.getCogsFromRevenueFY01()));
			tfCogsFromRevenueFY02.setText(String.format("%,.5f", temporary.getCogsFromRevenueFY02()));
			tfCogsFromRevenueFY03.setText(String.format("%,.5f", temporary.getCogsFromRevenueFY03()));
			tfCogsFromRevenueFY04.setText(String.format("%,.5f", temporary.getCogsFromRevenueFY04()));
			tfCogsFromRevenueFY05.setText(String.format("%,.5f", temporary.getCogsFromRevenueFY05()));
			
			tfOtherCostsPY03.setText(String.format("%,.2f", temporary.getOtherCostsPY03()));
			tfOtherCostsPY02.setText(String.format("%,.2f", temporary.getOtherCostsPY02()));
			tfOtherCostsPY01.setText(String.format("%,.2f", temporary.getOtherCostsPY01()));
			tfOtherCostsY00.setText(String.format("%,.2f", temporary.getOtherCostsY00()));
			tfOtherCostsFY01.setText(String.format("%,.2f", temporary.getOtherCostsFY01()));
			tfOtherCostsFY02.setText(String.format("%,.2f", temporary.getOtherCostsFY02()));
			tfOtherCostsFY03.setText(String.format("%,.2f", temporary.getOtherCostsFY03()));
			tfOtherCostsFY04.setText(String.format("%,.2f", temporary.getOtherCostsFY04()));
			tfOtherCostsFY05.setText(String.format("%,.2f", temporary.getOtherCostsFY05()));
			
			tfOtherCostsFromRevenuePY03.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenuePY03()));
			tfOtherCostsFromRevenuePY02.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenuePY02()));
			tfOtherCostsFromRevenuePY01.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenuePY01()));
			tfOtherCostsFromRevenueY00.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueY00()));
			tfOtherCostsFromRevenueFY01.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueFY01()));
			tfOtherCostsFromRevenueFY02.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueFY02()));
			tfOtherCostsFromRevenueFY03.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueFY03()));
			tfOtherCostsFromRevenueFY04.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueFY04()));
			tfOtherCostsFromRevenueFY05.setText(String.format("%,.5f", temporary.getOtherCostsFromRevenueFY05()));
			
			tfEbitdaPY03.setText(String.format("%,.2f", temporary.getEbitdaPY03()));
			tfEbitdaPY02.setText(String.format("%,.2f", temporary.getEbitdaPY02()));
			tfEbitdaPY01.setText(String.format("%,.2f", temporary.getEbitdaPY01()));
			tfEbitdaY00.setText(String.format("%,.2f", temporary.getEbitdaY00()));
			tfEbitdaFY01.setText(String.format("%,.2f", temporary.getEbitdaFY01()));
			tfEbitdaFY02.setText(String.format("%,.2f", temporary.getEbitdaFY02()));
			tfEbitdaFY03.setText(String.format("%,.2f", temporary.getEbitdaFY03()));
			tfEbitdaFY04.setText(String.format("%,.2f", temporary.getEbitdaFY04()));
			tfEbitdaFY05.setText(String.format("%,.2f", temporary.getEbitdaFY05()));
			
			tfEbitdaFromRevenuePY03.setText(String.format("%,.5f", temporary.getEbitdaFromRevenuePY03()));
			tfEbitdaFromRevenuePY02.setText(String.format("%,.5f", temporary.getEbitdaFromRevenuePY02()));
			tfEbitdaFromRevenuePY01.setText(String.format("%,.5f", temporary.getEbitdaFromRevenuePY01()));
			tfEbitdaFromRevenueY00.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueY00()));
			tfEbitdaFromRevenueFY01.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueFY01()));
			tfEbitdaFromRevenueFY02.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueFY02()));
			tfEbitdaFromRevenueFY03.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueFY03()));
			tfEbitdaFromRevenueFY04.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueFY04()));
			tfEbitdaFromRevenueFY05.setText(String.format("%,.5f", temporary.getEbitdaFromRevenueFY05()));
			
			tfDepreciationPY03.setText(String.format("%,.2f", temporary.getDepreciationPY03()));
			tfDepreciationPY02.setText(String.format("%,.2f", temporary.getDepreciationPY02()));
			tfDepreciationPY01.setText(String.format("%,.2f", temporary.getDepreciationPY01()));
			tfDepreciationY00.setText(String.format("%,.2f", temporary.getDepreciationY00()));
			tfDepreciationFY01.setText(String.format("%,.2f", temporary.getDepreciationFY01()));
			tfDepreciationFY02.setText(String.format("%,.2f", temporary.getDepreciationFY02()));
			tfDepreciationFY03.setText(String.format("%,.2f", temporary.getDepreciationFY03()));
			tfDepreciationFY04.setText(String.format("%,.2f", temporary.getDepreciationFY04()));
			tfDepreciationFY05.setText(String.format("%,.2f", temporary.getDepreciationFY05()));
			
			tfDepreciationIntangiblePY03.setText(String.format("%,.2f", temporary.getDepreciationIntangiblePY03()));
			tfDepreciationIntangiblePY02.setText(String.format("%,.2f", temporary.getDepreciationIntangiblePY02()));
			tfDepreciationIntangiblePY01.setText(String.format("%,.2f", temporary.getDepreciationIntangiblePY01()));
			tfDepreciationIntangibleY00.setText(String.format("%,.2f", temporary.getDepreciationIntangibleY00()));
			tfDepreciationIntangibleFY01.setText(String.format("%,.2f", temporary.getDepreciationIntangibleFY01()));
			tfDepreciationIntangibleFY02.setText(String.format("%,.2f", temporary.getDepreciationIntangibleFY02()));
			tfDepreciationIntangibleFY03.setText(String.format("%,.2f", temporary.getDepreciationIntangibleFY03()));
			tfDepreciationIntangibleFY04.setText(String.format("%,.2f", temporary.getDepreciationIntangibleFY04()));
			tfDepreciationIntangibleFY05.setText(String.format("%,.2f", temporary.getDepreciationIntangibleFY05()));
						
			tfInterestGainsPY03.setText(String.format("%,.2f", temporary.getInterestGainsPY03()));
			tfInterestGainsPY02.setText(String.format("%,.2f", temporary.getInterestGainsPY02()));
			tfInterestGainsPY01.setText(String.format("%,.2f", temporary.getInterestGainsPY01()));
			tfInterestGainsY00.setText(String.format("%,.2f", temporary.getInterestGainsY00()));
			tfInterestGainsFY01.setText(String.format("%,.2f", temporary.getInterestGainsFY01()));
			tfInterestGainsFY02.setText(String.format("%,.2f", temporary.getInterestGainsFY02()));
			tfInterestGainsFY03.setText(String.format("%,.2f", temporary.getInterestGainsFY03()));
			tfInterestGainsFY04.setText(String.format("%,.2f", temporary.getInterestGainsFY04()));
			tfInterestGainsFY05.setText(String.format("%,.2f", temporary.getInterestGainsFY05()));
			
			tfInterestLossPY03.setText(String.format("%,.2f", temporary.getInterestLossPY03()));
			tfInterestLossPY02.setText(String.format("%,.2f", temporary.getInterestLossPY02()));
			tfInterestLossPY01.setText(String.format("%,.2f", temporary.getInterestLossPY01()));
			tfInterestLossY00.setText(String.format("%,.2f", temporary.getInterestLossY00()));
			tfInterestLossFY01.setText(String.format("%,.2f", temporary.getInterestLossFY01()));
			tfInterestLossFY02.setText(String.format("%,.2f", temporary.getInterestLossFY02()));
			tfInterestLossFY03.setText(String.format("%,.2f", temporary.getInterestLossFY03()));
			tfInterestLossFY04.setText(String.format("%,.2f", temporary.getInterestLossFY04()));
			tfInterestLossFY05.setText(String.format("%,.2f", temporary.getInterestLossFY05()));
			
			tfEbtPY03.setText(String.format("%,.2f", temporary.getEbtPY03()));
			tfEbtPY02.setText(String.format("%,.2f", temporary.getEbtPY02()));
			tfEbtPY01.setText(String.format("%,.2f", temporary.getEbtPY01()));
			tfEbtY00.setText(String.format("%,.2f", temporary.getEbtY00()));
			tfEbtFY01.setText(String.format("%,.2f", temporary.getEbtFY01()));
			tfEbtFY02.setText(String.format("%,.2f", temporary.getEbtFY02()));
			tfEbtFY03.setText(String.format("%,.2f", temporary.getEbtFY03()));
			tfEbtFY04.setText(String.format("%,.2f", temporary.getEbtFY04()));
			tfEbtFY05.setText(String.format("%,.2f", temporary.getEbtFY05()));
			
			tfIncomeTaxPY03.setText(String.format("%,.2f", temporary.getIncomeTaxPY03()));
			tfIncomeTaxPY02.setText(String.format("%,.2f", temporary.getIncomeTaxPY02()));
			tfIncomeTaxPY01.setText(String.format("%,.2f", temporary.getIncomeTaxPY01()));
			tfIncomeTaxY00.setText(String.format("%,.2f", temporary.getIncomeTaxY00()));
			tfIncomeTaxFY01.setText(String.format("%,.2f", temporary.getIncomeTaxFY01()));
			tfIncomeTaxFY02.setText(String.format("%,.2f", temporary.getIncomeTaxFY02()));
			tfIncomeTaxFY03.setText(String.format("%,.2f", temporary.getIncomeTaxFY03()));
			tfIncomeTaxFY04.setText(String.format("%,.2f", temporary.getIncomeTaxFY04()));
			tfIncomeTaxFY05.setText(String.format("%,.2f", temporary.getIncomeTaxFY05()));
			
			tfIncomeTaxFromEbtPY03.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtPY03()));
			tfIncomeTaxFromEbtPY02.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtPY02()));
			tfIncomeTaxFromEbtPY01.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtPY01()));
			tfIncomeTaxFromEbtY00.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtY00()));
			tfIncomeTaxFromEbtFY01.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtFY01()));
			tfIncomeTaxFromEbtFY02.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtFY02()));
			tfIncomeTaxFromEbtFY03.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtFY03()));
			tfIncomeTaxFromEbtFY04.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtFY04()));
			tfIncomeTaxFromEbtFY05.setText(String.format("%,.5f", temporary.getIncomeTaxFromEbtFY05()));
			
			tfTotalIncomePY03.setText(String.format("%,.2f", temporary.getTotalIncomePY03()));
			tfTotalIncomePY02.setText(String.format("%,.2f", temporary.getTotalIncomePY02()));
			tfTotalIncomePY01.setText(String.format("%,.2f", temporary.getTotalIncomePY01()));
			tfTotalIncomeY00.setText(String.format("%,.2f", temporary.getTotalIncomeY00()));
			tfTotalIncomeFY01.setText(String.format("%,.2f", temporary.getTotalIncomeFY01()));
			tfTotalIncomeFY02.setText(String.format("%,.2f", temporary.getTotalIncomeFY02()));
			tfTotalIncomeFY03.setText(String.format("%,.2f", temporary.getTotalIncomeFY03()));
			tfTotalIncomeFY04.setText(String.format("%,.2f", temporary.getTotalIncomeFY04()));
			tfTotalIncomeFY05.setText(String.format("%,.2f", temporary.getTotalIncomeFY05()));
			
			//Anzeigen der geladenen Werte fuer das Finanzanlagevermoegen
			
			tfFinancialAssetsPY03.setText(String.format("%,.2f",temporary.getFinAssetsPY03()));
			tfFinancialAssetsPY02.setText(String.format("%,.2f",temporary.getFinAssetsPY02()));
			tfFinancialAssetsPY01.setText(String.format("%,.2f",temporary.getFinAssetsPY01()));
			tfFinancialAssetsY00.setText(String.format("%,.2f",temporary.getFinAssetsY00()));
			tfFinancialAssetsFY01.setText(String.format("%,.2f",temporary.getFinAssetsFY01()));
			tfFinancialAssetsFY02.setText(String.format("%,.2f",temporary.getFinAssetsFY02()));
			tfFinancialAssetsFY03.setText(String.format("%,.2f",temporary.getFinAssetsFY03()));
			tfFinancialAssetsFY04.setText(String.format("%,.2f",temporary.getFinAssetsFY04()));
			tfFinancialAssetsFY05.setText(String.format("%,.2f",temporary.getFinAssetsFY05()));
			
			tfFinancialAssetsChangePY02.setText(String.format("%,.2f", temporary.getFinancialAssetsChangePY02()));
			tfFinancialAssetsChangePY01.setText(String.format("%,.2f", temporary.getFinancialAssetsChangePY01()));
			tfFinancialAssetsChangeY00.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeY00()));
			tfFinancialAssetsChangeFY01.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeFY01()));
			tfFinancialAssetsChangeFY02.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeFY02()));
			tfFinancialAssetsChangeFY03.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeFY03()));
			tfFinancialAssetsChangeFY04.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeFY04()));
			tfFinancialAssetsChangeFY05.setText(String.format("%,.2f", temporary.getFinancialAssetsChangeFY05()));
					
			tfInterestGainsFromFinancialAssetsPY03.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsPY03()));
			tfInterestGainsFromFinancialAssetsPY02.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsPY02()));
			tfInterestGainsFromFinancialAssetsPY01.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsPY01()));
			tfInterestGainsFromFinancialAssetsY00.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsY00()));
			tfInterestGainsFromFinancialAssetsFY01.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsFY01()));
			tfInterestGainsFromFinancialAssetsFY02.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsFY02()));
			tfInterestGainsFromFinancialAssetsFY03.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsFY03()));
			tfInterestGainsFromFinancialAssetsFY04.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsFY04()));
			tfInterestGainsFromFinancialAssetsFY05.setText(String.format("%,.5f", temporary.getInterestGainsFromFinancialAssetsFY05()));
			
			//Anzeigen der geladenen Werte fuer das Sachanlagevermoegen
			
			tfPropertyAssetsPY03.setText(String.format("%,.2f",temporary.getPropAssetsPY03()));
			tfPropertyAssetsPY02.setText(String.format("%,.2f",temporary.getPropAssetsPY02()));
			tfPropertyAssetsPY01.setText(String.format("%,.2f",temporary.getPropAssetsPY01()));
			tfPropertyAssetsY00.setText(String.format("%,.2f",temporary.getPropAssetsY00()));
			tfPropertyAssetsFY01.setText(String.format("%,.2f",temporary.getPropAssetsFY01()));
			tfPropertyAssetsFY02.setText(String.format("%,.2f",temporary.getPropAssetsFY02()));
			tfPropertyAssetsFY03.setText(String.format("%,.2f",temporary.getPropAssetsFY03()));
			tfPropertyAssetsFY04.setText(String.format("%,.2f",temporary.getPropAssetsFY04()));
			tfPropertyAssetsFY05.setText(String.format("%,.2f",temporary.getPropAssetsFY05()));
			
			tfPropertyAssetsChangePY02.setText(String.format("%,.2f", temporary.getPropertyAssetsChangePY02()));
			tfPropertyAssetsChangePY01.setText(String.format("%,.2f", temporary.getPropertyAssetsChangePY01()));
			tfPropertyAssetsChangeY00.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeY00()));
			tfPropertyAssetsChangeFY01.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeFY01()));
			tfPropertyAssetsChangeFY02.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeFY02()));
			tfPropertyAssetsChangeFY03.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeFY03()));
			tfPropertyAssetsChangeFY04.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeFY04()));
			tfPropertyAssetsChangeFY05.setText(String.format("%,.2f", temporary.getPropertyAssetsChangeFY05()));
						
			tfDepreciationFromPropertyAssetsPY03.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsPY03()));
			tfDepreciationFromPropertyAssetsPY02.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsPY02()));
			tfDepreciationFromPropertyAssetsPY01.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsPY01()));
			tfDepreciationFromPropertyAssetsY00.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsY00()));
			tfDepreciationFromPropertyAssetsFY01.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsFY01()));
			tfDepreciationFromPropertyAssetsFY02.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsFY02()));
			tfDepreciationFromPropertyAssetsFY03.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsFY03()));
			tfDepreciationFromPropertyAssetsFY04.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsFY04()));
			tfDepreciationFromPropertyAssetsFY05.setText(String.format("%,.5f", temporary.getDepreciationFromPropertyAssetsFY05()));
			
			//Anzeigen der geladenen Werte fuer das immaterielle Vermoegen
			
			tfIntangibleAssetsPY03.setText(String.format("%,.2f",temporary.getIntAssetsPY03()));
			tfIntangibleAssetsPY02.setText(String.format("%,.2f",temporary.getIntAssetsPY02()));
			tfIntangibleAssetsPY01.setText(String.format("%,.2f",temporary.getIntAssetsPY01()));
			tfIntangibleAssetsY00.setText(String.format("%,.2f",temporary.getIntAssetsY00()));
			tfIntangibleAssetsFY01.setText(String.format("%,.2f",temporary.getIntAssetsFY01()));
			tfIntangibleAssetsFY02.setText(String.format("%,.2f",temporary.getIntAssetsFY02()));
			tfIntangibleAssetsFY03.setText(String.format("%,.2f",temporary.getIntAssetsFY03()));
			tfIntangibleAssetsFY04.setText(String.format("%,.2f",temporary.getIntAssetsFY04()));
			tfIntangibleAssetsFY05.setText(String.format("%,.2f",temporary.getIntAssetsFY05()));
			
			tfIntangibleAssetsChangePY02.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangePY02()));
			tfIntangibleAssetsChangePY01.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangePY01()));
			tfIntangibleAssetsChangeY00.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeY00()));
			tfIntangibleAssetsChangeFY01.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeFY01()));
			tfIntangibleAssetsChangeFY02.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeFY02()));
			tfIntangibleAssetsChangeFY03.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeFY03()));
			tfIntangibleAssetsChangeFY04.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeFY04()));
			tfIntangibleAssetsChangeFY05.setText(String.format("%,.2f", temporary.getIntangibleAssetsChangeFY05()));
			
			tfDepreciationFromIntangibleAssetsPY03.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsPY03()));
			tfDepreciationFromIntangibleAssetsPY02.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsPY02()));
			tfDepreciationFromIntangibleAssetsPY01.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsPY01()));
			tfDepreciationFromIntangibleAssetsY00.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsY00()));
			tfDepreciationFromIntangibleAssetsFY01.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsFY01()));
			tfDepreciationFromIntangibleAssetsFY02.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsFY02()));
			tfDepreciationFromIntangibleAssetsFY03.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsFY03()));
			tfDepreciationFromIntangibleAssetsFY04.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsFY04()));
			tfDepreciationFromIntangibleAssetsFY05.setText(String.format("%,.5f", temporary.getDepreciationFromIntangibleAssetsFY05()));
			
			//Anzeigen der geladenen Werte fuer das sonstige Anlagevermoegen
			
			tfOtherAssetsPY03.setText(String.format("%,.2f",temporary.getOtherAssetsPY03()));
			tfOtherAssetsPY02.setText(String.format("%,.2f",temporary.getOtherAssetsPY02()));
			tfOtherAssetsPY01.setText(String.format("%,.2f",temporary.getOtherAssetsPY01()));
			tfOtherAssetsY00.setText(String.format("%,.2f",temporary.getOtherAssetsY00()));
			tfOtherAssetsFY01.setText(String.format("%,.2f",temporary.getOtherAssetsFY01()));
			tfOtherAssetsFY02.setText(String.format("%,.2f",temporary.getOtherAssetsFY02()));
			tfOtherAssetsFY03.setText(String.format("%,.2f",temporary.getOtherAssetsFY03()));
			tfOtherAssetsFY04.setText(String.format("%,.2f",temporary.getOtherAssetsFY04()));
			tfOtherAssetsFY05.setText(String.format("%,.2f",temporary.getOtherAssetsFY05()));
			
			tfOtherAssetsChangePY02.setText(String.format("%,.2f", temporary.getOtherAssetsChangePY02()));
			tfOtherAssetsChangePY01.setText(String.format("%,.2f", temporary.getOtherAssetsChangePY01()));
			tfOtherAssetsChangeY00.setText(String.format("%,.2f", temporary.getOtherAssetsChangeY00()));
			tfOtherAssetsChangeFY01.setText(String.format("%,.2f", temporary.getOtherAssetsChangeFY01()));
			tfOtherAssetsChangeFY02.setText(String.format("%,.2f", temporary.getOtherAssetsChangeFY02()));
			tfOtherAssetsChangeFY03.setText(String.format("%,.2f", temporary.getOtherAssetsChangeFY03()));
			tfOtherAssetsChangeFY04.setText(String.format("%,.2f", temporary.getOtherAssetsChangeFY04()));
			tfOtherAssetsChangeFY05.setText(String.format("%,.2f", temporary.getOtherAssetsChangeFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe des Anlagevermoegens
			
			tfAssetsPY03.setText(String.format("%,.2f",temporary.getAssetsPY03()));
			tfAssetsPY02.setText(String.format("%,.2f",temporary.getAssetsPY02()));
			tfAssetsPY01.setText(String.format("%,.2f",temporary.getAssetsPY01()));
			tfAssetsY00.setText(String.format("%,.2f",temporary.getAssetsY00()));
			tfAssetsFY01.setText(String.format("%,.2f",temporary.getAssetsFY01()));
			tfAssetsFY02.setText(String.format("%,.2f",temporary.getAssetsFY02()));
			tfAssetsFY03.setText(String.format("%,.2f",temporary.getAssetsFY03()));
			tfAssetsFY04.setText(String.format("%,.2f",temporary.getAssetsFY04()));
			tfAssetsFY05.setText(String.format("%,.2f",temporary.getAssetsFY05()));		
			
			//Anzeigen der geladenen Werte fuer die Vorraete
			
			tfInventoryPY03.setText(String.format("%,.2f",temporary.getInventoryPY03()));
			tfInventoryPY02.setText(String.format("%,.2f",temporary.getInventoryPY02()));
			tfInventoryPY01.setText(String.format("%,.2f",temporary.getInventoryPY01()));
			tfInventoryY00.setText(String.format("%,.2f",temporary.getInventoryY00()));
			tfInventoryFY01.setText(String.format("%,.2f",temporary.getInventoryFY01()));
			tfInventoryFY02.setText(String.format("%,.2f",temporary.getInventoryFY02()));
			tfInventoryFY03.setText(String.format("%,.2f",temporary.getInventoryFY03()));
			tfInventoryFY04.setText(String.format("%,.2f",temporary.getInventoryFY04()));
			tfInventoryFY05.setText(String.format("%,.2f",temporary.getInventoryFY05()));
			
			tfInventoryTurnoverPY03.setText(String.format("%,.5f",temporary.getInventoryTurnoverPY03()));
			tfInventoryTurnoverPY02.setText(String.format("%,.5f",temporary.getInventoryTurnoverPY02()));
			tfInventoryTurnoverPY01.setText(String.format("%,.5f",temporary.getInventoryTurnoverPY01()));
			tfInventoryTurnoverY00.setText(String.format("%,.5f",temporary.getInventoryTurnoverY00()));
			tfInventoryTurnoverFY01.setText(String.format("%,.5f",temporary.getInventoryTurnoverFY01()));
			tfInventoryTurnoverFY02.setText(String.format("%,.5f",temporary.getInventoryTurnoverFY02()));
			tfInventoryTurnoverFY03.setText(String.format("%,.5f",temporary.getInventoryTurnoverFY03()));
			tfInventoryTurnoverFY04.setText(String.format("%,.5f",temporary.getInventoryTurnoverFY04()));
			tfInventoryTurnoverFY05.setText(String.format("%,.5f",temporary.getInventoryTurnoverFY05()));
			
			//Anzeigen der geladenen Werte fuer die Forderungen
			
			tfReceivablesPY03.setText(String.format("%,.2f",temporary.getReceivablesPY03()));
			tfReceivablesPY02.setText(String.format("%,.2f",temporary.getReceivablesPY02()));
			tfReceivablesPY01.setText(String.format("%,.2f",temporary.getReceivablesPY01()));
			tfReceivablesY00.setText(String.format("%,.2f",temporary.getReceivablesY00()));
			tfReceivablesFY01.setText(String.format("%,.2f",temporary.getReceivablesFY01()));
			tfReceivablesFY02.setText(String.format("%,.2f",temporary.getReceivablesFY02()));
			tfReceivablesFY03.setText(String.format("%,.2f",temporary.getReceivablesFY03()));
			tfReceivablesFY04.setText(String.format("%,.2f",temporary.getReceivablesFY04()));
			tfReceivablesFY05.setText(String.format("%,.2f",temporary.getReceivablesFY05()));
			
			tfReceivablesTurnoverPY03.setText(String.format("%,.5f",temporary.getReceivablesTurnoverPY03()));
			tfReceivablesTurnoverPY02.setText(String.format("%,.5f",temporary.getReceivablesTurnoverPY02()));
			tfReceivablesTurnoverPY01.setText(String.format("%,.5f",temporary.getReceivablesTurnoverPY01()));
			tfReceivablesTurnoverY00.setText(String.format("%,.5f",temporary.getReceivablesTurnoverY00()));
			tfReceivablesTurnoverFY01.setText(String.format("%,.5f",temporary.getReceivablesTurnoverFY01()));
			tfReceivablesTurnoverFY02.setText(String.format("%,.5f",temporary.getReceivablesTurnoverFY02()));
			tfReceivablesTurnoverFY03.setText(String.format("%,.5f",temporary.getReceivablesTurnoverFY03()));
			tfReceivablesTurnoverFY04.setText(String.format("%,.5f",temporary.getReceivablesTurnoverFY04()));
			tfReceivablesTurnoverFY05.setText(String.format("%,.5f",temporary.getReceivablesTurnoverFY05()));
			
			//Anzeigen der geladenen Werte fuer sonstiges Umlaufvermoegen
			
			tfOtherNCAPY03.setText(String.format("%,.2f",temporary.getOtherNCAPY03()));
			tfOtherNCAPY02.setText(String.format("%,.2f",temporary.getOtherNCAPY02()));
			tfOtherNCAPY01.setText(String.format("%,.2f",temporary.getOtherNCAPY01()));
			tfOtherNCAY00.setText(String.format("%,.2f",temporary.getOtherNCAY00()));
			tfOtherNCAFY01.setText(String.format("%,.2f",temporary.getOtherNCAFY01()));
			tfOtherNCAFY02.setText(String.format("%,.2f",temporary.getOtherNCAFY02()));
			tfOtherNCAFY03.setText(String.format("%,.2f",temporary.getOtherNCAFY03()));
			tfOtherNCAFY04.setText(String.format("%,.2f",temporary.getOtherNCAFY04()));
			tfOtherNCAFY05.setText(String.format("%,.2f",temporary.getOtherNCAFY05()));
			
			tfOtherNCAFromNCAPY02.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAPY02()));
			tfOtherNCAFromNCAPY01.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAPY01()));
			tfOtherNCAFromNCAY00.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAY00()));
			tfOtherNCAFromNCAFY01.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAFY01()));
			tfOtherNCAFromNCAFY02.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAFY02()));
			tfOtherNCAFromNCAFY03.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAFY03()));
			tfOtherNCAFromNCAFY04.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAFY04()));
			tfOtherNCAFromNCAFY05.setText(String.format("%,.2f",temporary.getOtherNCAFromNCAFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe des Umlaufvermoegens
			
			tfNCAPY03.setText(String.format("%,.2f",temporary.getNcaPY03()));
			tfNCAPY02.setText(String.format("%,.2f",temporary.getNcaPY02()));
			tfNCAPY01.setText(String.format("%,.2f",temporary.getNcaPY01()));
			tfNCAY00.setText(String.format("%,.2f",temporary.getNcaY00()));
			tfNCAFY01.setText(String.format("%,.2f",temporary.getNcaFY01()));
			tfNCAFY02.setText(String.format("%,.2f",temporary.getNcaFY02()));
			tfNCAFY03.setText(String.format("%,.2f",temporary.getNcaFY03()));
			tfNCAFY04.setText(String.format("%,.2f",temporary.getNcaFY04()));
			tfNCAFY05.setText(String.format("%,.2f",temporary.getNcaFY05()));
			
			//Anzeigen der geladenen Werte fuer die liquiden Mittel
			
			tfCashPY03.setText(String.format("%,.2f",temporary.getCashPY03()));
			tfCashPY02.setText(String.format("%,.2f",temporary.getCashPY02()));
			tfCashPY01.setText(String.format("%,.2f", temporary.getCashPY01()));
			tfCashY00.setText(String.format("%,.2f",temporary.getCashY00()));
			tfCashFY01.setText(String.format("%,.2f",temporary.getCashFY01()));
			tfCashFY02.setText(String.format("%,.2f",temporary.getCashFY02()));
			tfCashFY03.setText(String.format("%,.2f",temporary.getCashFY03()));
			tfCashFY04.setText(String.format("%,.2f",temporary.getCashFY04()));
			tfCashFY05.setText(String.format("%,.2f",temporary.getCashFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe der Aktiva
			
			tfTotalAssetsPY03.setText(String.format("%,.2f",temporary.getTotalAssetsPY03()));
			tfTotalAssetsPY02.setText(String.format("%,.2f",temporary.getTotalAssetsPY02()));
			tfTotalAssetsPY01.setText(String.format("%,.2f",temporary.getTotalAssetsPY01()));
			tfTotalAssetsY00.setText(String.format("%,.2f",temporary.getTotalAssetsY00()));
			tfTotalAssetsFY01.setText(String.format("%,.2f",temporary.getTotalAssetsFY01()));
			tfTotalAssetsFY02.setText(String.format("%,.2f",temporary.getTotalAssetsFY02()));
			tfTotalAssetsFY03.setText(String.format("%,.2f",temporary.getTotalAssetsFY03()));
			tfTotalAssetsFY04.setText(String.format("%,.2f",temporary.getTotalAssetsFY04()));
			tfTotalAssetsFY05.setText(String.format("%,.2f",temporary.getTotalAssetsFY05()));
			
			//Anzeigen der geladenen Werte fuer das Grundkapital
			
			tfShareCapitalPY03.setText(String.format("%,.2f",temporary.getShareCapitalPY03()));
			tfShareCapitalPY02.setText(String.format("%,.2f",temporary.getShareCapitalPY02()));
			tfShareCapitalPY01.setText(String.format("%,.2f",temporary.getShareCapitalPY01()));
			tfShareCapitalY00.setText(String.format("%,.2f",temporary.getShareCapitalY00()));
			tfShareCapitalFY01.setText(String.format("%,.2f",temporary.getShareCapitalFY01()));
			tfShareCapitalFY02.setText(String.format("%,.2f",temporary.getShareCapitalFY02()));
			tfShareCapitalFY03.setText(String.format("%,.2f",temporary.getShareCapitalFY03()));
			tfShareCapitalFY04.setText(String.format("%,.2f",temporary.getShareCapitalFY04()));
			tfShareCapitalFY05.setText(String.format("%,.2f",temporary.getShareCapitalFY05()));
			
			tfShareCapitalChangePY02.setText(String.format("%,.5f",temporary.getShareCapitalChangePY02()));
			tfShareCapitalChangePY01.setText(String.format("%,.5f",temporary.getShareCapitalChangePY01()));
			tfShareCapitalChangeY00.setText(String.format("%,.5f",temporary.getShareCapitalChangeY00()));
			tfShareCapitalChangeFY01.setText(String.format("%,.5f",temporary.getShareCapitalChangeFY01()));
			tfShareCapitalChangeFY02.setText(String.format("%,.5f",temporary.getShareCapitalChangeFY02()));
			tfShareCapitalChangeFY03.setText(String.format("%,.5f",temporary.getShareCapitalChangeFY03()));
			tfShareCapitalChangeFY04.setText(String.format("%,.5f",temporary.getShareCapitalChangeFY04()));
			tfShareCapitalChangeFY05.setText(String.format("%,.5f",temporary.getShareCapitalChangeFY05()));
			
			//Anzeigen der geladenen Werte fuer die Ruecklagen
			
			tfReservesPY03.setText(String.format("%,.2f",temporary.getReservesPY03()));
			tfReservesPY02.setText(String.format("%,.2f",temporary.getReservesPY02()));
			tfReservesPY01.setText(String.format("%,.2f",temporary.getReservesPY01()));
			tfReservesY00.setText(String.format("%,.2f",temporary.getReservesY00()));
			tfReservesFY01.setText(String.format("%,.2f",temporary.getReservesFY01()));
			tfReservesFY02.setText(String.format("%,.2f",temporary.getReservesFY02()));
			tfReservesFY03.setText(String.format("%,.2f",temporary.getReservesFY03()));
			tfReservesFY04.setText(String.format("%,.2f",temporary.getReservesFY04()));
			tfReservesFY05.setText(String.format("%,.2f",temporary.getReservesFY05()));
			
			tfReservesChangePY02.setText(String.format("%,.5f",temporary.getReservesChangePY02()));
			tfReservesChangePY01.setText(String.format("%,.5f",temporary.getReservesChangePY01()));
			tfReservesChangeY00.setText(String.format("%,.5f",temporary.getReservesChangeY00()));
			tfReservesChangeFY01.setText(String.format("%,.5f",temporary.getReservesChangeFY01()));
			tfReservesChangeFY02.setText(String.format("%,.5f",temporary.getReservesChangeFY02()));
			tfReservesChangeFY03.setText(String.format("%,.5f",temporary.getReservesChangeFY03()));
			tfReservesChangeFY04.setText(String.format("%,.5f",temporary.getReservesChangeFY04()));
			tfReservesChangeFY05.setText(String.format("%,.5f",temporary.getReservesChangeFY05()));
			
			tfDividendsPaidRatePY03.setText(String.format("%,.5f",temporary.getDividendsPaidRatePY03()));
			tfDividendsPaidRatePY02.setText(String.format("%,.5f",temporary.getDividendsPaidRatePY02()));
			tfDividendsPaidRatePY01.setText(String.format("%,.5f",temporary.getDividendsPaidRatePY01()));
			tfDividendsPaidRateY00.setText(String.format("%,.5f",temporary.getDividendsPaidRateY00()));
			tfDividendsPaidRateFY01.setText(String.format("%,.5f",temporary.getDividendsPaidRateFY01()));
			tfDividendsPaidRateFY02.setText(String.format("%,.5f",temporary.getDividendsPaidRateFY02()));
			tfDividendsPaidRateFY03.setText(String.format("%,.5f",temporary.getDividendsPaidRateFY03()));
			tfDividendsPaidRateFY04.setText(String.format("%,.5f",temporary.getDividendsPaidRateFY04()));
			tfDividendsPaidRateFY05.setText(String.format("%,.5f",temporary.getDividendsPaidRateFY05()));
			
			//Anzeigen der geladenen Werte fuer das sonstige Eigenkapital
			
			tfOtherEquityPY03.setText(String.format("%,.2f",temporary.getOtherEquityPY03()));
			tfOtherEquityPY02.setText(String.format("%,.2f",temporary.getOtherEquityPY02()));
			tfOtherEquityPY01.setText(String.format("%,.2f",temporary.getOtherEquityPY01()));
			tfOtherEquityY00.setText(String.format("%,.2f",temporary.getOtherEquityY00()));
			tfOtherEquityFY01.setText(String.format("%,.2f",temporary.getOtherEquityFY01()));
			tfOtherEquityFY02.setText(String.format("%,.2f",temporary.getOtherEquityFY02()));
			tfOtherEquityFY03.setText(String.format("%,.2f",temporary.getOtherEquityFY03()));
			tfOtherEquityFY04.setText(String.format("%,.2f",temporary.getOtherEquityFY04()));
			tfOtherEquityFY05.setText(String.format("%,.2f",temporary.getOtherEquityFY05()));
			
			tfOtherEquityChangePY02.setText(String.format("%,.5f",temporary.getOtherEquityChangePY02()));
			tfOtherEquityChangePY01.setText(String.format("%,.5f",temporary.getOtherEquityChangePY01()));
			tfOtherEquityChangeY00.setText(String.format("%,.5f",temporary.getOtherEquityChangeY00()));
			tfOtherEquityChangeFY01.setText(String.format("%,.5f",temporary.getOtherEquityChangeFY01()));
			tfOtherEquityChangeFY02.setText(String.format("%,.5f",temporary.getOtherEquityChangeFY02()));
			tfOtherEquityChangeFY03.setText(String.format("%,.5f",temporary.getOtherEquityChangeFY03()));
			tfOtherEquityChangeFY04.setText(String.format("%,.5f",temporary.getOtherEquityChangeFY04()));
			tfOtherEquityChangeFY05.setText(String.format("%,.5f",temporary.getOtherEquityChangeFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe des Eigenkapitals
			
			tfTotalEquityPY03.setText(String.format("%,.2f",temporary.getTotalEquityPY03()));
			tfTotalEquityPY02.setText(String.format("%,.2f",temporary.getTotalEquityPY02()));
			tfTotalEquityPY01.setText(String.format("%,.2f",temporary.getTotalEquityPY01()));
			tfTotalEquityY00.setText(String.format("%,.2f",temporary.getTotalEquityY00()));
			tfTotalEquityFY01.setText(String.format("%,.2f",temporary.getTotalEquityFY01()));
			tfTotalEquityFY02.setText(String.format("%,.2f",temporary.getTotalEquityFY02()));
			tfTotalEquityFY03.setText(String.format("%,.2f",temporary.getTotalEquityFY03()));
			tfTotalEquityFY04.setText(String.format("%,.2f",temporary.getTotalEquityFY04()));
			tfTotalEquityFY05.setText(String.format("%,.2f",temporary.getTotalEquityFY05()));
			
			//Anzeigen der geladenen Werte fuer das langfristige Fremdkapital
			
			tfLongTermBankDebtPY03.setText(String.format("%,.2f",temporary.getLongTermBankDebtPY03()));
			tfLongTermBankDebtPY02.setText(String.format("%,.2f",temporary.getLongTermBankDebtPY02()));
			tfLongTermBankDebtPY01.setText(String.format("%,.2f",temporary.getLongTermBankDebtPY01()));
			tfLongTermBankDebtY00.setText(String.format("%,.2f",temporary.getLongTermBankDebtY00()));
			tfLongTermBankDebtFY01.setText(String.format("%,.2f",temporary.getLongTermBankDebtFY01()));
			tfLongTermBankDebtFY02.setText(String.format("%,.2f",temporary.getLongTermBankDebtFY02()));
			tfLongTermBankDebtFY03.setText(String.format("%,.2f",temporary.getLongTermBankDebtFY03()));
			tfLongTermBankDebtFY04.setText(String.format("%,.2f",temporary.getLongTermBankDebtFY04()));
			tfLongTermBankDebtFY05.setText(String.format("%,.2f",temporary.getLongTermBankDebtFY05()));
			
			tfLongTermBankDebtChangePY02.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangePY02()));
			tfLongTermBankDebtChangePY01.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangePY01()));
			tfLongTermBankDebtChangeY00.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeY00()));
			tfLongTermBankDebtChangeFY01.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeFY01()));
			tfLongTermBankDebtChangeFY02.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeFY02()));
			tfLongTermBankDebtChangeFY03.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeFY03()));
			tfLongTermBankDebtChangeFY04.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeFY04()));
			tfLongTermBankDebtChangeFY05.setText(String.format("%,.5f",temporary.getLongTermBankDebtChangeFY05()));
			
			tfInterestLossFromBankDebtPY03.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtPY03()));
			tfInterestLossFromBankDebtPY02.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtPY02()));
			tfInterestLossFromBankDebtPY01.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtPY01()));
			tfInterestLossFromBankDebtY00.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtY00()));
			tfInterestLossFromBankDebtFY01.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtFY01()));
			tfInterestLossFromBankDebtFY02.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtFY02()));
			tfInterestLossFromBankDebtFY03.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtFY03()));
			tfInterestLossFromBankDebtFY04.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtFY04()));
			tfInterestLossFromBankDebtFY05.setText(String.format("%,.5f",temporary.getInterestLossFromBankDebtFY05()));

			//Anzeigen der geladenen Werte fuer die Rueckstellungen
			
			tfAccrualsPY03.setText(String.format("%,.2f",temporary.getAccrualsPY03()));
			tfAccrualsPY02.setText(String.format("%,.2f",temporary.getAccrualsPY02()));
			tfAccrualsPY01.setText(String.format("%,.2f",temporary.getAccrualsPY01()));
			tfAccrualsY00.setText(String.format("%,.2f",temporary.getAccrualsY00()));
			tfAccrualsFY01.setText(String.format("%,.2f",temporary.getAccrualsFY01()));
			tfAccrualsFY02.setText(String.format("%,.2f",temporary.getAccrualsFY02()));
			tfAccrualsFY03.setText(String.format("%,.2f",temporary.getAccrualsFY03()));
			tfAccrualsFY04.setText(String.format("%,.2f",temporary.getAccrualsFY04()));
			tfAccrualsFY05.setText(String.format("%,.2f",temporary.getAccrualsFY05()));
			
			tfAccrualsChangePY02.setText(String.format("%,.5f",temporary.getAccrualsChangePY02()));
			tfAccrualsChangePY01.setText(String.format("%,.5f",temporary.getAccrualsChangePY01()));
			tfAccrualsChangeY00.setText(String.format("%,.5f",temporary.getAccrualsChangeY00()));
			tfAccrualsChangeFY01.setText(String.format("%,.5f",temporary.getAccrualsChangeFY01()));
			tfAccrualsChangeFY02.setText(String.format("%,.5f",temporary.getAccrualsChangeFY02()));
			tfAccrualsChangeFY03.setText(String.format("%,.5f",temporary.getAccrualsChangeFY03()));
			tfAccrualsChangeFY04.setText(String.format("%,.5f",temporary.getAccrualsChangeFY04()));
			tfAccrualsChangeFY05.setText(String.format("%,.5f",temporary.getAccrualsChangeFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe der langfristigen Verbindlichkeiten
			
			tfTotalLongTermLiabilitiesPY03.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesPY03()));
			tfTotalLongTermLiabilitiesPY02.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesPY02()));
			tfTotalLongTermLiabilitiesPY01.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesPY01()));
			tfTotalLongTermLiabilitiesY00.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesY00()));
			tfTotalLongTermLiabilitiesFY01.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesFY01()));
			tfTotalLongTermLiabilitiesFY02.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesFY02()));
			tfTotalLongTermLiabilitiesFY03.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesFY03()));
			tfTotalLongTermLiabilitiesFY04.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesFY04()));
			tfTotalLongTermLiabilitiesFY05.setText(String.format("%,.2f",temporary.getTotalLongTermLiabilitiesFY05()));			
			
			//Anzeigen der geladenen Werte fuer die kurzfristigen Finanzverbindlichkeiten
			
			tfShortTermBankDebtPY03.setText(String.format("%,.2f",temporary.getShortTermBankDebtPY03()));
			tfShortTermBankDebtPY02.setText(String.format("%,.2f",temporary.getShortTermBankDebtPY02()));
			tfShortTermBankDebtPY01.setText(String.format("%,.2f",temporary.getShortTermBankDebtPY01()));
			tfShortTermBankDebtY00.setText(String.format("%,.2f",temporary.getShortTermBankDebtY00()));
			tfShortTermBankDebtFY01.setText(String.format("%,.2f",temporary.getShortTermBankDebtFY01()));
			tfShortTermBankDebtFY02.setText(String.format("%,.2f",temporary.getShortTermBankDebtFY02()));
			tfShortTermBankDebtFY03.setText(String.format("%,.2f",temporary.getShortTermBankDebtFY03()));
			tfShortTermBankDebtFY04.setText(String.format("%,.2f",temporary.getShortTermBankDebtFY04()));
			tfShortTermBankDebtFY05.setText(String.format("%,.2f",temporary.getShortTermBankDebtFY05()));
			
			tfShortTermBankDebtChangePY02.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangePY02()));
			tfShortTermBankDebtChangePY01.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangePY01()));
			tfShortTermBankDebtChangeY00.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeY00()));
			tfShortTermBankDebtChangeFY01.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeFY01()));
			tfShortTermBankDebtChangeFY02.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeFY02()));
			tfShortTermBankDebtChangeFY03.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeFY03()));
			tfShortTermBankDebtChangeFY04.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeFY04()));
			tfShortTermBankDebtChangeFY05.setText(String.format("%,.5f",temporary.getShortTermBankDebtChangeFY05()));
		
			//Anzeigen der geladenen Werte fuer die Verbindlichkeiten aus LuL
			
			tfTradePayablesPY03.setText(String.format("%,.2f",temporary.getTradePayablesPY03()));
			tfTradePayablesPY02.setText(String.format("%,.2f",temporary.getTradePayablesPY02()));
			tfTradePayablesPY01.setText(String.format("%,.2f",temporary.getTradePayablesPY01()));
			tfTradePayablesY00.setText(String.format("%,.2f",temporary.getTradePayablesY00()));
			tfTradePayablesFY01.setText(String.format("%,.2f",temporary.getTradePayablesFY01()));
			tfTradePayablesFY02.setText(String.format("%,.2f",temporary.getTradePayablesFY02()));
			tfTradePayablesFY03.setText(String.format("%,.2f",temporary.getTradePayablesFY03()));
			tfTradePayablesFY04.setText(String.format("%,.2f",temporary.getTradePayablesFY04()));
			tfTradePayablesFY05.setText(String.format("%,.2f",temporary.getTradePayablesFY05()));
			
			tfDaysPayablesOutstandingPY03.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingPY03()));
			tfDaysPayablesOutstandingPY02.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingPY02()));
			tfDaysPayablesOutstandingPY01.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingPY01()));
			tfDaysPayablesOutstandingY00.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingY00()));
			tfDaysPayablesOutstandingFY01.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingFY01()));
			tfDaysPayablesOutstandingFY02.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingFY02()));
			tfDaysPayablesOutstandingFY03.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingFY03()));
			tfDaysPayablesOutstandingFY04.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingFY04()));
			tfDaysPayablesOutstandingFY05.setText(String.format("%,.5f",temporary.getDaysPayablesOutstandingFY05()));
			
			//Anzeigen der geladenen Werte fuer die sonstigen kurzfr. Verbindlichkeiten
			
			tfOtherShortTermLiabilitiesPY03.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesPY03()));
			tfOtherShortTermLiabilitiesPY02.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesPY02()));
			tfOtherShortTermLiabilitiesPY01.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesPY01()));
			tfOtherShortTermLiabilitiesY00.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesY00()));
			tfOtherShortTermLiabilitiesFY01.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesFY01()));
			tfOtherShortTermLiabilitiesFY02.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesFY02()));
			tfOtherShortTermLiabilitiesFY03.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesFY03()));
			tfOtherShortTermLiabilitiesFY04.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesFY04()));
			tfOtherShortTermLiabilitiesFY05.setText(String.format("%,.2f",temporary.getOtherShortTermLiabilitiesFY05()));
			
			tfOtherShortTermLiabilitiesChangePY02.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangePY02()));
			tfOtherShortTermLiabilitiesChangePY01.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangePY01()));
			tfOtherShortTermLiabilitiesChangeY00.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeY00()));
			tfOtherShortTermLiabilitiesChangeFY01.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeFY01()));
			tfOtherShortTermLiabilitiesChangeFY02.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeFY02()));
			tfOtherShortTermLiabilitiesChangeFY03.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeFY03()));
			tfOtherShortTermLiabilitiesChangeFY04.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeFY04()));
			tfOtherShortTermLiabilitiesChangeFY05.setText(String.format("%,.5f",temporary.getOtherShortTermLiabilitiesChangeFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe der kurzfr. Verbindlichkeiten
			
			tfTotalShortTermLiabilitiesPY03.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesPY03()));
			tfTotalShortTermLiabilitiesPY02.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesPY02()));
			tfTotalShortTermLiabilitiesPY01.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesPY01()));
			tfTotalShortTermLiabilitiesY00.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesY00()));
			tfTotalShortTermLiabilitiesFY01.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesFY01()));
			tfTotalShortTermLiabilitiesFY02.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesFY02()));
			tfTotalShortTermLiabilitiesFY03.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesFY03()));
			tfTotalShortTermLiabilitiesFY04.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesFY04()));
			tfTotalShortTermLiabilitiesFY05.setText(String.format("%,.2f",temporary.getTotalShortTermLiabilitiesFY05()));
			
			//Anzeigen der geladenen Werte fuer die Summe der Passiva
			
			tfTotalLiabilitiesPY03.setText(String.format("%,.2f",temporary.getTotalLiabilitiesPY03()));
			tfTotalLiabilitiesPY02.setText(String.format("%,.2f",temporary.getTotalLiabilitiesPY02()));
			tfTotalLiabilitiesPY01.setText(String.format("%,.2f",temporary.getTotalLiabilitiesPY01()));
			tfTotalLiabilitiesY00.setText(String.format("%,.2f",temporary.getTotalLiabilitiesY00()));
			tfTotalLiabilitiesFY01.setText(String.format("%,.2f",temporary.getTotalLiabilitiesFY01()));
			tfTotalLiabilitiesFY02.setText(String.format("%,.2f",temporary.getTotalLiabilitiesFY02()));
			tfTotalLiabilitiesFY03.setText(String.format("%,.2f",temporary.getTotalLiabilitiesFY03()));
			tfTotalLiabilitiesFY04.setText(String.format("%,.2f",temporary.getTotalLiabilitiesFY04()));
			tfTotalLiabilitiesFY05.setText(String.format("%,.2f",temporary.getTotalLiabilitiesFY05()));
			
			//Anzeigen der geladenen Werte fuer Zinssätze in der CashFlow-Rechnung
			
			tfRiskFreeInterestRate.setText(String.format("%,.2f", temporary.getRiskFreeInterestRate()));
			tfMarketRiskPremium.setText(String.format("%,.2f", temporary.getMarketRiskPremium()));
			tfGrowthRateEndValue.setText(String.format("%,.2f", temporary.getGrowthRateEndValue()));
			
			// Anzeigen des Gewinns in der CashFlow-Rechnung
			
			tfCFTotalIncomeFY01.setText(String.format("%,.2f",temporary.getCfTotalIncomeFY01()));
			tfCFTotalIncomeFY02.setText(String.format("%,.2f",temporary.getCfTotalIncomeFY02()));
			tfCFTotalIncomeFY03.setText(String.format("%,.2f",temporary.getCfTotalIncomeFY03()));
			tfCFTotalIncomeFY04.setText(String.format("%,.2f",temporary.getCfTotalIncomeFY04()));
			tfCFTotalIncomeFY05.setText(String.format("%,.2f",temporary.getCfTotalIncomeFY05()));
			tfCFTotalIncomeTV.setText(String.format("%,.2f",temporary.getCfTotalIncomeTV()));
			
			//Anzeigen der Abschreibungen auf Sachanlagen in der CashFlow-Rechnung
			
			CFDepreciationFY01.setText(String.format("%,.2f",temporary.getDepreciationFY01()));
			CFDepreciationFY02.setText(String.format("%,.2f",temporary.getDepreciationFY02()));
			CFDepreciationFY03.setText(String.format("%,.2f",temporary.getDepreciationFY03()));
			CFDepreciationFY04.setText(String.format("%,.2f",temporary.getDepreciationFY04()));
			CFDepreciationFY05.setText(String.format("%,.2f",temporary.getDepreciationFY05()));
			CFDepreciationTV.setText(String.format("%,.2f",temporary.getCfDepreciationTV()));
			
			//Anzeigen der Abschreibungen auf immat. Vermoegen in der CashFlow-Rechnung
			
			tfCFDepreciationIntangibleFY01.setText(String.format("%,.2f",temporary.getDepreciationIntangibleFY01()));
			tfCFDepreciationIntangibleFY02.setText(String.format("%,.2f",temporary.getDepreciationIntangibleFY02()));
			tfCFDepreciationIntangibleFY03.setText(String.format("%,.2f",temporary.getDepreciationIntangibleFY03()));
			tfCFDepreciationIntangibleFY04.setText(String.format("%,.2f",temporary.getDepreciationIntangibleFY04()));
			tfCFDepreciationIntangibleFY05.setText(String.format("%,.2f",temporary.getDepreciationIntangibleFY05()));
			tfCFDepreciationIntangibleTV.setText(String.format("%,.2f",temporary.getCfDepreciationIntangibleTV()));
			
			//Anzeigen der Veraenderung der Rueckstellungen in der CashFlow-Rechnung
			
			tfCFAccrualsFY01.setText(String.format("%,.2f",temporary.getCfAccrualsFY01()));
			tfCFAccrualsFY02.setText(String.format("%,.2f",temporary.getCfAccrualsFY02()));
			tfCFAccrualsFY03.setText(String.format("%,.2f",temporary.getCfAccrualsFY03()));
			tfCFAccrualsFY04.setText(String.format("%,.2f",temporary.getCfAccrualsFY04()));
			tfCFAccrualsFY05.setText(String.format("%,.2f",temporary.getCfAccrualsFY05()));
			tfCFAccrualsTV.setText(String.format("%,.2f",temporary.getCfAccrualsTV()));
			
			//Anzeigen der Investitionen in das Anlagevermoegen in der CashFlow-Rechnung
			
			tfCFAssetsInvestFY01.setText(String.format("%,.2f",temporary.getCfAssetsInvestFY01()));
			tfCFAssetsInvestFY02.setText(String.format("%,.2f",temporary.getCfAssetsInvestFY02()));
			tfCFAssetsInvestFY03.setText(String.format("%,.2f",temporary.getCfAssetsInvestFY03()));
			tfCFAssetsInvestFY04.setText(String.format("%,.2f",temporary.getCfAssetsInvestFY04()));
			tfCFAssetsInvestFY05.setText(String.format("%,.2f",temporary.getCfAssetsInvestFY05()));
			tfCFAssetsInvestTV.setText(String.format("%,.2f",temporary.getCfAssetsInvestTV()));
			
			//Anzeigen der Investitionen in das Working Capital in der CashFlow-Rechnung
			
			tfCFWorkingCapitalInvestFY01.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestFY01()));
			tfCFWorkingCapitalInvestFY02.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestFY02()));
			tfCFWorkingCapitalInvestFY03.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestFY03()));
			tfCFWorkingCapitalInvestFY04.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestFY04()));
			tfCFWorkingCapitalInvestFY05.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestFY05()));
			tfCFWorkingCapitalInvestTV.setText(String.format("%,.2f",temporary.getCfWorkingCapitalInvestTV()));
			
			//Anzeigen der Veraenderung der zinstragenden Verbindlichkeiten in der CashFlow-Rechnung
			
			tfCFDebtChangeFY01.setText(String.format("%,.2f",temporary.getCfDebtChangeFY01()));
			tfCFDebtChangeFY02.setText(String.format("%,.2f",temporary.getCfDebtChangeFY02()));
			tfCFDebtChangeFY03.setText(String.format("%,.2f",temporary.getCfDebtChangeFY03()));
			tfCFDebtChangeFY04.setText(String.format("%,.2f",temporary.getCfDebtChangeFY04()));
			tfCFDebtChangeFY05.setText(String.format("%,.2f",temporary.getCfDebtChangeFY05()));
			tfCFDebtChangeTV.setText(String.format("%,.2f",temporary.getCfDebtChangeTV()));
			
			//Anzeigen der Cash Flows to Equity
			
			tfCashflowToEquityFY01.setText(String.format("%,.2f",temporary.getCashflowToEquityFY01()));
			tfCashflowToEquityFY02.setText(String.format("%,.2f",temporary.getCashflowToEquityFY02()));
			tfCashflowToEquityFY03.setText(String.format("%,.2f",temporary.getCashflowToEquityFY03()));
			tfCashflowToEquityFY04.setText(String.format("%,.2f",temporary.getCashflowToEquityFY04()));
			tfCashflowToEquityFY05.setText(String.format("%,.2f",temporary.getCashflowToEquityFY05()));
			tfCashflowToEquityTV.setText(String.format("%,.2f",temporary.getCashflowToEquityTV()));
			
			//Anzeigen der Discounted Cash Flows to Equity
			
			tfDiscountedCashflowFY01.setText(String.format("%,.2f",temporary.getDiscountedCashflowFY01()));
			tfDiscountedCashflowFY02.setText(String.format("%,.2f",temporary.getDiscountedCashflowFY02()));
			tfDiscountedCashflowFY03.setText(String.format("%,.2f",temporary.getDiscountedCashflowFY03()));
			tfDiscountedCashflowFY04.setText(String.format("%,.2f",temporary.getDiscountedCashflowFY04()));
			tfDiscountedCashflowFY05.setText(String.format("%,.2f",temporary.getDiscountedCashflowFY05()));
			tfDiscountedCashflowTV.setText(String.format("%,.2f",temporary.getDiscountedCashflowTV()));
			
			//Anzeigen der liquiden Mittel in der CashFlow-Rechnung
			
			tfCFCash.setText(String.format("%,.2f",temporary.getCashY00()));
			
			//Anzeigen der Fair Values in der CashFlow-Rechnung
			
			this.tfFairValue.setText(String.format("%,.2f",temporary.getFairValue()));
			this.tfFairValuePerShare.setText(String.format("%,.2f",temporary.getFairValuePerShare()));
			
			// Verschuldungsgrad in Grafik aktualisieren
			
						leverage [0] = temporary.getLeveragePY03();
						leverage [1] = temporary.getLeveragePY02();
						leverage [2] = temporary.getLeveragePY01();
						leverage [3] = temporary.getLeverageY00();
						leverage [4] = temporary.getLeverageFY01();
						leverage [5] = temporary.getLeverageFY02();
						leverage [6] = temporary.getLeverageFY03();
						leverage [7] = temporary.getLeverageFY04();
						leverage [8] = temporary.getLeverageFY05();
						
						leverageChart.updateXYSeries("Leverage", year, leverage, null);
						chartPanelLeverage.revalidate();
						chartPanelLeverage.repaint();
						
						
						// Anlagenintensität in Grafik aktualisieren
						
						assetIntensity [0] = temporary.getAssetIntensityPY03();
						assetIntensity [1] = temporary.getAssetIntensityPY02();
						assetIntensity [2] = temporary.getAssetIntensityPY01();
						assetIntensity [3] = temporary.getAssetIntensityY00();
						assetIntensity [4] = temporary.getAssetIntensityFY01();
						assetIntensity [5] = temporary.getAssetIntensityFY02();
						assetIntensity [6] = temporary.getAssetIntensityFY03();
						assetIntensity [7] = temporary.getAssetIntensityFY04();
						assetIntensity [8] = temporary.getAssetIntensityFY05();
						
						
						assetIntensityChart.updateXYSeries("Asset Intensity", year, assetIntensity, null);
						chartPanelAssetIntensity.revalidate();
						chartPanelAssetIntensity.repaint();
						
						// Umlaufintensität in Grafik aktualisieren
						
						circulatingIntensity [0] = temporary.getCirculatingIntensityPY03();
						circulatingIntensity [1] = temporary.getCirculatingIntensityPY02();
						circulatingIntensity [2] = temporary.getCirculatingIntensityPY01();
						circulatingIntensity [3] = temporary.getCirculatingIntensityY00();
						circulatingIntensity [4] = temporary.getCirculatingIntensityFY01();
						circulatingIntensity [5] = temporary.getCirculatingIntensityFY02();
						circulatingIntensity [6] = temporary.getCirculatingIntensityFY03();
						circulatingIntensity [7] = temporary.getCirculatingIntensityFY04();
						circulatingIntensity [8] = temporary.getCirculatingIntensityFY05();
						
						circulatingIntensityChart.updateXYSeries("Circulating Intensity", year, circulatingIntensity, null);
						chartPanelCirculatingIntensity.revalidate();
						chartPanelCirculatingIntensity.repaint();
						
						// Umschlagshäufigkeit der Forderungen in Grafik aktualisieren
						
						inventoryTurnover [0] = temporary.getInventoryTurnoverPY03();
						inventoryTurnover [1] = temporary.getInventoryTurnoverPY02();
						inventoryTurnover [2] = temporary.getInventoryTurnoverPY01();
						inventoryTurnover [3] = temporary.getInventoryTurnoverY00();
						inventoryTurnover [4] = temporary.getInventoryTurnoverFY01();
						inventoryTurnover [5] = temporary.getInventoryTurnoverFY02();
						inventoryTurnover [6] = temporary.getInventoryTurnoverFY03();
						inventoryTurnover [7] = temporary.getInventoryTurnoverFY04();
						inventoryTurnover [8] = temporary.getInventoryTurnoverFY05();
						
						inventoryTurnoverChart.updateXYSeries("Inventory Turnover", year, inventoryTurnover, null);
						chartPanelInventoryTurnover.revalidate();
						chartPanelInventoryTurnover.repaint();
						
						// Umschlagshäufigkeit der Vorräte in Grafik aktualisieren
						
						receivablesTurnover [0] = temporary.getReceivablesTurnoverPY03();
						receivablesTurnover [1] = temporary.getReceivablesTurnoverPY02();
						receivablesTurnover [2] = temporary.getReceivablesTurnoverPY01();
						receivablesTurnover [3] = temporary.getReceivablesTurnoverY00();
						receivablesTurnover [4] = temporary.getReceivablesTurnoverFY01();
						receivablesTurnover [5] = temporary.getReceivablesTurnoverFY02();
						receivablesTurnover [6] = temporary.getReceivablesTurnoverFY03();
						receivablesTurnover [7] = temporary.getReceivablesTurnoverFY04();
						receivablesTurnover [8] = temporary.getReceivablesTurnoverFY05();
									
						receivablesTurnoverChart.updateXYSeries("Receivables Turnover", year, receivablesTurnover, null);
						chartPanelReceivablesTurnover.revalidate();
						chartPanelReceivablesTurnover.repaint();
						
						// Umschlagshäufigkeit der Verbindlichkeiten in Grafik aktualisieren
						
						payablesTurnover [0] = temporary.getDaysPayablesOutstandingPY03();
						payablesTurnover [1] = temporary.getDaysPayablesOutstandingPY02();
						payablesTurnover [2] = temporary.getDaysPayablesOutstandingPY01();
						payablesTurnover [3] = temporary.getDaysPayablesOutstandingY00();
						payablesTurnover [4] = temporary.getDaysPayablesOutstandingFY01();
						payablesTurnover [5] = temporary.getDaysPayablesOutstandingFY02();
						payablesTurnover [6] = temporary.getDaysPayablesOutstandingFY03();
						payablesTurnover [7] = temporary.getDaysPayablesOutstandingFY04();
						payablesTurnover [8] = temporary.getDaysPayablesOutstandingFY05();
						
						payablesTurnoverChart.updateXYSeries("Payables Turnover", year, payablesTurnover, null);
						chartPanelPayablesTurnover.revalidate();
						chartPanelPayablesTurnover.repaint();
						
						// Umsatz in Grafik aktualisieren
						
						revenue [0] = temporary.getRevenuePY03();
						revenue [1] = temporary.getRevenuePY02();
						revenue [2] = temporary.getRevenuePY01();
						revenue [3] = temporary.getRevenueY00();
						revenue [4] = temporary.getRevenueFY01();
						revenue [5] = temporary.getRevenueFY02();
						revenue [6] = temporary.getRevenueFY03();
						revenue [7] = temporary.getRevenueFY04();
						revenue [8] = temporary.getRevenueFY05();
						
						revenueChart.updateXYSeries("Revenue",year,revenue,null);
						chartPanelRevenue.revalidate();
						chartPanelRevenue.repaint();
						
						// Gewinn in Grafik aktualisieren
						
						totalIncome [0] = temporary.getTotalIncomePY03();
						totalIncome [1] = temporary.getTotalIncomePY02();
						totalIncome [2] = temporary.getTotalIncomePY01();
						totalIncome [3] = temporary.getTotalIncomeY00();
						totalIncome [4] = temporary.getTotalIncomeFY01();
						totalIncome [5] = temporary.getTotalIncomeFY02();
						totalIncome [6] = temporary.getTotalIncomeFY03();
						totalIncome [7] = temporary.getTotalIncomeFY04();
						totalIncome [8] = temporary.getTotalIncomeFY05();
						
						totalIncomeChart.updateXYSeries("Total Income", year, totalIncome, null);
						chartPanelTotalIncome.revalidate();
						chartPanelTotalIncome.repaint();
						
						// Umsatzrendite in Grafik aktualisieren
						
						returnOnSales [0] = temporary.getReturnOnSalesPY03();
						returnOnSales [1] = temporary.getReturnOnSalesPY02();
						returnOnSales [2] = temporary.getReturnOnSalesPY01();
						returnOnSales [3] = temporary.getReturnOnSalesY00();
						returnOnSales [4] = temporary.getReturnOnSalesFY01();
						returnOnSales [5] = temporary.getReturnOnSalesFY02();
						returnOnSales [6] = temporary.getReturnOnSalesFY03();
						returnOnSales [7] = temporary.getReturnOnSalesFY04();
						returnOnSales [8] = temporary.getReturnOnSalesFY05();
						
						returnOnSalesChart.updateXYSeries("Return on Sales", year, returnOnSales, null);
						chartPanelReturnOnSales.revalidate();
						chartPanelReturnOnSales.repaint();
						
						// EBITDA Marge in Grafik aktualisieren
						
						returnOnEBITDA [0] = temporary.getReturnOnEBITDAPY03();
						returnOnEBITDA [1] = temporary.getReturnOnEBITDAPY02();
						returnOnEBITDA [2] = temporary.getReturnOnEBITDAPY01();
						returnOnEBITDA [3] = temporary.getReturnOnEBITDAY00();
						returnOnEBITDA [4] = temporary.getReturnOnEBITDAFY01();
						returnOnEBITDA [5] = temporary.getReturnOnEBITDAFY02();
						returnOnEBITDA [6] = temporary.getReturnOnEBITDAFY03();
						returnOnEBITDA [7] = temporary.getReturnOnEBITDAFY04();
						returnOnEBITDA [8] = temporary.getReturnOnEBITDAFY05();
						
						returnOnEBITDAChart.updateXYSeries("Return on EBITDA", year, returnOnEBITDA, null);
						chartPanelReturnOnEBITDA.revalidate();
						chartPanelReturnOnEBITDA.repaint();
						
						// Eigenkapitalrendite in Grafik aktualisieren
						
						returnOnEquity [0] = temporary.getReturnOnEquityPY03();
						returnOnEquity [1] = temporary.getReturnOnEquityPY02();
						returnOnEquity [2] = temporary.getReturnOnEquityPY01();
						returnOnEquity [3] = temporary.getReturnOnEquityY00();
						returnOnEquity [4] = temporary.getReturnOnEquityFY01();
						returnOnEquity [5] = temporary.getReturnOnEquityFY02();
						returnOnEquity [6] = temporary.getReturnOnEquityFY03();
						returnOnEquity [7] = temporary.getReturnOnEquityFY04();
						returnOnEquity [8] = temporary.getReturnOnEquityFY05();
						
						returnOnEquityChart.updateXYSeries("Return on Equity", year, returnOnEquity, null);
						chartPanelReturnOnEquity.revalidate();
						chartPanelReturnOnEquity.repaint();
						
						// Gesamtkapitalrendite in Grafik aktualisieren
								
						totalReturnOnInvest [0] = temporary.getTotalReturnOnInvestPY03();
						totalReturnOnInvest [1] = temporary.getTotalReturnOnInvestPY02();
						totalReturnOnInvest [2] = temporary.getTotalReturnOnInvestPY01();
						totalReturnOnInvest [3] = temporary.getTotalReturnOnInvestY00();
						totalReturnOnInvest [4] = temporary.getTotalReturnOnInvestFY01();
						totalReturnOnInvest [5] = temporary.getTotalReturnOnInvestFY02();
						totalReturnOnInvest [6] = temporary.getTotalReturnOnInvestFY03();
						totalReturnOnInvest [7] = temporary.getTotalReturnOnInvestFY04();
						totalReturnOnInvest [8] = temporary.getTotalReturnOnInvestFY05();
						
						totalReturnOnInvestChart.updateXYSeries("Total Return on Investment", year, totalReturnOnInvest, null);
						chartPanelTotalReturnOnInvest.revalidate();
						chartPanelTotalReturnOnInvest.repaint();			
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
		//Speichern der temporären Company als JSON File
	
	public void SaveCompany() {
		
		SaveAssetValues();
		Gson Write = new Gson();
		String json = Write.toJson(temporary);	
		int response = 0;
		FileWriter fw; 
		JFileChooser saveDialog = new JFileChooser(".");
		saveDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
		saveDialog.setAcceptAllFileFilterUsed(true);
		response = saveDialog.showSaveDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			
			
			try {
				fw = new FileWriter(saveDialog.getSelectedFile());
				fw.write(Write.toJson(temporary));
				fw.flush();
				System.out.println(json);
				
			} catch (IOException e) {
			e.printStackTrace();
			}
			}

		
	}
	
		//Laden einer Company aus einem JSON file
	
	public void LoadCompany() {
		
		Gson Read = new Gson();
		int response = 0;
		File file;		
		JFileChooser loadDialog = new JFileChooser(".");
		loadDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
		response = loadDialog.showOpenDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = loadDialog.getSelectedFile();
			
			try {
				
				if(file.isFile()) {
						Company temporary = Read.fromJson(new FileReader(file), Company.class);
						this.temporary = temporary;
						DisplayAssetValues();
												
				} else {
					
					JOptionPane.showMessageDialog(null,"Die Auswahl entspricht keiner gültigen Datei");
					
				}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	}
}

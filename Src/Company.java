package investigator;

import java.io.Serializable;

public class Company implements Serializable {

	/** @author Dario Guth
	 *  @copyright Dario Guth, 20210801
	 *  @version 0.9  
	 */

	private static final long serialVersionUID = 4735825962111455705L;

	private String companyName;
	private double shareVolume, currentSharePrice, fairValueFromSharePrice, riskFreeInterestRate, marketRiskPremium, growthRateEndValue, dividendsPaidPY03,
			dividendsPaidPY02, dividendsPaidPY01, dividendsPaidY00, revenuePY03, revenuePY02, revenuePY01, revenueY00,
			revenueFY01, revenueFY02, revenueFY03, revenueFY04, revenueFY05, revenueChangePY02, revenueChangePY01, revenueChangeY00,
			revenueChangeFY01, revenueChangeFY02, revenueChangeFY03, revenueChangeFY04, revenueChangeFY05, cogsPY03, cogsPY02, cogsPY01,
			cogsY00, cogsFY01, cogsFY02, cogsFY03, cogsFY04, cogsFY05, cogsFromRevenuePY03, cogsFromRevenuePY02,
			cogsFromRevenuePY01, cogsFromRevenueY00, cogsFromRevenueFY01, cogsFromRevenueFY02, cogsFromRevenueFY03,
			cogsFromRevenueFY04, cogsFromRevenueFY05, otherCostsPY03, otherCostsPY02, otherCostsPY01, otherCostsY00, otherCostsFY01,
			otherCostsFY02, otherCostsFY03, otherCostsFY04, otherCostsFY05, otherCostsFromRevenuePY03, otherCostsFromRevenuePY02,
			otherCostsFromRevenuePY01, otherCostsFromRevenueY00, otherCostsFromRevenueFY01, otherCostsFromRevenueFY02,
			otherCostsFromRevenueFY03, otherCostsFromRevenueFY04, otherCostsFromRevenueFY05, ebitdaPY03, ebitdaPY02, ebitdaPY01, ebitdaY00,
			ebitdaFY01, ebitdaFY02, ebitdaFY03, ebitdaFY04, ebitdaFY05, ebitdaFromRevenuePY03, ebitdaFromRevenuePY02,
			ebitdaFromRevenuePY01, ebitdaFromRevenueY00, ebitdaFromRevenueFY01, ebitdaFromRevenueFY02,
			ebitdaFromRevenueFY03, ebitdaFromRevenueFY04, ebitdaFromRevenueFY05, depreciationPY03, depreciationPY02, depreciationPY01,
			depreciationY00, depreciationFY01, depreciationFY02, depreciationFY03, depreciationFY04, depreciationFY05,
			depreciationIntangiblePY03, depreciationIntangiblePY02, depreciationIntangiblePY01,
			depreciationIntangibleY00, depreciationIntangibleFY01, depreciationIntangibleFY02,
			depreciationIntangibleFY03, depreciationIntangibleFY04, depreciationIntangibleFY05, interestGainsPY03, interestGainsPY02,
			interestGainsPY01, interestGainsY00, interestGainsFY01, interestGainsFY02, interestGainsFY03,
			interestGainsFY04, interestGainsFY05, interestLossPY03, interestLossPY02, interestLossPY01, interestLossY00, interestLossFY01,
			interestLossFY02, interestLossFY03, interestLossFY04, interestLossFY05, ebtPY03, ebtPY02, ebtPY01, ebtY00, ebtFY01, ebtFY02,
			ebtFY03, ebtFY04, ebtFY05, incomeTaxPY03, incomeTaxPY02, incomeTaxPY01, incomeTaxY00, incomeTaxFY01, incomeTaxFY02,
			incomeTaxFY03, incomeTaxFY04, incomeTaxFY05, incomeTaxFromEbtPY03, incomeTaxFromEbtPY02, incomeTaxFromEbtPY01,
			incomeTaxFromEbtY00, incomeTaxFromEbtFY01, incomeTaxFromEbtFY02, incomeTaxFromEbtFY03, incomeTaxFromEbtFY04, incomeTaxFromEbtFY05,
			totalIncomePY03, totalIncomePY02, totalIncomePY01, totalIncomeY00, totalIncomeFY01, totalIncomeFY02,
			totalIncomeFY03, totalIncomeFY04, totalIncomeFY05, finAssetsPY03, finAssetsPY02, finAssetsPY01, finAssetsY00, finAssetsFY01,
			finAssetsFY02, finAssetsFY03, finAssetsFY04, finAssetsFY05,
			financialAssetsChangePY02, financialAssetsChangePY01,financialAssetsChangeY00, financialAssetsChangeFY01,financialAssetsChangeFY02, financialAssetsChangeFY03 ,financialAssetsChangeFY04 ,financialAssetsChangeFY05,
			interestGainsFromFinancialAssetsPY03, interestGainsFromFinancialAssetsPY02,
			interestGainsFromFinancialAssetsPY01, interestGainsFromFinancialAssetsY00,
			interestGainsFromFinancialAssetsFY01, interestGainsFromFinancialAssetsFY02,
			interestGainsFromFinancialAssetsFY03, interestGainsFromFinancialAssetsFY04, interestGainsFromFinancialAssetsFY05, propAssetsPY03, propAssetsPY02,
			propAssetsPY01, propAssetsY00, propAssetsFY01, propAssetsFY02, propAssetsFY03, propAssetsFY04, propAssetsFY05,
			propertyAssetsChangePY02, propertyAssetsChangePY01, propertyAssetsChangeY00, propertyAssetsChangeFY01, propertyAssetsChangeFY02, propertyAssetsChangeFY03, propertyAssetsChangeFY04, propertyAssetsChangeFY05,
			depreciationFromPropertyAssetsPY03, depreciationFromPropertyAssetsPY02, depreciationFromPropertyAssetsPY01,
			depreciationFromPropertyAssetsY00, depreciationFromPropertyAssetsFY01, depreciationFromPropertyAssetsFY02,
			depreciationFromPropertyAssetsFY03, depreciationFromPropertyAssetsFY04, depreciationFromPropertyAssetsFY05, intAssetsPY03, intAssetsPY02,
			intAssetsPY01, intAssetsY00, intAssetsFY01, intAssetsFY02, intAssetsFY03, intAssetsFY04, intAssetsFY05,
			intangibleAssetsChangePY02, intangibleAssetsChangePY01, intangibleAssetsChangeY00, intangibleAssetsChangeFY01, intangibleAssetsChangeFY02, intangibleAssetsChangeFY03, intangibleAssetsChangeFY04, intangibleAssetsChangeFY05,
			depreciationFromIntangibleAssetsPY03, depreciationFromIntangibleAssetsPY02,
			depreciationFromIntangibleAssetsPY01, depreciationFromIntangibleAssetsY00,
			depreciationFromIntangibleAssetsFY01, depreciationFromIntangibleAssetsFY02,
			depreciationFromIntangibleAssetsFY03, depreciationFromIntangibleAssetsFY04, depreciationFromIntangibleAssetsFY05, otherAssetsPY03,
			otherAssetsPY02, otherAssetsPY01, otherAssetsY00, otherAssetsFY01, otherAssetsFY02, otherAssetsFY03, otherAssetsFY04, otherAssetsFY05, otherAssetsChangePY02, otherAssetsChangePY01,
			otherAssetsChangeY00, otherAssetsChangeFY01, otherAssetsChangeFY02, otherAssetsChangeFY03, otherAssetsChangeFY04, otherAssetsChangeFY05, assetsPY03, assetsPY02, assetsPY01, assetsY00, assetsFY01, assetsFY02, assetsFY03,
			assetsFY04, assetsFY05, inventoryPY03, inventoryPY02,
			inventoryPY01, inventoryY00, inventoryFY01,inventoryFY02,inventoryFY03, inventoryFY04, inventoryFY05, inventoryTurnoverPY03, inventoryTurnoverPY02, inventoryTurnoverPY01,
			inventoryTurnoverY00, inventoryTurnoverFY01, inventoryTurnoverFY02, inventoryTurnoverFY03, inventoryTurnoverFY04, inventoryTurnoverFY05, receivablesPY03, receivablesPY02, receivablesPY01, receivablesY00, receivablesFY01,
			receivablesFY02, receivablesFY03, receivablesFY04, receivablesFY05,
			receivablesTurnoverPY03, receivablesTurnoverPY02, receivablesTurnoverPY01, receivablesTurnoverY00, receivablesTurnoverFY01, receivablesTurnoverFY02, receivablesTurnoverFY03, receivablesTurnoverFY04, receivablesTurnoverFY05,
			otherNCAPY03, otherNCAPY02, otherNCAPY01, otherNCAY00, otherNCAFY01, otherNCAFY02, otherNCAFY03, otherNCAFY04, otherNCAFY05, otherNCAFromNCAPY02, otherNCAFromNCAPY01,
			otherNCAFromNCAY00, otherNCAFromNCAFY01, otherNCAFromNCAFY02, otherNCAFromNCAFY03, otherNCAFromNCAFY04, otherNCAFromNCAFY05, ncaPY03, ncaPY02, ncaPY01, ncaY00, ncaFY01, ncaFY02, ncaFY03, ncaFY04, ncaFY05, cashPY03, cashPY02, 
			cashPY01, cashY00, cashFY01, cashFY02, cashFY03, cashFY04, cashFY05,
			totalAssetsPY03, totalAssetsPY02, totalAssetsPY01, totalAssetsY00, totalAssetsFY01, totalAssetsFY02, totalAssetsFY03, totalAssetsFY04, totalAssetsFY05, 
			shareCapitalPY03, shareCapitalPY02,	shareCapitalPY01, shareCapitalY00, shareCapitalFY01, shareCapitalFY02, shareCapitalFY03, shareCapitalFY04, shareCapitalFY05, 
			shareCapitalChangePY02, shareCapitalChangePY01, shareCapitalChangeY00, shareCapitalChangeFY01,shareCapitalChangeFY02, shareCapitalChangeFY03, shareCapitalChangeFY04, shareCapitalChangeFY05,
			reservesPY03, reservesPY02, reservesPY01, reservesY00, reservesFY01, reservesFY02, reservesFY03, reservesFY04, reservesFY05, 
			reservesChangePY02, reservesChangePY01, reservesChangeY00, reservesChangeFY01, reservesChangeFY02, reservesChangeFY03,reservesChangeFY04, reservesChangeFY05,
			dividendsPaidRatePY03, dividendsPaidRatePY02, dividendsPaidRatePY01,
			dividendsPaidRateY00, dividendsPaidRateFY01, dividendsPaidRateFY02, dividendsPaidRateFY03,
			dividendsPaidRateFY04, dividendsPaidRateFY05, otherEquityPY03, otherEquityPY02, otherEquityPY01,
			otherEquityY00, otherEquityFY01, otherEquityFY02, otherEquityFY03, otherEquityFY04, otherEquityFY05,
			otherEquityChangePY02, otherEquityChangePY01, otherEquityChangeY00, otherEquityChangeFY01, otherEquityChangeFY02, otherEquityChangeFY03, otherEquityChangeFY04, otherEquityChangeFY05,
			totalEquityPY03,totalEquityPY02, totalEquityPY01, totalEquityY00, totalEquityFY01, totalEquityFY02, totalEquityFY03, totalEquityFY04, totalEquityFY05, 
			longTermBankDebtPY03, longTermBankDebtPY02,longTermBankDebtPY01, longTermBankDebtY00, longTermBankDebtFY01, longTermBankDebtFY02, longTermBankDebtFY03,
			longTermBankDebtFY04, longTermBankDebtFY05, longTermBankDebtChangePY02, longTermBankDebtChangePY01, longTermBankDebtChangeY00, longTermBankDebtChangeFY01, longTermBankDebtChangeFY02,
			longTermBankDebtChangeFY03, longTermBankDebtChangeFY04, longTermBankDebtChangeFY05,
			interestLossFromBankDebtPY03, interestLossFromBankDebtPY02, interestLossFromBankDebtPY01,
			interestLossFromBankDebtY00, interestLossFromBankDebtFY01, interestLossFromBankDebtFY02,
			interestLossFromBankDebtFY03, interestLossFromBankDebtFY04, interestLossFromBankDebtFY05, 
			accrualsPY03, accrualsPY02, accrualsPY01, accrualsY00, accrualsFY01, accrualsFY02, accrualsFY03, accrualsFY04, accrualsFY05,
			accrualsChangePY02, accrualsChangePY01, accrualsChangeY00, accrualsChangeFY01, accrualsChangeFY02, accrualsChangeFY03, accrualsChangeFY04, accrualsChangeFY05, 
			totalLongTermLiabilitiesPY03, totalLongTermLiabilitiesPY02, totalLongTermLiabilitiesPY01, totalLongTermLiabilitiesY00, totalLongTermLiabilitiesFY01, totalLongTermLiabilitiesFY02,
			totalLongTermLiabilitiesFY03, totalLongTermLiabilitiesFY04, totalLongTermLiabilitiesFY05,
			shortTermBankDebtPY03, shortTermBankDebtPY02, shortTermBankDebtPY01, shortTermBankDebtY00, shortTermBankDebtFY01, shortTermBankDebtFY02, shortTermBankDebtFY03, shortTermBankDebtFY04, 
			shortTermBankDebtFY05,
			shortTermBankDebtChangePY02, shortTermBankDebtChangePY01, shortTermBankDebtChangeY00, shortTermBankDebtChangeFY01, shortTermBankDebtChangeFY02, shortTermBankDebtChangeFY03, 
			shortTermBankDebtChangeFY04, shortTermBankDebtChangeFY05, 
			tradePayablesPY03, tradePayablesPY02, tradePayablesPY01, tradePayablesY00, tradePayablesFY01, tradePayablesFY02, tradePayablesFY03, tradePayablesFY04, tradePayablesFY05,
			daysPayablesOutstandingPY03, daysPayablesOutstandingPY02, daysPayablesOutstandingPY01, daysPayablesOutstandingY00, daysPayablesOutstandingFY01, daysPayablesOutstandingFY02,
			daysPayablesOutstandingFY03, daysPayablesOutstandingFY04, daysPayablesOutstandingFY05,
			otherShortTermLiabilitiesPY03, otherShortTermLiabilitiesPY02, otherShortTermLiabilitiesPY01,
			otherShortTermLiabilitiesY00, otherShortTermLiabilitiesFY01, otherShortTermLiabilitiesFY02, otherShortTermLiabilitiesFY03, otherShortTermLiabilitiesFY04, otherShortTermLiabilitiesFY05,
			otherShortTermLiabilitiesChangePY02, otherShortTermLiabilitiesChangePY01, otherShortTermLiabilitiesChangeY00, otherShortTermLiabilitiesChangeFY01, otherShortTermLiabilitiesChangeFY02, 
			otherShortTermLiabilitiesChangeFY03, otherShortTermLiabilitiesChangeFY04, otherShortTermLiabilitiesChangeFY05,
			totalShortTermLiabilitiesPY03, totalShortTermLiabilitiesPY02, totalShortTermLiabilitiesPY01, totalShortTermLiabilitiesY00, totalShortTermLiabilitiesFY01, totalShortTermLiabilitiesFY02,
			totalShortTermLiabilitiesFY03, totalShortTermLiabilitiesFY04, totalShortTermLiabilitiesFY05,
			totalLiabilitiesPY03, totalLiabilitiesPY02, totalLiabilitiesPY01, totalLiabilitiesY00, totalLiabilitiesFY01, totalLiabilitiesFY02, totalLiabilitiesFY03, totalLiabilitiesFY04, 
			totalLiabilitiesFY05,
			cfTotalIncomeFY01, cfTotalIncomeFY02, cfTotalIncomeFY03, cfTotalIncomeFY04, cfTotalIncomeFY05, cfTotalIncomeTV, cfDepreciationTV, cfDepreciationIntangibleTV,
			cfAccrualsFY01, cfAccrualsFY02, cfAccrualsFY03, cfAccrualsFY04, cfAccrualsFY05, cfAccrualsTV,
			cfAssetsInvestFY01, cfAssetsInvestFY02, cfAssetsInvestFY03, cfAssetsInvestFY04, cfAssetsInvestFY05, cfAssetsInvestTV,
			cfWorkingCapitalInvestFY01, cfWorkingCapitalInvestFY02, cfWorkingCapitalInvestFY03, cfWorkingCapitalInvestFY04, cfWorkingCapitalInvestFY05, cfWorkingCapitalInvestTV,
			cfDebtChangeFY01, cfDebtChangeFY02, cfDebtChangeFY03, cfDebtChangeFY04, cfDebtChangeFY05, cfDebtChangeTV,
			cashflowToEquityFY01, cashflowToEquityFY02, cashflowToEquityFY03, cashflowToEquityFY04, cashflowToEquityFY05, cashflowToEquityTV,
			discountedCashflowFY01, discountedCashflowFY02, discountedCashflowFY03, discountedCashflowFY04, discountedCashflowFY05, discountedCashflowTV,
			fairValue, fairValuePerShare, leveragePY03, leveragePY02, leveragePY01, leverageY00, leverageFY01, leverageFY02, leverageFY03, leverageFY04, leverageFY05,
			assetIntensityPY03, assetIntensityPY02, assetIntensityPY01, assetIntensityY00, assetIntensityFY01, assetIntensityFY02, assetIntensityFY03, assetIntensityFY04, assetIntensityFY05,
			circulatingIntensityPY03, circulatingIntensityPY02, circulatingIntensityPY01, circulatingIntensityY00, circulatingIntensityFY01, circulatingIntensityFY02, circulatingIntensityFY03, circulatingIntensityFY04, circulatingIntensityFY05,
			returnOnSalesPY03, returnOnSalesPY02, returnOnSalesPY01, returnOnSalesY00, returnOnSalesFY01, returnOnSalesFY02, returnOnSalesFY03, returnOnSalesFY04, returnOnSalesFY05,
			returnOnEBITDAPY03, returnOnEBITDAPY02, returnOnEBITDAPY01, returnOnEBITDAY00, returnOnEBITDAFY01, returnOnEBITDAFY02, returnOnEBITDAFY03, returnOnEBITDAFY04, returnOnEBITDAFY05,
			returnOnEquityPY03, returnOnEquityPY02, returnOnEquityPY01, returnOnEquityY00, returnOnEquityFY01, returnOnEquityFY02, returnOnEquityFY03, returnOnEquityFY04, returnOnEquityFY05,
			totalReturnOnInvestPY03, totalReturnOnInvestPY02, totalReturnOnInvestPY01, totalReturnOnInvestY00, totalReturnOnInvestFY01, totalReturnOnInvestFY02, totalReturnOnInvestFY03, totalReturnOnInvestFY04, totalReturnOnInvestFY05;

	// Konstruktor fuer eine neue Company

	Company() {

		this.companyName = "Unnamed Company";
		this.shareVolume = 1;
		this.currentSharePrice = 0.00;
		this.fairValueFromSharePrice = 0.00;
		this.riskFreeInterestRate = 2.00;
		this.marketRiskPremium = 5.50;
		this.growthRateEndValue = 0.50;
		this.dividendsPaidPY03 = 0.00;
		this.dividendsPaidPY02 = 0.00;
		this.dividendsPaidPY01 = 0.00;
		this.dividendsPaidY00 = 0.00;
		this.revenuePY03 = 0.00;
		this.revenuePY02 = 0.00;
		this.revenuePY01 = 0.00;
		this.revenueY00 = 0.00;
		this.revenueFY01 = 0.00;
		this.revenueFY02 = 0.00;
		this.revenueFY03 = 0.00;
		this.revenueFY04 = 0.00;
		this.revenueFY05 = 0.00;
		this.revenueChangePY02 = 0.00;
		this.revenueChangePY01 = 0.00;
		this.revenueChangeY00 = 0.00;
		this.revenueChangeFY01 = 0.00;
		this.revenueChangeFY02 = 0.00;
		this.revenueChangeFY03 = 0.00;
		this.revenueChangeFY04 = 0.00;
		this.revenueChangeFY05 = 0.00;
		this.cogsPY03 = 0.00;
		this.cogsPY02 = 0.00;
		this.cogsPY01 = 0.00;
		this.cogsY00 = 0.00;
		this.cogsFY01 = 0.00;
		this.cogsFY02 = 0.00;
		this.cogsFY03 = 0.00;
		this.cogsFY04 = 0.00;
		this.cogsFY05 = 0.00;
		this.cogsFromRevenuePY03 = 0.00;
		this.cogsFromRevenuePY02 = 0.00;
		this.cogsFromRevenuePY01 = 0.00;
		this.cogsFromRevenueY00 = 0.00;
		this.cogsFromRevenueFY01 = 0.00;
		this.cogsFromRevenueFY02 = 0.00;
		this.cogsFromRevenueFY03 = 0.00;
		this.cogsFromRevenueFY04 = 0.00;
		this.cogsFromRevenueFY05 = 0.00;
		this.otherCostsPY03 = 0.00;
		this.otherCostsPY02 = 0.00;
		this.otherCostsPY01 = 0.00;
		this.otherCostsY00 = 0.00;
		this.otherCostsFY01 = 0.00;
		this.otherCostsFY02 = 0.00;
		this.otherCostsFY03 = 0.00;
		this.otherCostsFY04 = 0.00;
		this.otherCostsFY05 = 0.00;
		this.otherCostsFromRevenuePY03 = 0.00;
		this.otherCostsFromRevenuePY02 = 0.00;
		this.otherCostsFromRevenuePY01 = 0.00;
		this.otherCostsFromRevenueY00 = 0.00;
		this.otherCostsFromRevenueFY01 = 0.00;
		this.otherCostsFromRevenueFY02 = 0.00;
		this.otherCostsFromRevenueFY03 = 0.00;
		this.otherCostsFromRevenueFY04 = 0.00;
		this.otherCostsFromRevenueFY05 = 0.00;
		this.ebitdaPY03 = 0.00;
		this.ebitdaPY02 = 0.00;
		this.ebitdaPY01 = 0.00;
		this.ebitdaY00 = 0.00;
		this.ebitdaFY01 = 0.00;
		this.ebitdaFY02 = 0.00;
		this.ebitdaFY03 = 0.00;
		this.ebitdaFY04 = 0.00;
		this.ebitdaFY05 = 0.00;
		this.ebitdaFromRevenuePY03 = 0.00;
		this.ebitdaFromRevenuePY02 = 0.00;
		this.ebitdaFromRevenuePY01 = 0.00;
		this.ebitdaFromRevenueY00 = 0.00;
		this.ebitdaFromRevenueFY01 = 0.00;
		this.ebitdaFromRevenueFY02 = 0.00;
		this.ebitdaFromRevenueFY03 = 0.00;
		this.ebitdaFromRevenueFY04 = 0.00;
		this.ebitdaFromRevenueFY05 = 0.00;
		this.depreciationPY03 = 0.00;
		this.depreciationPY02 = 0.00;
		this.depreciationPY01 = 0.00;
		this.depreciationY00 = 0.00;
		this.depreciationFY01 = 0.00;
		this.depreciationFY02 = 0.00;
		this.depreciationFY03 = 0.00;
		this.depreciationFY04 = 0.00;
		this.depreciationFY05 = 0.00;
		this.depreciationIntangiblePY03 = 0.00;
		this.depreciationIntangiblePY02 = 0.00;
		this.depreciationIntangiblePY01 = 0.00;
		this.depreciationIntangibleY00 = 0.00;
		this.depreciationIntangibleFY01 = 0.00;
		this.depreciationIntangibleFY02 = 0.00;
		this.depreciationIntangibleFY03 = 0.00;
		this.depreciationIntangibleFY04 = 0.00;
		this.depreciationIntangibleFY05 = 0.00;
		this.interestGainsPY03 = 0.00;
		this.interestGainsPY02 = 0.00;
		this.interestGainsPY01 = 0.00;
		this.interestGainsY00 = 0.00;
		this.interestLossPY03 = 0.00;
		this.interestLossPY02 = 0.00;
		this.interestLossPY01 = 0.00;
		this.interestLossY00 = 0.00;
		this.interestLossFY01 = 0.00;
		this.interestLossFY02 = 0.00;
		this.interestLossFY03 = 0.00;
		this.interestLossFY04 = 0.00;
		this.interestLossFY05 = 0.00;
		this.interestGainsFY01 = 0.00;
		this.interestGainsFY02 = 0.00;
		this.interestGainsFY03 = 0.00;
		this.interestGainsFY04 = 0.00;
		this.interestGainsFY05 = 0.00;
		this.ebtPY03 = 0.00;
		this.ebtPY02 = 0.00;
		this.ebtPY01 = 0.00;
		this.ebtY00 = 0.00;
		this.ebtFY01 = 0.00; 
		this.ebtFY02 = 0.00; 
		this.ebtFY03 = 0.00;
		this.ebtFY04 = 0.00;
		this.ebtFY05 = 0.00; 
		this.incomeTaxPY03 = 0.00;
		this.incomeTaxPY02 = 0.00;
		this.incomeTaxPY01 = 0.00;
		this.incomeTaxY00 = 0.00;
		this.incomeTaxFY01 = 0.00; 
		this.incomeTaxFY02 = 0.00;
		this.incomeTaxFY03 = 0.00;
		this.incomeTaxFY04 = 0.00;
		this.incomeTaxFY05 = 0.00;
		this.incomeTaxFromEbtPY03 = 0.00;
		this.incomeTaxFromEbtPY02 = 0.00;
		this.incomeTaxFromEbtPY01 = 0.00;
		this.incomeTaxFromEbtY00 = 0.00;
		this.incomeTaxFromEbtFY01 = 0.00;
		this.incomeTaxFromEbtFY02 = 0.00;
		this.incomeTaxFromEbtFY03 = 0.00;
		this.incomeTaxFromEbtFY04 = 0.00;
		this.incomeTaxFromEbtFY05 = 0.00;
		this.totalIncomePY03 = 0.00;
		this.totalIncomePY02 = 0.00;
		this.totalIncomePY01 = 0.00;
		this.totalIncomeY00 = 0.00;
		this.totalIncomeFY01 = 0.00;
		this.totalIncomeFY02 = 0.00;
		this.totalIncomeFY03 = 0.00;
		this.totalIncomeFY04 = 0.00;
		this.totalIncomeFY05 = 0.00;
		this.assetsY00 = 0.00;
		this.assetsPY01 = 0.00;
		this.assetsPY02 = 0.00;
		this.assetsPY03 = 0.00;
		this.assetsFY01 = 0.00;
		this.assetsFY02 = 0.00;
		this.assetsFY03 = 0.00;
		this.assetsFY04 = 0.00;
		this.assetsFY05 = 0.00;
		this.finAssetsY00 = 0.00;
		this.finAssetsPY01 = 0.00;
		this.finAssetsPY02 = 0.00;
		this.finAssetsPY03 = 0.00;
		this.finAssetsFY01 = 0.00;
		this.finAssetsFY02 = 0.00; 
		this.finAssetsFY03 = 0.00; 
		this.finAssetsFY04 = 0.00; 
		this.finAssetsFY05 = 0.00; 
		this.financialAssetsChangePY02 = 0.00;
		this.financialAssetsChangePY01 = 0.00;
		this.financialAssetsChangeY00 = 0.00;
		this.financialAssetsChangeFY01 = 0.00;
		this.financialAssetsChangeFY02 = 0.00;
		this.financialAssetsChangeFY03 = 0.00;
		this.financialAssetsChangeFY04 = 0.00;
		this.financialAssetsChangeFY05 = 0.00;
		this.interestGainsFromFinancialAssetsPY03 = 0.00;
		this.interestGainsFromFinancialAssetsPY02 = 0.00;
		this.interestGainsFromFinancialAssetsPY01 = 0.00;
		this.interestGainsFromFinancialAssetsY00 = 0.00;
		this.interestGainsFromFinancialAssetsFY01 = 0.00;
		this.interestGainsFromFinancialAssetsFY02 = 0.00;
		this.interestGainsFromFinancialAssetsFY03 = 0.00;
		this.interestGainsFromFinancialAssetsFY04 = 0.00;
		this.interestGainsFromFinancialAssetsFY05 = 0.00;
		this.propAssetsPY03 = 0.00;
		this.propAssetsPY02 = 0.00;
		this.propAssetsPY01 = 0.00;
		this.propAssetsY00 = 0.00;
		this.propAssetsFY01 = 0.00;
		this.propAssetsFY02 = 0.00;
		this.propAssetsFY03 = 0.00;
		this.propAssetsFY04 = 0.00;
		this.propAssetsFY05 = 0.00;
		this.propertyAssetsChangePY02 = 0.00;
		this.propertyAssetsChangePY01 = 0.00;
		this.propertyAssetsChangeY00 = 0.00;
		this.propertyAssetsChangeFY01 = 0.00;
		this.propertyAssetsChangeFY02 = 0.00;
		this.propertyAssetsChangeFY03 = 0.00;
		this.propertyAssetsChangeFY04 = 0.00;
		this.propertyAssetsChangeFY05 = 0.00;
		this.depreciationFromPropertyAssetsPY03 = 0.00;
		this.depreciationFromPropertyAssetsPY02 = 0.00;
		this.depreciationFromPropertyAssetsPY01 = 0.00;
		this.depreciationFromPropertyAssetsY00 = 0.00;
		this.depreciationFromPropertyAssetsFY01 = 0.00;
		this.depreciationFromPropertyAssetsFY02 = 0.00;
		this.depreciationFromPropertyAssetsFY03 = 0.00;
		this.depreciationFromPropertyAssetsFY04 = 0.00;
		this.depreciationFromPropertyAssetsFY05 = 0.00;
		this.intAssetsPY03 = 0.00;
		this.intAssetsPY02 = 0.00;
		this.intAssetsPY01 = 0.00;
		this.intAssetsY00 = 0.00;
		this.intAssetsFY01 = 0.00;
		this.intAssetsFY02 = 0.00;
		this.intAssetsFY03 = 0.00;
		this.intAssetsFY04 = 0.00;
		this.intAssetsFY05 = 0.00;
		this.intangibleAssetsChangePY02 = 0.00;
		this.intangibleAssetsChangePY01 = 0.00;
		this.intangibleAssetsChangeY00 = 0.00;
		this.intangibleAssetsChangeFY01 = 0.00;
		this.intangibleAssetsChangeFY02 = 0.00;
		this.intangibleAssetsChangeFY03 = 0.00;
		this.intangibleAssetsChangeFY04 = 0.00;
		this.intangibleAssetsChangeFY05 = 0.00;
		this.depreciationFromIntangibleAssetsPY03 = 0.00;
		this.depreciationFromIntangibleAssetsPY02 = 0.00;
		this.depreciationFromIntangibleAssetsPY01 = 0.00;
		this.depreciationFromIntangibleAssetsY00 = 0.00;
		this.depreciationFromIntangibleAssetsFY01 = 0.00;
		this.depreciationFromIntangibleAssetsFY02 = 0.00;
		this.depreciationFromIntangibleAssetsFY03 = 0.00;
		this.depreciationFromIntangibleAssetsFY04 = 0.00;
		this.depreciationFromIntangibleAssetsFY05 = 0.00;
		this.otherAssetsPY03 = 0.00;
		this.otherAssetsPY02 = 0.00;
		this.otherAssetsPY01 = 0.00;
		this.otherAssetsY00 = 0.00;
		this.otherAssetsFY01 = 0.00;
		this.otherAssetsFY02 = 0.00;
		this.otherAssetsFY03 = 0.00;
		this.otherAssetsFY04 = 0.00;
		this.otherAssetsFY05 = 0.00;
		this.otherAssetsChangePY02 = 0.00;
		this.otherAssetsChangePY01 = 0.00;
		this.otherAssetsChangeY00 = 0.00;
		this.otherAssetsChangeFY01 = 0.00;
		this.otherAssetsChangeFY02 = 0.00;
		this.otherAssetsChangeFY03 = 0.00;
		this.otherAssetsChangeFY04 = 0.00;
		this.otherAssetsChangeFY05 = 0.00;
		this.inventoryPY03 = 0.00;
		this.inventoryPY02 = 0.00;
		this.inventoryPY01 = 0.00;
		this.inventoryY00 = 0.00;
		this.inventoryFY01 = 0.00;
		this.inventoryFY02 = 0.00;
		this.inventoryFY03 = 0.00; 
		this.inventoryFY04 = 0.00;
		this.inventoryFY05 = 0.00;
		this.inventoryTurnoverPY03 = 0.00;
		this.inventoryTurnoverPY02 = 0.00;
		this.inventoryTurnoverPY01 = 0.00;
		this.inventoryTurnoverY00 = 0.00;
		this.inventoryTurnoverFY01 = 0.00;
		this.inventoryTurnoverFY02 = 0.00;
		this.inventoryTurnoverFY03 = 0.00;
		this.inventoryTurnoverFY04 = 0.00;
		this.inventoryTurnoverFY05 = 0.00;
		this.receivablesPY03 = 0.00;
		this.receivablesPY02 = 0.00;
		this.receivablesPY01 = 0.00;
		this.receivablesY00 = 0.00;
		this.receivablesFY01 = 0.00;
		this.receivablesFY02 = 0.00;
		this.receivablesFY03 = 0.00;
		this.receivablesFY04 = 0.00;
		this.receivablesFY05 = 0.00;
		this.receivablesTurnoverPY03 = 0.00;
		this.receivablesTurnoverPY02 = 0.00;
		this.receivablesTurnoverPY01 = 0.00;
		this.receivablesTurnoverY00 = 0.00;
		this.receivablesTurnoverFY01 = 0.00;
		this.receivablesTurnoverFY02 = 0.00;
		this.receivablesTurnoverFY03 = 0.00;
		this.receivablesTurnoverFY04 = 0.00;
		this.receivablesTurnoverFY05 = 0.00;
		this.otherNCAPY03 = 0.00;
		this.otherNCAPY02 = 0.00;
		this.otherNCAPY01 = 0.00;
		this.otherNCAY00 = 0.00;
		this.otherNCAFY01 = 0.00;
		this.otherNCAFY02 = 0.00;
		this.otherNCAFY03 = 0.00;
		this.otherNCAFY04 = 0.00;
		this.otherNCAFY05 = 0.00;
		this.otherNCAFromNCAPY02 = 0.00;
		this.otherNCAFromNCAPY01 = 0.00;
		this.otherNCAFromNCAY00 = 0.00;
		this.otherNCAFromNCAFY01 = 0.00;
		this.otherNCAFromNCAFY02 = 0.00;
		this.otherNCAFromNCAFY03 = 0.00;
		this.otherNCAFromNCAFY04 = 0.00;
		this.otherNCAFromNCAFY05 = 0.00;
		this.ncaPY03 = 0.00;
		this.ncaPY02 = 0.00;
		this.ncaPY01 = 0.00;
		this.ncaY00 = 0.00;
		this.ncaFY01 = 0.00;
		this.ncaFY02 = 0.00;
		this.ncaFY03 = 0.00;
		this.ncaFY04 = 0.00;
		this.ncaFY05 = 0.00;
		this.cashPY03 = 0.00;
		this.cashPY02 = 0.00;
		this.cashPY01 = 0.00;
		this.cashY00 = 0.00;
		this.cashFY01 = 0.00;
		this.cashFY02 = 0.00;
		this.cashFY03 = 0.00;
		this.cashFY04 = 0.00;
		this.cashFY05 = 0.00;
		this.totalAssetsPY03 = 0.00;
		this.totalAssetsPY02 = 0.00;
		this.totalAssetsPY01 = 0.00;
		this.totalAssetsY00 = 0.00;
		this.totalAssetsFY01 = 0.00;
		this.totalAssetsFY02 = 0.00;
		this.totalAssetsFY03 = 0.00;
		this.totalAssetsFY04 = 0.00;
		this.totalAssetsFY05 = 0.00;
		this.shareCapitalPY03 = 0.00;
		this.shareCapitalPY02 = 0.00;
		this.shareCapitalPY01 = 0.00;
		this.shareCapitalY00 = 0.00;
		this.shareCapitalChangePY02 = 0.00;
		this.shareCapitalChangePY01 = 0.00;
		this.shareCapitalChangeY00 = 0.00;
		this.shareCapitalChangeFY01 = 0.00;
		this.shareCapitalChangeFY02 = 0.00;
		this.shareCapitalChangeFY03 = 0.00;
		this.shareCapitalChangeFY04 = 0.00;
		this.shareCapitalChangeFY05 = 0.00;
		this.shareCapitalFY01 = 0.00;
		this.shareCapitalFY02 = 0.00;
		this.shareCapitalFY03 = 0.00;
		this.shareCapitalFY04 = 0.00;
		this.shareCapitalFY05 = 0.00;
		this.reservesPY03 = 0.00;
		this.reservesPY02 = 0.00;
		this.reservesPY01 = 0.00;
		this.reservesY00 = 0.00;
		this.reservesFY01 = 0.00;
		this.reservesFY02 = 0.00;
		this.reservesFY03 = 0.00;
		this.reservesFY04 = 0.00;
		this.reservesFY05 = 0.00;
		this.reservesChangePY02 = 0.00;
		this.reservesChangePY01 = 0.00;
		this.reservesChangeY00 = 0.00;
		this.reservesChangeFY01 = 0.00;
		this.reservesChangeFY02 = 0.00;
		this.reservesChangeFY03 = 0.00;
		this.reservesChangeFY04 = 0.00;
		this.reservesChangeFY05 = 0.00;
		this.dividendsPaidRatePY03 = 0.00;
		this.dividendsPaidRatePY02 = 0.00;
		this.dividendsPaidRatePY01 = 0.00;
		this.dividendsPaidRateY00 = 0.00;
		this.dividendsPaidRateFY01 = 0.00;
		this.dividendsPaidRateFY02 = 0.00;
		this.dividendsPaidRateFY03 = 0.00;
		this.dividendsPaidRateFY04 = 0.00;
		this.dividendsPaidRateFY05 = 0.00;
		this.otherEquityPY03 = 0.00;
		this.otherEquityPY02 = 0.00;
		this.otherEquityPY01 = 0.00;
		this.otherEquityY00 = 0.00;
		this.otherEquityFY01 = 0.00;
		this.otherEquityFY02 = 0.00;
		this.otherEquityFY03 = 0.00;
		this.otherEquityFY04 = 0.00;
		this.otherEquityFY05 = 0.00;
		this.otherEquityChangePY02 = 0.00;
		this.otherEquityChangePY01 = 0.00;
		this.otherEquityChangeY00 = 0.00;
		this.otherEquityChangeFY01 = 0.00;
		this.otherEquityChangeFY02 = 0.00;
		this.otherEquityChangeFY03 = 0.00;
		this.otherEquityChangeFY04 = 0.00;
		this.otherEquityChangeFY05 = 0.00;
		this.totalEquityPY03 = 0.00;
		this.totalEquityPY02 = 0.00;
		this.totalEquityPY01 = 0.00;
		this.totalEquityY00 = 0.00;
		this.totalEquityFY01 = 0.00;
		this.totalEquityFY02 = 0.00;
		this.totalEquityFY03 = 0.00;
		this.totalEquityFY04 = 0.00;
		this.totalEquityFY05 = 0.00;
		this.longTermBankDebtPY03 = 0.00;
		this.longTermBankDebtPY02 = 0.00;
		this.longTermBankDebtPY01 = 0.00;
		this.longTermBankDebtY00 = 0.00;
		this.longTermBankDebtFY01 = 0.00; 
		this.longTermBankDebtFY02 = 0.00; 
		this.longTermBankDebtFY03 = 0.00; 
		this.longTermBankDebtFY04 = 0.00; 
		this.longTermBankDebtFY05 = 0.00; 
		this.longTermBankDebtChangePY02 = 0.00;
		this.longTermBankDebtChangePY01 = 0.00;
		this.longTermBankDebtChangeY00 = 0.00;
		this.longTermBankDebtChangeFY01 = 0.00;
		this.longTermBankDebtChangeFY02 = 0.00;
		this.longTermBankDebtChangeFY03 = 0.00;
		this.longTermBankDebtChangeFY04 = 0.00;
		this.longTermBankDebtChangeFY05 = 0.00;
		this.interestLossFromBankDebtPY03 = 0.00;
		this.interestLossFromBankDebtPY02 = 0.00;
		this.interestLossFromBankDebtPY01 = 0.00;
		this.interestLossFromBankDebtY00 = 0.00;
		this.interestLossFromBankDebtFY01 = 0.00;
		this.interestLossFromBankDebtFY02 = 0.00;
		this.interestLossFromBankDebtFY03 = 0.00;
		this.interestLossFromBankDebtFY04 = 0.00;
		this.interestLossFromBankDebtFY05 = 0.00;
		this.accrualsPY03 = 0.00;
		this.accrualsPY02 = 0.00;
		this.accrualsPY01 = 0.00;
		this.accrualsY00 = 0.00;
		this.accrualsFY01 = 0.00;
		this.accrualsFY02 = 0.00;
		this.accrualsFY03 = 0.00;
		this.accrualsFY04 = 0.00;
		this.accrualsFY05 = 0.00;
		this.accrualsChangePY02 = 0.00;
		this.accrualsChangePY01 = 0.00;
		this.accrualsChangeY00 = 0.00;
		this.accrualsChangeFY01 = 0.00;
		this.accrualsChangeFY02 = 0.00;
		this.accrualsChangeFY03 = 0.00;
		this.accrualsChangeFY04 = 0.00;
		this.accrualsChangeFY05 = 0.00;
		this.totalLongTermLiabilitiesPY03 = 0.00;
		this.totalLongTermLiabilitiesPY02 = 0.00;
		this.totalLongTermLiabilitiesPY01 = 0.00;
		this.totalLongTermLiabilitiesY00 = 0.00;
		this.totalLongTermLiabilitiesFY01 = 0.00;
		this.totalLongTermLiabilitiesFY02 = 0.00;
		this.totalLongTermLiabilitiesFY03 = 0.00;
		this.totalLongTermLiabilitiesFY04 = 0.00;
		this.totalLongTermLiabilitiesFY05 = 0.00;
		this.shortTermBankDebtPY03 = 0.00;
		this.shortTermBankDebtPY02 = 0.00;
		this.shortTermBankDebtPY01 = 0.00;
		this.shortTermBankDebtY00 = 0.00;
		this.shortTermBankDebtFY01 = 0.00; 
		this.shortTermBankDebtFY02 = 0.00; 
		this.shortTermBankDebtFY03 = 0.00; 
		this.shortTermBankDebtFY04 = 0.00; 
		this.shortTermBankDebtFY05 = 0.00; 
		this.shortTermBankDebtChangePY02 = 0.00;
		this.shortTermBankDebtChangePY01 = 0.00;
		this.shortTermBankDebtChangeY00 = 0.00;
		this.shortTermBankDebtChangeFY01 = 0.00; 
		this.shortTermBankDebtChangeFY02 = 0.00;
		this.shortTermBankDebtChangeFY03 = 0.00;
		this.shortTermBankDebtChangeFY04 = 0.00; 
		this.shortTermBankDebtChangeFY05 = 0.00;
		this.tradePayablesPY03 = 0.00;
		this.tradePayablesPY02 = 0.00;
		this.tradePayablesPY01 = 0.00;
		this.tradePayablesY00 = 0.00;
		this.tradePayablesFY01 = 0.00;
		this.tradePayablesFY02 = 0.00;
		this.tradePayablesFY03 = 0.00;
		this.tradePayablesFY04 = 0.00;
		this.tradePayablesFY05 = 0.00;
		this.daysPayablesOutstandingPY03 = 0.00;
		this.daysPayablesOutstandingPY02 = 0.00;
		this.daysPayablesOutstandingPY01 = 0.00;
		this.daysPayablesOutstandingY00 = 0.00;
		this.daysPayablesOutstandingFY01 = 0.00;
		this.daysPayablesOutstandingFY02 = 0.00;
		this.daysPayablesOutstandingFY03 = 0.00;
		this.daysPayablesOutstandingFY04 = 0.00;
		this.daysPayablesOutstandingFY05 = 0.00;
		this.otherShortTermLiabilitiesPY03 = 0.00;
		this.otherShortTermLiabilitiesPY02 = 0.00;
		this.otherShortTermLiabilitiesPY01 = 0.00;
		this.otherShortTermLiabilitiesY00 = 0.00;
		this.otherShortTermLiabilitiesFY01 = 0.00;
		this.otherShortTermLiabilitiesFY02 = 0.00;
		this.otherShortTermLiabilitiesFY03 = 0.00;
		this.otherShortTermLiabilitiesFY04 = 0.00;
		this.otherShortTermLiabilitiesFY05 = 0.00;
		this.otherShortTermLiabilitiesChangePY02 = 0.00;
		this.otherShortTermLiabilitiesChangePY01 = 0.00;
		this.otherShortTermLiabilitiesChangeY00 = 0.00;
		this.otherShortTermLiabilitiesChangeFY01 = 0.00;
		this.otherShortTermLiabilitiesChangeFY02 = 0.00;
		this.otherShortTermLiabilitiesChangeFY03 = 0.00;
		this.otherShortTermLiabilitiesChangeFY04 = 0.00;
		this.otherShortTermLiabilitiesChangeFY05 = 0.00;
		this.totalShortTermLiabilitiesPY03 = 0.00;
		this.totalShortTermLiabilitiesPY02 = 0.00;
		this.totalShortTermLiabilitiesPY01 = 0.00;
		this.totalShortTermLiabilitiesY00 = 0.00;
		this.totalShortTermLiabilitiesFY01 = 0.00;
		this.totalShortTermLiabilitiesFY02 = 0.00;
		this.totalShortTermLiabilitiesFY03 = 0.00;
		this.totalShortTermLiabilitiesFY04 = 0.00;
		this.totalShortTermLiabilitiesFY05 = 0.00;
		this.totalLiabilitiesPY03 = 0.00;
		this.totalLiabilitiesPY02 = 0.00;
		this.totalLiabilitiesPY01 = 0.00;
		this.totalLiabilitiesY00 = 0.00;
		this.totalLiabilitiesFY01 = 0.00;
		this.totalLiabilitiesFY02 = 0.00;
		this.totalLiabilitiesFY03 = 0.00;
		this.totalLiabilitiesFY04 = 0.00;
		this.totalLiabilitiesFY05 = 0.00;
		this.cfTotalIncomeFY01 = 0.00;
		this.cfTotalIncomeFY02 = 0.00;
		this.cfTotalIncomeFY03 = 0.00;
		this.cfTotalIncomeFY04 = 0.00;
		this.cfTotalIncomeFY05 = 0.00;
		this.cfTotalIncomeTV = 0.00;
		this.cfDepreciationTV = 0.00;
		this.cfDepreciationIntangibleTV = 0.00;
		this.cfAccrualsFY01 = 0.00;
		this.cfAccrualsFY02 = 0.00;
		this.cfAccrualsFY03 = 0.00;
		this.cfAccrualsFY04 = 0.00;
		this.cfAccrualsFY05 = 0.00;
		this.cfAccrualsTV = 0.00;
		this.cfAssetsInvestFY01 = 0.00;
		this.cfAssetsInvestFY02 = 0.00;
		this.cfAssetsInvestFY03 = 0.00;
		this.cfAssetsInvestFY04 = 0.00;
		this.cfAssetsInvestFY05 = 0.00;
		this.cfAssetsInvestTV = 0.00;
		this.cfWorkingCapitalInvestFY01 = 0.00;
		this.cfWorkingCapitalInvestFY02 = 0.00;
		this.cfWorkingCapitalInvestFY03 = 0.00;
		this.cfWorkingCapitalInvestFY04 = 0.00;
		this.cfWorkingCapitalInvestFY05 = 0.00;
		this.cfWorkingCapitalInvestTV = 0.00;
		this.cfDebtChangeFY01 = 0.00;
		this.cfDebtChangeFY02 = 0.00;
		this.cfDebtChangeFY03 = 0.00;
		this.cfDebtChangeFY04 = 0.00;
		this.cfDebtChangeFY05 = 0.00;
		this.cfDebtChangeTV = 0.00;
		this.cashflowToEquityFY01 = 0.00;
		this.cashflowToEquityFY02 = 0.00;
		this.cashflowToEquityFY03 = 0.00;
		this.cashflowToEquityFY04 = 0.00;
		this.cashflowToEquityFY05 = 0.00;
		this.cashflowToEquityTV = 0.00;
		this.discountedCashflowFY01 = 0.00;
		this.discountedCashflowFY02 = 0.00;
		this.discountedCashflowFY03 = 0.00;
		this.discountedCashflowFY04 = 0.00;
		this.discountedCashflowFY05 = 0.00;
		this.discountedCashflowTV = 0.00;
		this.fairValue = 0.001;
		this.fairValuePerShare = 0.001;
		this.leveragePY03 = 0.00;
		this.leveragePY02 = 0.00;
		this.leveragePY01 = 0.00;
		this.leverageY00 = 0.00;
		this.leverageFY01 = 0.00;
		this.leverageFY02 = 0.00;
		this.leverageFY03 = 0.00;
		this.leverageFY04 = 0.00;
		this.leverageFY05 = 0.00;
		this.assetIntensityPY03 = 0.00;
		this.assetIntensityPY02 = 0.00;
		this.assetIntensityPY01 = 0.00;
		this.assetIntensityY00 = 0.00;
		this.assetIntensityFY01 = 0.00;
		this.assetIntensityFY02 = 0.00;
		this.assetIntensityFY03 = 0.00;
		this.assetIntensityFY04 = 0.00;
		this.assetIntensityFY05 = 0.00;
		this.circulatingIntensityPY03 = 0.00;
		this.circulatingIntensityPY02 = 0.00;
		this.circulatingIntensityPY01 = 0.00;
		this.circulatingIntensityY00 = 0.00;
		this.circulatingIntensityFY01 = 0.00;
		this.circulatingIntensityFY02 = 0.00;
		this.circulatingIntensityFY03 = 0.00;
		this.circulatingIntensityFY04 = 0.00;
		this.circulatingIntensityFY05 = 0.00;
		this.returnOnSalesPY03 = 0.00;
		this.returnOnSalesPY02 = 0.00;
		this.returnOnSalesPY01 = 0.00;
		this.returnOnSalesY00 = 0.00;
		this.returnOnSalesFY01 = 0.00;
		this.returnOnSalesFY02 = 0.00;
		this.returnOnSalesFY03 = 0.00;
		this.returnOnSalesFY04 = 0.00;
		this.returnOnSalesFY05 = 0.00;
		this.returnOnEBITDAPY03 = 0.00;
		this.returnOnEBITDAPY02 = 0.00;
		this.returnOnEBITDAPY01 = 0.00;
		this.returnOnEBITDAY00 = 0.00;
		this.returnOnEBITDAFY01 = 0.00;
		this.returnOnEBITDAFY02 = 0.00;
		this.returnOnEBITDAFY03 = 0.00;
		this.returnOnEBITDAFY04 = 0.00;
		this.returnOnEBITDAFY05 = 0.00;
		this.returnOnEquityPY03 = 0.00;
		this.returnOnEquityPY02 = 0.00;
		this.returnOnEquityPY01 = 0.00;
		this.returnOnEquityY00 = 0.00;
		this.returnOnEquityFY01 = 0.00;
		this.returnOnEquityFY02 = 0.00;
		this.returnOnEquityFY03 = 0.00;
		this.returnOnEquityFY04 = 0.00;
		this.returnOnEquityFY05 = 0.00;
		this.totalReturnOnInvestPY03 = 0.00;
		this.totalReturnOnInvestPY02 = 0.00;
		this.totalReturnOnInvestPY01 = 0.00;
		this.totalReturnOnInvestY00 = 0.00;
		this.totalReturnOnInvestFY01 = 0.00;
		this.totalReturnOnInvestFY02 = 0.00;
		this.totalReturnOnInvestFY03 = 0.00;
		this.totalReturnOnInvestFY04 = 0.00;
		this.totalReturnOnInvestFY05 = 0.00;


	}

	// Getter und Setter fuer die Grunddaten des Unternehmens

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getShareVolume() {
		return shareVolume;
	}

	public void setShareVolume(double shareVolume) {
		this.shareVolume = shareVolume;
	}

	public double getCurrentSharePrice() {
		return currentSharePrice;
	}

	public void setCurrentSharePrice(double currentSharePrice) {
		this.currentSharePrice = currentSharePrice;
	}

	public double getFairValueFromSharePrice() {
		return fairValueFromSharePrice;
	}

	public void setFairValueFromSharePrice() {
		if (this.currentSharePrice == 0.00) {
			this.fairValueFromSharePrice = 0.00;
		} else {
			this.fairValueFromSharePrice = ((this.fairValuePerShare / this.currentSharePrice) - 1) * 100;
		}

	}

	public double getDividendsPaidPY03() {
		return dividendsPaidPY03;
	}

	public void setDividendsPaidPY03(double dividendsPaidPY03) {
		this.dividendsPaidPY03 = dividendsPaidPY03;
	}

	public double getDividendsPaidPY02() {
		return dividendsPaidPY02;
	}

	public void setDividendsPaidPY02(double dividendsPaidPY02) {
		this.dividendsPaidPY02 = dividendsPaidPY02;
	}

	public double getDividendsPaidPY01() {
		return dividendsPaidPY01;
	}

	public void setDividendsPaidPY01(double dividendsPaidPY01) {
		this.dividendsPaidPY01 = dividendsPaidPY01;
	}

	public double getDividendsPaidY00() {
		return dividendsPaidY00;
	}

	public void setDividendsPaidY00(double dividendsPaidY00) {
		this.dividendsPaidY00 = dividendsPaidY00;
	}

	public double getRiskFreeInterestRate() {
		return riskFreeInterestRate;
	}

	public void setRiskFreeInterestRate(double riskFreeInterestRate) {
		this.riskFreeInterestRate = riskFreeInterestRate;
	}

	public double getMarketRiskPremium() {
		return marketRiskPremium;
	}

	public void setMarketRiskPremium(double marketRiskPremium) {
		this.marketRiskPremium = marketRiskPremium;
	}

	public double getGrowthRateEndValue() {
		return growthRateEndValue;
	}

	public void setGrowthRateEndValue(double growthRateEndValue) {
		this.growthRateEndValue = growthRateEndValue;
	}

	
	/**
	 * Getter und Setter fuer die Gewinn und Verlustrechnung sowie Berechnung von
	 * Umsatz, EBITDA, EBIT,EBT, Jahresergebnis und zugehoeriger
	 * Verhältniskennzahlen.
	 **/
	public double getRevenuePY03() {
		return revenuePY03;
	}

	public void setRevenuePY03(double revenuePY03) {
		this.revenuePY03 = revenuePY03;
	}

	public double getRevenuePY02() {
		return revenuePY02;
	}

	public void setRevenuePY02(double revenuePY02) {
		this.revenuePY02 = revenuePY02;
	}

	public double getRevenuePY01() {
		return revenuePY01;
	}

	public void setRevenuePY01(double revenuePY01) {
		this.revenuePY01 = revenuePY01;
	}

	public double getRevenueY00() {
		return revenueY00;
	}

	public void setRevenueY00(double revenueY00) {
		this.revenueY00 = revenueY00;
	}

	public double getRevenueFY01() {
		return revenueFY01;
	}

	public void setRevenueFY01() {
		this.revenueFY01 = this.revenueY00 * (1 + (this.revenueChangeFY01 / 100));
	}

	public double getRevenueFY02() {
		return revenueFY02;
	}

	public void setRevenueFY02() {
		this.revenueFY02 = this.revenueFY01 * (1 + (this.revenueChangeFY02 / 100));
	}

	public double getRevenueFY03() {
		return revenueFY03;
	}

	public void setRevenueFY03() {
		this.revenueFY03 = this.revenueFY02 * (1 + (this.revenueChangeFY03 / 100));
	}

	public double getRevenueFY04() {
		return revenueFY04;
	}

	public void setRevenueFY04() {
		this.revenueFY04 = this.revenueFY03 * (1 + (this.revenueChangeFY04 / 100));
	}
	
	public double getRevenueFY05() {
		return revenueFY05;
	}
	
	public void setRevenueFY05() {
		this.revenueFY05 = this.revenueFY04 * (1 + (this.revenueChangeFY05 / 100));
	}

	public double getRevenueChangePY02() {
		return revenueChangePY02;
	}

	public void setRevenueChangePY02() {
		if (this.revenuePY03 != 0) {
			this.revenueChangePY02 = ((this.revenuePY02 / this.revenuePY03) - 1) * 100;
		} else {
			this.revenueChangePY02 = 0.00;
		}

	}

	public double getRevenueChangePY01() {
		return revenueChangePY01;
	}

	public void setRevenueChangePY01() {
		if (this.revenuePY02 != 0) {
			this.revenueChangePY01 = ((this.revenuePY01 / this.revenuePY02) - 1) * 100;
		} else {
			this.revenueChangePY01 = 0.00;
		}

	}

	public double getRevenueChangeY00() {
		return revenueChangeY00;
	}

	public void setRevenueChangeY00() {
		if (this.revenuePY01 != 0) {
			this.revenueChangeY00 = ((this.revenueY00 / this.revenuePY01) - 1) * 100;
		} else {
			this.revenueChangeY00 = 0.00;
		}

	}

	public double getRevenueChangeFY01() {
		return revenueChangeFY01;
	}

	public void setRevenueChangeFY01(double revenueChangeFY01) {
		this.revenueChangeFY01 = revenueChangeFY01;
	}

	public double getRevenueChangeFY02() {
		return revenueChangeFY02;
	}

	public void setRevenueChangeFY02(double revenueChangeFY02) {
		this.revenueChangeFY02 = revenueChangeFY02;
	}

	public double getRevenueChangeFY03() {
		return revenueChangeFY03;
	}

	public void setRevenueChangeFY03(double revenueChangeFY03) {
		this.revenueChangeFY03 = revenueChangeFY03;
	}

	public double getRevenueChangeFY04() {
		return revenueChangeFY04;
	}

	public void setRevenueChangeFY04(double revenueChangeFY04) {
		this.revenueChangeFY04 = revenueChangeFY04;
	}
	

	public double getRevenueChangeFY05() {
		return revenueChangeFY05;
	}

	public void setRevenueChangeFY05(double revenueChangeFY05) {
		this.revenueChangeFY05 = revenueChangeFY05;
	}

	public double getCogsPY03() {
		return cogsPY03;
	}

	public void setCogsPY03(double cogsPY03) {
		this.cogsPY03 = cogsPY03;
	}

	public double getCogsPY02() {
		return cogsPY02;
	}

	public void setCogsPY02(double cogsPY02) {
		this.cogsPY02 = cogsPY02;
	}

	public double getCogsPY01() {
		return cogsPY01;
	}

	public void setCogsPY01(double cogsPY01) {
		this.cogsPY01 = cogsPY01;
	}

	public double getCogsY00() {
		return cogsY00;
	}

	public void setCogsY00(double cogsY00) {
		this.cogsY00 = cogsY00;
	}

	public double getCogsFY01() {
		return cogsFY01;
	}

	public void setCogsFY01() {
		this.cogsFY01 = this.revenueFY01 * (this.cogsFromRevenueFY01 / 100);
	}

	public double getCogsFY02() {
		return cogsFY02;
	}

	public void setCogsFY02() {
		this.cogsFY02 = this.revenueFY02 * (this.cogsFromRevenueFY02 / 100);
	}

	public double getCogsFY03() {
		return cogsFY03;
	}

	public void setCogsFY03() {
		this.cogsFY03 = this.revenueFY03 * (this.cogsFromRevenueFY03 / 100);
	}

	public double getCogsFY04() {
		return cogsFY04;
	}

	public void setCogsFY04() {
		this.cogsFY04 = this.revenueFY04 * (this.cogsFromRevenueFY04 / 100);
	}
	
	public double getCogsFY05() {
		return cogsFY05;
	}

	public void setCogsFY05() {
		this.cogsFY05 = this.revenueFY05 * (this.cogsFromRevenueFY05 / 100);
	}	

	public double getCogsFromRevenuePY03() {
		return cogsFromRevenuePY03;
	}

	public void setCogsFromRevenuePY03() {
		if (this.revenuePY03 != 0) {
			this.cogsFromRevenuePY03 = (this.cogsPY03 / this.revenuePY03) * 100;
		} else {
			this.cogsFromRevenuePY03 = 0.00;
		}

	}

	public double getCogsFromRevenuePY02() {
		return cogsFromRevenuePY02;
	}

	public void setCogsFromRevenuePY02() {
		if (this.revenuePY02 != 0) {
			this.cogsFromRevenuePY02 = (this.cogsPY02 / this.revenuePY02) * 100;
		} else {
			this.cogsFromRevenuePY02 = 0.00;
		}

	}

	public double getCogsFromRevenuePY01() {
		return cogsFromRevenuePY01;
	}

	public void setCogsFromRevenuePY01() {
		if (this.revenuePY01 != 0) {
			this.cogsFromRevenuePY01 = (this.cogsPY01 / this.revenuePY01) * 100;
		} else {
			this.cogsFromRevenuePY01 = 0.00;
		}

	}

	public double getCogsFromRevenueY00() {
		return cogsFromRevenueY00;
	}

	public void setCogsFromRevenueY00() {
		if (this.revenueY00 != 0) {
			this.cogsFromRevenueY00 = (this.cogsY00 / this.revenueY00) * 100;
		} else {
			this.cogsFromRevenueY00 = 0.00;
		}

	}

	public double getCogsFromRevenueFY01() {
		return cogsFromRevenueFY01;
	}

	public void setCogsFromRevenueFY01(double cogsFromRevenueFY01) {
		this.cogsFromRevenueFY01 = cogsFromRevenueFY01;
	}

	public double getCogsFromRevenueFY02() {
		return cogsFromRevenueFY02;
	}

	public void setCogsFromRevenueFY02(double cogsFromRevenueFY02) {
		this.cogsFromRevenueFY02 = cogsFromRevenueFY02;
	}

	public double getCogsFromRevenueFY03() {
		return cogsFromRevenueFY03;
	}

	public void setCogsFromRevenueFY03(double cogsFromRevenueFY03) {
		this.cogsFromRevenueFY03 = cogsFromRevenueFY03;
	}

	public double getCogsFromRevenueFY04() {
		return cogsFromRevenueFY04;
	}

	public void setCogsFromRevenueFY04(double cogsFromRevenueFY04) {
		this.cogsFromRevenueFY04 = cogsFromRevenueFY04;
	}
		
	public double getCogsFromRevenueFY05() {
		return cogsFromRevenueFY05;
	}

	public void setCogsFromRevenueFY05(double cogsFromRevenueFY05) {
		this.cogsFromRevenueFY05 = cogsFromRevenueFY05;
	}

	public double getOtherCostsPY03() {
		return otherCostsPY03;
	}

	public void setOtherCostsPY03() {
		this.otherCostsPY03 = this.revenuePY03 - this.cogsPY03 - this.ebitdaPY03;
	}

	public double getOtherCostsPY02() {
		return otherCostsPY02;
	}

	public void setOtherCostsPY02() {
		this.otherCostsPY02 = this.revenuePY02 - this.cogsPY02 - this.ebitdaPY02;
	}

	public double getOtherCostsPY01() {
		return otherCostsPY01;
	}

	public void setOtherCostsPY01() {
		this.otherCostsPY01 = this.revenuePY01 - this.cogsPY01 - this.ebitdaPY01;
	}

	public double getOtherCostsY00() {
		return otherCostsY00;
	}

	public void setOtherCostsY00() {
		this.otherCostsY00 = this.revenueY00 - this.cogsY00 - this.ebitdaY00;
	}

	public double getOtherCostsFY01() {
		return otherCostsFY01;
	}

	public void setOtherCostsFY01() {
		this.otherCostsFY01 = this.revenueFY01 * (this.otherCostsFromRevenueFY01 / 100);
	}

	public double getOtherCostsFY02() {
		return otherCostsFY02;
	}

	public void setOtherCostsFY02() {
		this.otherCostsFY02 = this.revenueFY02 * (this.otherCostsFromRevenueFY02 / 100);
	}

	public double getOtherCostsFY03() {
		return otherCostsFY03;
	}

	public void setOtherCostsFY03() {
		this.otherCostsFY03 = this.revenueFY03 * (this.otherCostsFromRevenueFY03 / 100);
	}

	public double getOtherCostsFY04() {
		return otherCostsFY04;
	}

	public void setOtherCostsFY04() {
		this.otherCostsFY04 = this.revenueFY04 * (this.otherCostsFromRevenueFY04 / 100);
	}
	
	public double getOtherCostsFY05() {
		return otherCostsFY05;
	}

	public void setOtherCostsFY05() {
		this.otherCostsFY05 = this.revenueFY05 * (this.otherCostsFromRevenueFY05 / 100);
	}

	public double getOtherCostsFromRevenuePY03() {
		return otherCostsFromRevenuePY03;
	}

	public void setOtherCostsFromRevenuePY03() {
		if (this.revenuePY03 != 0) {
			this.otherCostsFromRevenuePY03 = (this.otherCostsPY03 / this.revenuePY03) * 100;
		} else {
			this.otherCostsFromRevenuePY03 = 0.00;
		}

	}

	public double getOtherCostsFromRevenuePY02() {
		return otherCostsFromRevenuePY02;
	}

	public void setOtherCostsFromRevenuePY02() {
		if (this.revenuePY02 != 0) {
			this.otherCostsFromRevenuePY02 = (this.otherCostsPY02 / this.revenuePY02) * 100;
		} else {
			this.otherCostsFromRevenuePY02 = 0.00;
		}
	}

	public double getOtherCostsFromRevenuePY01() {
		return otherCostsFromRevenuePY01;
	}

	public void setOtherCostsFromRevenuePY01() {
		if (this.revenuePY01 != 0) {
			this.otherCostsFromRevenuePY01 = (this.otherCostsPY01 / this.revenuePY01) * 100;
		} else {
			this.otherCostsFromRevenuePY01 = 0.00;
		}
	}

	public double getOtherCostsFromRevenueY00() {
		return otherCostsFromRevenueY00;
	}

	public void setOtherCostsFromRevenueY00() {
		if (this.revenueY00 != 0) {
			this.otherCostsFromRevenueY00 = (this.otherCostsY00 / this.revenueY00) * 100;
		} else {
			this.otherCostsFromRevenueY00 = 0.00;
		}
	}

	public double getOtherCostsFromRevenueFY01() {
		return otherCostsFromRevenueFY01;
	}

	public void setOtherCostsFromRevenueFY01(double otherCostsFromRevenueFY01) {
		this.otherCostsFromRevenueFY01 = otherCostsFromRevenueFY01;
	}

	public double getOtherCostsFromRevenueFY02() {
		return otherCostsFromRevenueFY02;
	}

	public void setOtherCostsFromRevenueFY02(double otherCostsFromRevenueFY02) {
		this.otherCostsFromRevenueFY02 = otherCostsFromRevenueFY02;
	}

	public double getOtherCostsFromRevenueFY03() {
		return otherCostsFromRevenueFY03;
	}

	public void setOtherCostsFromRevenueFY03(double otherCostsFromRevenueFY03) {
		this.otherCostsFromRevenueFY03 = otherCostsFromRevenueFY03;
	}

	public double getOtherCostsFromRevenueFY04() {
		return otherCostsFromRevenueFY04;
	}

	public void setOtherCostsFromRevenueFY04(double otherCostsFromRevenueFY04) {
		this.otherCostsFromRevenueFY04 = otherCostsFromRevenueFY04;
	}
	
	public double getOtherCostsFromRevenueFY05() {
		return otherCostsFromRevenueFY05;
	}

	public void setOtherCostsFromRevenueFY05(double otherCostsFromRevenueFY05) {
		this.otherCostsFromRevenueFY05 = otherCostsFromRevenueFY05;
	}

	public double getEbitdaPY03() {
		return ebitdaPY03;
	}

	public void setEbitdaPY03() {
		this.ebitdaPY03 = this.totalIncomePY03 - this.interestGainsPY03 + this.interestLossPY03 + this.depreciationPY03
				+ this.depreciationIntangiblePY03 + this.incomeTaxPY03;
	}

	public double getEbitdaPY02() {
		return ebitdaPY02;
	}

	public void setEbitdaPY02() {
		this.ebitdaPY02 = this.totalIncomePY02 - this.interestGainsPY02 + this.interestLossPY02 + this.depreciationPY02
				+ this.depreciationIntangiblePY02 + this.incomeTaxPY02;
	}

	public double getEbitdaPY01() {
		return ebitdaPY01;
	}

	public void setEbitdaPY01() {
		this.ebitdaPY01 = this.totalIncomePY01 - this.interestGainsPY01 + this.interestLossPY01 + this.depreciationPY01
				+ this.depreciationIntangiblePY01 + this.incomeTaxPY01;
	}

	public double getEbitdaY00() {
		return ebitdaY00;
	}

	public void setEbitdaY00() {
		this.ebitdaY00 = this.totalIncomeY00 - this.interestGainsY00 + this.interestLossY00 + this.depreciationY00
				+ this.depreciationIntangibleY00 + this.incomeTaxY00;
	}

	public double getEbitdaFY01() {
		return ebitdaFY01;
	}

	public void setEbitdaFY01() {
		this.ebitdaFY01 = this.revenueFY01 - this.cogsFY01 - this.otherCostsFY01;
	}

	public double getEbitdaFY02() {
		return ebitdaFY02;
	}

	public void setEbitdaFY02() {
		this.ebitdaFY02 = this.revenueFY02 - this.cogsFY02 - this.otherCostsFY02;
	}

	public double getEbitdaFY03() {
		return ebitdaFY03;
	}

	public void setEbitdaFY03() {
		this.ebitdaFY03 = this.revenueFY03 - this.cogsFY03 - this.otherCostsFY03;
	}

	public double getEbitdaFY04() {
		return ebitdaFY04;
	}

	public void setEbitdaFY04() {
		this.ebitdaFY04 = this.revenueFY04 - this.cogsFY04 - this.otherCostsFY04;
	}
	
	public double getEbitdaFY05() {
		return ebitdaFY05;
	}

	public void setEbitdaFY05() {
		this.ebitdaFY05 = this.revenueFY05 - this.cogsFY05 - this.otherCostsFY05;
	}

	public double getEbitdaFromRevenuePY03() {
		return ebitdaFromRevenuePY03;
	}

	public void setEbitdaFromRevenuePY03() {
		if (this.revenuePY03 != 0 & this.ebitdaPY03 != 0) {
			this.ebitdaFromRevenuePY03 = (this.ebitdaPY03 / this.revenuePY03) * 100;
		} else {
			this.ebitdaFromRevenuePY03 = 0.00;
		}

	}

	public double getEbitdaFromRevenuePY02() {
		return ebitdaFromRevenuePY02;
	}

	public void setEbitdaFromRevenuePY02() {
		if (this.revenuePY02 != 0 & this.ebitdaPY02 != 0) {
			this.ebitdaFromRevenuePY02 = (this.ebitdaPY02 / this.revenuePY02) * 100;
		} else {
			this.ebitdaFromRevenuePY02 = 0.00;
		}

	}

	public double getEbitdaFromRevenuePY01() {
		return ebitdaFromRevenuePY01;
	}

	public void setEbitdaFromRevenuePY01() {
		if (this.revenuePY01 != 0 & this.ebitdaPY01 != 0) {

			this.ebitdaFromRevenuePY01 = (this.ebitdaPY01 / this.revenuePY01) * 100;
		} else {
			this.ebitdaFromRevenuePY01 = 0.00;
		}

	}

	public double getEbitdaFromRevenueY00() {
		return ebitdaFromRevenueY00;
	}

	public void setEbitdaFromRevenueY00() {
		if (this.revenueY00 != 0 & this.ebitdaY00 != 0) {

			this.ebitdaFromRevenueY00 = (this.ebitdaY00 / this.revenueY00) * 100;

		} else {

			this.ebitdaFromRevenueY00 = 0.00;
		}
	}

	public double getEbitdaFromRevenueFY01() {
		return ebitdaFromRevenueFY01;
	}

	public void setEbitdaFromRevenueFY01() {
		if (this.revenueFY01 != 0 & this.ebitdaFY01 != 0) {

			this.ebitdaFromRevenueFY01 = (this.ebitdaFY01 / this.revenueFY01) * 100;

		} else {

			this.ebitdaFromRevenueFY01 = 0.00;
		}
	}

	public double getEbitdaFromRevenueFY02() {
		return ebitdaFromRevenueFY02;
	}

	public void setEbitdaFromRevenueFY02() {
		if (this.revenueFY02 != 0 & this.ebitdaFY02 != 0) {

			this.ebitdaFromRevenueFY02 = (this.ebitdaFY02 / this.revenueFY02) * 100;

		} else {

			this.ebitdaFromRevenueFY02 = 0.00;
		}
	}

	public double getEbitdaFromRevenueFY03() {
		return ebitdaFromRevenueFY03;
	}

	public void setEbitdaFromRevenueFY03() {
		if (this.revenueFY03 != 0 & this.ebitdaFY03 != 0) {

			this.ebitdaFromRevenueFY03 = (this.ebitdaFY03 / this.revenueFY03) * 100;

		} else {

			this.ebitdaFromRevenueFY03 = 0.00;
		}
	}

	public double getEbitdaFromRevenueFY04() {
		return ebitdaFromRevenueFY04;
	}

	public void setEbitdaFromRevenueFY04() {
		if (this.revenueFY04 != 0 & this.ebitdaFY04 != 0) {

			this.ebitdaFromRevenueFY04 = (this.ebitdaFY04 / this.revenueFY04) * 100;

		} else {

			this.ebitdaFromRevenueFY04 = 0.00;
		}
	}
	
	public double getEbitdaFromRevenueFY05() {
		return ebitdaFromRevenueFY05;
	}

	public void setEbitdaFromRevenueFY05() {
		if (this.revenueFY05 != 0 & this.ebitdaFY05 != 0) {

			this.ebitdaFromRevenueFY05 = (this.ebitdaFY05 / this.revenueFY05) * 100;

		} else {

			this.ebitdaFromRevenueFY05 = 0.00;
		}
	}
	
	public double getDepreciationPY03() {
		return depreciationPY03;
	}

	public void setDepreciationPY03(double depreciationPY03) {
		this.depreciationPY03 = depreciationPY03;
	}

	public double getDepreciationPY02() {
		return depreciationPY02;
	}

	public void setDepreciationPY02(double depreciationPY02) {
		this.depreciationPY02 = depreciationPY02;
	}

	public double getDepreciationPY01() {
		return depreciationPY01;
	}

	public void setDepreciationPY01(double depreciationPY01) {
		this.depreciationPY01 = depreciationPY01;
	}

	public double getDepreciationY00() {
		return depreciationY00;
	}

	public void setDepreciationY00(double depreciationY00) {
		this.depreciationY00 = depreciationY00;
	}

	public double getDepreciationFY01() {
		return depreciationFY01;
	}

	public void setDepreciationFY01(double depreciationFY01) {
		this.depreciationFY01 = depreciationFY01;
	}

	public double getDepreciationFY02() {
		return depreciationFY02;
	}

	public void setDepreciationFY02(double depreciationFY02) {
		this.depreciationFY02 = depreciationFY02;
	}

	public double getDepreciationFY03() {
		return depreciationFY03;
	}

	public void setDepreciationFY03(double depreciationFY03) {
		this.depreciationFY03 = depreciationFY03;
	}

	public double getDepreciationFY04() {
		return depreciationFY04;
	}

	public void setDepreciationFY04(double depreciationFY04) {
		this.depreciationFY04 = depreciationFY04;
	}

	public double getDepreciationFY05() {
		return depreciationFY05;
	}

	public void setDepreciationFY05(double depreciationFY05) {
		this.depreciationFY05 = depreciationFY05;
	}

	public double getDepreciationIntangiblePY03() {
		return depreciationIntangiblePY03;
	}

	public void setDepreciationIntangiblePY03(double depreciationIntangiblePY03) {
		this.depreciationIntangiblePY03 = depreciationIntangiblePY03;
	}

	public double getDepreciationIntangiblePY02() {
		return depreciationIntangiblePY02;
	}

	public void setDepreciationIntangiblePY02(double depreciationIntangiblePY02) {
		this.depreciationIntangiblePY02 = depreciationIntangiblePY02;
	}

	public double getDepreciationIntangiblePY01() {
		return depreciationIntangiblePY01;
	}

	public void setDepreciationIntangiblePY01(double depreciationIntangiblePY01) {
		this.depreciationIntangiblePY01 = depreciationIntangiblePY01;
	}

	public double getDepreciationIntangibleY00() {
		return depreciationIntangibleY00;
	}

	public void setDepreciationIntangibleY00(double depreciationIntangibleY00) {
		this.depreciationIntangibleY00 = depreciationIntangibleY00;
	}
	
	public double getDepreciationIntangibleFY01() {
		return depreciationIntangibleFY01;
	}

	public void setDepreciationIntangibleFY01(double depreciationIntangibleFY01) {
		this.depreciationIntangibleFY01 = depreciationIntangibleFY01;
	}

	public double getDepreciationIntangibleFY02() {
		return depreciationIntangibleFY02;
	}

	public void setDepreciationIntangibleFY02(double depreciationIntangibleFY02) {
		this.depreciationIntangibleFY02 = depreciationIntangibleFY02;
	}

	public double getDepreciationIntangibleFY03() {
		return depreciationIntangibleFY03;
	}

	public void setDepreciationIntangibleFY03(double depreciationIntangibleFY03) {
		this.depreciationIntangibleFY03 = depreciationIntangibleFY03;
	}

	public double getDepreciationIntangibleFY04() {
		return depreciationIntangibleFY04;
	}

	public void setDepreciationIntangibleFY04(double depreciationIntangibleFY04) {
		this.depreciationIntangibleFY04 = depreciationIntangibleFY04;
	}

	public double getDepreciationIntangibleFY05() {
		return depreciationIntangibleFY05;
	}

	public void setDepreciationIntangibleFY05(double depreciationIntangibleFY05) {
		this.depreciationIntangibleFY05 = depreciationIntangibleFY05;
	}

	public double getInterestGainsPY03() {
		return interestGainsPY03;
	}

	public void setInterestGainsPY03(double interestGainsPY03) {
		this.interestGainsPY03 = interestGainsPY03;
	}

	public double getInterestGainsPY02() {
		return interestGainsPY02;
	}

	public void setInterestGainsPY02(double interestGainsPY02) {
		this.interestGainsPY02 = interestGainsPY02;
	}

	public double getInterestGainsPY01() {
		return interestGainsPY01;
	}

	public void setInterestGainsPY01(double interestGainsPY01) {
		this.interestGainsPY01 = interestGainsPY01;
	}

	public double getInterestGainsY00() {
		return interestGainsY00;
	}

	public void setInterestGainsY00(double interestGainsY00) {
		this.interestGainsY00 = interestGainsY00;
	}

	public double getInterestGainsFY01() {
		return interestGainsFY01;
	}

	public void setInterestGainsFY01() {
		this.interestGainsFY01 = (this.interestGainsFromFinancialAssetsFY01 / 100) * this.finAssetsFY01;
	}

	public double getInterestGainsFY02() {
		return interestGainsFY02;
	}

	public void setInterestGainsFY02() {
		this.interestGainsFY02 = (this.interestGainsFromFinancialAssetsFY02 / 100) * this.finAssetsFY02;
	}

	public double getInterestGainsFY03() {
		return interestGainsFY03;
	}

	public void setInterestGainsFY03() {
		this.interestGainsFY03 = (this.interestGainsFromFinancialAssetsFY03 / 100) * this.finAssetsFY03;
	}

	public double getInterestGainsFY04() {
		return interestGainsFY04;
	}

	public void setInterestGainsFY04() {
		this.interestGainsFY04 = (this.interestGainsFromFinancialAssetsFY04 / 100) * this.finAssetsFY04;
	}
	
	public double getInterestGainsFY05() {
		return interestGainsFY05;
	}

	public void setInterestGainsFY05() {
		this.interestGainsFY05 = (this.interestGainsFromFinancialAssetsFY05 / 100) * this.finAssetsFY05;
	}
	

	public double getInterestLossPY03() {
		return interestLossPY03;
	}

	public void setInterestLossPY03(double interestLossPY03) {
		this.interestLossPY03 = interestLossPY03;
	}

	public double getInterestLossPY02() {
		return interestLossPY02;
	}

	public void setInterestLossPY02(double interestLossPY02) {
		this.interestLossPY02 = interestLossPY02;
	}

	public double getInterestLossPY01() {
		return interestLossPY01;
	}

	public void setInterestLossPY01(double interestLossPY01) {
		this.interestLossPY01 = interestLossPY01;
	}

	public double getInterestLossY00() {
		return interestLossY00;
	}

	public void setInterestLossY00(double interestLossY00) {
		this.interestLossY00 = interestLossY00;
	}

	public double getInterestLossFY01() {
		return interestLossFY01;
	}

	public void setInterestLossFY01() {
		this.interestLossFY01 = (this.shortTermBankDebtFY01 + this.longTermBankDebtFY01)
				* (this.interestLossFromBankDebtFY01 / 100);
	}

	public double getInterestLossFY02() {
		return interestLossFY02;
	}

	public void setInterestLossFY02() {
		this.interestLossFY02 = (this.shortTermBankDebtFY02 + this.longTermBankDebtFY02)
				* (this.interestLossFromBankDebtFY02 / 100);
	}

	public double getInterestLossFY03() {
		return interestLossFY03;
	}

	public void setInterestLossFY03() {
		this.interestLossFY03 = (this.shortTermBankDebtFY03 + this.longTermBankDebtFY03)
				* (this.interestLossFromBankDebtFY03 / 100);
		;
	}

	public double getInterestLossFY04() {
		return interestLossFY04;
	}

	public void setInterestLossFY04() {
		this.interestLossFY04 = (this.shortTermBankDebtFY04 + this.longTermBankDebtFY04)
				* (this.interestLossFromBankDebtFY04 / 100);
	}
	
	public double getInterestLossFY05() {
		return interestLossFY05;
	}

	public void setInterestLossFY05() {
		this.interestLossFY05 = (this.shortTermBankDebtFY05 + this.longTermBankDebtFY05)
				* (this.interestLossFromBankDebtFY05 / 100);
	}

	public double getEbtPY03() {
		return ebtPY03;
	}

	public void setEbtPY03(double ebtPY03) {
		this.ebtPY03 = ebtPY03;
	}

	public double getEbtPY02() {
		return ebtPY02;
	}

	public void setEbtPY02(double ebtPY02) {
		this.ebtPY02 = ebtPY02;
	}

	public double getEbtPY01() {
		return ebtPY01;
	}

	public void setEbtPY01(double ebtPY01) {
		this.ebtPY01 = ebtPY01;
	}

	public double getEbtY00() {
		return ebtY00;
	}

	public void setEbtY00(double ebtY00) {
		this.ebtY00 = ebtY00;
	}

	public double getEbtFY01() {
		return ebtFY01;
	}

	public void setEbtFY01() {
		this.ebtFY01 = this.ebitdaFY01 - this.depreciationFY01 - this.depreciationIntangibleFY01
				+ this.interestGainsFY01 - this.interestLossFY01;
	}

	public double getEbtFY02() {
		return ebtFY02;
	}

	public void setEbtFY02() {
		this.ebtFY02 = this.ebitdaFY02 - this.depreciationFY02 - this.depreciationIntangibleFY02
				+ this.interestGainsFY02 - this.interestLossFY02;
	}

	public double getEbtFY03() {
		return ebtFY03;
	}

	public void setEbtFY03() {
		this.ebtFY03 = this.ebitdaFY03 - this.depreciationFY03 - this.depreciationIntangibleFY03
				+ this.interestGainsFY03 - this.interestLossFY03;
	}

	public double getEbtFY04() {
		return ebtFY04;
	}

	public void setEbtFY04() {
		this.ebtFY04 = this.ebitdaFY04 - this.depreciationFY04 - this.depreciationIntangibleFY04
				+ this.interestGainsFY04 - this.interestLossFY04;
	}
	
	public double getEbtFY05() {
		return ebtFY05;
	}

	public void setEbtFY05() {
		this.ebtFY05 = this.ebitdaFY05 - this.depreciationFY05 - this.depreciationIntangibleFY05
				+ this.interestGainsFY05 - this.interestLossFY05;
	}

	public double getIncomeTaxPY03() {
		return incomeTaxPY03;
	}

	public void setIncomeTaxPY03(double incomeTaxPY03) {
		this.incomeTaxPY03 = incomeTaxPY03;
	}

	public double getIncomeTaxPY02() {
		return incomeTaxPY02;
	}

	public void setIncomeTaxPY02(double incomeTaxPY02) {
		this.incomeTaxPY02 = incomeTaxPY02;
	}

	public double getIncomeTaxPY01() {
		return incomeTaxPY01;
	}

	public void setIncomeTaxPY01(double incomeTaxPY01) {
		this.incomeTaxPY01 = incomeTaxPY01;
	}

	public double getIncomeTaxY00() {
		return incomeTaxY00;
	}

	public void setIncomeTaxY00(double incomeTaxY00) {
		this.incomeTaxY00 = incomeTaxY00;
	}

	public double getIncomeTaxFY01() {
		return incomeTaxFY01;
	}

	public void setIncomeTaxFY01() {
		if (this.ebtFY01 > 0) {
			this.incomeTaxFY01 = (this.incomeTaxFromEbtFY01 / 100) * this.ebtFY01;
		} else {
			this.incomeTaxFY01 = 0.00;
		}
	}

	public double getIncomeTaxFY02() {
		return incomeTaxFY02;
	}

	public void setIncomeTaxFY02() {
		if (this.ebtFY02 > 0) {
			this.incomeTaxFY02 = (this.incomeTaxFromEbtFY02 / 100) * this.ebtFY02;
		} else {
			this.incomeTaxFY02 = 0.00;
		}
	}

	public double getIncomeTaxFY03() {
		return incomeTaxFY03;
	}

	public void setIncomeTaxFY03() {
		if (this.ebtFY03 > 0) {
			this.incomeTaxFY03 = (this.incomeTaxFromEbtFY03 / 100) * this.ebtFY03;
		} else {
			this.incomeTaxFY03 = 0.00;
		}
	}

	public double getIncomeTaxFY04() {
		return incomeTaxFY04;
	}

	public void setIncomeTaxFY04() {
		if (this.ebtFY04 > 0) {
			this.incomeTaxFY04 = (this.incomeTaxFromEbtFY04 / 100) * this.ebtFY04;
		} else {
			this.incomeTaxFY04 = 0.00;
		}
	}
	
	public double getIncomeTaxFY05() {
		return incomeTaxFY05;
	}

	public void setIncomeTaxFY05() {
		if (this.ebtFY05 > 0) {
			this.incomeTaxFY05 = (this.incomeTaxFromEbtFY05 / 100) * this.ebtFY05;
		} else {
			this.incomeTaxFY05 = 0.00;
		}
	}

	public double getIncomeTaxFromEbtPY03() {
		return incomeTaxFromEbtPY03;
	}

	public void setIncomeTaxFromEbtPY03() {
		if (this.ebtPY03 != 0) {

			this.incomeTaxFromEbtPY03 = (incomeTaxPY03 / ebtPY03) * 100;

		} else {

			this.incomeTaxFromEbtPY03 = 0.00;

		}
	}

	public double getIncomeTaxFromEbtPY02() {
		return incomeTaxFromEbtPY02;
	}

	public void setIncomeTaxFromEbtPY02() {
		if (this.ebtPY02 != 0) {

			this.incomeTaxFromEbtPY02 = (incomeTaxPY02 / ebtPY02) * 100;

		} else {

			this.incomeTaxFromEbtPY02 = 0.00;

		}
	}

	public double getIncomeTaxFromEbtPY01() {
		return incomeTaxFromEbtPY01;
	}

	public void setIncomeTaxFromEbtPY01() {
		if (this.ebtPY01 != 0) {

			this.incomeTaxFromEbtPY01 = (incomeTaxPY01 / ebtPY01) * 100;

		} else {

			this.incomeTaxFromEbtPY01 = 0.00;

		}
	}

	public double getIncomeTaxFromEbtY00() {
		return incomeTaxFromEbtY00;
	}

	public void setIncomeTaxFromEbtY00() {
		if (this.ebtY00 != 0) {

			this.incomeTaxFromEbtY00 = (incomeTaxY00 / ebtY00) * 100;

		} else {

			this.incomeTaxFromEbtY00 = 0.00;

		}
	}

	public double getIncomeTaxFromEbtFY01() {
		return incomeTaxFromEbtFY01;
	}

	public void setIncomeTaxFromEbtFY01(double incomeTaxFromEbtFY01) {
		this.incomeTaxFromEbtFY01 = incomeTaxFromEbtFY01;
	}

	public double getIncomeTaxFromEbtFY02() {
		return incomeTaxFromEbtFY02;
	}

	public void setIncomeTaxFromEbtFY02(double incomeTaxFromEbtFY02) {
		this.incomeTaxFromEbtFY02 = incomeTaxFromEbtFY02;
	}

	public double getIncomeTaxFromEbtFY03() {
		return incomeTaxFromEbtFY03;
	}

	public void setIncomeTaxFromEbtFY03(double incomeTaxFromEbtFY03) {
		this.incomeTaxFromEbtFY03 = incomeTaxFromEbtFY03;
	}

	public double getIncomeTaxFromEbtFY04() {
		return incomeTaxFromEbtFY04;
	}

	public void setIncomeTaxFromEbtFY04(double incomeTaxFromEbtFY04) {
		this.incomeTaxFromEbtFY04 = incomeTaxFromEbtFY04;
	}
	
	public double getIncomeTaxFromEbtFY05() {
		return incomeTaxFromEbtFY05;
	}

	public void setIncomeTaxFromEbtFY05(double incomeTaxFromEbtFY05) {
		this.incomeTaxFromEbtFY05 = incomeTaxFromEbtFY05;
	}

	public double getTotalIncomePY03() {
		return totalIncomePY03;
	}

	public void setTotalIncomePY03(double totalIncomePY03) {
		this.totalIncomePY03 = totalIncomePY03;
	}

	public double getTotalIncomePY02() {
		return totalIncomePY02;
	}

	public void setTotalIncomePY02(double totalIncomePY02) {
		this.totalIncomePY02 = totalIncomePY02;
	}

	public double getTotalIncomePY01() {
		return totalIncomePY01;
	}

	public void setTotalIncomePY01(double totalIncomePY01) {
		this.totalIncomePY01 = totalIncomePY01;
	}

	public double getTotalIncomeY00() {
		return totalIncomeY00;
	}

	public void setTotalIncomeY00(double totalIncomeY00) {
		this.totalIncomeY00 = totalIncomeY00;
	}

	public double getTotalIncomeFY01() {
		return totalIncomeFY01;
	}

	public void setTotalIncomeFY01() {
		this.totalIncomeFY01 = this.ebtFY01 - this.incomeTaxFY01;
	}

	public double getTotalIncomeFY02() {
		return totalIncomeFY02;
	}

	public void setTotalIncomeFY02() {
		this.totalIncomeFY02 = this.ebtFY02 - this.incomeTaxFY02;
	}

	public double getTotalIncomeFY03() {
		return totalIncomeFY03;
	}

	public void setTotalIncomeFY03() {
		this.totalIncomeFY03 = this.ebtFY03 - this.incomeTaxFY03;
	}

	public double getTotalIncomeFY04() {
		return totalIncomeFY04;
	}

	public void setTotalIncomeFY04() {
		this.totalIncomeFY04 = this.ebtFY04 - this.incomeTaxFY04;
	}
	
	public double getTotalIncomeFY05() {
		return totalIncomeFY05;
	}

	public void setTotalIncomeFY05() {
		this.totalIncomeFY05 = this.ebtFY05 - this.incomeTaxFY05;
	}

	
	/**
	 * Getter und Setter fuer das Anlagevermoegen Berechne aus dem immateriellen
	 * Vermoegen, dem Sachanlagevermoegen und dem Finanzvermoegen die Summe des
	 * Anlagevermoegens
	 **/

	// Getter und Setter fuer das Finanzanlagevermoegen

	public double getFinAssetsPY03() {
		return finAssetsPY03;
	}

	public void setFinAssetsPY03(double finAssetsPY03) {
		this.finAssetsPY03 = finAssetsPY03;
	}

	public double getFinAssetsPY02() {
		return finAssetsPY02;
	}

	public void setFinAssetsPY02(double finAssetsPY02) {
		this.finAssetsPY02 = finAssetsPY02;
	}

	public double getFinAssetsPY01() {
		return finAssetsPY01;
	}

	public void setFinAssetsPY01(double finAssetsPY01) {
		this.finAssetsPY01 = finAssetsPY01;
	}

	public double getFinAssetsY00() {
		return finAssetsY00;
	}
	
	public void setFinAssetsY00(double finAssetsY00) {
		this.finAssetsY00 = finAssetsY00;
	}
	
	public double getFinAssetsFY01() {
		return finAssetsFY01;
	}

	public void setFinAssetsFY01() {
		this.finAssetsFY01 = finAssetsY00 + this.financialAssetsChangeFY01;
	}

	public double getFinAssetsFY02() {
		return finAssetsFY02;
	}

	public void setFinAssetsFY02() {
		this.finAssetsFY02 = finAssetsFY01 + this.financialAssetsChangeFY02;
	}

	public double getFinAssetsFY03() {
		return finAssetsFY03;
	}

	public void setFinAssetsFY03() {
		this.finAssetsFY03 = finAssetsFY02 + this.financialAssetsChangeFY03;
	}

	public double getFinAssetsFY04() {
		return finAssetsFY04;
	}

	public void setFinAssetsFY04() {
		this.finAssetsFY04 = finAssetsFY03 + this.financialAssetsChangeFY04;
	}

	public double getFinAssetsFY05() {
		return finAssetsFY05;
	}

	public void setFinAssetsFY05() {
		this.finAssetsFY05 = finAssetsFY04 + this.financialAssetsChangeFY05;
	}

	public double getFinancialAssetsChangePY02() {
		return financialAssetsChangePY02;
	}

	public void setFinancialAssetsChangePY02() {
		this.financialAssetsChangePY02 = this.finAssetsPY02 - this.finAssetsPY03;
	}

	public double getFinancialAssetsChangePY01() {
		return financialAssetsChangePY01;
	}

	public void setFinancialAssetsChangePY01() {
		this.financialAssetsChangePY01 = this.finAssetsPY01 - this.finAssetsPY02;
	}

	public double getFinancialAssetsChangeY00() {
		return financialAssetsChangeY00;
	}

	public void setFinancialAssetsChangeY00() {
		this.financialAssetsChangeY00 = this.finAssetsY00 - this.finAssetsPY01;
	}
	

	public double getFinancialAssetsChangeFY01() {
		return financialAssetsChangeFY01;
	}

	public void setFinancialAssetsChangeFY01(double financialAssetsChangeFY01) {
		this.financialAssetsChangeFY01 = financialAssetsChangeFY01;
	}

	public double getFinancialAssetsChangeFY02() {
		return financialAssetsChangeFY02;
	}

	public void setFinancialAssetsChangeFY02(double financialAssetsChangeFY02) {
		this.financialAssetsChangeFY02 = financialAssetsChangeFY02;
	}

	public double getFinancialAssetsChangeFY03() {
		return financialAssetsChangeFY03;
	}

	public void setFinancialAssetsChangeFY03(double financialAssetsChangeFY03) {
		this.financialAssetsChangeFY03 = financialAssetsChangeFY03;
	}

	public double getFinancialAssetsChangeFY04() {
		return financialAssetsChangeFY04;
	}

	public void setFinancialAssetsChangeFY04(double financialAssetsChangeFY04) {
		this.financialAssetsChangeFY04 = financialAssetsChangeFY04;
	}

	public double getFinancialAssetsChangeFY05() {
		return financialAssetsChangeFY05;
	}

	public void setFinancialAssetsChangeFY05(double financialAssetsChangeFY05) {
		this.financialAssetsChangeFY05 = financialAssetsChangeFY05;
	}

	public double getInterestGainsFromFinancialAssetsPY03() {
		return interestGainsFromFinancialAssetsPY03;
	}

	public void setInterestGainsFromFinancialAssetsPY03() {
		if (this.finAssetsPY03 != 0 & this.interestGainsPY03 != 0) {
			this.interestGainsFromFinancialAssetsPY03 = (this.interestGainsPY03 / this.finAssetsPY03) * 100;
		} else {
			this.interestGainsFromFinancialAssetsPY03 = 0.00;
		}
	}

	public double getInterestGainsFromFinancialAssetsPY02() {
		return interestGainsFromFinancialAssetsPY02;
	}

	public void setInterestGainsFromFinancialAssetsPY02() {
		if (this.finAssetsPY02 != 0 & this.interestGainsPY02 != 0) {
			this.interestGainsFromFinancialAssetsPY02 = (this.interestGainsPY02 / this.finAssetsPY02) * 100;
		} else {
			this.interestGainsFromFinancialAssetsPY02 = 0.00;
		}
	}

	public double getInterestGainsFromFinancialAssetsPY01() {
		return interestGainsFromFinancialAssetsPY01;
	}

	public void setInterestGainsFromFinancialAssetsPY01() {
		if (this.finAssetsPY01 != 0 & this.interestGainsPY01 != 0) {
			this.interestGainsFromFinancialAssetsPY01 = (this.interestGainsPY01 / this.finAssetsPY01) * 100;
		} else {
			this.interestGainsFromFinancialAssetsPY01 = 0.00;
		}
	}

	public double getInterestGainsFromFinancialAssetsY00() {
		return interestGainsFromFinancialAssetsY00;
	}

	public void setInterestGainsFromFinancialAssetsY00() {
		if (this.finAssetsY00 != 0 & this.interestGainsY00 != 0) {
			this.interestGainsFromFinancialAssetsY00 = (this.interestGainsY00 / this.finAssetsY00) * 100;
		} else {
			this.interestGainsFromFinancialAssetsY00 = 0.00;
		}
	}

	public double getInterestGainsFromFinancialAssetsFY01() {
		return interestGainsFromFinancialAssetsFY01;
	}

	public void setInterestGainsFromFinancialAssetsFY01(double interestGainsFromFinancialAssetsFY01) {
		this.interestGainsFromFinancialAssetsFY01 = interestGainsFromFinancialAssetsFY01;
	}

	public double getInterestGainsFromFinancialAssetsFY02() {
		return interestGainsFromFinancialAssetsFY02;
	}

	public void setInterestGainsFromFinancialAssetsFY02(double interestGainsFromFinancialAssetsFY02) {
		this.interestGainsFromFinancialAssetsFY02 = interestGainsFromFinancialAssetsFY02;
	}

	public double getInterestGainsFromFinancialAssetsFY03() {
		return interestGainsFromFinancialAssetsFY03;
	}

	public void setInterestGainsFromFinancialAssetsFY03(double interestGainsFromFinancialAssetsFY03) {
		this.interestGainsFromFinancialAssetsFY03 = interestGainsFromFinancialAssetsFY03;
	}

	public double getInterestGainsFromFinancialAssetsFY04() {
		return interestGainsFromFinancialAssetsFY04;
	}

	public void setInterestGainsFromFinancialAssetsFY04(double interestGainsFromFinancialAssetsFY04) {
		this.interestGainsFromFinancialAssetsFY04 = interestGainsFromFinancialAssetsFY04;
	}
	
	public double getInterestGainsFromFinancialAssetsFY05() {
		return interestGainsFromFinancialAssetsFY05;
	}

	public void setInterestGainsFromFinancialAssetsFY05(double interestGainsFromFinancialAssetsFY05) {
		this.interestGainsFromFinancialAssetsFY05 = interestGainsFromFinancialAssetsFY05;
	}

	
	// Getter und Setter fuer das Sachanlagevermoegen

	public double getPropAssetsPY03() {
		return propAssetsPY03;
	}

	public void setPropAssetsPY03(double propAssetsPY03) {
		this.propAssetsPY03 = propAssetsPY03;
	}

	public double getPropAssetsPY02() {
		return propAssetsPY02;
	}

	public void setPropAssetsPY02(double propAssetsPY02) {
		this.propAssetsPY02 = propAssetsPY02;
	}

	public double getPropAssetsPY01() {
		return propAssetsPY01;
	}

	public void setPropAssetsPY01(double propAssetsPY01) {
		this.propAssetsPY01 = propAssetsPY01;
	}

	public double getPropAssetsY00() {
		return propAssetsY00;
	}

	public void setPropAssetsY00(double propAssetsY00) {
		this.propAssetsY00 = propAssetsY00;
	}
	
	public double getPropAssetsFY01() {
		return propAssetsFY01;
	}

	public void setPropAssetsFY01() {
		this.propAssetsFY01 = this.propAssetsY00 + this.propertyAssetsChangeFY01 - this.depreciationFY01; // Bestand + Investition - Abschreibung/Abgang
	}

	public double getPropAssetsFY02() {
		return propAssetsFY02;
	}

	public void setPropAssetsFY02() {
		this.propAssetsFY02 = this.propAssetsFY01 + this.propertyAssetsChangeFY02 - this.depreciationFY02;
	}

	public double getPropAssetsFY03() {
		return propAssetsFY03;
	}

	public void setPropAssetsFY03() {
		this.propAssetsFY03 = this.propAssetsFY02 + this.propertyAssetsChangeFY03 - this.depreciationFY03;
	}

	public double getPropAssetsFY04() {
		return propAssetsFY04;
	}

	public void setPropAssetsFY04() {
		this.propAssetsFY04 = this.propAssetsFY03 + this.propertyAssetsChangeFY04 - this.depreciationFY04;
	}

	public double getPropAssetsFY05() {
		return propAssetsFY05;
	}

	public void setPropAssetsFY05() {
		this.propAssetsFY05 = this.propAssetsFY04 + this.propertyAssetsChangeFY05 - this.depreciationFY05;
	}

	public double getPropertyAssetsChangePY02() {
		return propertyAssetsChangePY02;
	}

	public void setPropertyAssetsChangePY02() {
		this.propertyAssetsChangePY02 = (this.propAssetsPY02 - this.propAssetsPY03) + this.depreciationPY02;
	}

	public double getPropertyAssetsChangePY01() {
		return propertyAssetsChangePY01;
	}

	public void setPropertyAssetsChangePY01() {
		this.propertyAssetsChangePY01 = (this.propAssetsPY01 - this.propAssetsPY02) + this.depreciationPY01;
	}

	public double getPropertyAssetsChangeY00() {
		return propertyAssetsChangeY00;
	}

	public void setPropertyAssetsChangeY00() {
		this.propertyAssetsChangeY00 = (this.propAssetsY00 - this.propAssetsPY01) + this.depreciationY00;
	}
	
	public double getPropertyAssetsChangeFY01() {
		return propertyAssetsChangeFY01;
	}

	public void setPropertyAssetsChangeFY01(double propertyAssetsChangeFY01) {
		this.propertyAssetsChangeFY01 = propertyAssetsChangeFY01;
	}

	public double getPropertyAssetsChangeFY02() {
		return propertyAssetsChangeFY02;
	}

	public void setPropertyAssetsChangeFY02(double propertyAssetsChangeFY02) {
		this.propertyAssetsChangeFY02 = propertyAssetsChangeFY02;
	}

	public double getPropertyAssetsChangeFY03() {
		return propertyAssetsChangeFY03;
	}

	public void setPropertyAssetsChangeFY03(double propertyAssetsChangeFY03) {
		this.propertyAssetsChangeFY03 = propertyAssetsChangeFY03;
	}

	public double getPropertyAssetsChangeFY04() {
		return propertyAssetsChangeFY04;
	}

	public void setPropertyAssetsChangeFY04(double propertyAssetsChangeFY04) {
		this.propertyAssetsChangeFY04 = propertyAssetsChangeFY04;
	}

	public double getPropertyAssetsChangeFY05() {
		return propertyAssetsChangeFY05;
	}

	public void setPropertyAssetsChangeFY05(double propertyAssetsChangeFY05) {
		this.propertyAssetsChangeFY05 = propertyAssetsChangeFY05;
	}

	public double getDepreciationFromPropertyAssetsPY03() {
		return depreciationFromPropertyAssetsPY03;
	}

	public void setDepreciationFromPropertyAssetsPY03() {
		if (this.propAssetsPY03 != 0 & this.depreciationPY03 != 0) {
			this.depreciationFromPropertyAssetsPY03 = (this.depreciationPY03 / this.propAssetsPY03) * 100;
		} else {
			this.depreciationFromPropertyAssetsPY03 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsPY02() {
		return depreciationFromPropertyAssetsPY02;
	}

	public void setDepreciationFromPropertyAssetsPY02() {
		if (this.propAssetsPY02 != 0 & this.depreciationPY02 != 0) {
			this.depreciationFromPropertyAssetsPY02 = (this.depreciationPY02 / this.propAssetsPY02) * 100;
		} else {
			this.depreciationFromPropertyAssetsPY02 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsPY01() {
		return depreciationFromPropertyAssetsPY01;
	}

	public void setDepreciationFromPropertyAssetsPY01() {
		if (this.propAssetsPY01 != 0 & this.depreciationPY01 != 0) {
			this.depreciationFromPropertyAssetsPY01 = (this.depreciationPY01 / this.propAssetsPY01) * 100;
		} else {
			this.depreciationFromPropertyAssetsPY01 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsY00() {
		return depreciationFromPropertyAssetsY00;
	}

	public void setDepreciationFromPropertyAssetsY00() {
		if (this.propAssetsY00 != 0 & this.depreciationY00 != 0) {
			this.depreciationFromPropertyAssetsY00 = (this.depreciationY00 / this.propAssetsY00) * 100;
		} else {
			this.depreciationFromPropertyAssetsY00 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsFY01() {
		return depreciationFromPropertyAssetsFY01;
	}

	public void setDepreciationFromPropertyAssetsFY01() {
		if (this.propAssetsFY01 != 0 & this.depreciationFY01 != 0) {
			this.depreciationFromPropertyAssetsFY01 = (this.depreciationFY01 / this.propAssetsFY01) * 100;
		} else {
			this.depreciationFromPropertyAssetsFY01 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsFY02() {
		return depreciationFromPropertyAssetsFY02;
	}

	public void setDepreciationFromPropertyAssetsFY02() {
		if (this.propAssetsFY02 != 0 & this.depreciationFY02 != 0) {
			this.depreciationFromPropertyAssetsFY02 = (this.depreciationFY02 / this.propAssetsFY02) * 100;
		} else {
			this.depreciationFromPropertyAssetsFY02 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsFY03() {
		return depreciationFromPropertyAssetsFY03;
	}

	public void setDepreciationFromPropertyAssetsFY03() {
		if (this.propAssetsFY03 != 0 & this.depreciationFY03 != 0) {
			this.depreciationFromPropertyAssetsFY03 = (this.depreciationFY03 / this.propAssetsFY03) * 100;
		} else {
			this.depreciationFromPropertyAssetsFY03 = 0.00;
		}
	}

	public double getDepreciationFromPropertyAssetsFY04() {
		return depreciationFromPropertyAssetsFY04;
	}

	public void setDepreciationFromPropertyAssetsFY04() {
		if (this.propAssetsFY04 != 0 & this.depreciationFY04 != 0) {
			this.depreciationFromPropertyAssetsFY04 = (this.depreciationFY04 / this.propAssetsFY04) * 100;
		} else {
			this.depreciationFromPropertyAssetsFY04 = 0.00;
		}
	}
	
	public double getDepreciationFromPropertyAssetsFY05() {
		return depreciationFromPropertyAssetsFY05;
	}

	public void setDepreciationFromPropertyAssetsFY05() {
		if (this.propAssetsFY05 != 0 & this.depreciationFY05 != 0) {
			this.depreciationFromPropertyAssetsFY05 = (this.depreciationFY05 / this.propAssetsFY05) * 100;
		} else {
			this.depreciationFromPropertyAssetsFY05 = 0.00;
		}
	}

	// Getter und Setter fuer Intangible Assets

	public double getIntAssetsPY03() {
		return intAssetsPY03;
	}

	public void setIntAssetsPY03(double intAssetsPY03) {
		this.intAssetsPY03 = intAssetsPY03;
	}

	public double getIntAssetsPY02() {
		return intAssetsPY02;
	}

	public void setIntAssetsPY02(double intAssetsPY02) {
		this.intAssetsPY02 = intAssetsPY02;
	}

	public double getIntAssetsPY01() {
		return intAssetsPY01;
	}

	public void setIntAssetsPY01(double intAssetsPY01) {
		this.intAssetsPY01 = intAssetsPY01;
	}

	public double getIntAssetsY00() {
		return intAssetsY00;
	}

	public void setIntAssetsY00(double intAssetsY00) {
		this.intAssetsY00 = intAssetsY00;
	}
	
	
	public double getIntAssetsFY01() {
		return intAssetsFY01;
	}

	public void setIntAssetsFY01() {
		this.intAssetsFY01 = this.intAssetsY00 + this.intangibleAssetsChangeFY01 - this.depreciationIntangibleFY01; // Bestand + Invest - Abschreibung/Abgang
	}

	public double getIntAssetsFY02() {
		return intAssetsFY02;
	}

	public void setIntAssetsFY02() {
		this.intAssetsFY02 = this.intAssetsFY01 + this.intangibleAssetsChangeFY02 - this.depreciationIntangibleFY02;
	}

	public double getIntAssetsFY03() {
		return intAssetsFY03;
	}

	public void setIntAssetsFY03() {
		this.intAssetsFY03 = this.intAssetsFY02 + this.intangibleAssetsChangeFY03 - this.depreciationIntangibleFY03;
	}

	public double getIntAssetsFY04() {
		return intAssetsFY04;
	}

	public void setIntAssetsFY04() {
		this.intAssetsFY04 = this.intAssetsFY03 + this.intangibleAssetsChangeFY04 - this.depreciationIntangibleFY04;
	}

	public double getIntAssetsFY05() {
		return intAssetsFY05;
	}

	public void setIntAssetsFY05() {
		this.intAssetsFY05 = this.intAssetsFY04 + this.intangibleAssetsChangeFY05 - this.depreciationIntangibleFY05;
	}

	public double getIntangibleAssetsChangePY02() {
		return intangibleAssetsChangePY02;
	}

	public void setIntangibleAssetsChangePY02() {
		this.intangibleAssetsChangePY02 = (this.intAssetsPY02 - this.intAssetsPY03) + this.depreciationIntangiblePY02;
	}

	public double getIntangibleAssetsChangePY01() {
		return intangibleAssetsChangePY01;
	}

	public void setIntangibleAssetsChangePY01() {
		this.intangibleAssetsChangePY01 = (this.intAssetsPY01 - this.intAssetsPY02) + this.depreciationIntangiblePY01;
	}

	public double getIntangibleAssetsChangeY00() {
		return intangibleAssetsChangeY00;
	}

	public void setIntangibleAssetsChangeY00() {
		this.intangibleAssetsChangeY00 = (this.intAssetsY00 - this.intAssetsPY01) + this.depreciationIntangibleY00;
	}
	

	public double getIntangibleAssetsChangeFY01() {
		return intangibleAssetsChangeFY01;
	}

	public void setIntangibleAssetsChangeFY01(double intangibleAssetsChangeFY01) {
		this.intangibleAssetsChangeFY01 = intangibleAssetsChangeFY01;
	}

	public double getIntangibleAssetsChangeFY02() {
		return intangibleAssetsChangeFY02;
	}

	public void setIntangibleAssetsChangeFY02(double intangibleAssetsChangeFY02) {
		this.intangibleAssetsChangeFY02 = intangibleAssetsChangeFY02;
	}

	public double getIntangibleAssetsChangeFY03() {
		return intangibleAssetsChangeFY03;
	}

	public void setIntangibleAssetsChangeFY03(double intangibleAssetsChangeFY03) {
		this.intangibleAssetsChangeFY03 = intangibleAssetsChangeFY03;
	}

	public double getIntangibleAssetsChangeFY04() {
		return intangibleAssetsChangeFY04;
	}

	public void setIntangibleAssetsChangeFY04(double intangibleAssetsChangeFY04) {
		this.intangibleAssetsChangeFY04 = intangibleAssetsChangeFY04;
	}

	public double getIntangibleAssetsChangeFY05() {
		return intangibleAssetsChangeFY05;
	}

	public void setIntangibleAssetsChangeFY05(double intangibleAssetsChangeFY05) {
		this.intangibleAssetsChangeFY05 = intangibleAssetsChangeFY05;
	}

	public double getDepreciationFromIntangibleAssetsPY03() {
		return depreciationFromIntangibleAssetsPY03;
	}

	public void setDepreciationFromIntangibleAssetsPY03() {
		if (this.intAssetsPY03 != 0 & this.depreciationIntangiblePY03 != 0) {
			this.depreciationFromIntangibleAssetsPY03 = (this.depreciationIntangiblePY03 / this.intAssetsPY03) * 100;
		} else {
			this.depreciationFromIntangibleAssetsPY03 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsPY02() {
		return depreciationFromIntangibleAssetsPY02;
	}

	public void setDepreciationFromIntangibleAssetsPY02() {
		if (this.intAssetsPY02 != 0 & this.depreciationIntangiblePY02 != 0) {
			this.depreciationFromIntangibleAssetsPY02 = (this.depreciationIntangiblePY02 / this.intAssetsPY02) * 100;
		} else {
			this.depreciationFromIntangibleAssetsPY02 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsPY01() {
		return depreciationFromIntangibleAssetsPY01;
	}

	public void setDepreciationFromIntangibleAssetsPY01() {
		if (this.intAssetsPY01 != 0 & this.depreciationIntangiblePY01 != 0) {
			this.depreciationFromIntangibleAssetsPY01 = (this.depreciationIntangiblePY01 / this.intAssetsPY01) * 100;
		} else {
			this.depreciationFromIntangibleAssetsPY01 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsY00() {
		return depreciationFromIntangibleAssetsY00;
	}

	public void setDepreciationFromIntangibleAssetsY00() {
		if (this.intAssetsY00 != 0 & this.depreciationIntangibleY00 != 0) {
			this.depreciationFromIntangibleAssetsY00 = (this.depreciationIntangibleY00 / this.intAssetsY00) * 100;
		} else {
			this.depreciationFromIntangibleAssetsY00 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsFY01() {
		return depreciationFromIntangibleAssetsFY01;
	}

	public void setDepreciationFromIntangibleAssetsFY01() {
		if (this.intAssetsFY01 != 0 & this.depreciationIntangibleFY01 != 0) {
			this.depreciationFromIntangibleAssetsFY01 = (this.depreciationIntangibleFY01 / this.intAssetsFY01) * 100;
		} else {
			this.depreciationFromIntangibleAssetsFY01 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsFY02() {
		return depreciationFromIntangibleAssetsFY02;
	}

	public void setDepreciationFromIntangibleAssetsFY02() {
		if (this.intAssetsFY02 != 0 & this.depreciationIntangibleFY02 != 0) {
			this.depreciationFromIntangibleAssetsFY02 = (this.depreciationIntangibleFY02 / this.intAssetsFY02) * 100;
		} else {
			this.depreciationFromIntangibleAssetsFY02 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsFY03() {
		return depreciationFromIntangibleAssetsFY03;
	}

	public void setDepreciationFromIntangibleAssetsFY03() {
		if (this.intAssetsFY03 != 0 & this.depreciationIntangibleFY03 != 0) {
			this.depreciationFromIntangibleAssetsFY03 = (this.depreciationIntangibleFY03 / this.intAssetsFY03) * 100;
		} else {
			this.depreciationFromIntangibleAssetsFY03 = 0.00;
		}
	}

	public double getDepreciationFromIntangibleAssetsFY04() {
		return depreciationFromIntangibleAssetsFY04;
	}

	public void setDepreciationFromIntangibleAssetsFY04() {
		if (this.intAssetsFY04 != 0 & this.depreciationIntangibleFY04 != 0) {
			this.depreciationFromIntangibleAssetsFY04 = (this.depreciationIntangibleFY04 / this.intAssetsFY04) * 100;
		} else {
			this.depreciationFromIntangibleAssetsFY04 = 0.00;
		}
	}
	
	public double getDepreciationFromIntangibleAssetsFY05() {
		return depreciationFromIntangibleAssetsFY05;
	}

	public void setDepreciationFromIntangibleAssetsFY05() {
		if (this.intAssetsFY05 != 0 & this.depreciationIntangibleFY05 != 0) {
			this.depreciationFromIntangibleAssetsFY05 = (this.depreciationIntangibleFY05 / this.intAssetsFY05) * 100;
		} else {
			this.depreciationFromIntangibleAssetsFY05 = 0.00;
		}
	}

	// Getter und Setter fuer das sonstige Anlagevermoegen

	public double getOtherAssetsPY03() {
		return otherAssetsPY03;
	}

	public void setOtherAssetsPY03(double otherAssetsPY03) {
		this.otherAssetsPY03 = otherAssetsPY03;
	}

	public double getOtherAssetsPY02() {
		return otherAssetsPY02;
	}

	public void setOtherAssetsPY02(double otherAssetsPY02) {
		this.otherAssetsPY02 = otherAssetsPY02;
	}

	public double getOtherAssetsPY01() {
		return otherAssetsPY01;
	}

	public void setOtherAssetsPY01(double otherAssetsPY01) {
		this.otherAssetsPY01 = otherAssetsPY01;
	}

	public double getOtherAssetsY00() {
		return otherAssetsY00;
	}

	public void setOtherAssetsY00(double otherAssetsY00) {
		this.otherAssetsY00 = otherAssetsY00;
	}
	

	public double getOtherAssetsFY01() {
		return otherAssetsFY01;
	}

	public void setOtherAssetsFY01() {
		this.otherAssetsFY01 = this.otherAssetsY00 + this.otherAssetsChangeFY01;
	}

	public double getOtherAssetsFY02() {
		return otherAssetsFY02;
	}

	public void setOtherAssetsFY02() {
		this.otherAssetsFY02 = this.otherAssetsFY01 + this.otherAssetsChangeFY02;
	}

	public double getOtherAssetsFY03() {
		return otherAssetsFY03;
	}

	public void setOtherAssetsFY03() {
		this.otherAssetsFY03 = this.otherAssetsFY02 + this.otherAssetsChangeFY03;
	}

	public double getOtherAssetsFY04() {
		return otherAssetsFY04;
	}

	public void setOtherAssetsFY04() {
		this.otherAssetsFY04 = this.otherAssetsFY03 + this.otherAssetsChangeFY04;
	}

	public double getOtherAssetsFY05() {
		return otherAssetsFY05;
	}

	public void setOtherAssetsFY05() {
		this.otherAssetsFY05 = this.otherAssetsFY04 + this.otherAssetsChangeFY05;
	}

	public double getOtherAssetsChangePY02() {
		return otherAssetsChangePY02;
	}

	public void setOtherAssetsChangePY02() {
		this.otherAssetsChangePY02 = this.otherAssetsPY02 - this.otherAssetsPY03;
	}

	public double getOtherAssetsChangePY01() {
		return otherAssetsChangePY01;
	}

	public void setOtherAssetsChangePY01() {
		this.otherAssetsChangePY01 = this.otherAssetsPY01 - this.otherAssetsPY02;
	}

	public double getOtherAssetsChangeY00() {
		return otherAssetsChangeY00;
	}

	public void setOtherAssetsChangeY00() {
		this.otherAssetsChangeY00 = this.otherAssetsY00 - this.otherAssetsPY01;
	}
	
	public double getOtherAssetsChangeFY01() {
		return otherAssetsChangeFY01;
	}

	public void setOtherAssetsChangeFY01(double otherAssetsChangeFY01) {
		this.otherAssetsChangeFY01 = otherAssetsChangeFY01;
	}

	public double getOtherAssetsChangeFY02() {
		return otherAssetsChangeFY02;
	}

	public void setOtherAssetsChangeFY02(double otherAssetsChangeFY02) {
		this.otherAssetsChangeFY02 = otherAssetsChangeFY02;
	}

	public double getOtherAssetsChangeFY03() {
		return otherAssetsChangeFY03;
	}

	public void setOtherAssetsChangeFY03(double otherAssetsChangeFY03) {
		this.otherAssetsChangeFY03 = otherAssetsChangeFY03;
	}

	public double getOtherAssetsChangeFY04() {
		return otherAssetsChangeFY04;
	}

	public void setOtherAssetsChangeFY04(double otherAssetsChangeFY04) {
		this.otherAssetsChangeFY04 = otherAssetsChangeFY04;
	}

	public double getOtherAssetsChangeFY05() {
		return otherAssetsChangeFY05;
	}

	public void setOtherAssetsChangeFY05(double otherAssetsChangeFY05) {
		this.otherAssetsChangeFY05 = otherAssetsChangeFY05;
	}
	

	// Getter und Setter fuer die Summe des Anlagevermoegen


	public double getAssetsPY03() {
		return assetsPY03;
	}

	public void setAssetsPY03() {
		this.assetsPY03 = this.finAssetsPY03 + this.propAssetsPY03 + this.intAssetsPY03 + this.otherAssetsPY03;
	}

	public double getAssetsPY02() {
		return assetsPY02;
	}

	public void setAssetsPY02() {
		this.assetsPY02 = this.finAssetsPY02 + this.propAssetsPY02 + this.intAssetsPY02 + this.otherAssetsPY02;
	}

	public double getAssetsPY01() {
		return assetsPY01;
	}

	public void setAssetsPY01() {
		this.assetsPY01 = this.finAssetsPY01 + this.propAssetsPY01 + this.intAssetsPY01 + this.otherAssetsPY01;
	}

	public double getAssetsY00() {
		return assetsY00;
	}

	public void setAssetsY00() {
		this.assetsY00 = this.finAssetsY00 + this.propAssetsY00 + this.intAssetsY00 + this.otherAssetsY00;
	}
	
	public double getAssetsFY01() {
		return assetsFY01;
	}

	public void setAssetsFY01() {
		this.assetsFY01 = this.finAssetsFY01 + this.propAssetsFY01 + this.intAssetsFY01 + this.otherAssetsFY01;
	}

	public double getAssetsFY02() {
		return assetsFY02;
	}

	public void setAssetsFY02() {
		this.assetsFY02 = this.finAssetsFY02 + this.propAssetsFY02 + this.intAssetsFY02 + this.otherAssetsFY02;
	}

	public double getAssetsFY03() {
		return assetsFY03;
	}

	public void setAssetsFY03() {
		this.assetsFY03 = this.finAssetsFY03 + this.propAssetsFY03 + this.intAssetsFY03 + this.otherAssetsFY03;
	}

	public double getAssetsFY04() {
		return assetsFY04;
	}

	public void setAssetsFY04() {
		this.assetsFY04 = this.finAssetsFY04 + this.propAssetsFY04 + this.intAssetsFY04 + this.otherAssetsFY04;
	}

	public double getAssetsFY05() {
		return assetsFY05;
	}

	public void setAssetsFY05() {
		this.assetsFY05 = this.finAssetsFY05 + this.propAssetsFY05 + this.intAssetsFY05 + this.otherAssetsFY05;
	}
	

	// Getter und Setter fuer Vorraete



	public double getInventoryPY03() {
		return inventoryPY03;
	}

	public void setInventoryPY03(double inventoryPY03) {
		this.inventoryPY03 = inventoryPY03;
	}

	public double getInventoryPY02() {
		return inventoryPY02;
	}

	public void setInventoryPY02(double inventoryPY02) {
		this.inventoryPY02 = inventoryPY02;
	}

	public double getInventoryPY01() {
		return inventoryPY01;
	}

	public void setInventoryPY01(double inventoryPY01) {
		this.inventoryPY01 = inventoryPY01;
	}

	public double getInventoryY00() {
		return inventoryY00;
	}

	public void setInventoryY00(double inventoryY00) {
		this.inventoryY00 = inventoryY00;
	}
	
	
	public double getInventoryFY01() {
		return inventoryFY01;
	}

	public void setInventoryFY01() {
		if (this.cogsFY01 != 0 & this.inventoryTurnoverFY01 != 0) {
			
			this.inventoryFY01 = this.cogsFY01 / this.inventoryTurnoverFY01;
			
		} else {
			
			this.inventoryFY01 = this.inventoryY00;
		}
		
	}

	public double getInventoryFY02() {
		return inventoryFY02;
	}

	public void setInventoryFY02() {
		if (this.cogsFY02 != 0 & this.inventoryTurnoverFY02 != 0) {
			
			this.inventoryFY02 = this.cogsFY02 / this.inventoryTurnoverFY02;
			
		} else {
			
			this.inventoryFY02 = this.inventoryFY01;
		}
		
	}

	public double getInventoryFY03() {
		return inventoryFY03;
	}

	public void setInventoryFY03() {
		if (this.cogsFY03 != 0 & this.inventoryTurnoverFY03 != 0) {
			
			this.inventoryFY03 = this.cogsFY03 / this.inventoryTurnoverFY03;
			
		} else {
			
			this.inventoryFY03 = this.inventoryFY02;
		}
		
	}

	public double getInventoryFY04() {
		return inventoryFY04;
	}

	public void setInventoryFY04() {
		if (this.cogsFY04 != 0 & this.inventoryTurnoverFY04 != 0) {
			
			this.inventoryFY04 = this.cogsFY04 / this.inventoryTurnoverFY04;
			
		} else {
			
			this.inventoryFY04 = this.inventoryFY03;
		}
	}

	public double getInventoryFY05() {
		return inventoryFY05;
	}

	public void setInventoryFY05() {
		if (this.cogsFY05 != 0 & this.inventoryTurnoverFY05 != 0) {
			
			this.inventoryFY05 = this.cogsFY05 / this.inventoryTurnoverFY05;
			
		} else {
			
			this.inventoryFY05 = this.inventoryFY04;
		}
	}

	public double getInventoryTurnoverPY03() {
		return inventoryTurnoverPY03;
	}

	public void setInventoryTurnoverPY03() {
		if (this.inventoryPY03 == 0 | this.cogsPY03 == 0) {
			this.inventoryTurnoverPY03 = 0.00;
		} else {

			this.inventoryTurnoverPY03 = this.cogsPY03 / this.inventoryPY03;
		}
	}

	public double getInventoryTurnoverPY02() {
		return inventoryTurnoverPY02;
	}

	public void setInventoryTurnoverPY02() {
		if (this.inventoryPY02 == 0 | this.cogsPY02 == 0) {
			this.inventoryTurnoverPY02 = 0.00;
		} else {

			this.inventoryTurnoverPY02 = this.cogsPY02 / this.inventoryPY02;
		}

	}

	public double getInventoryTurnoverPY01() {
		return inventoryTurnoverPY01;
	}

	public void setInventoryTurnoverPY01() {
		if (this.inventoryPY01 == 0 | this.cogsPY01 == 0) {
			this.inventoryTurnoverPY01 = 0.00;
		} else {

			this.inventoryTurnoverPY01 = this.cogsPY01 / this.inventoryPY01;
		}
	}

	public double getInventoryTurnoverY00() {
		return inventoryTurnoverY00;
	}

	public void setInventoryTurnoverY00() {
		if (this.inventoryY00 == 0 | this.cogsY00 == 0) {
			this.inventoryTurnoverY00 = 0.00;
		} else {

			this.inventoryTurnoverY00 = this.cogsY00 / this.inventoryY00;
		}
	}
	
	public double getInventoryTurnoverFY01() {
		return inventoryTurnoverFY01;
	}

	public void setInventoryTurnoverFY01(double inventoryTurnoverFY01) {
		this.inventoryTurnoverFY01 = inventoryTurnoverFY01;
	}

	public double getInventoryTurnoverFY02() {
		return inventoryTurnoverFY02;
	}

	public void setInventoryTurnoverFY02(double inventoryTurnoverFY02) {
		this.inventoryTurnoverFY02 = inventoryTurnoverFY02;
	}

	public double getInventoryTurnoverFY03() {
		return inventoryTurnoverFY03;
	}

	public void setInventoryTurnoverFY03(double inventoryTurnoverFY03) {
		this.inventoryTurnoverFY03 = inventoryTurnoverFY03;
	}

	public double getInventoryTurnoverFY04() {
		return inventoryTurnoverFY04;
	}

	public void setInventoryTurnoverFY04(double inventoryTurnoverFY04) {
		this.inventoryTurnoverFY04 = inventoryTurnoverFY04;
	}

	public double getInventoryTurnoverFY05() {
		return inventoryTurnoverFY05;
	}

	public void setInventoryTurnoverFY05(double inventoryTurnoverFY05) {
		this.inventoryTurnoverFY05 = inventoryTurnoverFY05;
	}
	

	// Getter und Setter fuer Forderungen



	public double getReceivablesPY03() {
		return receivablesPY03;
	}

	public void setReceivablesPY03(double receivablesPY03) {
		this.receivablesPY03 = receivablesPY03;
	}

	public double getReceivablesPY02() {
		return receivablesPY02;
	}

	public void setReceivablesPY02(double receivablesPY02) {
		this.receivablesPY02 = receivablesPY02;
	}

	public double getReceivablesPY01() {
		return receivablesPY01;
	}

	public void setReceivablesPY01(double receivablesPY01) {
		this.receivablesPY01 = receivablesPY01;
	}

	public double getReceivablesY00() {
		return receivablesY00;
	}
	
	public void setReceivablesY00(double receivablesY00) {
		this.receivablesY00 = receivablesY00;
	}

	
	public double getReceivablesFY01() {
		return receivablesFY01;
	}

	public void setReceivablesFY01() {
		if (this.revenueFY01 != 0 & this.receivablesTurnoverFY01 != 0) {
			
			this.receivablesFY01 = this.revenueFY01 / this.receivablesTurnoverFY01;
		} else {
			
			this.receivablesFY01 = this.receivablesY00;
			
		}
		
	}

	public double getReceivablesFY02() {
		return receivablesFY02;
	}

	public void setReceivablesFY02() {
		if (this.revenueFY02 != 0 & this.receivablesTurnoverFY02 != 0) {
			
			this.receivablesFY02 = this.revenueFY02 / this.receivablesTurnoverFY02;
		} else {
			
			this.receivablesFY02 = this.receivablesFY01;
			
		}
	}

	public double getReceivablesFY03() {
		return receivablesFY03;
	}

	public void setReceivablesFY03() {
		if (this.revenueFY03 != 0 & this.receivablesTurnoverFY03 != 0) {
			
			this.receivablesFY03 = this.revenueFY03 / this.receivablesTurnoverFY03;
		} else {
			
			this.receivablesFY03 = this.receivablesFY02;
			
		}
	}

	public double getReceivablesFY04() {
		return receivablesFY04;
	}

	public void setReceivablesFY04() {
		if (this.revenueFY04 != 0 & this.receivablesTurnoverFY04 != 0) {
			
			this.receivablesFY04 = this.revenueFY04 / this.receivablesTurnoverFY04;
		} else {
			
			this.receivablesFY04 = this.receivablesFY03;
			
		}
	}

	public double getReceivablesFY05() {
		return receivablesFY05;
	}

	public void setReceivablesFY05() {
		if (this.revenueFY05 != 0 & this.receivablesTurnoverFY05 != 0) {
			
			this.receivablesFY05 = this.revenueFY05 / this.receivablesTurnoverFY05;
		} else {
			
			this.receivablesFY05 = this.receivablesFY04;
			
		}
	}

	public double getReceivablesTurnoverPY03() {
		return receivablesTurnoverPY03;
	}

	public void setReceivablesTurnoverPY03() {
		if (this.receivablesPY03 == 0 | this.revenuePY03 == 0) {
			this.receivablesTurnoverPY03 = 0.00;
		} else {

			this.receivablesTurnoverPY03 = this.revenuePY03 / this.receivablesPY03;
		}
	}

	public double getReceivablesTurnoverPY02() {
		return receivablesTurnoverPY02;
	}

	public void setReceivablesTurnoverPY02() {
		if (this.receivablesPY02 == 0 | this.revenuePY02 == 0) {
			this.receivablesTurnoverPY02 = 0.00;
		} else {

			this.receivablesTurnoverPY02 = this.revenuePY02 / this.receivablesPY02;
		}
	}

	public double getReceivablesTurnoverPY01() {
		return receivablesTurnoverPY01;
	}

	public void setReceivablesTurnoverPY01() {
		if (this.receivablesPY01 == 0 | this.revenuePY01 == 0) {
			this.receivablesTurnoverPY01 = 0.00;
		} else {

			this.receivablesTurnoverPY01 = this.revenuePY01 / this.receivablesPY01;
		}
	}

	public double getReceivablesTurnoverY00() {
		return receivablesTurnoverY00;
	}

	public void setReceivablesTurnoverY00() {
		if (this.receivablesY00 == 0 | this.revenueY00 == 0) {
			this.receivablesTurnoverY00 = 0.00;
		} else {

			this.receivablesTurnoverY00 = this.revenueY00 / this.receivablesY00;
		}
	}
	

	public double getReceivablesTurnoverFY01() {
		return receivablesTurnoverFY01;
	}

	public void setReceivablesTurnoverFY01(double receivablesTurnoverFY01) {
		this.receivablesTurnoverFY01 = receivablesTurnoverFY01;
	}

	public double getReceivablesTurnoverFY02() {
		return receivablesTurnoverFY02;
	}

	public void setReceivablesTurnoverFY02(double receivablesTurnoverFY02) {
		this.receivablesTurnoverFY02 = receivablesTurnoverFY02;
	}

	public double getReceivablesTurnoverFY03() {
		return receivablesTurnoverFY03;
	}

	public void setReceivablesTurnoverFY03(double receivablesTurnoverFY03) {
		this.receivablesTurnoverFY03 = receivablesTurnoverFY03;
	}

	public double getReceivablesTurnoverFY04() {
		return receivablesTurnoverFY04;
	}

	public void setReceivablesTurnoverFY04(double receivablesTurnoverFY04) {
		this.receivablesTurnoverFY04 = receivablesTurnoverFY04;
	}

	public double getReceivablesTurnoverFY05() {
		return receivablesTurnoverFY05;
	}

	public void setReceivablesTurnoverFY05(double receivablesTurnoverFY05) {
		this.receivablesTurnoverFY05 = receivablesTurnoverFY05;
	}
	

	// Getter und Setter fuer sonstiges Umlaufvermoegen
	
	public double getOtherNCAPY03() {
		return otherNCAPY03;
	}

	public void setOtherNCAPY03(double otherNCAPY03) {
		this.otherNCAPY03 = otherNCAPY03;
	}

	public double getOtherNCAPY02() {
		return otherNCAPY02;
	}

	public void setOtherNCAPY02(double otherNCAPY02) {
		this.otherNCAPY02 = otherNCAPY02;
	}

	public double getOtherNCAPY01() {
		return otherNCAPY01;
	}

	public void setOtherNCAPY01(double otherNCAPY01) {
		this.otherNCAPY01 = otherNCAPY01;
	}

	public double getOtherNCAY00() {
		return otherNCAY00;
	}

	public void setOtherNCAY00(double otherNCAY00) {
		this.otherNCAY00 = otherNCAY00;
	}
	
	public double getOtherNCAFY01() {
		return otherNCAFY01;
	}

	public void setOtherNCAFY01() {
		this.otherNCAFY01 = this.otherNCAY00 + this.otherNCAFromNCAFY01; // Bestand +  Zugang bzw. - Abgang
	}

	public double getOtherNCAFY02() {
		return otherNCAFY02;
	}

	public void setOtherNCAFY02() {
		this.otherNCAFY02 = this.otherNCAFY01 + this.otherNCAFromNCAFY02;
	}

	public double getOtherNCAFY03() {
		return otherNCAFY03;
	}

	public void setOtherNCAFY03() {
		this.otherNCAFY03 = this.otherNCAFY02 + this.otherNCAFromNCAFY03;
	}

	public double getOtherNCAFY04() {
		return otherNCAFY04;
	}

	public void setOtherNCAFY04() {
		this.otherNCAFY04 = this.otherNCAFY03 + this.otherNCAFromNCAFY04;
	}

	public double getOtherNCAFY05() {
		return otherNCAFY05;
	}

	public void setOtherNCAFY05() {
		this.otherNCAFY05 = this.otherNCAFY04 + this.otherNCAFromNCAFY05;
	}

	public double getOtherNCAFromNCAPY02() {
		return otherNCAFromNCAPY02;
	}

	public void setOtherNCAFromNCAPY02() {
		this.otherNCAFromNCAPY02 = this.otherNCAPY02 - this.otherNCAPY03;
	}

	public double getOtherNCAFromNCAPY01() {
		return otherNCAFromNCAPY01;
	}

	public void setOtherNCAFromNCAPY01() {
		this.otherNCAFromNCAPY01 = this.otherNCAPY01 - this.otherNCAPY02;
	}

	public double getOtherNCAFromNCAY00() {
		return otherNCAFromNCAY00;
	}

	public void setOtherNCAFromNCAY00() {
		this.otherNCAFromNCAY00 = this.otherNCAY00 - this.otherNCAPY01;
	}
	
	
	public double getOtherNCAFromNCAFY01() {
		return otherNCAFromNCAFY01;
	}

	public void setOtherNCAFromNCAFY01(double otherNCAFromNCAFY01) {
		this.otherNCAFromNCAFY01 = otherNCAFromNCAFY01;
	}

	public double getOtherNCAFromNCAFY02() {
		return otherNCAFromNCAFY02;
	}

	public void setOtherNCAFromNCAFY02(double otherNCAFromNCAFY02) {
		this.otherNCAFromNCAFY02 = otherNCAFromNCAFY02;
	}

	public double getOtherNCAFromNCAFY03() {
		return otherNCAFromNCAFY03;
	}

	public void setOtherNCAFromNCAFY03(double otherNCAFromNCAFY03) {
		this.otherNCAFromNCAFY03 = otherNCAFromNCAFY03;
	}

	public double getOtherNCAFromNCAFY04() {
		return otherNCAFromNCAFY04;
	}

	public void setOtherNCAFromNCAFY04(double otherNCAFromNCAFY04) {
		this.otherNCAFromNCAFY04 = otherNCAFromNCAFY04;
	}

	public double getOtherNCAFromNCAFY05() {
		return otherNCAFromNCAFY05;
	}

	public void setOtherNCAFromNCAFY05(double otherNCAFromNCAFY05) {
		this.otherNCAFromNCAFY05 = otherNCAFromNCAFY05;
	}

	/**
	 * Getter und Setter fuer das Umlaufvermoegen Berechne aus den Vorräten,
	 * Forderungen und die Summe des Umlaufvermoegens
	 **/

	public double getNcaPY03() {
		return ncaPY03;
	}

	public void setNcaPY03() {
		this.ncaPY03 = this.inventoryPY03 + this.receivablesPY03 + this.otherNCAPY03;
	}

	public double getNcaPY02() {
		return ncaPY02;
	}

	public void setNcaPY02() {
		this.ncaPY02 = this.inventoryPY02 + this.receivablesPY02 + this.otherNCAPY02;
	}

	public double getNcaPY01() {
		return ncaPY01;
	}

	public void setNcaPY01() {
		this.ncaPY01 = this.inventoryPY01 + this.receivablesPY01 + this.otherNCAPY01;
	}

	public double getNcaY00() {
		return ncaY00;
	}

	public void setNcaY00() {
		this.ncaY00 = this.inventoryY00 + this.receivablesY00 + this.otherNCAY00;
	}
	

	public double getNcaFY01() {
		return ncaFY01;
	}

	public void setNcaFY01() {
		this.ncaFY01 = this.inventoryFY01 + this.receivablesFY01 + this.otherNCAFY01;
	}

	public double getNcaFY02() {
		return ncaFY02;
	}

	public void setNcaFY02() {
		this.ncaFY02 = this.inventoryFY02 + this.receivablesFY02 + this.otherNCAFY02;
	}

	public double getNcaFY03() {
		return ncaFY03;
	}

	public void setNcaFY03() {
		this.ncaFY03 = this.inventoryFY03 + this.receivablesFY03 + this.otherNCAFY03;
	}

	public double getNcaFY04() {
		return ncaFY04;
	}

	public void setNcaFY04() {
		this.ncaFY04 = this.inventoryFY04 + this.receivablesFY04 + this.otherNCAFY04;
	}

	public double getNcaFY05() {
		return ncaFY05;
	}

	public void setNcaFY05() {
		this.ncaFY05 = this.inventoryFY05 + this.receivablesFY05 + this.otherNCAFY05;
	}
		

	// Berechnung der liquiden Mittel in den Bilanz Aktiva

	public double getCashPY03() {
		return this.cashPY03;
	}

	public void setCashPY03() {
		this.cashPY03 = this.totalLiabilitiesPY03 - this.assetsPY03 - this.ncaPY03;
	}

	public double getCashPY02() {
		return this.cashPY02;
	}

	public void setCashPY02() {
		this.cashPY02 = this.totalLiabilitiesPY02 - this.assetsPY02 - this.ncaPY02;
	}

	public double getCashPY01() {
		return this.cashPY01;
	}

	public void setCashPY01() {
		this.cashPY01 = this.totalLiabilitiesPY01 - this.assetsPY01 - this.ncaPY01;
	}

	public double getCashY00() {
		return this.cashY00;
	}

	public void setCashY00() {
		this.cashY00 = this.totalLiabilitiesY00 - this.assetsY00 - this.ncaY00;
	}

	public double getCashFY01() {
		return cashFY01;
	}

	public void setCashFY01() {
		this.cashFY01 = this.totalLiabilitiesFY01 - this.assetsFY01 - this.ncaFY01;
	}

	public double getCashFY02() {
		return cashFY02;
	}

	public void setCashFY02() {
		this.cashFY02 = this.totalLiabilitiesFY02 - this.assetsFY02 - this.ncaFY02;
	}

	public double getCashFY03() {
		return cashFY03;
	}

	public void setCashFY03() {
		this.cashFY03 = this.totalLiabilitiesFY03 - this.assetsFY03 - this.ncaFY03;
	}

	public double getCashFY04() {
		return cashFY04;
	}

	public void setCashFY04() {
		this.cashFY04 = this.totalLiabilitiesFY04 - this.assetsFY04 - this.ncaFY04;
	}

	public double getCashFY05() {
		return cashFY05;
	}

	public void setCashFY05() {
		this.cashFY05 = this.totalLiabilitiesFY05 - this.assetsFY05 - this.ncaFY05;
	}
	

	// Berechnung Summe der Aktiva

	public double getTotalAssetsPY03() {
		return totalAssetsPY03;
	}

	public void setTotalAssetsPY03() {
		this.totalAssetsPY03 = this.assetsPY03 + this.ncaPY03 + this.cashPY03;
	}

	public double getTotalAssetsPY02() {
		return totalAssetsPY02;
	}

	public void setTotalAssetsPY02() {
		this.totalAssetsPY02 = this.assetsPY02 + this.ncaPY02 + this.cashPY02;
	}

	public double getTotalAssetsPY01() {
		return totalAssetsPY01;
	}

	public void setTotalAssetsPY01() {
		this.totalAssetsPY01 = this.assetsPY01 + this.ncaPY01 + this.cashPY01;
	}

	public double getTotalAssetsY00() {
		return totalAssetsY00;
	}

	public void setTotalAssetsY00() {
		this.totalAssetsY00 = this.assetsY00 + this.ncaY00 + this.cashY00;
	}
	
	public double getTotalAssetsFY01() {
		return totalAssetsFY01;
	}

	public void setTotalAssetsFY01() {
		this.totalAssetsFY01 = this.assetsFY01 + this.ncaFY01 + this.cashFY01;
	}

	public double getTotalAssetsFY02() {
		return totalAssetsFY02;
	}

	public void setTotalAssetsFY02() {
		this.totalAssetsFY02 = this.assetsFY02 + this.ncaFY02 + this.cashFY02;
	}

	public double getTotalAssetsFY03() {
		return totalAssetsFY03;
	}

	public void setTotalAssetsFY03() {
		this.totalAssetsFY03 = this.assetsFY03 + this.ncaFY03 + this.cashFY03;
	}

	public double getTotalAssetsFY04() {
		return totalAssetsFY04;
	}

	public void setTotalAssetsFY04() {
		this.totalAssetsFY04 = this.assetsFY04 + this.ncaFY04 + this.cashFY04;
	}

	public double getTotalAssetsFY05() {
		return totalAssetsFY05;
	}

	public void setTotalAssetsFY05() {
		this.totalAssetsFY05 = this.assetsFY05 + this.ncaFY05 + this.cashFY05;
	}
	
	

	// Passiva
	// Getter und Setter fuer das Grundkapital


	public double getShareCapitalPY03() {
		return shareCapitalPY03;
	}

	public void setShareCapitalPY03(double shareCapitalPY03) {
		this.shareCapitalPY03 = shareCapitalPY03;
	}

	public double getShareCapitalPY02() {
		return shareCapitalPY02;
	}

	public void setShareCapitalPY02(double shareCapitalPY02) {
		this.shareCapitalPY02 = shareCapitalPY02;
	}

	public double getShareCapitalPY01() {
		return shareCapitalPY01;
	}

	public void setShareCapitalPY01(double shareCapitalPY01) {
		this.shareCapitalPY01 = shareCapitalPY01;
	}

	public double getShareCapitalY00() {
		return shareCapitalY00;
	}

	public void setShareCapitalY00(double shareCapitalY00) {
		this.shareCapitalY00 = shareCapitalY00;
	}
	
	public double getShareCapitalFY01() {
		return shareCapitalFY01;
	}

	public void setShareCapitalFY01() {
		this.shareCapitalFY01 = this.shareCapitalY00 * (1 + (this.shareCapitalChangeFY01 / 100));
	}

	public double getShareCapitalFY02() {
		return shareCapitalFY02;
	}

	public void setShareCapitalFY02() {
		this.shareCapitalFY02 = this.shareCapitalFY01 * (1 + (this.shareCapitalChangeFY02 / 100));
	}

	public double getShareCapitalFY03() {
		return shareCapitalFY03;
	}

	public void setShareCapitalFY03() {
		this.shareCapitalFY03 = this.shareCapitalFY02 * (1 + (this.shareCapitalChangeFY03 / 100));
	}

	public double getShareCapitalFY04() {
		return shareCapitalFY04;
	}

	public void setShareCapitalFY04() {
		this.shareCapitalFY04 = this.shareCapitalFY03 * (1 + (this.shareCapitalChangeFY04 / 100));
	}

	public double getShareCapitalFY05() {
		return shareCapitalFY05;
	}

	public void setShareCapitalFY05() {
		this.shareCapitalFY05 = this.shareCapitalFY04 * (1 + (this.shareCapitalChangeFY05 / 100));
	}

	public double getShareCapitalChangePY02() {
		return shareCapitalChangePY02;
	}

	public void setShareCapitalChangePY02() {
		if (this.shareCapitalPY03 != 0) {
			this.shareCapitalChangePY02 = ((this.shareCapitalPY02 / this.shareCapitalPY03) - 1) * 100;
		} else {
			this.shareCapitalChangePY02 = 0.00;
		}
	}

	public double getShareCapitalChangePY01() {
		return shareCapitalChangePY01;
	}

	public void setShareCapitalChangePY01() {
		if (this.shareCapitalPY02 != 0) {
			this.shareCapitalChangePY01 = ((this.shareCapitalPY01 / this.shareCapitalPY02) - 1) * 100;
		} else {
			this.shareCapitalChangePY01 = 0.00;
		}
	}

	public double getShareCapitalChangeY00() {
		return shareCapitalChangeY00;
	}

	public void setShareCapitalChangeY00() {
		if (this.shareCapitalPY01 != 0) {
			this.shareCapitalChangeY00 = ((this.shareCapitalY00 / this.shareCapitalPY01) - 1) * 100;
		} else {
			this.shareCapitalChangeY00 = 0.00;
		}
	}
		
	public double getShareCapitalChangeFY01() {
		return shareCapitalChangeFY01;
	}

	public void setShareCapitalChangeFY01(double shareCapitalChangeFY01) {
		this.shareCapitalChangeFY01 = shareCapitalChangeFY01;
	}

	public double getShareCapitalChangeFY02() {
		return shareCapitalChangeFY02;
	}

	public void setShareCapitalChangeFY02(double shareCapitalChangeFY02) {
		this.shareCapitalChangeFY02 = shareCapitalChangeFY02;
	}

	public double getShareCapitalChangeFY03() {
		return shareCapitalChangeFY03;
	}

	public void setShareCapitalChangeFY03(double shareCapitalChangeFY03) {
		this.shareCapitalChangeFY03 = shareCapitalChangeFY03;
	}

	public double getShareCapitalChangeFY04() {
		return shareCapitalChangeFY04;
	}

	public void setShareCapitalChangeFY04(double shareCapitalChangeFY04) {
		this.shareCapitalChangeFY04 = shareCapitalChangeFY04;
	}

	public double getShareCapitalChangeFY05() {
		return shareCapitalChangeFY05;
	}

	public void setShareCapitalChangeFY05(double shareCapitalChangeFY05) {
		this.shareCapitalChangeFY05 = shareCapitalChangeFY05;
	}
	
	
	// Getter und Setter fuer die Ruecklagen
	

	public double getReservesPY03() {
		return reservesPY03;
	}

	public void setReservesPY03(double reservesPY03) {
		this.reservesPY03 = reservesPY03;
	}

	public double getReservesPY02() {
		return reservesPY02;
	}

	public void setReservesPY02(double reservesPY02) {
		this.reservesPY02 = reservesPY02;
	}

	public double getReservesPY01() {
		return reservesPY01;
	}

	public void setReservesPY01(double reservesPY01) {
		this.reservesPY01 = reservesPY01;
	}

	public double getReservesY00() {
		return reservesY00;
	}

	public void setReservesY00(double reservesY00) {
		this.reservesY00 = reservesY00;
	}
	
	public double getReservesFY01() {
		return reservesFY01;
	}

	public void setReservesFY01() {
		this.reservesFY01 = this.reservesY00 + (this.totalIncomeFY01 - (this.totalIncomeFY01 * (this.dividendsPaidRateFY01 / 100))); //Bestand Vorjahr + Jahresüberschuss - Ausschüttungen
	}

	public double getReservesFY02() {
		return reservesFY02;
	}

	public void setReservesFY02() {
		this.reservesFY02 = this.reservesFY01 + (this.totalIncomeFY02 - (this.totalIncomeFY02 * (this.dividendsPaidRateFY02 / 100)));
	}

	public double getReservesFY03() {
		return reservesFY03;
	}

	public void setReservesFY03() {
		this.reservesFY03 = this.reservesFY02 + (this.totalIncomeFY03 - (this.totalIncomeFY03 * (this.dividendsPaidRateFY03 / 100)));
	}

	public double getReservesFY04() {
		return reservesFY04;
	}

	public void setReservesFY04() {
		this.reservesFY04 = this.reservesFY03 + (this.totalIncomeFY04 - (this.totalIncomeFY04 * (this.dividendsPaidRateFY04 / 100)));
	}

	public double getReservesFY05() {
		return reservesFY05;
	}

	public void setReservesFY05() {
		this.reservesFY05 = this.reservesFY04 + (this.totalIncomeFY05 - (this.totalIncomeFY05 * (this.dividendsPaidRateFY05 / 100)));
	}

	public double getDividendsPaidRatePY03() {
		return dividendsPaidRatePY03;
	}

	public double getReservesChangePY02() {
		return reservesChangePY02;
	}

	public void setReservesChangePY02() {
		if (this.reservesPY03 != 0) {
			this.reservesChangePY02 = ((this.reservesPY02 / this.reservesPY03) - 1) * 100;
		} else {
			this.reservesChangePY02 = 0.00;
		}
	}

	public double getReservesChangePY01() {
		return reservesChangePY01;
	}

	public void setReservesChangePY01() {
		if (this.reservesPY02 != 0) {
			this.reservesChangePY01 = ((this.reservesPY01 / this.reservesPY02) - 1) * 100;
		} else {
			this.reservesChangePY01 = 0.00;
		}
	}

	public double getReservesChangeY00() {
		return reservesChangeY00;
	}

	public void setReservesChangeY00() {
		if (this.reservesPY01 != 0) {
			this.reservesChangeY00 = ((this.reservesY00 / this.reservesPY01) - 1) * 100;
		} else {
			this.reservesChangeY00 = 0.00;
		}
	}
	

	public double getReservesChangeFY01() {
		return reservesChangeFY01;
	}

	public void setReservesChangeFY01() {
		if (this.reservesY00 != 0) {
			this.reservesChangeFY01 = ((this.reservesFY01 / this.reservesY00) - 1) * 100;
		} else {
			this.reservesChangeFY01 = 0.00;
		}
	}

	public double getReservesChangeFY02() {
		return reservesChangeFY02;
	}

	public void setReservesChangeFY02() {
		if (this.reservesFY01 != 0) {
			this.reservesChangeFY02 = ((this.reservesFY02 / this.reservesFY01) - 1) * 100;
		} else {
			this.reservesChangeFY02 = 0.00;
		}
	}

	public double getReservesChangeFY03() {
		return reservesChangeFY03;
	}

	public void setReservesChangeFY03() {
		if (this.reservesFY02 != 0) {
			this.reservesChangeFY03 = ((this.reservesFY03 / this.reservesFY02) - 1) * 100;
		} else {
			this.reservesChangeFY03 = 0.00;
		}
	}

	public double getReservesChangeFY04() {
		return reservesChangeFY04;
	}

	public void setReservesChangeFY04() {
		if (this.reservesFY03 != 0) {
			this.reservesChangeFY04 = ((this.reservesFY04 / this.reservesFY03) - 1) * 100;
		} else {
			this.reservesChangeFY04 = 0.00;
		}
	}

	public double getReservesChangeFY05() {
		return reservesChangeFY05;
	}

	public void setReservesChangeFY05() {
		if (this.reservesFY04 != 0) {
			this.reservesChangeFY05 = ((this.reservesFY05 / this.reservesFY04) - 1) * 100;
		} else {
			this.reservesChangeFY05 = 0.00;
		}
	}

	public void setDividendsPaidRatePY03() {
		if (this.totalIncomePY03 == 0 | this.dividendsPaidPY03 == 0) {
			this.dividendsPaidRatePY03 = 0.00;
		} else {
			this.dividendsPaidRatePY03 = (this.dividendsPaidPY03 / this.totalIncomePY03) * 100;
		}

	}

	public double getDividendsPaidRatePY02() {
		return dividendsPaidRatePY02;
	}

	public void setDividendsPaidRatePY02() {
		if (this.totalIncomePY02 == 0 | this.dividendsPaidPY02 == 0) {
			this.dividendsPaidRatePY02 = 0.00;
		} else {
			this.dividendsPaidRatePY02 = (this.dividendsPaidPY02 / this.totalIncomePY02) * 100;
		}
	}

	public double getDividendsPaidRatePY01() {
		return dividendsPaidRatePY01;
	}

	public void setDividendsPaidRatePY01() {
		if (this.totalIncomePY01 == 0 | this.dividendsPaidPY01 == 0) {
			this.dividendsPaidRatePY01 = 0.00;
		} else {
			this.dividendsPaidRatePY01 = (this.dividendsPaidPY01 / this.totalIncomePY01) * 100;
		}
	}

	public double getDividendsPaidRateY00() {
		return dividendsPaidRateY00;
	}

	public void setDividendsPaidRateY00() {
		if (this.totalIncomeY00 == 0 | this.dividendsPaidY00 == 0) {
			this.dividendsPaidRateY00 = 0.00;
		} else {
			this.dividendsPaidRateY00 = (this.dividendsPaidY00 / this.totalIncomeY00) * 100;
		}
	}

	public double getDividendsPaidRateFY01() {
		return dividendsPaidRateFY01;
	}

	public void setDividendsPaidRateFY01(double dividendsPaidRateFY01) {
		this.dividendsPaidRateFY01 = dividendsPaidRateFY01;
	}

	public double getDividendsPaidRateFY02() {
		return dividendsPaidRateFY02;
	}

	public void setDividendsPaidRateFY02(double dividendsPaidRateFY02) {
		this.dividendsPaidRateFY02 = dividendsPaidRateFY02;
	}

	public double getDividendsPaidRateFY03() {
		return dividendsPaidRateFY03;
	}

	public void setDividendsPaidRateFY03(double dividendsPaidRateFY03) {
		this.dividendsPaidRateFY03 = dividendsPaidRateFY03;
	}

	public double getDividendsPaidRateFY04() {
		return dividendsPaidRateFY04;
	}

	public void setDividendsPaidRateFY04(double dividendsPaidRateFY04) {
		this.dividendsPaidRateFY04 = dividendsPaidRateFY04;
	}

	public double getDividendsPaidRateFY05() {
		return dividendsPaidRateFY05;
	}

	public void setDividendsPaidRateFY05(double dividendsPaidRateFY05) {
		this.dividendsPaidRateFY05 = dividendsPaidRateFY05;
	}

	// Getter und Setter fuer sonstiges Eigenkapital

	public double getOtherEquityPY03() {
		return otherEquityPY03;
	}

	public void setOtherEquityPY03(double otherEquityPY03) {
		this.otherEquityPY03 = otherEquityPY03;
	}

	public double getOtherEquityPY02() {
		return otherEquityPY02;
	}

	public void setOtherEquityPY02(double otherEquityPY02) {
		this.otherEquityPY02 = otherEquityPY02;
	}

	public double getOtherEquityPY01() {
		return otherEquityPY01;
	}

	public void setOtherEquityPY01(double otherEquityPY01) {
		this.otherEquityPY01 = otherEquityPY01;
	}

	public double getOtherEquityY00() {
		return otherEquityY00;
	}

	public void setOtherEquityY00(double otherEquityY00) {
		this.otherEquityY00 = otherEquityY00;
	}
	
	public double getOtherEquityFY01() {
		return otherEquityFY01;
	}

	public void setOtherEquityFY01() {
		this.otherEquityFY01 = this.otherEquityY00 * (1 + (this.otherEquityChangeFY01 / 100));
	}

	public double getOtherEquityFY02() {
		return otherEquityFY02;
	}

	public void setOtherEquityFY02() {
		this.otherEquityFY02 = this.otherEquityFY01 * (1 + (this.otherEquityChangeFY02 / 100));
	}

	public double getOtherEquityFY03() {
		return otherEquityFY03;
	}

	public void setOtherEquityFY03() {
		this.otherEquityFY03 = this.otherEquityFY02 * (1 + (this.otherEquityChangeFY03 / 100));
	}

	public double getOtherEquityFY04() {
		return otherEquityFY04;
	}

	public void setOtherEquityFY04() {
		this.otherEquityFY04 = this.otherEquityFY03 * (1 + (this.otherEquityChangeFY04 / 100));
	}

	public double getOtherEquityFY05() {
		return otherEquityFY05;
	}

	public void setOtherEquityFY05() {
		this.otherEquityFY05 = this.otherEquityFY04 * (1 + (this.otherEquityChangeFY05 / 100));
	}

	public double getOtherEquityChangePY02() {
		return otherEquityChangePY02;
	}

	public void setOtherEquityChangePY02() {
		if (this.otherEquityPY03 != 0) {
			this.otherEquityChangePY02 = ((this.otherEquityPY02 / this.otherEquityPY03) - 1) * 100;
		} else {
			this.otherEquityChangePY02 = 0.00;
		}
	}

	public double getOtherEquityChangePY01() {
		return otherEquityChangePY01;
	}

	public void setOtherEquityChangePY01() {
		if (this.otherEquityPY02 != 0) {
			this.otherEquityChangePY01 = ((this.otherEquityPY01 / this.otherEquityPY02) - 1) * 100;
		} else {
			this.otherEquityChangePY01 = 0.00;
		}
	}

	public double getOtherEquityChangeY00() {
		return otherEquityChangeY00;
	}

	public void setOtherEquityChangeY00() {
		if (this.otherEquityPY01 != 0) {
			this.otherEquityChangeY00 = ((this.otherEquityY00 / this.otherEquityPY01) - 1) * 100;
		} else {
			this.otherEquityChangeY00 = 0.00;
		}
	}

	public double getOtherEquityChangeFY01() {
		return otherEquityChangeFY01;
	}

	public void setOtherEquityChangeFY01(double otherEquityChangeFY01) {
		this.otherEquityChangeFY01 = otherEquityChangeFY01;
	}

	public double getOtherEquityChangeFY02() {
		return otherEquityChangeFY02;
	}

	public void setOtherEquityChangeFY02(double otherEquityChangeFY02) {
		this.otherEquityChangeFY02 = otherEquityChangeFY02;
	}

	public double getOtherEquityChangeFY03() {
		return otherEquityChangeFY03;
	}

	public void setOtherEquityChangeFY03(double otherEquityChangeFY03) {
		this.otherEquityChangeFY03 = otherEquityChangeFY03;
	}

	public double getOtherEquityChangeFY04() {
		return otherEquityChangeFY04;
	}

	public void setOtherEquityChangeFY04(double otherEquityChangeFY04) {
		this.otherEquityChangeFY04 = otherEquityChangeFY04;
	}

	public double getOtherEquityChangeFY05() {
		return otherEquityChangeFY05;
	}

	public void setOtherEquityChangeFY05(double otherEquityChangeFY05) {
		this.otherEquityChangeFY05 = otherEquityChangeFY05;
	}
	
	
	
	// Berechnung der Summe fuer das Eigenkapital
	
	public double getTotalEquityPY03() {
		return totalEquityPY03;
	}

	public void setTotalEquityPY03() {
		this.totalEquityPY03 = this.shareCapitalPY03 + this.reservesPY03 + this.otherEquityPY03;
	}

	public double getTotalEquityPY02() {
		return totalEquityPY02;
	}

	public void setTotalEquityPY02() {
		this.totalEquityPY02 = this.shareCapitalPY02 + this.reservesPY02 + this.otherEquityPY02;
	}

	public double getTotalEquityPY01() {
		return totalEquityPY01;
	}

	public void setTotalEquityPY01() {
		this.totalEquityPY01 = this.shareCapitalPY01 + this.reservesPY01 + this.otherEquityPY01;
	}

	public double getTotalEquityY00() {
		return totalEquityY00;
	}

	public void setTotalEquityY00() {
		this.totalEquityY00 = this.shareCapitalY00 + this.reservesY00 + this.otherEquityY00;
	}
	
	public double getTotalEquityFY01() {
		return totalEquityFY01;
	}

	public void setTotalEquityFY01() {
		this.totalEquityFY01 = this.shareCapitalFY01 + this.reservesFY01 + this.otherEquityFY01;
	}

	public double getTotalEquityFY02() {
		return totalEquityFY02;
	}

	public void setTotalEquityFY02() {
		this.totalEquityFY02 =  this.shareCapitalFY02 + this.reservesFY02 + this.otherEquityFY02;
	}

	public double getTotalEquityFY03() {
		return totalEquityFY03;
	}

	public void setTotalEquityFY03() {
		this.totalEquityFY03 = this.shareCapitalFY03 + this.reservesFY03 + this.otherEquityFY03;
	}

	public double getTotalEquityFY04() {
		return totalEquityFY04;
	}

	public void setTotalEquityFY04() {
		this.totalEquityFY04 = this.shareCapitalFY04 + this.reservesFY04 + this.otherEquityFY04;
	}

	public double getTotalEquityFY05() {
		return totalEquityFY05;
	}

	public void setTotalEquityFY05() {
		this.totalEquityFY05 =  this.shareCapitalFY05 + this.reservesFY05 + this.otherEquityFY05;
	}


	// Getter und Setter fuer langfristiges Fremdkapital sowie Berechnungen zu
	// Zinsen und Veraenderungen des langfristigen Fremdkapitals
	public double getLongTermBankDebtPY03() {
		return longTermBankDebtPY03;
	}

	public void setLongTermBankDebtPY03(double longTermBankDebtPY03) {
		this.longTermBankDebtPY03 = longTermBankDebtPY03;
	}

	public double getLongTermBankDebtPY02() {
		return longTermBankDebtPY02;
	}

	public void setLongTermBankDebtPY02(double longTermBankDebtPY02) {
		this.longTermBankDebtPY02 = longTermBankDebtPY02;
	}

	public double getLongTermBankDebtPY01() {
		return longTermBankDebtPY01;
	}

	public void setLongTermBankDebtPY01(double longTermBankDebtPY01) {
		this.longTermBankDebtPY01 = longTermBankDebtPY01;
	}

	public double getLongTermBankDebtY00() {
		return longTermBankDebtY00;
	}

	public void setLongTermBankDebtY00(double longTermBankDebtY00) {
		this.longTermBankDebtY00 = longTermBankDebtY00;
	}
	
	public double getLongTermBankDebtFY01() {
		return longTermBankDebtFY01;
	}

	public void setLongTermBankDebtFY01() {
		this.longTermBankDebtFY01 = this.longTermBankDebtY00 * (1 + (this.longTermBankDebtChangeFY01 / 100));
	}

	public double getLongTermBankDebtFY02() {
		return longTermBankDebtFY02;
	}

	public void setLongTermBankDebtFY02() {
		this.longTermBankDebtFY02 = this.longTermBankDebtFY01 * (1 + (this.longTermBankDebtChangeFY02 / 100));
	}

	public double getLongTermBankDebtFY03() {
		return longTermBankDebtFY03;
	}

	public void setLongTermBankDebtFY03() {
		this.longTermBankDebtFY03 = this.longTermBankDebtFY02 * (1 + (this.longTermBankDebtChangeFY03 / 100));
	}

	public double getLongTermBankDebtFY04() {
		return longTermBankDebtFY04;
	}

	public void setLongTermBankDebtFY04() {
		this.longTermBankDebtFY04 =  this.longTermBankDebtFY03 * (1 + (this.longTermBankDebtChangeFY04 / 100));
	}

	public double getLongTermBankDebtFY05() {
		return longTermBankDebtFY05;
	}

	public void setLongTermBankDebtFY05() {
		this.longTermBankDebtFY05 = this.longTermBankDebtFY04 * (1 + (this.longTermBankDebtChangeFY05 / 100));
	}

	public double getLongTermBankDebtChangePY02() {
		return longTermBankDebtChangePY02;
	}

	public void setLongTermBankDebtChangePY02() {
		if (this.longTermBankDebtPY03 != 0) {
			this.longTermBankDebtChangePY02 = ((this.longTermBankDebtPY02 / this.longTermBankDebtPY03) - 1) * 100;
		} else {
			this.longTermBankDebtChangePY02 = 0.00;
		}

	}

	public double getLongTermBankDebtChangePY01() {
		return longTermBankDebtChangePY01;
	}

	public void setLongTermBankDebtChangePY01() {
		if (this.longTermBankDebtPY02 != 0) {
			this.longTermBankDebtChangePY01 = ((this.longTermBankDebtPY01 / this.longTermBankDebtPY02) - 1) * 100;
		} else {
			this.longTermBankDebtChangePY01 = 0.00;
		}
	}

	public double getLongTermBankDebtChangeY00() {
		return longTermBankDebtChangeY00;
	}

	public void setLongTermBankDebtChangeY00() {
		if (this.longTermBankDebtPY01 != 0) {
			this.longTermBankDebtChangeY00 = ((this.longTermBankDebtY00 / this.longTermBankDebtPY01) - 1) * 100;
		} else {
			this.longTermBankDebtChangeY00 = 0.00;
		}
	}

	public double getLongTermBankDebtChangeFY01() {
		return longTermBankDebtChangeFY01;
	}

	public void setLongTermBankDebtChangeFY01(double longTermBankDebtChangeFY01) {
		this.longTermBankDebtChangeFY01 = longTermBankDebtChangeFY01;
	}

	public double getLongTermBankDebtChangeFY02() {
		return longTermBankDebtChangeFY02;
	}

	public void setLongTermBankDebtChangeFY02(double longTermBankDebtChangeFY02) {
		this.longTermBankDebtChangeFY02 = longTermBankDebtChangeFY02;
	}

	public double getLongTermBankDebtChangeFY03() {
		return longTermBankDebtChangeFY03;
	}

	public void setLongTermBankDebtChangeFY03(double longTermBankDebtChangeFY03) {
		this.longTermBankDebtChangeFY03 = longTermBankDebtChangeFY03;
	}

	public double getLongTermBankDebtChangeFY04() {
		return longTermBankDebtChangeFY04;
	}

	public void setLongTermBankDebtChangeFY04(double longTermBankDebtChangeFY04) {
		this.longTermBankDebtChangeFY04 = longTermBankDebtChangeFY04;
	}

	public double getLongTermBankDebtChangeFY05() {
		return longTermBankDebtChangeFY05;
	}

	public void setLongTermBankDebtChangeFY05(double longTermBankDebtChangeFY05) {
		this.longTermBankDebtChangeFY05 = longTermBankDebtChangeFY05;
	}

	public double getInterestLossFromBankDebtPY03() {
		return interestLossFromBankDebtPY03;
	}

	public void setInterestLossFromBankDebtPY03() {
		if (this.interestLossPY03 != 0 & this.longTermBankDebtPY03 != 0) {
			this.interestLossFromBankDebtPY03 = (this.interestLossPY03
					/ (this.longTermBankDebtPY03 + this.shortTermBankDebtPY03)) * 100;
		} else {
			this.interestLossFromBankDebtPY03 = 0.00;
		}
	}

	public double getInterestLossFromBankDebtPY02() {
		return interestLossFromBankDebtPY02;
	}

	public void setInterestLossFromBankDebtPY02() {
		if (this.interestLossPY02 != 0 & this.longTermBankDebtPY02 != 0) {
			this.interestLossFromBankDebtPY02 = (this.interestLossPY02
					/ (this.longTermBankDebtPY02 + this.shortTermBankDebtPY02)) * 100;
		} else {
			this.interestLossFromBankDebtPY02 = 0.00;
		}
	}

	public double getInterestLossFromBankDebtPY01() {
		return interestLossFromBankDebtPY01;
	}

	public void setInterestLossFromBankDebtPY01() {
		if (this.interestLossPY01 != 0 & this.longTermBankDebtPY01 != 0) {
			this.interestLossFromBankDebtPY01 = (this.interestLossPY01
					/ (this.longTermBankDebtPY01 + this.shortTermBankDebtPY01)) * 100;
		} else {
			this.interestLossFromBankDebtPY01 = 0.00;
		}
	}

	public double getInterestLossFromBankDebtY00() {
		return interestLossFromBankDebtY00;
	}

	public void setInterestLossFromBankDebtY00() {
		if (this.interestLossY00 != 0 & this.longTermBankDebtY00 != 0) {
			this.interestLossFromBankDebtY00 = (this.interestLossY00
					/ (this.longTermBankDebtY00 + this.shortTermBankDebtY00)) * 100;
		} else {
			this.interestLossFromBankDebtY00 = 0.00;
		}
	}

	public double getInterestLossFromBankDebtFY01() {
		return interestLossFromBankDebtFY01;
	}

	public void setInterestLossFromBankDebtFY01(double interestLossFromBankDebtFY01) {
		this.interestLossFromBankDebtFY01 = interestLossFromBankDebtFY01;
	}

	public double getInterestLossFromBankDebtFY02() {
		return interestLossFromBankDebtFY02;
	}

	public void setInterestLossFromBankDebtFY02(double interestLossFromBankDebtFY02) {
		this.interestLossFromBankDebtFY02 = interestLossFromBankDebtFY02;
	}

	public double getInterestLossFromBankDebtFY03() {
		return interestLossFromBankDebtFY03;
	}

	public void setInterestLossFromBankDebtFY03(double interestLossFromBankDebtFY03) {
		this.interestLossFromBankDebtFY03 = interestLossFromBankDebtFY03;
	}

	public double getInterestLossFromBankDebtFY04() {
		return interestLossFromBankDebtFY04;
	}

	public void setInterestLossFromBankDebtFY04(double interestLossFromBankDebtFY04) {
		this.interestLossFromBankDebtFY04 = interestLossFromBankDebtFY04;
		
	}
	
	public double getInterestLossFromBankDebtFY05() {
		return interestLossFromBankDebtFY05;
	}

	public void setInterestLossFromBankDebtFY05(double interestLossFromBankDebtFY05) {
		this.interestLossFromBankDebtFY05 = interestLossFromBankDebtFY05;
		
	}
	

	// Getter und Setter fuer Rueckstellungen sowie Berechnung der Veraenderung

	public double getAccrualsPY03() {
		return accrualsPY03;
	}

	public void setAccrualsPY03(double accrualsPY03) {
		this.accrualsPY03 = accrualsPY03;
	}

	public double getAccrualsPY02() {
		return accrualsPY02;
	}

	public void setAccrualsPY02(double accrualsPY02) {
		this.accrualsPY02 = accrualsPY02;
	}

	public double getAccrualsPY01() {
		return accrualsPY01;
	}

	public void setAccrualsPY01(double accrualsPY01) {
		this.accrualsPY01 = accrualsPY01;
	}

	public double getAccrualsY00() {
		return accrualsY00;
	}

	public void setAccrualsY00(double accrualsY00) {
		this.accrualsY00 = accrualsY00;
	}

	public double getAccrualsFY01() {
		return accrualsFY01;
	}

	public void setAccrualsFY01() {
		this.accrualsFY01 = this.accrualsY00 * (1 + (this.accrualsChangeFY01 / 100));
	}

	public double getAccrualsFY02() {
		return accrualsFY02;
	}

	public void setAccrualsFY02() {
		this.accrualsFY02 = this.accrualsFY01 * (1 + (this.accrualsChangeFY02 / 100));
	}

	public double getAccrualsFY03() {
		return accrualsFY03;
	}

	public void setAccrualsFY03() {
		this.accrualsFY03 = this.accrualsFY02 * (1 + (this.accrualsChangeFY03 / 100));
	}

	public double getAccrualsFY04() {
		return accrualsFY04;
	}

	public void setAccrualsFY04() {
		this.accrualsFY04 = this.accrualsFY03 * (1 + (this.accrualsChangeFY04 / 100));
	}

	public double getAccrualsFY05() {
		return accrualsFY05;
	}

	public void setAccrualsFY05() {
		this.accrualsFY05 = this.accrualsFY04 * (1 + (this.accrualsChangeFY05 / 100));
	}

	public double getAccrualsChangePY02() {
		return accrualsChangePY02;
	}

	public void setAccrualsChangePY02() {
		if (this.accrualsPY03 != 0) {
			this.accrualsChangePY02 = ((this.accrualsPY02 / this.accrualsPY03) - 1) * 100;
		} else {
			this.accrualsChangePY02 = 0.00;
		}

	}

	public double getAccrualsChangePY01() {
		return accrualsChangePY01;
	}

	public void setAccrualsChangePY01() {
		if (this.accrualsPY02 != 0) {
			this.accrualsChangePY01 = ((this.accrualsPY01 / this.accrualsPY02) - 1) * 100;
		} else {
			this.accrualsChangePY01 = 0.00;
		}
	}

	public double getAccrualsChangeY00() {
		return accrualsChangeY00;
	}

	public void setAccrualsChangeY00() {
		if (this.accrualsPY01 != 0) {
			this.accrualsChangeY00 = ((this.accrualsY00 / this.accrualsPY01) - 1) * 100;
		} else {
			this.accrualsChangeY00 = 0.00;
		}
	}

	public double getAccrualsChangeFY01() {
		return accrualsChangeFY01;
	}

	public void setAccrualsChangeFY01(double accrualsChangeFY01) {
		this.accrualsChangeFY01 = accrualsChangeFY01;
	}

	public double getAccrualsChangeFY02() {
		return accrualsChangeFY02;
	}

	public void setAccrualsChangeFY02(double accrualsChangeFY02) {
		this.accrualsChangeFY02 = accrualsChangeFY02;
	}

	public double getAccrualsChangeFY03() {
		return accrualsChangeFY03;
	}

	public void setAccrualsChangeFY03(double accrualsChangeFY03) {
		this.accrualsChangeFY03 = accrualsChangeFY03;
	}

	public double getAccrualsChangeFY04() {
		return accrualsChangeFY04;
	}

	public void setAccrualsChangeFY04(double accrualsChangeFY04) {
		this.accrualsChangeFY04 = accrualsChangeFY04;
	}

	public double getAccrualsChangeFY05() {
		return accrualsChangeFY05;
	}

	public void setAccrualsChangeFY05(double accrualsChangeFY05) {
		this.accrualsChangeFY05 = accrualsChangeFY05;
	}

	
	// Summe der langfristigen Schulden berechnen
	
	public double getTotalLongTermLiabilitiesPY03() {
		return totalLongTermLiabilitiesPY03;
	}

	public void setTotalLongTermLiabilitiesPY03() {
		this.totalLongTermLiabilitiesPY03 = this.longTermBankDebtPY03 + this.accrualsPY03;
	}

	public double getTotalLongTermLiabilitiesPY02() {
		return totalLongTermLiabilitiesPY02;
	}

	public void setTotalLongTermLiabilitiesPY02() {
		this.totalLongTermLiabilitiesPY02 = this.longTermBankDebtPY02 + this.accrualsPY02;
	}

	public double getTotalLongTermLiabilitiesPY01() {
		return totalLongTermLiabilitiesPY01;
	}

	public void setTotalLongTermLiabilitiesPY01() {
		this.totalLongTermLiabilitiesPY01 = this.longTermBankDebtPY01 + this.accrualsPY01;
	}

	public double getTotalLongTermLiabilitiesY00() {
		return totalLongTermLiabilitiesY00;
	}

	public void setTotalLongTermLiabilitiesY00() {
		this.totalLongTermLiabilitiesY00 = this.longTermBankDebtY00 + this.accrualsY00;
	}

	public double getTotalLongTermLiabilitiesFY01() {
		return totalLongTermLiabilitiesFY01;
	}

	public void setTotalLongTermLiabilitiesFY01() {
		this.totalLongTermLiabilitiesFY01 = this.longTermBankDebtFY01 + this.accrualsFY01;
	}

	public double getTotalLongTermLiabilitiesFY02() {
		return totalLongTermLiabilitiesFY02;
	}

	public void setTotalLongTermLiabilitiesFY02() {
		this.totalLongTermLiabilitiesFY02 = this.longTermBankDebtFY02 + this.accrualsFY02;
	}

	public double getTotalLongTermLiabilitiesFY03() {
		return totalLongTermLiabilitiesFY03;
	}

	public void setTotalLongTermLiabilitiesFY03() {
		this.totalLongTermLiabilitiesFY03 = this.longTermBankDebtFY03 + this.accrualsFY03;
	}

	public double getTotalLongTermLiabilitiesFY04() {
		return totalLongTermLiabilitiesFY04;
	}

	public void setTotalLongTermLiabilitiesFY04() {
		this.totalLongTermLiabilitiesFY04 = this.longTermBankDebtFY04 + this.accrualsFY04;
	}

	public double getTotalLongTermLiabilitiesFY05() {
		return totalLongTermLiabilitiesFY05;
	}

	public void setTotalLongTermLiabilitiesFY05() {
		this.totalLongTermLiabilitiesFY05 = this.longTermBankDebtFY05 + this.accrualsFY05;
	}

	
	// Getter und Setter fuer kurzfristige Finanzverbindlichkeiten sowie Berechnung
	// der Veraenderung
	
	public double getShortTermBankDebtPY03() {
		return shortTermBankDebtPY03;
	}

	public void setShortTermBankDebtPY03(double shortTermBankDebtPY03) {
		this.shortTermBankDebtPY03 = shortTermBankDebtPY03;
	}

	public double getShortTermBankDebtPY02() {
		return shortTermBankDebtPY02;
	}

	public void setShortTermBankDebtPY02(double shortTermBankDebtPY02) {
		this.shortTermBankDebtPY02 = shortTermBankDebtPY02;
	}

	public double getShortTermBankDebtPY01() {
		return shortTermBankDebtPY01;
	}

	public void setShortTermBankDebtPY01(double shortTermBankDebtPY01) {
		this.shortTermBankDebtPY01 = shortTermBankDebtPY01;
	}

	public double getShortTermBankDebtY00() {
		return shortTermBankDebtY00;
	}

	public void setShortTermBankDebtY00(double shortTermBankDebtY00) {
		this.shortTermBankDebtY00 = shortTermBankDebtY00;
	}
	
	public double getShortTermBankDebtFY01() {
		return shortTermBankDebtFY01;
	}

	public void setShortTermBankDebtFY01() {
		this.shortTermBankDebtFY01 = this.shortTermBankDebtY00 * (1 + (this.shortTermBankDebtChangeFY01 /100));
	}

	public double getShortTermBankDebtFY02() {
		return shortTermBankDebtFY02;
	}

	public void setShortTermBankDebtFY02() {
		this.shortTermBankDebtFY02 = this.shortTermBankDebtFY01 * (1 + (this.shortTermBankDebtChangeFY02 /100));
	}

	public double getShortTermBankDebtFY03() {
		return shortTermBankDebtFY03;
	}

	public void setShortTermBankDebtFY03() {
		this.shortTermBankDebtFY03 = this.shortTermBankDebtFY02 * (1 + (this.shortTermBankDebtChangeFY03 /100));
	}

	public double getShortTermBankDebtFY04() {
		return shortTermBankDebtFY04;
	}

	public void setShortTermBankDebtFY04() {
		this.shortTermBankDebtFY04 = this.shortTermBankDebtFY03 * (1 + (this.shortTermBankDebtChangeFY04 /100));
	}

	public double getShortTermBankDebtFY05() {
		return shortTermBankDebtFY05;
	}

	public void setShortTermBankDebtFY05() {
		this.shortTermBankDebtFY05 =  this.shortTermBankDebtFY04 * (1 + (this.shortTermBankDebtChangeFY05 /100));
	}

	public double getShortTermBankDebtChangePY02() {
		return shortTermBankDebtChangePY02;
	}

	public void setShortTermBankDebtChangePY02() {
		if (this.shortTermBankDebtPY03 != 0) {
			this.shortTermBankDebtChangePY02 = ((this.shortTermBankDebtPY02 / this.shortTermBankDebtPY03) - 1) * 100;
		} else {
			this.shortTermBankDebtChangePY02 = 0.00;
		}

	}

	public double getShortTermBankDebtChangePY01() {
		return shortTermBankDebtChangePY01;
	}

	public void setShortTermBankDebtChangePY01() {
		if (this.shortTermBankDebtPY02 != 0) {
			this.shortTermBankDebtChangePY01 = ((this.shortTermBankDebtPY01 / this.shortTermBankDebtPY02) - 1) * 100;
		} else {
			this.shortTermBankDebtChangePY01 = 0.00;
		}
	}

	public double getShortTermBankDebtChangeY00() {
		return shortTermBankDebtChangeY00;
	}

	public void setShortTermBankDebtChangeY00() {
		if (this.shortTermBankDebtPY01 != 0) {
			this.shortTermBankDebtChangeY00 = ((this.shortTermBankDebtY00 / this.shortTermBankDebtPY01) - 1) * 100;
		} else {
			this.shortTermBankDebtChangeY00 = 0.00;
		}
	}

	public double getShortTermBankDebtChangeFY01() {
		return shortTermBankDebtChangeFY01;
	}

	public void setShortTermBankDebtChangeFY01(double shortTermBankDebtChangeFY01) {
		this.shortTermBankDebtChangeFY01 = shortTermBankDebtChangeFY01;
	}

	public double getShortTermBankDebtChangeFY02() {
		return shortTermBankDebtChangeFY02;
	}

	public void setShortTermBankDebtChangeFY02(double shortTermBankDebtChangeFY02) {
		this.shortTermBankDebtChangeFY02 = shortTermBankDebtChangeFY02;
	}

	public double getShortTermBankDebtChangeFY03() {
		return shortTermBankDebtChangeFY03;
	}

	public void setShortTermBankDebtChangeFY03(double shortTermBankDebtChangeFY03) {
		this.shortTermBankDebtChangeFY03 = shortTermBankDebtChangeFY03;
	}

	public double getShortTermBankDebtChangeFY04() {
		return shortTermBankDebtChangeFY04;
	}

	public void setShortTermBankDebtChangeFY04(double shortTermBankDebtChangeFY04) {
		this.shortTermBankDebtChangeFY04 = shortTermBankDebtChangeFY04;
	}

	public double getShortTermBankDebtChangeFY05() {
		return shortTermBankDebtChangeFY05;
	}

	public void setShortTermBankDebtChangeFY05(double shortTermBankDebtChangeFY05) {
		this.shortTermBankDebtChangeFY05 = shortTermBankDebtChangeFY05;
	}
	
	
	// Getter und Setter fuer Verbindlichkeiten aus L.u.L sowie Berechnung der
	// Umschlagshäufigkeit
	
	public double getTradePayablesPY03() {
		return tradePayablesPY03;
	}

	public void setTradePayablesPY03(double tradePayablesPY03) {
		this.tradePayablesPY03 = tradePayablesPY03;
	}

	public double getTradePayablesPY02() {
		return tradePayablesPY02;
	}

	public void setTradePayablesPY02(double tradePayablesPY02) {
		this.tradePayablesPY02 = tradePayablesPY02;
	}

	public double getTradePayablesPY01() {
		return tradePayablesPY01;
	}

	public void setTradePayablesPY01(double tradePayablesPY01) {
		this.tradePayablesPY01 = tradePayablesPY01;
	}

	public double getTradePayablesY00() {
		return tradePayablesY00;
	}

	public void setTradePayablesY00(double tradePayablesY00) {
		this.tradePayablesY00 = tradePayablesY00;
	}
	

	public double getTradePayablesFY01() {
		return tradePayablesFY01;
	}

	public void setTradePayablesFY01() {
		if (this.cogsFY01 != 0 & this.daysPayablesOutstandingFY01 != 0) {
			
			this.tradePayablesFY01 = this.cogsFY01 / this.daysPayablesOutstandingFY01;
			
		} else {
			
			this.tradePayablesFY01 = this.tradePayablesY00;
		}	
	}

	public double getTradePayablesFY02() {
		return tradePayablesFY02;
	}

	public void setTradePayablesFY02() {
		if (this.cogsFY02 != 0 & this.daysPayablesOutstandingFY02 != 0) {
			
			this.tradePayablesFY02 = this.cogsFY02 / this.daysPayablesOutstandingFY02;
			
		} else {
			
			this.tradePayablesFY02 = this.tradePayablesFY01;
		}	
	}

	public double getTradePayablesFY03() {
		return tradePayablesFY03;
	}

	public void setTradePayablesFY03() {
		if (this.cogsFY03 != 0 & this.daysPayablesOutstandingFY03 != 0) {
			
			this.tradePayablesFY03 = this.cogsFY03 / this.daysPayablesOutstandingFY03;
			
		} else {
			
			this.tradePayablesFY03 = this.tradePayablesFY02;
		}	
	}

	public double getTradePayablesFY04() {
		return tradePayablesFY04;
	}

	public void setTradePayablesFY04() {
	if (this.cogsFY04 != 0 & this.daysPayablesOutstandingFY04 != 0) {
			
			this.tradePayablesFY04 = this.cogsFY04 / this.daysPayablesOutstandingFY04;
			
		} else {
			
			this.tradePayablesFY04 = this.tradePayablesFY03;
		}
	}

	public double getTradePayablesFY05() {
		return tradePayablesFY05;
	}

	public void setTradePayablesFY05() {
	if (this.cogsFY05 != 0 & this.daysPayablesOutstandingFY05 != 0) {
			
			this.tradePayablesFY05 = this.cogsFY05 / this.daysPayablesOutstandingFY05;
			
		} else {
			
			this.tradePayablesFY05 = this.tradePayablesFY04;
		}
	}

	public double getDaysPayablesOutstandingPY03() {
		return daysPayablesOutstandingPY03;
	}

	public void setDaysPayablesOutstandingPY03() {
		if (this.tradePayablesPY03 == 0 | this.cogsPY03 == 0) {
			this.daysPayablesOutstandingPY03 = 0.00;
		} else {

			this.daysPayablesOutstandingPY03 = this.cogsPY03 / this.tradePayablesPY03;
		}
	}

	public double getDaysPayablesOutstandingPY02() {
		return daysPayablesOutstandingPY02;
	}

	public void setDaysPayablesOutstandingPY02() {
		if (this.tradePayablesPY02 == 0 | this.cogsPY02 == 0) {
			this.daysPayablesOutstandingPY02 = 0.00;
		} else {

			this.daysPayablesOutstandingPY02 = this.cogsPY02 / this.tradePayablesPY02;
		}
	}

	public double getDaysPayablesOutstandingPY01() {
		return daysPayablesOutstandingPY01;
	}

	public void setDaysPayablesOutstandingPY01() {
		if (this.tradePayablesPY01 == 0 | this.cogsPY01 == 0) {
			this.daysPayablesOutstandingPY01 = 0.00;
		} else {

			this.daysPayablesOutstandingPY01 = this.cogsPY01 / this.tradePayablesPY01;
		}
	}

	public double getDaysPayablesOutstandingY00() {
		return daysPayablesOutstandingY00;
	}

	public void setDaysPayablesOutstandingY00() {
		if (this.tradePayablesY00 == 0 | this.cogsY00 == 0) {
			this.daysPayablesOutstandingY00 = 0.00;
		} else {

			this.daysPayablesOutstandingY00 = this.cogsY00 / this.tradePayablesY00;
		}
	}

	public double getDaysPayablesOutstandingFY01() {
		return daysPayablesOutstandingFY01;
	}

	public void setDaysPayablesOutstandingFY01(double daysPayablesOutstandingFY01) {
		this.daysPayablesOutstandingFY01 = daysPayablesOutstandingFY01;
	}

	public double getDaysPayablesOutstandingFY02() {
		return daysPayablesOutstandingFY02;
	}

	public void setDaysPayablesOutstandingFY02(double daysPayablesOutstandingFY02) {
		this.daysPayablesOutstandingFY02 = daysPayablesOutstandingFY02;
	}

	public double getDaysPayablesOutstandingFY03() {
		return daysPayablesOutstandingFY03;
	}

	public void setDaysPayablesOutstandingFY03(double daysPayablesOutstandingFY03) {
		this.daysPayablesOutstandingFY03 = daysPayablesOutstandingFY03;
	}

	public double getDaysPayablesOutstandingFY04() {
		return daysPayablesOutstandingFY04;
	}

	public void setDaysPayablesOutstandingFY04(double daysPayablesOutstandingFY04) {
		this.daysPayablesOutstandingFY04 = daysPayablesOutstandingFY04;
	}

	public double getDaysPayablesOutstandingFY05() {
		return daysPayablesOutstandingFY05;
	}

	public void setDaysPayablesOutstandingFY05(double daysPayablesOutstandingFY05) {
		this.daysPayablesOutstandingFY05 = daysPayablesOutstandingFY05;
	}

	
	// Getter und Setter fuer sonstige kurzfr. Verbindlichkeiten sowie Berechnung
	// der Veraenderung
	
	public double getOtherShortTermLiabilitiesPY03() {
		return otherShortTermLiabilitiesPY03;
	}

	public void setOtherShortTermLiabilitiesPY03(double otherShortTermLiabilitiesPY03) {
		this.otherShortTermLiabilitiesPY03 = otherShortTermLiabilitiesPY03;
	}

	public double getOtherShortTermLiabilitiesPY02() {
		return otherShortTermLiabilitiesPY02;
	}

	public void setOtherShortTermLiabilitiesPY02(double otherShortTermLiabilitiesPY02) {
		this.otherShortTermLiabilitiesPY02 = otherShortTermLiabilitiesPY02;
	}

	public double getOtherShortTermLiabilitiesPY01() {
		return otherShortTermLiabilitiesPY01;
	}

	public void setOtherShortTermLiabilitiesPY01(double otherShortTermLiabilitiesPY01) {
		this.otherShortTermLiabilitiesPY01 = otherShortTermLiabilitiesPY01;
	}

	public double getOtherShortTermLiabilitiesY00() {
		return otherShortTermLiabilitiesY00;
	}

	public void setOtherShortTermLiabilitiesY00(double otherShortTermLiabilitiesY00) {
		this.otherShortTermLiabilitiesY00 = otherShortTermLiabilitiesY00;
	}
	
	public double getOtherShortTermLiabilitiesFY01() {
		return otherShortTermLiabilitiesFY01;
	}

	public void setOtherShortTermLiabilitiesFY01() {
		this.otherShortTermLiabilitiesFY01 = this.otherShortTermLiabilitiesY00 * (1 + (this.otherShortTermLiabilitiesChangeFY01 / 100));
	}

	public double getOtherShortTermLiabilitiesFY02() {
		return otherShortTermLiabilitiesFY02;
	}

	public void setOtherShortTermLiabilitiesFY02() {
		this.otherShortTermLiabilitiesFY02 = this.otherShortTermLiabilitiesFY01 * (1 + (this.otherShortTermLiabilitiesChangeFY02 / 100));
	}

	public double getOtherShortTermLiabilitiesFY03() {
		return otherShortTermLiabilitiesFY03;
	}

	public void setOtherShortTermLiabilitiesFY03() {
		this.otherShortTermLiabilitiesFY03 = this.otherShortTermLiabilitiesFY02 * (1 + (this.otherShortTermLiabilitiesChangeFY03 / 100));
	}

	public double getOtherShortTermLiabilitiesFY04() {
		return otherShortTermLiabilitiesFY04;
	}

	public void setOtherShortTermLiabilitiesFY04() {
		this.otherShortTermLiabilitiesFY04 = this.otherShortTermLiabilitiesFY03 * (1 + (this.otherShortTermLiabilitiesChangeFY04 / 100));
	}

	public double getOtherShortTermLiabilitiesFY05() {
		return otherShortTermLiabilitiesFY05;
	}

	public void setOtherShortTermLiabilitiesFY05() {
		this.otherShortTermLiabilitiesFY05 = this.otherShortTermLiabilitiesFY04 * (1 + (this.otherShortTermLiabilitiesChangeFY05 / 100));
	}

	public double getOtherShortTermLiabilitiesChangePY02() {
		return otherShortTermLiabilitiesChangePY02;
	}

	public void setOtherShortTermLiabilitiesChangePY02() {
		if (otherShortTermLiabilitiesPY03 != 0) {
			this.otherShortTermLiabilitiesChangePY02 = ((otherShortTermLiabilitiesPY02 / otherShortTermLiabilitiesPY03)
					- 1) * 100;
		} else {
			this.otherShortTermLiabilitiesChangePY02 = 0.00;
		}

	}

	public double getOtherShortTermLiabilitiesChangePY01() {
		return otherShortTermLiabilitiesChangePY01;
	}

	public void setOtherShortTermLiabilitiesChangePY01() {
		if (otherShortTermLiabilitiesPY02 != 0) {
			this.otherShortTermLiabilitiesChangePY01 = ((otherShortTermLiabilitiesPY01 / otherShortTermLiabilitiesPY02)
					- 1) * 100;
		} else {
			this.otherShortTermLiabilitiesChangePY01 = 0.00;
		}
	}

	public double getOtherShortTermLiabilitiesChangeY00() {
		return otherShortTermLiabilitiesChangeY00;
	}

	public void setOtherShortTermLiabilitiesChangeY00() {
		if (otherShortTermLiabilitiesPY01 != 0) {
			this.otherShortTermLiabilitiesChangeY00 = ((otherShortTermLiabilitiesY00 / otherShortTermLiabilitiesPY01)
					- 1) * 100;
		} else {
			this.otherShortTermLiabilitiesChangeY00 = 0.00;
		}
	}

	public double getOtherShortTermLiabilitiesChangeFY01() {
		return otherShortTermLiabilitiesChangeFY01;
	}

	public void setOtherShortTermLiabilitiesChangeFY01(double otherShortTermLiabilitiesChangeFY01) {
		this.otherShortTermLiabilitiesChangeFY01 = otherShortTermLiabilitiesChangeFY01;
	}

	public double getOtherShortTermLiabilitiesChangeFY02() {
		return otherShortTermLiabilitiesChangeFY02;
	}

	public void setOtherShortTermLiabilitiesChangeFY02(double otherShortTermLiabilitiesChangeFY02) {
		this.otherShortTermLiabilitiesChangeFY02 = otherShortTermLiabilitiesChangeFY02;
	}

	public double getOtherShortTermLiabilitiesChangeFY03() {
		return otherShortTermLiabilitiesChangeFY03;
	}

	public void setOtherShortTermLiabilitiesChangeFY03(double otherShortTermLiabilitiesChangeFY03) {
		this.otherShortTermLiabilitiesChangeFY03 = otherShortTermLiabilitiesChangeFY03;
	}

	public double getOtherShortTermLiabilitiesChangeFY04() {
		return otherShortTermLiabilitiesChangeFY04;
	}

	public void setOtherShortTermLiabilitiesChangeFY04(double otherShortTermLiabilitiesChangeFY04) {
		this.otherShortTermLiabilitiesChangeFY04 = otherShortTermLiabilitiesChangeFY04;
	}

	public double getOtherShortTermLiabilitiesChangeFY05() {
		return otherShortTermLiabilitiesChangeFY05;
	}

	public void setOtherShortTermLiabilitiesChangeFY05(double otherShortTermLiabilitiesChangeFY05) {
		this.otherShortTermLiabilitiesChangeFY05 = otherShortTermLiabilitiesChangeFY05;
	}
	
	// Summe der kurzfristigen Verbindlichkeiten berechnen

	public double getTotalShortTermLiabilitiesPY03() {
		return totalShortTermLiabilitiesPY03;
	}

	public void setTotalShortTermLiabilitiesPY03() {
		this.totalShortTermLiabilitiesPY03 = this.shortTermBankDebtPY03 + this.tradePayablesPY03 + this.otherShortTermLiabilitiesPY03;
	}

	public double getTotalShortTermLiabilitiesPY02() {
		return totalShortTermLiabilitiesPY02;
	}

	public void setTotalShortTermLiabilitiesPY02() {
		this.totalShortTermLiabilitiesPY02 = this.shortTermBankDebtPY02 + this.tradePayablesPY02 + this.otherShortTermLiabilitiesPY02;
	}

	public double getTotalShortTermLiabilitiesPY01() {
		return totalShortTermLiabilitiesPY01;
	}

	public void setTotalShortTermLiabilitiesPY01() {
		this.totalShortTermLiabilitiesPY01 = this.shortTermBankDebtPY01 + this.tradePayablesPY01 + this.otherShortTermLiabilitiesPY01;
	}

	public double getTotalShortTermLiabilitiesY00() {
		return totalShortTermLiabilitiesY00;
	}

	public void setTotalShortTermLiabilitiesY00() {
		this.totalShortTermLiabilitiesY00 = this.shortTermBankDebtY00 + this.tradePayablesY00 + this.otherShortTermLiabilitiesY00;
	}

	public double getTotalShortTermLiabilitiesFY01() {
		return totalShortTermLiabilitiesFY01;
	}

	public void setTotalShortTermLiabilitiesFY01() {
		this.totalShortTermLiabilitiesFY01 = this.shortTermBankDebtFY01 + this.tradePayablesFY01 + this.otherShortTermLiabilitiesFY01; 
	}

	public double getTotalShortTermLiabilitiesFY02() {
		return totalShortTermLiabilitiesFY02;
	}

	public void setTotalShortTermLiabilitiesFY02() {
		this.totalShortTermLiabilitiesFY02 = this.shortTermBankDebtFY02 + this.tradePayablesFY02 + this.otherShortTermLiabilitiesFY02; 
	}

	public double getTotalShortTermLiabilitiesFY03() {
		return totalShortTermLiabilitiesFY03;
	}

	public void setTotalShortTermLiabilitiesFY03() {
		this.totalShortTermLiabilitiesFY03 = this.shortTermBankDebtFY03 + this.tradePayablesFY03 + this.otherShortTermLiabilitiesFY03;
	}

	public double getTotalShortTermLiabilitiesFY04() {
		return totalShortTermLiabilitiesFY04;
	}

	public void setTotalShortTermLiabilitiesFY04() {
		this.totalShortTermLiabilitiesFY04 = this.shortTermBankDebtFY04 + this.tradePayablesFY04 + this.otherShortTermLiabilitiesFY04;
	}

	public double getTotalShortTermLiabilitiesFY05() {
		return totalShortTermLiabilitiesFY05;
	}

	public void setTotalShortTermLiabilitiesFY05() {
		this.totalShortTermLiabilitiesFY05 = this.shortTermBankDebtFY05 + this.tradePayablesFY05 + this.otherShortTermLiabilitiesFY05;
	}

	
	// Summe der Passiva berechnen
	
	public double getTotalLiabilitiesPY03() {
		return totalLiabilitiesPY03;
	}

	public void setTotalLiabilitiesPY03() {
		this.totalLiabilitiesPY03 = this.totalEquityPY03 + this.totalLongTermLiabilitiesPY03 + this.totalShortTermLiabilitiesPY03;
	}

	public double getTotalLiabilitiesPY02() {
		return totalLiabilitiesPY02;
	}

	public void setTotalLiabilitiesPY02() {
		this.totalLiabilitiesPY02 = this.totalEquityPY02 + this.totalLongTermLiabilitiesPY02 + this.totalShortTermLiabilitiesPY02;
	}

	public double getTotalLiabilitiesPY01() {
		return totalLiabilitiesPY01;
	}

	public void setTotalLiabilitiesPY01() {
		this.totalLiabilitiesPY01 = this.totalEquityPY01 + this.totalLongTermLiabilitiesPY01 + this.totalShortTermLiabilitiesPY01;
	}

	public double getTotalLiabilitiesY00() {
		return totalLiabilitiesY00;
	}

	public void setTotalLiabilitiesY00() {
		this.totalLiabilitiesY00 = this.totalEquityY00 + this.totalLongTermLiabilitiesY00 + this.totalShortTermLiabilitiesY00;
	}

	public double getTotalLiabilitiesFY01() {
		return totalLiabilitiesFY01;
	}

	public void setTotalLiabilitiesFY01() {
		this.totalLiabilitiesFY01 = this.totalEquityFY01 + this.totalLongTermLiabilitiesFY01 + this.totalShortTermLiabilitiesFY01;
	}

	public double getTotalLiabilitiesFY02() {
		return totalLiabilitiesFY02;
	}

	public void setTotalLiabilitiesFY02() {
		this.totalLiabilitiesFY02 = this.totalEquityFY02 + this.totalLongTermLiabilitiesFY02 + this.totalShortTermLiabilitiesFY02;
	}

	public double getTotalLiabilitiesFY03() {
		return totalLiabilitiesFY03;
	}

	public void setTotalLiabilitiesFY03() {
		this.totalLiabilitiesFY03 = this.totalEquityFY03 + this.totalLongTermLiabilitiesFY03 + this.totalShortTermLiabilitiesFY03;
	}

	public double getTotalLiabilitiesFY04() {
		return totalLiabilitiesFY04;
	}

	public void setTotalLiabilitiesFY04() {
		this.totalLiabilitiesFY04 = this.totalEquityFY04 + this.totalLongTermLiabilitiesFY04 + this.totalShortTermLiabilitiesFY04;
	}

	public double getTotalLiabilitiesFY05() {
		return totalLiabilitiesFY05;
	}

	public void setTotalLiabilitiesFY05() {
		this.totalLiabilitiesFY05 = this.totalEquityFY05 + this.totalLongTermLiabilitiesFY05 + this.totalShortTermLiabilitiesFY05;
	}

	
//Berechnungen im Rahmen der DCF Bewertung
	
	
	//Gewinn nach adjustierten Steuern berechnen
	
	public double getCfTotalIncomeFY01() {
		return cfTotalIncomeFY01;
	}

	public void setCfTotalIncomeFY01() {
		
		double ebitFY01 = 0.00;
		double ebtFY01 = 0.00;
		
		ebitFY01 = this.ebitdaFY01 - this.depreciationFY01 - this.depreciationIntangibleFY01;
		ebtFY01 = ebitFY01 - this.interestLossFY01;
		this.cfTotalIncomeFY01 = ebtFY01 * (1 -  (this.incomeTaxFromEbtFY01 / 100));
	}

	public double getCfTotalIncomeFY02() {
		return cfTotalIncomeFY02;
	}

	public void setCfTotalIncomeFY02() {
		double ebitFY02 = 0.00;
		double ebtFY02 = 0.00;
		
		ebitFY02 = this.ebitdaFY02 - this.depreciationFY02 - this.depreciationIntangibleFY02;
		ebtFY02 = ebitFY02 - this.interestLossFY02;
		this.cfTotalIncomeFY02 = ebtFY02 * (1 -  (this.incomeTaxFromEbtFY02 / 100));
	}

	public double getCfTotalIncomeFY03() {
		return cfTotalIncomeFY03;
	}

	public void setCfTotalIncomeFY03() {
		double ebitFY03 = 0.00;
		double ebtFY03 = 0.00;
		
		ebitFY03 = this.ebitdaFY03 - this.depreciationFY03 - this.depreciationIntangibleFY03;
		ebtFY03 = ebitFY03 - this.interestLossFY03;
		this.cfTotalIncomeFY03 = ebtFY03 * (1 -  (this.incomeTaxFromEbtFY03 / 100));
	}

	public double getCfTotalIncomeFY04() {
		return cfTotalIncomeFY04;
	}

	public void setCfTotalIncomeFY04() {
		double ebitFY04 = 0.00;
		double ebtFY04 = 0.00;
		
		ebitFY04 = this.ebitdaFY04 - this.depreciationFY04 - this.depreciationIntangibleFY04;
		ebtFY04 = ebitFY04 - this.interestLossFY04;
		this.cfTotalIncomeFY04 = ebtFY04 * (1 -  (this.incomeTaxFromEbtFY04 / 100));
	}

	public double getCfTotalIncomeFY05() {
		return cfTotalIncomeFY05;
	}

	public void setCfTotalIncomeFY05() {
		double ebitFY05 = 0.00;
		double ebtFY05 = 0.00;
		
		ebitFY05 = this.ebitdaFY05 - this.depreciationFY05 - this.depreciationIntangibleFY05;
		ebtFY05 = ebitFY05 - this.interestLossFY05;
		this.cfTotalIncomeFY05 = ebtFY05 * (1 -  (this.incomeTaxFromEbtFY05 / 100));
	}	
		

	public double getCfTotalIncomeTV() {
		return cfTotalIncomeTV;
	}

	public void setCfTotalIncomeTV() {
		
		double ebitFY05 = 0.00;
		double ebitTV = 0.00;
		double ebtTV = 0.00;
		
		ebitFY05 = this.ebitdaFY05 - this.depreciationFY05 - this.depreciationIntangibleFY05; // EBIT Jahr +5
		ebitTV = ebitFY05 * (1 + (this.growthRateEndValue / 100)); // EBIT Jahr +5 zzgl. Wachstumsfaktor Endwert	
		ebtTV = ebitTV - (((this.shortTermBankDebtFY05 + this.longTermBankDebtFY05) * ( 1 + (this.growthRateEndValue / 100))) * (this.interestLossFromBankDebtFY05 / 100)); //berechne ebtTV = ebitTV - Zinsaufwand
		
		
		if (ebtTV > 0) {
			this.cfTotalIncomeTV = ebtTV - (ebtTV * (this.incomeTaxFromEbtFY05 / 100)); //ebtTV - Steuern
			
		} else {
			
			this.cfTotalIncomeTV = ebtTV;
		}
		
	}
	
	//Terminal Value der Abschreibungen auf Sachanlagen berechnen
	

	public double getCfDepreciationTV() {
		return cfDepreciationTV;
	}

	public void setCfDepreciationTV() {
		this.cfDepreciationTV = this.depreciationFY05 * (1 + (this.growthRateEndValue / 100));
	}
	
	
	//Terminal Value der Abschreibungen auf immat. Vermoegen berechnen
	

	public double getCfDepreciationIntangibleTV() {
		return cfDepreciationIntangibleTV;
	}

	public void setCfDepreciationIntangibleTV() {
		this.cfDepreciationIntangibleTV = this.depreciationIntangibleFY05 * (1 + (this.growthRateEndValue / 100));
	}
	
	
	//Veränderung der Rueckstellungen berechnen
	
	public double getCfAccrualsFY01() {
		return cfAccrualsFY01;
	}

	public void setCfAccrualsFY01() {
		this.cfAccrualsFY01 = this.accrualsFY01 - this.accrualsY00;
	}

	public double getCfAccrualsFY02() {
		return cfAccrualsFY02;
	}

	public void setCfAccrualsFY02() {
		this.cfAccrualsFY02 = this.accrualsFY02 - this.accrualsFY01;
	}

	public double getCfAccrualsFY03() {
		return cfAccrualsFY03;
	}

	public void setCfAccrualsFY03() {
		this.cfAccrualsFY03 = this.accrualsFY03 - this.accrualsFY02;
	}

	public double getCfAccrualsFY04() {
		return cfAccrualsFY04;
	}

	public void setCfAccrualsFY04() {
		this.cfAccrualsFY04 = this.accrualsFY04 - this.accrualsFY03;
	}

	public double getCfAccrualsFY05() {
		return cfAccrualsFY05;
	}

	public void setCfAccrualsFY05() {
		this.cfAccrualsFY05 = this.accrualsFY05 - this.accrualsFY04;
	}
	
	public double getCfAccrualsTV() {
		return cfAccrualsTV;
	}

	public void setCfAccrualsTV() {
		this.cfAccrualsTV = (this.accrualsFY05 * (1 + (this.growthRateEndValue / 100))) - this.accrualsFY05;
	}	
	
	
	
	// Summe der Investitionen in das Anlagevermoegen berechnen
	


	public double getCfAssetsInvestFY01() {
		return cfAssetsInvestFY01;
	}

	public void setCfAssetsInvestFY01() {
		this.cfAssetsInvestFY01 = this.financialAssetsChangeFY01 + this.propertyAssetsChangeFY01 + this.intangibleAssetsChangeFY01 + this.otherAssetsChangeFY01;
	}

	public double getCfAssetsInvestFY02() {
		return cfAssetsInvestFY02;
	}

	public void setCfAssetsInvestFY02() {
		this.cfAssetsInvestFY02 = this.financialAssetsChangeFY02 + this.propertyAssetsChangeFY02 + this.intangibleAssetsChangeFY02 + this.otherAssetsChangeFY02;
	}

	public double getCfAssetsInvestFY03() {
		return cfAssetsInvestFY03;
	}

	public void setCfAssetsInvestFY03() {
		this.cfAssetsInvestFY03 = this.financialAssetsChangeFY03 + this.propertyAssetsChangeFY03 + this.intangibleAssetsChangeFY03 + this.otherAssetsChangeFY03;
	}

	public double getCfAssetsInvestFY04() {
		return cfAssetsInvestFY04;
	}

	public void setCfAssetsInvestFY04() {
		this.cfAssetsInvestFY04 = this.financialAssetsChangeFY04 + this.propertyAssetsChangeFY04 + this.intangibleAssetsChangeFY04 + this.otherAssetsChangeFY04;
	}

	public double getCfAssetsInvestFY05() {
		return cfAssetsInvestFY05;
	}

	public void setCfAssetsInvestFY05() {
		this.cfAssetsInvestFY05 = this.financialAssetsChangeFY05 + this.propertyAssetsChangeFY05 + this.intangibleAssetsChangeFY05 + this.otherAssetsChangeFY05;
	}

	public double getCfAssetsInvestTV() {
		return cfAssetsInvestTV;
	}
	
	public void setCfAssetsInvestTV() {
		this.cfAssetsInvestTV = (this.financialAssetsChangeFY05 + this.propertyAssetsChangeFY05 + this.intangibleAssetsChangeFY05 + this.otherAssetsChangeFY05) * (1 + (this.growthRateEndValue / 100));
	}

	
	//Summe der Investitionen in das Working Capital berechnen
	
	public double getCfWorkingCapitalInvestFY01() {
		return cfWorkingCapitalInvestFY01;
	}

	public void setCfWorkingCapitalInvestFY01() {
		this.cfWorkingCapitalInvestFY01 = (this.inventoryFY01 - this.inventoryY00 + this.receivablesFY01 - this.receivablesY00 + this.otherNCAFY01 - this.otherNCAY00) - (this.tradePayablesFY01 - this.tradePayablesY00);
	}

	public double getCfWorkingCapitalInvestFY02() {
		return cfWorkingCapitalInvestFY02;
	}

	public void setCfWorkingCapitalInvestFY02() {
		this.cfWorkingCapitalInvestFY02 = (this.inventoryFY02 - this.inventoryFY01 + this.receivablesFY02 - this.receivablesFY01 + this.otherNCAFY02 - this.otherNCAFY01) - (this.tradePayablesFY02 - this.tradePayablesFY01);
	}

	public double getCfWorkingCapitalInvestFY03() {
		return cfWorkingCapitalInvestFY03;
	}

	public void setCfWorkingCapitalInvestFY03() {
		this.cfWorkingCapitalInvestFY03 = (this.inventoryFY03 - this.inventoryFY02 + this.receivablesFY03 - this.receivablesFY02 + this.otherNCAFY03 - this.otherNCAFY02) - (this.tradePayablesFY03 - this.tradePayablesFY02);
	}

	public double getCfWorkingCapitalInvestFY04() {
		return cfWorkingCapitalInvestFY04;
	}

	public void setCfWorkingCapitalInvestFY04() {
		this.cfWorkingCapitalInvestFY04 = (this.inventoryFY04 - this.inventoryFY03 + this.receivablesFY04 - this.receivablesFY03 + this.otherNCAFY04 - this.otherNCAFY03) - (this.tradePayablesFY04 - this.tradePayablesFY03);
	}

	public double getCfWorkingCapitalInvestFY05() {
		return cfWorkingCapitalInvestFY05;
	}

	public void setCfWorkingCapitalInvestFY05() {
		this.cfWorkingCapitalInvestFY05 = (this.inventoryFY05 - this.inventoryFY04 + this.receivablesFY05 - this.receivablesFY04 + this.otherNCAFY05 - this.otherNCAFY04) - (this.tradePayablesFY05 - this.tradePayablesFY04);
	}

	public double getCfWorkingCapitalInvestTV() {
		return cfWorkingCapitalInvestTV;
	}

	public void setCfWorkingCapitalInvestTV() {
		this.cfWorkingCapitalInvestTV = (this.cfWorkingCapitalInvestFY05 * (1 + (this.growthRateEndValue/100))) - this.cfWorkingCapitalInvestFY05;
	}

	
	
	// Veraenderung der zinstragenden Verbindlichkeiten berechnen
	
	public double getCfDebtChangeFY01() {
		return cfDebtChangeFY01;
	}

	public void setCfDebtChangeFY01() {
		this.cfDebtChangeFY01 = (this.shortTermBankDebtFY01 - this.shortTermBankDebtY00) + (this.longTermBankDebtFY01 - this.longTermBankDebtY00);
	}

	public double getCfDebtChangeFY02() {
		return cfDebtChangeFY02;
	}

	public void setCfDebtChangeFY02() {
		this.cfDebtChangeFY02 = (this.shortTermBankDebtFY02 - this.shortTermBankDebtFY01) + (this.longTermBankDebtFY02 - this.longTermBankDebtFY01);
	}

	public double getCfDebtChangeFY03() {
		return cfDebtChangeFY03;
	}

	public void setCfDebtChangeFY03() {
		this.cfDebtChangeFY03 = (this.shortTermBankDebtFY03 - this.shortTermBankDebtFY02) + (this.longTermBankDebtFY03 - this.longTermBankDebtFY02);
	}

	public double getCfDebtChangeFY04() {
		return cfDebtChangeFY04;
	}

	public void setCfDebtChangeFY04() {
		this.cfDebtChangeFY04 = (this.shortTermBankDebtFY04 - this.shortTermBankDebtFY03) + (this.longTermBankDebtFY04 - this.longTermBankDebtFY03);
	}

	public double getCfDebtChangeFY05() {
		return cfDebtChangeFY05;
	}

	public void setCfDebtChangeFY05() {
		this.cfDebtChangeFY05 = (this.shortTermBankDebtFY05 - this.shortTermBankDebtFY04) + (this.longTermBankDebtFY05 - this.longTermBankDebtFY04);
	}

	public double getCfDebtChangeTV() {
		return cfDebtChangeTV;
	}

	public void setCfDebtChangeTV() {
		this.cfDebtChangeTV = (this.cfDebtChangeFY05 * (1 + (this.growthRateEndValue / 100))) - this.cfDebtChangeFY05;
	}

	
	
	//Berechnung der Cash Flow to Equity
	

	public double getCashflowToEquityFY01() {
		return cashflowToEquityFY01;
	}

	public void setCashflowToEquityFY01() {
		this.cashflowToEquityFY01 = this.cfTotalIncomeFY01 + this.depreciationFY01 + this.depreciationIntangibleFY01 + this.cfAccrualsFY01 - this.cfAssetsInvestFY01 - this.cfWorkingCapitalInvestFY01 + this.cfDebtChangeFY01;
	}

	public double getCashflowToEquityFY02() {
		return cashflowToEquityFY02;
	}

	public void setCashflowToEquityFY02() {
		this.cashflowToEquityFY02 = this.cfTotalIncomeFY02 + this.depreciationFY02 + this.depreciationIntangibleFY02 + this.cfAccrualsFY02 - this.cfAssetsInvestFY02 - this.cfWorkingCapitalInvestFY02 + this.cfDebtChangeFY02;
	}

	public double getCashflowToEquityFY03() {
		return cashflowToEquityFY03;
	}

	public void setCashflowToEquityFY03() {
		this.cashflowToEquityFY03 = this.cfTotalIncomeFY03 + this.depreciationFY03 + this.depreciationIntangibleFY03 + this.cfAccrualsFY03 - this.cfAssetsInvestFY03 - this.cfWorkingCapitalInvestFY03 + this.cfDebtChangeFY03;
	}

	public double getCashflowToEquityFY04() {
		return cashflowToEquityFY04;
	}

	public void setCashflowToEquityFY04() {
		this.cashflowToEquityFY04 = this.cfTotalIncomeFY04 + this.depreciationFY04 + this.depreciationIntangibleFY04 + this.cfAccrualsFY04 - this.cfAssetsInvestFY04 - this.cfWorkingCapitalInvestFY04 + this.cfDebtChangeFY04;
	}

	public double getCashflowToEquityFY05() {
		return cashflowToEquityFY05;
	}

	public void setCashflowToEquityFY05() {
		this.cashflowToEquityFY05 = this.cfTotalIncomeFY05 + this.depreciationFY05 + this.depreciationIntangibleFY05 + this.cfAccrualsFY05 - this.cfAssetsInvestFY05 - this.cfWorkingCapitalInvestFY05 + this.cfDebtChangeFY05;
	}

	public double getCashflowToEquityTV() {
		return cashflowToEquityTV;
	}

	public void setCashflowToEquityTV() {
		this.cashflowToEquityTV = (this.cfTotalIncomeTV + this.cfDepreciationTV + this.cfDepreciationIntangibleTV + this.cfAccrualsTV - this.cfAssetsInvestTV - this.cfWorkingCapitalInvestTV + this.cfDebtChangeTV)
			/ ((this.riskFreeInterestRate + this.marketRiskPremium - this.growthRateEndValue) / 100);
	}

	
	// Discounted Cash Flows to Equity berechnen
	
	public double getDiscountedCashflowFY01() {
		return discountedCashflowFY01;
	}

	public void setDiscountedCashflowFY01() {
		double discountRateFY01, interestRateFY01;
		
		interestRateFY01 = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateFY01 = 1 / Math.pow(interestRateFY01, 1);
		
		this.discountedCashflowFY01 = this.cashflowToEquityFY01 * discountRateFY01;
	}

	public double getDiscountedCashflowFY02() {
		return discountedCashflowFY02;
	}

	public void setDiscountedCashflowFY02() {
		double discountRateFY02, interestRateFY02;
		
		interestRateFY02 = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateFY02 = 1 / Math.pow(interestRateFY02, 2);
		
		this.discountedCashflowFY02 = this.cashflowToEquityFY02 * discountRateFY02;
	}

	public double getDiscountedCashflowFY03() {
		return discountedCashflowFY03;
	}

	public void setDiscountedCashflowFY03() {
		double discountRateFY03, interestRateFY03;
		
		interestRateFY03 = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateFY03 = 1 / Math.pow(interestRateFY03, 3);
		
		this.discountedCashflowFY03 = this.cashflowToEquityFY03 * discountRateFY03;
	}

	public double getDiscountedCashflowFY04() {
		return discountedCashflowFY04;
	}

	public void setDiscountedCashflowFY04() {
		double discountRateFY04, interestRateFY04;
		
		interestRateFY04 = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateFY04 = 1 / Math.pow(interestRateFY04, 4);
		
		this.discountedCashflowFY04 = this.cashflowToEquityFY04 * discountRateFY04;
	}

	public double getDiscountedCashflowFY05() {
		return discountedCashflowFY05;
	}

	public void setDiscountedCashflowFY05() {
		double discountRateFY05, interestRateFY05;
		
		interestRateFY05 = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateFY05 = 1 / Math.pow(interestRateFY05, 5);
		
		this.discountedCashflowFY05 = this.cashflowToEquityFY05 * discountRateFY05;
	}

	public double getDiscountedCashflowTV() {
		return discountedCashflowTV;
	}

	public void setDiscountedCashflowTV() {
		double discountRateTV, interestRateTV;
		
		interestRateTV = 1 + ((this.riskFreeInterestRate + this.marketRiskPremium) / 100);
		discountRateTV = 1 / Math.pow(interestRateTV, 5);
		
		this.discountedCashflowTV = this.cashflowToEquityTV * discountRateTV;
	}
	
	// Fair Values berechnen

	public double getFairValue() {
		return fairValue;
	}

	public void setFairValue() {
		this.fairValue = this.discountedCashflowFY01 + this.discountedCashflowFY02 + this.discountedCashflowFY03 + this.discountedCashflowFY04 + this.discountedCashflowFY05 + this.discountedCashflowTV;
	}

	public double getFairValuePerShare() {
		return fairValuePerShare;
	}

	public void setFairValuePerShare() {
		this.fairValuePerShare = this.fairValue / this.shareVolume;
	}

	
	//Verschuldungsgrad fuer Grafiken berechnen
	
	public double getLeveragePY03() {
		return leveragePY03;
	}

	public void setLeveragePY03() {
		if (this.totalEquityPY03 == 0) {
			this.leveragePY03 = 0.00;
		} else {
			this.leveragePY03 = ((this.totalLongTermLiabilitiesPY03 + this.totalShortTermLiabilitiesPY03) / this.totalEquityPY03) * 100; //Fremdkapital / Eigenkapital * 100
		}
		
	}

	public double getLeveragePY02() {
		return leveragePY02;
	}

	public void setLeveragePY02() {
		if (this.totalEquityPY02 == 0) {
			this.leveragePY02 = 0.00;
		} else {
			this.leveragePY02 = ((this.totalLongTermLiabilitiesPY02 + this.totalShortTermLiabilitiesPY02) / this.totalEquityPY02) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeveragePY01() {
		return leveragePY01;
	}

	public void setLeveragePY01() {
		if (this.totalEquityPY01 == 0) {
			this.leveragePY01 = 0.00;
		} else {
			this.leveragePY01 = ((this.totalLongTermLiabilitiesPY01 + this.totalShortTermLiabilitiesPY01) / this.totalEquityPY01) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageY00() {
		return leverageY00;
	}

	public void setLeverageY00() {
		if (this.totalEquityY00 == 0) {
			this.leverageY00 = 0.00;
		} else {
			this.leverageY00 = ((this.totalLongTermLiabilitiesY00 + this.totalShortTermLiabilitiesY00) / this.totalEquityY00) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageFY01() {
		return leverageFY01;
	}

	public void setLeverageFY01() {
		if (this.totalEquityFY01 == 0) {
			this.leverageFY01 = 0.00;
		} else {
			this.leverageFY01 = ((this.totalLongTermLiabilitiesFY01 + this.totalShortTermLiabilitiesFY01) / this.totalEquityFY01) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageFY02() {
		return leverageFY02;
	}

	public void setLeverageFY02() {
		if (this.totalEquityFY02 == 0) {
			this.leverageFY02 = 0.00;
		} else {
			this.leverageFY02 = ((this.totalLongTermLiabilitiesFY02 + this.totalShortTermLiabilitiesFY02) / this.totalEquityFY02) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageFY03() {
		return leverageFY03;
	}

	public void setLeverageFY03() {
		if (this.totalEquityFY03 == 0) {
			this.leverageFY03 = 0.00;
		} else {
			this.leverageFY03 = ((this.totalLongTermLiabilitiesFY03 + this.totalShortTermLiabilitiesFY03) / this.totalEquityFY03) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageFY04() {
		return leverageFY04;
	}

	public void setLeverageFY04() {
		if (this.totalEquityFY04 == 0) {
			this.leverageFY04 = 0.00;
		} else {
			this.leverageFY04 = ((this.totalLongTermLiabilitiesFY04 + this.totalShortTermLiabilitiesFY04) / this.totalEquityFY04) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	public double getLeverageFY05() {
		return leverageFY05;
	}

	public void setLeverageFY05() {
		if (this.totalEquityFY05 == 0) {
			this.leverageFY05 = 0.00;
		} else {
			this.leverageFY05 = ((this.totalLongTermLiabilitiesFY05 + this.totalShortTermLiabilitiesFY05) / this.totalEquityFY05) * 100; //Fremdkapital / Eigenkapital * 100
		}
	}

	
	//Anlagenintensitaet fuer Grafik berechnen
	
	public double getAssetIntensityPY03() {
		return assetIntensityPY03;
	}

	public void setAssetIntensityPY03() {
		if (this.totalAssetsPY03 == 0) {
			this.assetIntensityPY03 = 0.00;		
		} else {
			this.assetIntensityPY03 = (this.assetsPY03 / this.totalAssetsPY03) * 100;
		}	
	}

	public double getAssetIntensityPY02() {
		return assetIntensityPY02;
	}

	public void setAssetIntensityPY02() {
		if (this.totalAssetsPY02 == 0) {
			this.assetIntensityPY02 = 0.00;		
		} else {
			this.assetIntensityPY02 = (this.assetsPY02 / this.totalAssetsPY02) * 100;
		}	
	}

	public double getAssetIntensityPY01() {
		return assetIntensityPY01;
	}

	public void setAssetIntensityPY01() {
		if (this.totalAssetsPY01 == 0) {
			this.assetIntensityPY01 = 0.00;		
		} else {
			this.assetIntensityPY01 = (this.assetsPY01 / this.totalAssetsPY01) * 100;
		}	
	}

	public double getAssetIntensityY00() {
		return assetIntensityY00;
	}

	public void setAssetIntensityY00() {
		if (this.totalAssetsY00 == 0) {
			this.assetIntensityY00 = 0.00;		
		} else {
			this.assetIntensityY00 = (this.assetsY00 / this.totalAssetsY00) * 100;
		}	
	}

	public double getAssetIntensityFY01() {
		return assetIntensityFY01;
	}

	public void setAssetIntensityFY01() {
		if (this.totalAssetsFY01 == 0) {
			this.assetIntensityFY01 = 0.00;		
		} else {
			this.assetIntensityFY01 = (this.assetsFY01 / this.totalAssetsFY01) * 100;
		}	
	}

	public double getAssetIntensityFY02() {
		return assetIntensityFY02;
	}

	public void setAssetIntensityFY02() {
		if (this.totalAssetsFY02 == 0) {
			this.assetIntensityFY02 = 0.00;		
		} else {
			this.assetIntensityFY02 = (this.assetsFY02 / this.totalAssetsFY02) * 100;
		}
	}

	public double getAssetIntensityFY03() {
		return assetIntensityFY03;
	}

	public void setAssetIntensityFY03() {
		if (this.totalAssetsFY03 == 0) {
			this.assetIntensityFY03 = 0.00;		
		} else {
			this.assetIntensityFY03 = (this.assetsFY03 / this.totalAssetsFY03) * 100;
		}
	}

	public double getAssetIntensityFY04() {
		return assetIntensityFY04;
	}

	public void setAssetIntensityFY04() {
		if (this.totalAssetsFY04 == 0) {
			this.assetIntensityFY04 = 0.00;		
		} else {
			this.assetIntensityFY04 = (this.assetsFY04 / this.totalAssetsFY04) * 100;
		}
	}

	public double getAssetIntensityFY05() {
		return assetIntensityFY05;
	}

	public void setAssetIntensityFY05() {
		if (this.totalAssetsFY05 == 0) {
			this.assetIntensityFY05 = 0.00;		
		} else {
			this.assetIntensityFY05 = (this.assetsFY05 / this.totalAssetsFY05) * 100;
		}
	}
	
	// Umlaufintensitaet fuer Grafik berechnen

	public double getCirculatingIntensityPY03() {
		return circulatingIntensityPY03;
	}

	public void setCirculatingIntensityPY03() {
		if (this.totalAssetsPY03 == 0) {
			this.circulatingIntensityPY03 = 0.00;
		} else {
			this.circulatingIntensityPY03 = (this.ncaPY03 / this.totalAssetsPY03) * 100; 
		}	
	}

	public double getCirculatingIntensityPY02() {
		return circulatingIntensityPY02;
	}

	public void setCirculatingIntensityPY02() {
		if (this.totalAssetsPY02 == 0) {
			this.circulatingIntensityPY02 = 0.00;
		} else {
			this.circulatingIntensityPY02 = (this.ncaPY02 / this.totalAssetsPY02) * 100; 
		}	
	}

	public double getCirculatingIntensityPY01() {
		return circulatingIntensityPY01;
	}

	public void setCirculatingIntensityPY01() {
		if (this.totalAssetsPY01 == 0) {
			this.circulatingIntensityPY01 = 0.00;
		} else {
			this.circulatingIntensityPY01 = (this.ncaPY01 / this.totalAssetsPY01) * 100; 
		}	
	}

	public double getCirculatingIntensityY00() {
		return circulatingIntensityY00;
	}

	public void setCirculatingIntensityY00() {
		if (this.totalAssetsY00 == 0) {
			this.circulatingIntensityY00 = 0.00;
		} else {
			this.circulatingIntensityY00 = (this.ncaY00 / this.totalAssetsY00) * 100; 
		}	
	}

	public double getCirculatingIntensityFY01() {
		return circulatingIntensityFY01;
	}

	public void setCirculatingIntensityFY01() {
		if (this.totalAssetsFY01 == 0) {
			this.circulatingIntensityFY01 = 0.00;
		} else {
			this.circulatingIntensityFY01 = (this.ncaFY01 / this.totalAssetsFY01) * 100; 
		}
	}

	public double getCirculatingIntensityFY02() {
		return circulatingIntensityFY02;
	}

	public void setCirculatingIntensityFY02() {
		if (this.totalAssetsFY02 == 0) {
			this.circulatingIntensityFY02 = 0.00;
		} else {
			this.circulatingIntensityFY02 = (this.ncaFY02 / this.totalAssetsFY02) * 100; 
		}
	}

	public double getCirculatingIntensityFY03() {
		return circulatingIntensityFY03;
	}

	public void setCirculatingIntensityFY03() {
		if (this.totalAssetsFY03 == 0) {
			this.circulatingIntensityFY03 = 0.00;
		} else {
			this.circulatingIntensityFY03 = (this.ncaFY03 / this.totalAssetsFY03) * 100; 
		}
	}

	public double getCirculatingIntensityFY04() {
		return circulatingIntensityFY04;
	}

	public void setCirculatingIntensityFY04() {
		if (this.totalAssetsFY04 == 0) {
			this.circulatingIntensityFY04 = 0.00;
		} else {
			this.circulatingIntensityFY04 = (this.ncaFY04 / this.totalAssetsFY04) * 100; 
		}
	}

	public double getCirculatingIntensityFY05() {
		return circulatingIntensityFY05;
	}

	public void setCirculatingIntensityFY05() {
		if (this.totalAssetsFY05 == 0) {
			this.circulatingIntensityFY05 = 0.00;
		} else {
			this.circulatingIntensityFY05 = (this.ncaFY05 / this.totalAssetsFY05) * 100; 
		}
	}

	// Umstzrendite fuer Grafik berechnen
	
	public double getReturnOnSalesPY03() {
		return returnOnSalesPY03;
	}

	public void setReturnOnSalesPY03() {
		if (this.revenuePY03 == 0) {
			this.returnOnSalesPY03 = 0.00;
		} else {
			this.returnOnSalesPY03 = (this.totalIncomePY03 / this.revenuePY03) * 100; 
		}
	}

	public double getReturnOnSalesPY02() {
		return returnOnSalesPY02;
	}

	public void setReturnOnSalesPY02() {
		if (this.revenuePY02 == 0) {
			this.returnOnSalesPY02 = 0.00;
		} else {
			this.returnOnSalesPY02 = (this.totalIncomePY02 / this.revenuePY02) * 100; 
		}
	}

	public double getReturnOnSalesPY01() {
		return returnOnSalesPY01;
	}

	public void setReturnOnSalesPY01() {
		if (this.revenuePY01 == 0) {
			this.returnOnSalesPY01 = 0.00;
		} else {
			this.returnOnSalesPY01 = (this.totalIncomePY01 / this.revenuePY01) * 100; 
		}
	}

	public double getReturnOnSalesY00() {
		return returnOnSalesY00;
	}

	public void setReturnOnSalesY00() {
		if (this.revenueY00 == 0) {
			this.returnOnSalesY00 = 0.00;
		} else {
			this.returnOnSalesY00 = (this.totalIncomeY00 / this.revenueY00) * 100; 
		}
	}

	public double getReturnOnSalesFY01() {
		return returnOnSalesFY01;
	}

	public void setReturnOnSalesFY01() {
		if (this.revenueFY01 == 0) {
			this.returnOnSalesFY01 = 0.00;
		} else {
			this.returnOnSalesFY01 = (this.totalIncomeFY01 / this.revenueFY01) * 100; 
		}
	}

	public double getReturnOnSalesFY02() {
		return returnOnSalesFY02;
	}

	public void setReturnOnSalesFY02() {
		if (this.revenueFY02 == 0) {
			this.returnOnSalesFY02 = 0.00;
		} else {
			this.returnOnSalesFY02 = (this.totalIncomeFY02 / this.revenueFY02) * 100; 
		}
	}

	public double getReturnOnSalesFY03() {
		return returnOnSalesFY03;
	}

	public void setReturnOnSalesFY03() {
		if (this.revenueFY03 == 0) {
			this.returnOnSalesFY03 = 0.00;
		} else {
			this.returnOnSalesFY03 = (this.totalIncomeFY03 / this.revenueFY03) * 100; 
		}
	}

	public double getReturnOnSalesFY04() {
		return returnOnSalesFY04;
	}

	public void setReturnOnSalesFY04() {
		if (this.revenueFY04 == 0) {
			this.returnOnSalesFY04 = 0.00;
		} else {
			this.returnOnSalesFY04 = (this.totalIncomeFY04 / this.revenueFY04) * 100; 
		}
	}

	public double getReturnOnSalesFY05() {
		return returnOnSalesFY05;
	}

	public void setReturnOnSalesFY05() {
		if (this.revenueFY05 == 0) {
			this.returnOnSalesFY05 = 0.00;
		} else {
			this.returnOnSalesFY05 = (this.totalIncomeFY05 / this.revenueFY05) * 100; 
		}
	}
	
	
	//EBIDTA Marge fuer Grafik berechnen

	public double getReturnOnEBITDAPY03() {
		return returnOnEBITDAPY03;
	}

	public void setReturnOnEBITDAPY03() {
		if (this.revenuePY03 == 0) {
			this.returnOnEBITDAPY03 = 0.00;
		} else {
			this.returnOnEBITDAPY03 = (this.ebitdaPY03 / this.revenuePY03) * 100;
		}	
	}

	public double getReturnOnEBITDAPY02() {
		return returnOnEBITDAPY02;
	}

	public void setReturnOnEBITDAPY02() {
		if (this.revenuePY02 == 0) {
			this.returnOnEBITDAPY02 = 0.00;
		} else {
			this.returnOnEBITDAPY02 = (this.ebitdaPY02 / this.revenuePY02) * 100;
		}
	}

	public double getReturnOnEBITDAPY01() {
		return returnOnEBITDAPY01;
	}

	public void setReturnOnEBITDAPY01() {
		if (this.revenuePY01 == 0) {
			this.returnOnEBITDAPY01 = 0.00;
		} else {
			this.returnOnEBITDAPY01 = (this.ebitdaPY01 / this.revenuePY01) * 100;
		}
	}

	public double getReturnOnEBITDAY00() {
		return returnOnEBITDAY00;
	}

	public void setReturnOnEBITDAY00() {
		if (this.revenueY00 == 0) {
			this.returnOnEBITDAY00 = 0.00;
		} else {
			this.returnOnEBITDAY00 = (this.ebitdaY00 / this.revenueY00) * 100;
		}
	}

	public double getReturnOnEBITDAFY01() {
		return returnOnEBITDAFY01;
	}

	public void setReturnOnEBITDAFY01() {
		if (this.revenueFY01 == 0) {
			this.returnOnEBITDAFY01 = 0.00;
		} else {
			this.returnOnEBITDAFY01 = (this.ebitdaFY01 / this.revenueFY01) * 100;
		}
	}

	public double getReturnOnEBITDAFY02() {
		return returnOnEBITDAFY02;
	}

	public void setReturnOnEBITDAFY02() {
		if (this.revenueFY02 == 0) {
			this.returnOnEBITDAFY02 = 0.00;
		} else {
			this.returnOnEBITDAFY02 = (this.ebitdaFY02 / this.revenueFY02) * 100;
		}
	}

	public double getReturnOnEBITDAFY03() {
		return returnOnEBITDAFY03;
	}

	public void setReturnOnEBITDAFY03() {
		if (this.revenueFY03 == 0) {
			this.returnOnEBITDAFY03 = 0.00;
		} else {
			this.returnOnEBITDAFY03 = (this.ebitdaFY03 / this.revenueFY03) * 100;
		}
	}

	public double getReturnOnEBITDAFY04() {
		return returnOnEBITDAFY04;
	}

	public void setReturnOnEBITDAFY04() {
		if (this.revenueFY04 == 0) {
			this.returnOnEBITDAFY04 = 0.00;
		} else {
			this.returnOnEBITDAFY04 = (this.ebitdaFY04 / this.revenueFY04) * 100;
		}
	}

	public double getReturnOnEBITDAFY05() {
		return returnOnEBITDAFY05;
	}

	public void setReturnOnEBITDAFY05() {
		if (this.revenueFY05 == 0) {
			this.returnOnEBITDAFY05 = 0.00;
		} else {
			this.returnOnEBITDAFY05 = (this.ebitdaFY05 / this.revenueFY05) * 100;
		}
	}

	//Eigenkapitalrendite fuer Grafik berechnen
	
	public double getReturnOnEquityPY03() {
		return returnOnEquityPY03;
	}

	public void setReturnOnEquityPY03() {
		if (this.totalEquityPY03 == 0) {
			this.returnOnEquityPY03 = 0.00;
		} else {
			this.returnOnEquityPY03 = (this.totalIncomePY03 / this.totalEquityPY03) * 100;
		}
	}

	public double getReturnOnEquityPY02() {
		return returnOnEquityPY02;
	}

	public void setReturnOnEquityPY02() {
		if (this.totalEquityPY02 == 0) {
			this.returnOnEquityPY02 = 0.00;
		} else {
			this.returnOnEquityPY02 = (this.totalIncomePY02 / this.totalEquityPY02) * 100;
		}
	}

	public double getReturnOnEquityPY01() {
		return returnOnEquityPY01;
	}

	public void setReturnOnEquityPY01() {
		if (this.totalEquityPY01 == 0) {
			this.returnOnEquityPY01 = 0.00;
		} else {
			this.returnOnEquityPY01 = (this.totalIncomePY01 / this.totalEquityPY01) * 100;
		}
	}

	public double getReturnOnEquityY00() {
		return returnOnEquityY00;
	}

	public void setReturnOnEquityY00() {
		if (this.totalEquityY00 == 0) {
			this.returnOnEquityY00 = 0.00;
		} else {
			this.returnOnEquityY00 = (this.totalIncomeY00 / this.totalEquityY00) * 100;
		}
	}

	public double getReturnOnEquityFY01() {
		return returnOnEquityFY01;
	}

	public void setReturnOnEquityFY01() {
		if (this.totalEquityFY01 == 0) {
			this.returnOnEquityFY01 = 0.00;
		} else {
			this.returnOnEquityFY01 = (this.totalIncomeFY01 / this.totalEquityFY01) * 100;
		}
	}

	public double getReturnOnEquityFY02() {
		return returnOnEquityFY02;
	}

	public void setReturnOnEquityFY02() {
		if (this.totalEquityFY02 == 0) {
			this.returnOnEquityFY02 = 0.00;
		} else {
			this.returnOnEquityFY02 = (this.totalIncomeFY02 / this.totalEquityFY02) * 100;
		}
	}

	public double getReturnOnEquityFY03() {
		return returnOnEquityFY03;
	}

	public void setReturnOnEquityFY03() {
		if (this.totalEquityFY03 == 0) {
			this.returnOnEquityFY03 = 0.00;
		} else {
			this.returnOnEquityFY03 = (this.totalIncomeFY03 / this.totalEquityFY03) * 100;
		}
	}

	public double getReturnOnEquityFY04() {
		return returnOnEquityFY04;
	}

	public void setReturnOnEquityFY04() {
		if (this.totalEquityFY04 == 0) {
			this.returnOnEquityFY04 = 0.00;
		} else {
			this.returnOnEquityFY04 = (this.totalIncomeFY04 / this.totalEquityFY04) * 100;
		}
	}

	public double getReturnOnEquityFY05() {
		return returnOnEquityFY05;
	}

	public void setReturnOnEquityFY05() {
		if (this.totalEquityFY05 == 0) {
			this.returnOnEquityFY05 = 0.00;
		} else {
			this.returnOnEquityFY05 = (this.totalIncomeFY05 / this.totalEquityFY05) * 100;
		}
	}

	//Gesamtkapitalrendite fuer Grafik berechnen
	public double getTotalReturnOnInvestPY03() {
		return totalReturnOnInvestPY03;
	}

	public void setTotalReturnOnInvestPY03() {
		if (this.totalAssetsPY03 == 0) {
			this.totalReturnOnInvestPY03 = 0.00;
		} else {
			this.totalReturnOnInvestPY03 = (this.totalIncomePY03 / this.totalAssetsPY03) * 100;
		}
	}

	public double getTotalReturnOnInvestPY02() {
		return totalReturnOnInvestPY02;
	}

	public void setTotalReturnOnInvestPY02() {
		if (this.totalAssetsPY02 == 0) {
			this.totalReturnOnInvestPY02 = 0.00;
		} else {
			this.totalReturnOnInvestPY02 = (this.totalIncomePY02 / this.totalAssetsPY02) * 100;
		}
	}

	public double getTotalReturnOnInvestPY01() {
		return totalReturnOnInvestPY01;
	}

	public void setTotalReturnOnInvestPY01() {
		if (this.totalAssetsPY01 == 0) {
			this.totalReturnOnInvestPY01 = 0.00;
		} else {
			this.totalReturnOnInvestPY01 = (this.totalIncomePY01 / this.totalAssetsPY01) * 100;
		}
	}

	public double getTotalReturnOnInvestY00() {
		return totalReturnOnInvestY00;
	}

	public void setTotalReturnOnInvestY00() {
		if (this.totalAssetsY00 == 0) {
			this.totalReturnOnInvestY00 = 0.00;
		} else {
			this.totalReturnOnInvestY00 = (this.totalIncomeY00 / this.totalAssetsY00) * 100;
		}
	}

	public double getTotalReturnOnInvestFY01() {
		return totalReturnOnInvestFY01;
	}

	public void setTotalReturnOnInvestFY01() {
		if (this.totalAssetsFY01 == 0) {
			this.totalReturnOnInvestFY01 = 0.00;
		} else {
			this.totalReturnOnInvestFY01 = (this.totalIncomeFY01 / this.totalAssetsFY01) * 100;
		}
	}

	public double getTotalReturnOnInvestFY02() {
		return totalReturnOnInvestFY02;
	}

	public void setTotalReturnOnInvestFY02() {
		if (this.totalAssetsFY02 == 0) {
			this.totalReturnOnInvestFY02 = 0.00;
		} else {
			this.totalReturnOnInvestFY02 = (this.totalIncomeFY02 / this.totalAssetsFY02) * 100;
		}
	}

	public double getTotalReturnOnInvestFY03() {
		return totalReturnOnInvestFY03;
	}

	public void setTotalReturnOnInvestFY03() {
		if (this.totalAssetsFY03 == 0) {
			this.totalReturnOnInvestFY03 = 0.00;
		} else {
			this.totalReturnOnInvestFY03 = (this.totalIncomeFY03 / this.totalAssetsFY03) * 100;
		}
	}

	public double getTotalReturnOnInvestFY04() {
		return totalReturnOnInvestFY04;
	}

	public void setTotalReturnOnInvestFY04() {
		if (this.totalAssetsFY04 == 0) {
			this.totalReturnOnInvestFY04 = 0.00;
		} else {
			this.totalReturnOnInvestFY04 = (this.totalIncomeFY04 / this.totalAssetsFY04) * 100;
		}
	}

	public double getTotalReturnOnInvestFY05() {
		return totalReturnOnInvestFY05;
	}

	public void setTotalReturnOnInvestFY05() {
		if (this.totalAssetsFY05 == 0) {
			this.totalReturnOnInvestFY05 = 0.00;
		} else {
			this.totalReturnOnInvestFY05 = (this.totalIncomeFY05 / this.totalAssetsFY05) * 100;
		}
	}	
	
	// Default Werte widerherstellen
	
	public void setDefaultValues() {
		this.companyName = "Unnamed";
		this.shareVolume = 1;
		this.currentSharePrice = 0.00;
		this.fairValueFromSharePrice = 0.00;
		this.riskFreeInterestRate = 2.00;
		this.marketRiskPremium = 5.50;
		this.growthRateEndValue = 0.50;
		this.dividendsPaidPY03 = 0.00;
		this.dividendsPaidPY02 = 0.00;
		this.dividendsPaidPY01 = 0.00;
		this.dividendsPaidY00 = 0.00;
		this.revenuePY03 = 0.00;
		this.revenuePY02 = 0.00;
		this.revenuePY01 = 0.00;
		this.revenueY00 = 0.00;
		this.revenueFY01 = 0.00;
		this.revenueFY02 = 0.00;
		this.revenueFY03 = 0.00;
		this.revenueFY04 = 0.00;
		this.revenueFY05 = 0.00;
		this.revenueChangePY02 = 0.00;
		this.revenueChangePY01 = 0.00;
		this.revenueChangeY00 = 0.00;
		this.revenueChangeFY01 = 0.00;
		this.revenueChangeFY02 = 0.00;
		this.revenueChangeFY03 = 0.00;
		this.revenueChangeFY04 = 0.00;
		this.revenueChangeFY05 = 0.00;
		this.cogsPY03 = 0.00;
		this.cogsPY02 = 0.00;
		this.cogsPY01 = 0.00;
		this.cogsY00 = 0.00;
		this.cogsFY01 = 0.00;
		this.cogsFY02 = 0.00;
		this.cogsFY03 = 0.00;
		this.cogsFY04 = 0.00;
		this.cogsFY05 = 0.00;
		this.cogsFromRevenuePY03 = 0.00;
		this.cogsFromRevenuePY02 = 0.00;
		this.cogsFromRevenuePY01 = 0.00;
		this.cogsFromRevenueY00 = 0.00;
		this.cogsFromRevenueFY01 = 0.00;
		this.cogsFromRevenueFY02 = 0.00;
		this.cogsFromRevenueFY03 = 0.00;
		this.cogsFromRevenueFY04 = 0.00;
		this.cogsFromRevenueFY05 = 0.00;
		this.otherCostsPY03 = 0.00;
		this.otherCostsPY02 = 0.00;
		this.otherCostsPY01 = 0.00;
		this.otherCostsY00 = 0.00;
		this.otherCostsFY01 = 0.00;
		this.otherCostsFY02 = 0.00;
		this.otherCostsFY03 = 0.00;
		this.otherCostsFY04 = 0.00;
		this.otherCostsFY05 = 0.00;
		this.otherCostsFromRevenuePY03 = 0.00;
		this.otherCostsFromRevenuePY02 = 0.00;
		this.otherCostsFromRevenuePY01 = 0.00;
		this.otherCostsFromRevenueY00 = 0.00;
		this.otherCostsFromRevenueFY01 = 0.00;
		this.otherCostsFromRevenueFY02 = 0.00;
		this.otherCostsFromRevenueFY03 = 0.00;
		this.otherCostsFromRevenueFY04 = 0.00;
		this.otherCostsFromRevenueFY05 = 0.00;
		this.ebitdaPY03 = 0.00;
		this.ebitdaPY02 = 0.00;
		this.ebitdaPY01 = 0.00;
		this.ebitdaY00 = 0.00;
		this.ebitdaFY01 = 0.00;
		this.ebitdaFY02 = 0.00;
		this.ebitdaFY03 = 0.00;
		this.ebitdaFY04 = 0.00;
		this.ebitdaFY05 = 0.00;
		this.ebitdaFromRevenuePY03 = 0.00;
		this.ebitdaFromRevenuePY02 = 0.00;
		this.ebitdaFromRevenuePY01 = 0.00;
		this.ebitdaFromRevenueY00 = 0.00;
		this.ebitdaFromRevenueFY01 = 0.00;
		this.ebitdaFromRevenueFY02 = 0.00;
		this.ebitdaFromRevenueFY03 = 0.00;
		this.ebitdaFromRevenueFY04 = 0.00;
		this.ebitdaFromRevenueFY05 = 0.00;
		this.depreciationPY03 = 0.00;
		this.depreciationPY02 = 0.00;
		this.depreciationPY01 = 0.00;
		this.depreciationY00 = 0.00;
		this.depreciationFY01 = 0.00;
		this.depreciationFY02 = 0.00;
		this.depreciationFY03 = 0.00;
		this.depreciationFY04 = 0.00;
		this.depreciationFY05 = 0.00;
		this.depreciationIntangiblePY03 = 0.00;
		this.depreciationIntangiblePY02 = 0.00;
		this.depreciationIntangiblePY01 = 0.00;
		this.depreciationIntangibleY00 = 0.00;
		this.depreciationIntangibleFY01 = 0.00;
		this.depreciationIntangibleFY02 = 0.00;
		this.depreciationIntangibleFY03 = 0.00;
		this.depreciationIntangibleFY04 = 0.00;
		this.depreciationIntangibleFY05 = 0.00;
		this.interestGainsPY03 = 0.00;
		this.interestGainsPY02 = 0.00;
		this.interestGainsPY01 = 0.00;
		this.interestGainsY00 = 0.00;
		this.interestLossPY03 = 0.00;
		this.interestLossPY02 = 0.00;
		this.interestLossPY01 = 0.00;
		this.interestLossY00 = 0.00;
		this.interestLossFY01 = 0.00;
		this.interestLossFY02 = 0.00;
		this.interestLossFY03 = 0.00;
		this.interestLossFY04 = 0.00;
		this.interestLossFY05 = 0.00;
		this.interestGainsFY01 = 0.00;
		this.interestGainsFY02 = 0.00;
		this.interestGainsFY03 = 0.00;
		this.interestGainsFY04 = 0.00;
		this.interestGainsFY05 = 0.00;
		this.ebtPY03 = 0.00;
		this.ebtPY02 = 0.00;
		this.ebtPY01 = 0.00;
		this.ebtY00 = 0.00;
		this.ebtFY01 = 0.00; 
		this.ebtFY02 = 0.00; 
		this.ebtFY03 = 0.00;
		this.ebtFY04 = 0.00;
		this.ebtFY05 = 0.00; 
		this.incomeTaxPY03 = 0.00;
		this.incomeTaxPY02 = 0.00;
		this.incomeTaxPY01 = 0.00;
		this.incomeTaxY00 = 0.00;
		this.incomeTaxFY01 = 0.00; 
		this.incomeTaxFY02 = 0.00;
		this.incomeTaxFY03 = 0.00;
		this.incomeTaxFY04 = 0.00;
		this.incomeTaxFY05 = 0.00;
		this.incomeTaxFromEbtPY03 = 0.00;
		this.incomeTaxFromEbtPY02 = 0.00;
		this.incomeTaxFromEbtPY01 = 0.00;
		this.incomeTaxFromEbtY00 = 0.00;
		this.incomeTaxFromEbtFY01 = 0.00;
		this.incomeTaxFromEbtFY02 = 0.00;
		this.incomeTaxFromEbtFY03 = 0.00;
		this.incomeTaxFromEbtFY04 = 0.00;
		this.incomeTaxFromEbtFY05 = 0.00;
		this.totalIncomePY03 = 0.00;
		this.totalIncomePY02 = 0.00;
		this.totalIncomePY01 = 0.00;
		this.totalIncomeY00 = 0.00;
		this.totalIncomeFY01 = 0.00;
		this.totalIncomeFY02 = 0.00;
		this.totalIncomeFY03 = 0.00;
		this.totalIncomeFY04 = 0.00;
		this.totalIncomeFY05 = 0.00;
		this.assetsY00 = 0.00;
		this.assetsPY01 = 0.00;
		this.assetsPY02 = 0.00;
		this.assetsPY03 = 0.00;
		this.assetsFY01 = 0.00;
		this.assetsFY02 = 0.00;
		this.assetsFY03 = 0.00;
		this.assetsFY04 = 0.00;
		this.assetsFY05 = 0.00;
		this.finAssetsY00 = 0.00;
		this.finAssetsPY01 = 0.00;
		this.finAssetsPY02 = 0.00;
		this.finAssetsPY03 = 0.00;
		this.finAssetsFY01 = 0.00;
		this.finAssetsFY02 = 0.00; 
		this.finAssetsFY03 = 0.00; 
		this.finAssetsFY04 = 0.00; 
		this.finAssetsFY05 = 0.00; 
		this.financialAssetsChangePY02 = 0.00;
		this.financialAssetsChangePY01 = 0.00;
		this.financialAssetsChangeY00 = 0.00;
		this.financialAssetsChangeFY01 = 0.00;
		this.financialAssetsChangeFY02 = 0.00;
		this.financialAssetsChangeFY03 = 0.00;
		this.financialAssetsChangeFY04 = 0.00;
		this.financialAssetsChangeFY05 = 0.00;
		this.interestGainsFromFinancialAssetsPY03 = 0.00;
		this.interestGainsFromFinancialAssetsPY02 = 0.00;
		this.interestGainsFromFinancialAssetsPY01 = 0.00;
		this.interestGainsFromFinancialAssetsY00 = 0.00;
		this.interestGainsFromFinancialAssetsFY01 = 0.00;
		this.interestGainsFromFinancialAssetsFY02 = 0.00;
		this.interestGainsFromFinancialAssetsFY03 = 0.00;
		this.interestGainsFromFinancialAssetsFY04 = 0.00;
		this.interestGainsFromFinancialAssetsFY05 = 0.00;
		this.propAssetsPY03 = 0.00;
		this.propAssetsPY02 = 0.00;
		this.propAssetsPY01 = 0.00;
		this.propAssetsY00 = 0.00;
		this.propAssetsFY01 = 0.00;
		this.propAssetsFY02 = 0.00;
		this.propAssetsFY03 = 0.00;
		this.propAssetsFY04 = 0.00;
		this.propAssetsFY05 = 0.00;
		this.propertyAssetsChangePY02 = 0.00;
		this.propertyAssetsChangePY01 = 0.00;
		this.propertyAssetsChangeY00 = 0.00;
		this.propertyAssetsChangeFY01 = 0.00;
		this.propertyAssetsChangeFY02 = 0.00;
		this.propertyAssetsChangeFY03 = 0.00;
		this.propertyAssetsChangeFY04 = 0.00;
		this.propertyAssetsChangeFY05 = 0.00;
		this.depreciationFromPropertyAssetsPY03 = 0.00;
		this.depreciationFromPropertyAssetsPY02 = 0.00;
		this.depreciationFromPropertyAssetsPY01 = 0.00;
		this.depreciationFromPropertyAssetsY00 = 0.00;
		this.depreciationFromPropertyAssetsFY01 = 0.00;
		this.depreciationFromPropertyAssetsFY02 = 0.00;
		this.depreciationFromPropertyAssetsFY03 = 0.00;
		this.depreciationFromPropertyAssetsFY04 = 0.00;
		this.depreciationFromPropertyAssetsFY05 = 0.00;
		this.intAssetsPY03 = 0.00;
		this.intAssetsPY02 = 0.00;
		this.intAssetsPY01 = 0.00;
		this.intAssetsY00 = 0.00;
		this.intAssetsFY01 = 0.00;
		this.intAssetsFY02 = 0.00;
		this.intAssetsFY03 = 0.00;
		this.intAssetsFY04 = 0.00;
		this.intAssetsFY05 = 0.00;
		this.intangibleAssetsChangePY02 = 0.00;
		this.intangibleAssetsChangePY01 = 0.00;
		this.intangibleAssetsChangeY00 = 0.00;
		this.intangibleAssetsChangeFY01 = 0.00;
		this.intangibleAssetsChangeFY02 = 0.00;
		this.intangibleAssetsChangeFY03 = 0.00;
		this.intangibleAssetsChangeFY04 = 0.00;
		this.intangibleAssetsChangeFY05 = 0.00;
		this.depreciationFromIntangibleAssetsPY03 = 0.00;
		this.depreciationFromIntangibleAssetsPY02 = 0.00;
		this.depreciationFromIntangibleAssetsPY01 = 0.00;
		this.depreciationFromIntangibleAssetsY00 = 0.00;
		this.depreciationFromIntangibleAssetsFY01 = 0.00;
		this.depreciationFromIntangibleAssetsFY02 = 0.00;
		this.depreciationFromIntangibleAssetsFY03 = 0.00;
		this.depreciationFromIntangibleAssetsFY04 = 0.00;
		this.depreciationFromIntangibleAssetsFY05 = 0.00;
		this.otherAssetsPY03 = 0.00;
		this.otherAssetsPY02 = 0.00;
		this.otherAssetsPY01 = 0.00;
		this.otherAssetsY00 = 0.00;
		this.otherAssetsFY01 = 0.00;
		this.otherAssetsFY02 = 0.00;
		this.otherAssetsFY03 = 0.00;
		this.otherAssetsFY04 = 0.00;
		this.otherAssetsFY05 = 0.00;
		this.otherAssetsChangePY02 = 0.00;
		this.otherAssetsChangePY01 = 0.00;
		this.otherAssetsChangeY00 = 0.00;
		this.otherAssetsChangeFY01 = 0.00;
		this.otherAssetsChangeFY02 = 0.00;
		this.otherAssetsChangeFY03 = 0.00;
		this.otherAssetsChangeFY04 = 0.00;
		this.otherAssetsChangeFY05 = 0.00;
		this.inventoryPY03 = 0.00;
		this.inventoryPY02 = 0.00;
		this.inventoryPY01 = 0.00;
		this.inventoryY00 = 0.00;
		this.inventoryFY01 = 0.00;
		this.inventoryFY02 = 0.00;
		this.inventoryFY03 = 0.00; 
		this.inventoryFY04 = 0.00;
		this.inventoryFY05 = 0.00;
		this.inventoryTurnoverPY03 = 0.00;
		this.inventoryTurnoverPY02 = 0.00;
		this.inventoryTurnoverPY01 = 0.00;
		this.inventoryTurnoverY00 = 0.00;
		this.inventoryTurnoverFY01 = 0.00;
		this.inventoryTurnoverFY02 = 0.00;
		this.inventoryTurnoverFY03 = 0.00;
		this.inventoryTurnoverFY04 = 0.00;
		this.inventoryTurnoverFY05 = 0.00;
		this.receivablesPY03 = 0.00;
		this.receivablesPY02 = 0.00;
		this.receivablesPY01 = 0.00;
		this.receivablesY00 = 0.00;
		this.receivablesFY01 = 0.00;
		this.receivablesFY02 = 0.00;
		this.receivablesFY03 = 0.00;
		this.receivablesFY04 = 0.00;
		this.receivablesFY05 = 0.00;
		this.receivablesTurnoverPY03 = 0.00;
		this.receivablesTurnoverPY02 = 0.00;
		this.receivablesTurnoverPY01 = 0.00;
		this.receivablesTurnoverY00 = 0.00;
		this.receivablesTurnoverFY01 = 0.00;
		this.receivablesTurnoverFY02 = 0.00;
		this.receivablesTurnoverFY03 = 0.00;
		this.receivablesTurnoverFY04 = 0.00;
		this.receivablesTurnoverFY05 = 0.00;
		this.otherNCAPY03 = 0.00;
		this.otherNCAPY02 = 0.00;
		this.otherNCAPY01 = 0.00;
		this.otherNCAY00 = 0.00;
		this.otherNCAFY01 = 0.00;
		this.otherNCAFY02 = 0.00;
		this.otherNCAFY03 = 0.00;
		this.otherNCAFY04 = 0.00;
		this.otherNCAFY05 = 0.00;
		this.otherNCAFromNCAPY02 = 0.00;
		this.otherNCAFromNCAPY01 = 0.00;
		this.otherNCAFromNCAY00 = 0.00;
		this.otherNCAFromNCAFY01 = 0.00;
		this.otherNCAFromNCAFY02 = 0.00;
		this.otherNCAFromNCAFY03 = 0.00;
		this.otherNCAFromNCAFY04 = 0.00;
		this.otherNCAFromNCAFY05 = 0.00;
		this.ncaPY03 = 0.00;
		this.ncaPY02 = 0.00;
		this.ncaPY01 = 0.00;
		this.ncaY00 = 0.00;
		this.ncaFY01 = 0.00;
		this.ncaFY02 = 0.00;
		this.ncaFY03 = 0.00;
		this.ncaFY04 = 0.00;
		this.ncaFY05 = 0.00;
		this.cashPY03 = 0.00;
		this.cashPY02 = 0.00;
		this.cashPY01 = 0.00;
		this.cashY00 = 0.00;
		this.cashFY01 = 0.00;
		this.cashFY02 = 0.00;
		this.cashFY03 = 0.00;
		this.cashFY04 = 0.00;
		this.cashFY05 = 0.00;
		this.totalAssetsPY03 = 0.00;
		this.totalAssetsPY02 = 0.00;
		this.totalAssetsPY01 = 0.00;
		this.totalAssetsY00 = 0.00;
		this.totalAssetsFY01 = 0.00;
		this.totalAssetsFY02 = 0.00;
		this.totalAssetsFY03 = 0.00;
		this.totalAssetsFY04 = 0.00;
		this.totalAssetsFY05 = 0.00;
		this.shareCapitalPY03 = 0.00;
		this.shareCapitalPY02 = 0.00;
		this.shareCapitalPY01 = 0.00;
		this.shareCapitalY00 = 0.00;
		this.shareCapitalChangePY02 = 0.00;
		this.shareCapitalChangePY01 = 0.00;
		this.shareCapitalChangeY00 = 0.00;
		this.shareCapitalChangeFY01 = 0.00;
		this.shareCapitalChangeFY02 = 0.00;
		this.shareCapitalChangeFY03 = 0.00;
		this.shareCapitalChangeFY04 = 0.00;
		this.shareCapitalChangeFY05 = 0.00;
		this.shareCapitalFY01 = 0.00;
		this.shareCapitalFY02 = 0.00;
		this.shareCapitalFY03 = 0.00;
		this.shareCapitalFY04 = 0.00;
		this.shareCapitalFY05 = 0.00;
		this.reservesPY03 = 0.00;
		this.reservesPY02 = 0.00;
		this.reservesPY01 = 0.00;
		this.reservesY00 = 0.00;
		this.reservesFY01 = 0.00;
		this.reservesFY02 = 0.00;
		this.reservesFY03 = 0.00;
		this.reservesFY04 = 0.00;
		this.reservesFY05 = 0.00;
		this.reservesChangePY02 = 0.00;
		this.reservesChangePY01 = 0.00;
		this.reservesChangeY00 = 0.00;
		this.reservesChangeFY01 = 0.00;
		this.reservesChangeFY02 = 0.00;
		this.reservesChangeFY03 = 0.00;
		this.reservesChangeFY04 = 0.00;
		this.reservesChangeFY05 = 0.00;
		this.dividendsPaidRatePY03 = 0.00;
		this.dividendsPaidRatePY02 = 0.00;
		this.dividendsPaidRatePY01 = 0.00;
		this.dividendsPaidRateY00 = 0.00;
		this.dividendsPaidRateFY01 = 0.00;
		this.dividendsPaidRateFY02 = 0.00;
		this.dividendsPaidRateFY03 = 0.00;
		this.dividendsPaidRateFY04 = 0.00;
		this.dividendsPaidRateFY05 = 0.00;
		this.otherEquityPY03 = 0.00;
		this.otherEquityPY02 = 0.00;
		this.otherEquityPY01 = 0.00;
		this.otherEquityY00 = 0.00;
		this.otherEquityFY01 = 0.00;
		this.otherEquityFY02 = 0.00;
		this.otherEquityFY03 = 0.00;
		this.otherEquityFY04 = 0.00;
		this.otherEquityFY05 = 0.00;
		this.otherEquityChangePY02 = 0.00;
		this.otherEquityChangePY01 = 0.00;
		this.otherEquityChangeY00 = 0.00;
		this.otherEquityChangeFY01 = 0.00;
		this.otherEquityChangeFY02 = 0.00;
		this.otherEquityChangeFY03 = 0.00;
		this.otherEquityChangeFY04 = 0.00;
		this.otherEquityChangeFY05 = 0.00;
		this.totalEquityPY03 = 0.00;
		this.totalEquityPY02 = 0.00;
		this.totalEquityPY01 = 0.00;
		this.totalEquityY00 = 0.00;
		this.totalEquityFY01 = 0.00;
		this.totalEquityFY02 = 0.00;
		this.totalEquityFY03 = 0.00;
		this.totalEquityFY04 = 0.00;
		this.totalEquityFY05 = 0.00;
		this.longTermBankDebtPY03 = 0.00;
		this.longTermBankDebtPY02 = 0.00;
		this.longTermBankDebtPY01 = 0.00;
		this.longTermBankDebtY00 = 0.00;
		this.longTermBankDebtFY01 = 0.00; 
		this.longTermBankDebtFY02 = 0.00; 
		this.longTermBankDebtFY03 = 0.00; 
		this.longTermBankDebtFY04 = 0.00; 
		this.longTermBankDebtFY05 = 0.00; 
		this.longTermBankDebtChangePY02 = 0.00;
		this.longTermBankDebtChangePY01 = 0.00;
		this.longTermBankDebtChangeY00 = 0.00;
		this.longTermBankDebtChangeFY01 = 0.00;
		this.longTermBankDebtChangeFY02 = 0.00;
		this.longTermBankDebtChangeFY03 = 0.00;
		this.longTermBankDebtChangeFY04 = 0.00;
		this.longTermBankDebtChangeFY05 = 0.00;
		this.interestLossFromBankDebtPY03 = 0.00;
		this.interestLossFromBankDebtPY02 = 0.00;
		this.interestLossFromBankDebtPY01 = 0.00;
		this.interestLossFromBankDebtY00 = 0.00;
		this.interestLossFromBankDebtFY01 = 0.00;
		this.interestLossFromBankDebtFY02 = 0.00;
		this.interestLossFromBankDebtFY03 = 0.00;
		this.interestLossFromBankDebtFY04 = 0.00;
		this.interestLossFromBankDebtFY05 = 0.00;
		this.accrualsPY03 = 0.00;
		this.accrualsPY02 = 0.00;
		this.accrualsPY01 = 0.00;
		this.accrualsY00 = 0.00;
		this.accrualsFY01 = 0.00;
		this.accrualsFY02 = 0.00;
		this.accrualsFY03 = 0.00;
		this.accrualsFY04 = 0.00;
		this.accrualsFY05 = 0.00;
		this.accrualsChangePY02 = 0.00;
		this.accrualsChangePY01 = 0.00;
		this.accrualsChangeY00 = 0.00;
		this.accrualsChangeFY01 = 0.00;
		this.accrualsChangeFY02 = 0.00;
		this.accrualsChangeFY03 = 0.00;
		this.accrualsChangeFY04 = 0.00;
		this.accrualsChangeFY05 = 0.00;
		this.totalLongTermLiabilitiesPY03 = 0.00;
		this.totalLongTermLiabilitiesPY02 = 0.00;
		this.totalLongTermLiabilitiesPY01 = 0.00;
		this.totalLongTermLiabilitiesY00 = 0.00;
		this.totalLongTermLiabilitiesFY01 = 0.00;
		this.totalLongTermLiabilitiesFY02 = 0.00;
		this.totalLongTermLiabilitiesFY03 = 0.00;
		this.totalLongTermLiabilitiesFY04 = 0.00;
		this.totalLongTermLiabilitiesFY05 = 0.00;
		this.shortTermBankDebtPY03 = 0.00;
		this.shortTermBankDebtPY02 = 0.00;
		this.shortTermBankDebtPY01 = 0.00;
		this.shortTermBankDebtY00 = 0.00;
		this.shortTermBankDebtFY01 = 0.00; 
		this.shortTermBankDebtFY02 = 0.00; 
		this.shortTermBankDebtFY03 = 0.00; 
		this.shortTermBankDebtFY04 = 0.00; 
		this.shortTermBankDebtFY05 = 0.00; 
		this.shortTermBankDebtChangePY02 = 0.00;
		this.shortTermBankDebtChangePY01 = 0.00;
		this.shortTermBankDebtChangeY00 = 0.00;
		this.shortTermBankDebtChangeFY01 = 0.00; 
		this.shortTermBankDebtChangeFY02 = 0.00;
		this.shortTermBankDebtChangeFY03 = 0.00;
		this.shortTermBankDebtChangeFY04 = 0.00; 
		this.shortTermBankDebtChangeFY05 = 0.00;
		this.tradePayablesPY03 = 0.00;
		this.tradePayablesPY02 = 0.00;
		this.tradePayablesPY01 = 0.00;
		this.tradePayablesY00 = 0.00;
		this.tradePayablesFY01 = 0.00;
		this.tradePayablesFY02 = 0.00;
		this.tradePayablesFY03 = 0.00;
		this.tradePayablesFY04 = 0.00;
		this.tradePayablesFY05 = 0.00;
		this.daysPayablesOutstandingPY03 = 0.00;
		this.daysPayablesOutstandingPY02 = 0.00;
		this.daysPayablesOutstandingPY01 = 0.00;
		this.daysPayablesOutstandingY00 = 0.00;
		this.daysPayablesOutstandingFY01 = 0.00;
		this.daysPayablesOutstandingFY02 = 0.00;
		this.daysPayablesOutstandingFY03 = 0.00;
		this.daysPayablesOutstandingFY04 = 0.00;
		this.daysPayablesOutstandingFY05 = 0.00;
		this.otherShortTermLiabilitiesPY03 = 0.00;
		this.otherShortTermLiabilitiesPY02 = 0.00;
		this.otherShortTermLiabilitiesPY01 = 0.00;
		this.otherShortTermLiabilitiesY00 = 0.00;
		this.otherShortTermLiabilitiesFY01 = 0.00;
		this.otherShortTermLiabilitiesFY02 = 0.00;
		this.otherShortTermLiabilitiesFY03 = 0.00;
		this.otherShortTermLiabilitiesFY04 = 0.00;
		this.otherShortTermLiabilitiesFY05 = 0.00;
		this.otherShortTermLiabilitiesChangePY02 = 0.00;
		this.otherShortTermLiabilitiesChangePY01 = 0.00;
		this.otherShortTermLiabilitiesChangeY00 = 0.00;
		this.otherShortTermLiabilitiesChangeFY01 = 0.00;
		this.otherShortTermLiabilitiesChangeFY02 = 0.00;
		this.otherShortTermLiabilitiesChangeFY03 = 0.00;
		this.otherShortTermLiabilitiesChangeFY04 = 0.00;
		this.otherShortTermLiabilitiesChangeFY05 = 0.00;
		this.totalShortTermLiabilitiesPY03 = 0.00;
		this.totalShortTermLiabilitiesPY02 = 0.00;
		this.totalShortTermLiabilitiesPY01 = 0.00;
		this.totalShortTermLiabilitiesY00 = 0.00;
		this.totalShortTermLiabilitiesFY01 = 0.00;
		this.totalShortTermLiabilitiesFY02 = 0.00;
		this.totalShortTermLiabilitiesFY03 = 0.00;
		this.totalShortTermLiabilitiesFY04 = 0.00;
		this.totalShortTermLiabilitiesFY05 = 0.00;
		this.totalLiabilitiesPY03 = 0.00;
		this.totalLiabilitiesPY02 = 0.00;
		this.totalLiabilitiesPY01 = 0.00;
		this.totalLiabilitiesY00 = 0.00;
		this.totalLiabilitiesFY01 = 0.00;
		this.totalLiabilitiesFY02 = 0.00;
		this.totalLiabilitiesFY03 = 0.00;
		this.totalLiabilitiesFY04 = 0.00;
		this.totalLiabilitiesFY05 = 0.00;
		this.cfTotalIncomeFY01 = 0.00;
		this.cfTotalIncomeFY02 = 0.00;
		this.cfTotalIncomeFY03 = 0.00;
		this.cfTotalIncomeFY04 = 0.00;
		this.cfTotalIncomeFY05 = 0.00;
		this.cfTotalIncomeTV = 0.00;
		this.cfDepreciationTV = 0.00;
		this.cfDepreciationIntangibleTV = 0.00;
		this.cfAccrualsFY01 = 0.00;
		this.cfAccrualsFY02 = 0.00;
		this.cfAccrualsFY03 = 0.00;
		this.cfAccrualsFY04 = 0.00;
		this.cfAccrualsFY05 = 0.00;
		this.cfAccrualsTV = 0.00;
		this.cfAssetsInvestFY01 = 0.00;
		this.cfAssetsInvestFY02 = 0.00;
		this.cfAssetsInvestFY03 = 0.00;
		this.cfAssetsInvestFY04 = 0.00;
		this.cfAssetsInvestFY05 = 0.00;
		this.cfAssetsInvestTV = 0.00;
		this.cfWorkingCapitalInvestFY01 = 0.00;
		this.cfWorkingCapitalInvestFY02 = 0.00;
		this.cfWorkingCapitalInvestFY03 = 0.00;
		this.cfWorkingCapitalInvestFY04 = 0.00;
		this.cfWorkingCapitalInvestFY05 = 0.00;
		this.cfWorkingCapitalInvestTV = 0.00;
		this.cfDebtChangeFY01 = 0.00;
		this.cfDebtChangeFY02 = 0.00;
		this.cfDebtChangeFY03 = 0.00;
		this.cfDebtChangeFY04 = 0.00;
		this.cfDebtChangeFY05 = 0.00;
		this.cfDebtChangeTV = 0.00;
		this.cashflowToEquityFY01 = 0.00;
		this.cashflowToEquityFY02 = 0.00;
		this.cashflowToEquityFY03 = 0.00;
		this.cashflowToEquityFY04 = 0.00;
		this.cashflowToEquityFY05 = 0.00;
		this.cashflowToEquityTV = 0.00;
		this.discountedCashflowFY01 = 0.00;
		this.discountedCashflowFY02 = 0.00;
		this.discountedCashflowFY03 = 0.00;
		this.discountedCashflowFY04 = 0.00;
		this.discountedCashflowFY05 = 0.00;
		this.discountedCashflowTV = 0.00;
		this.fairValue = 0.001;
		this.fairValuePerShare = 0.001;
		this.leveragePY03 = 0.00;
		this.leveragePY02 = 0.00;
		this.leveragePY01 = 0.00;
		this.leverageY00 = 0.00;
		this.leverageFY01 = 0.00;
		this.leverageFY02 = 0.00;
		this.leverageFY03 = 0.00;
		this.leverageFY04 = 0.00;
		this.leverageFY05 = 0.00;
		this.assetIntensityPY03 = 0.00;
		this.assetIntensityPY02 = 0.00;
		this.assetIntensityPY01 = 0.00;
		this.assetIntensityY00 = 0.00;
		this.assetIntensityFY01 = 0.00;
		this.assetIntensityFY02 = 0.00;
		this.assetIntensityFY03 = 0.00;
		this.assetIntensityFY04 = 0.00;
		this.assetIntensityFY05 = 0.00;
		this.circulatingIntensityPY03 = 0.00;
		this.circulatingIntensityPY02 = 0.00;
		this.circulatingIntensityPY01 = 0.00;
		this.circulatingIntensityY00 = 0.00;
		this.circulatingIntensityFY01 = 0.00;
		this.circulatingIntensityFY02 = 0.00;
		this.circulatingIntensityFY03 = 0.00;
		this.circulatingIntensityFY04 = 0.00;
		this.circulatingIntensityFY05 = 0.00;
		this.returnOnSalesPY03 = 0.00;
		this.returnOnSalesPY02 = 0.00;
		this.returnOnSalesPY01 = 0.00;
		this.returnOnSalesY00 = 0.00;
		this.returnOnSalesFY01 = 0.00;
		this.returnOnSalesFY02 = 0.00;
		this.returnOnSalesFY03 = 0.00;
		this.returnOnSalesFY04 = 0.00;
		this.returnOnSalesFY05 = 0.00;
		this.returnOnEBITDAPY03 = 0.00;
		this.returnOnEBITDAPY02 = 0.00;
		this.returnOnEBITDAPY01 = 0.00;
		this.returnOnEBITDAY00 = 0.00;
		this.returnOnEBITDAFY01 = 0.00;
		this.returnOnEBITDAFY02 = 0.00;
		this.returnOnEBITDAFY03 = 0.00;
		this.returnOnEBITDAFY04 = 0.00;
		this.returnOnEBITDAFY05 = 0.00;
		this.returnOnEquityPY03 = 0.00;
		this.returnOnEquityPY02 = 0.00;
		this.returnOnEquityPY01 = 0.00;
		this.returnOnEquityY00 = 0.00;
		this.returnOnEquityFY01 = 0.00;
		this.returnOnEquityFY02 = 0.00;
		this.returnOnEquityFY03 = 0.00;
		this.returnOnEquityFY04 = 0.00;
		this.returnOnEquityFY05 = 0.00;
		this.totalReturnOnInvestPY03 = 0.00;
		this.totalReturnOnInvestPY02 = 0.00;
		this.totalReturnOnInvestPY01 = 0.00;
		this.totalReturnOnInvestY00 = 0.00;
		this.totalReturnOnInvestFY01 = 0.00;
		this.totalReturnOnInvestFY02 = 0.00;
		this.totalReturnOnInvestFY03 = 0.00;
		this.totalReturnOnInvestFY04 = 0.00;
		this.totalReturnOnInvestFY05 = 0.00;
	}
	
	// Ceteris Paribus Simulation durchführen
	
	public void smartSimulationHelper() {
		
		if (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00 != 0) {
			
			this.revenueChangeFY01 = (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00) / 3;
			this.revenueChangeFY02 = (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00) / 3;
			this.revenueChangeFY03 = (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00) / 3;
			this.revenueChangeFY04 = (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00) / 3;
			this.revenueChangeFY05 = (this.revenueChangePY02 + this.revenueChangePY01 + this.revenueChangeY00) / 3;
			
		} else {
			
			this.revenueChangeFY01 = 0.00;
			this.revenueChangeFY02 = 0.00;
			this.revenueChangeFY03 = 0.00;
			this.revenueChangeFY04 = 0.00;
			this.revenueChangeFY05 = 0.00;
		}
		
		if (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00 != 0) {
			
			this.cogsFromRevenueFY01 = (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00) / 4;
			this.cogsFromRevenueFY02 = (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00) / 4;
			this.cogsFromRevenueFY03 = (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00) / 4;
			this.cogsFromRevenueFY04 = (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00) / 4;
			this.cogsFromRevenueFY05 = (this.cogsFromRevenuePY03 + this.cogsFromRevenuePY02 + this.cogsFromRevenuePY01 + this.cogsFromRevenueY00) / 4;
		

		} else {
			
			this.cogsFromRevenueFY01 = 0.00;
			this.cogsFromRevenueFY02 = 0.00;
			this.cogsFromRevenueFY03 = 0.00;
			this.cogsFromRevenueFY04 = 0.00;
			this.cogsFromRevenueFY05 = 0.00;
			
		}
		
		if (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00 != 0) {
		
			this.otherCostsFromRevenueFY01 = (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00) / 4;
			this.otherCostsFromRevenueFY02 = (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00) / 4;
			this.otherCostsFromRevenueFY03 = (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00) / 4;
			this.otherCostsFromRevenueFY04 = (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00) / 4;
			this.otherCostsFromRevenueFY05 = (this.otherCostsFromRevenuePY03 + this.otherCostsFromRevenuePY02 + this.otherCostsFromRevenuePY01 + this.otherCostsFromRevenueY00) / 4;
			
		} else {
			
			this.otherCostsFromRevenueFY01 = 0.00;
			this.otherCostsFromRevenueFY02 = 0.00;
			this.otherCostsFromRevenueFY03 = 0.00;
			this.otherCostsFromRevenueFY04 = 0.00;
			this.otherCostsFromRevenueFY05 = 0.00;
		}

		if (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00 != 0) {
			
			this.depreciationFY01 = (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00) / 4;
			this.depreciationFY02 = (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00) / 4;
			this.depreciationFY03 = (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00) / 4;
			this.depreciationFY04 = (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00) / 4;
			this.depreciationFY05 = (this.depreciationPY03 + this.depreciationPY02 + this.depreciationPY01 + this.depreciationY00) / 4;
			
		} else {
			
			this.depreciationFY01 = 0.00;
			this.depreciationFY02 = 0.00;
			this.depreciationFY03 = 0.00;
			this.depreciationFY04 = 0.00;
			this.depreciationFY05 = 0.00;
			
		}
		
		if (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00 != 0) {
			
			this.depreciationIntangibleFY01 = (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00) / 4;
			this.depreciationIntangibleFY02 = (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00) / 4;
			this.depreciationIntangibleFY03 = (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00) / 4;
			this.depreciationIntangibleFY04 = (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00) / 4;
			this.depreciationIntangibleFY05 = (this.depreciationIntangiblePY03 + this.depreciationIntangiblePY02 + this.depreciationIntangiblePY01 + this.depreciationIntangibleY00) / 4;
			
		} else {
			
			this.depreciationIntangibleFY01 = 0.00;
			this.depreciationIntangibleFY02 = 0.00;
			this.depreciationIntangibleFY03 = 0.00;
			this.depreciationIntangibleFY04 = 0.00;
			this.depreciationIntangibleFY05 = 0.00;
			
		}
		
		if (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00 != 0) {
			
			this.interestGainsFromFinancialAssetsFY01 = (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00) /4;
			this.interestGainsFromFinancialAssetsFY02 = (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00) /4;
			this.interestGainsFromFinancialAssetsFY03 = (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00) /4;
			this.interestGainsFromFinancialAssetsFY04 = (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00) /4;
			this.interestGainsFromFinancialAssetsFY05 = (this.interestGainsFromFinancialAssetsPY03 + this.interestGainsFromFinancialAssetsPY02 + this.interestGainsFromFinancialAssetsPY01 + this.interestGainsFromFinancialAssetsY00) /4;
			
		} else {
			
			this.interestGainsFromFinancialAssetsFY01 = 0.00;
			this.interestGainsFromFinancialAssetsFY02 = 0.00;
			this.interestGainsFromFinancialAssetsFY03 = 0.00;
			this.interestGainsFromFinancialAssetsFY04 = 0.00;
			this.interestGainsFromFinancialAssetsFY05 = 0.00;
			
		}
		
		if (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00 != 0) {
			
			this.interestLossFromBankDebtFY01 = (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00) / 4;
			this.interestLossFromBankDebtFY02 = (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00) / 4;
			this.interestLossFromBankDebtFY03 = (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00) / 4;
			this.interestLossFromBankDebtFY04 = (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00) / 4;
			this.interestLossFromBankDebtFY05 = (this.interestLossFromBankDebtPY03 + this.interestLossFromBankDebtPY02 + this.interestLossFromBankDebtPY01 + this.interestLossFromBankDebtY00) / 4;
			
			
		} else {
			
			this.interestLossFromBankDebtFY01 = 0.00;
			this.interestLossFromBankDebtFY02 = 0.00;
			this.interestLossFromBankDebtFY03 = 0.00;
			this.interestLossFromBankDebtFY04 = 0.00;
			this.interestLossFromBankDebtFY05 = 0.00;
			
		}		
	
		if (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00 != 0) {
			
			this.incomeTaxFromEbtFY01 = (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00) / 4;
			this.incomeTaxFromEbtFY02 = (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00) / 4;
			this.incomeTaxFromEbtFY03 = (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00) / 4;
			this.incomeTaxFromEbtFY04 = (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00) / 4;
			this.incomeTaxFromEbtFY05 = (this.incomeTaxFromEbtPY03 + this.incomeTaxFromEbtPY02 + this.incomeTaxFromEbtPY01 + this.incomeTaxFromEbtY00) / 4;
			
		} else {
			
			this.incomeTaxFromEbtFY01 = 0.00;
			this.incomeTaxFromEbtFY02 = 0.00;
			this.incomeTaxFromEbtFY03 = 0.00;
			this.incomeTaxFromEbtFY04 = 0.00;
			this.incomeTaxFromEbtFY05 = 0.00;
			
		}
			
		if (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00 != 0) {
			
			this.dividendsPaidRateFY01 = (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00) / 4;
			this.dividendsPaidRateFY02 = (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00) / 4;
			this.dividendsPaidRateFY03 = (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00) / 4;
			this.dividendsPaidRateFY04 = (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00) / 4;
			this.dividendsPaidRateFY05 = (this.dividendsPaidRatePY03 + this.dividendsPaidRatePY02 + this.dividendsPaidRatePY01 + this.dividendsPaidRateY00) / 4;
			
		} else {
			
			this.dividendsPaidRateFY01 = 0.00;
			this.dividendsPaidRateFY02 = 0.00;
			this.dividendsPaidRateFY03 = 0.00;
			this.dividendsPaidRateFY04 = 0.00;
			this.dividendsPaidRateFY05 = 0.00;
			
		}

		if (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00 != 0) {
			
			this.financialAssetsChangeFY01 = (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00) / 3;
			this.financialAssetsChangeFY02 = (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00) / 3;
			this.financialAssetsChangeFY03 = (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00) / 3;
			this.financialAssetsChangeFY04 = (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00) / 3;
			this.financialAssetsChangeFY05 = (this.financialAssetsChangePY02 + this.financialAssetsChangePY01 + this.financialAssetsChangeY00) / 3;
			
		} else {
			
			this.financialAssetsChangeFY01 = 0.00;
			this.financialAssetsChangeFY02 = 0.00;
			this.financialAssetsChangeFY03 = 0.00;
			this.financialAssetsChangeFY04 = 0.00;
			this.financialAssetsChangeFY05 = 0.00;
			
		}
		
		
		//if (this.propertyAssetsChangePY02 + this.propertyAssetsChangePY01 + this.propertyAssetsChangeY00 != 0) {
			
			this.propertyAssetsChangeFY01 = this.depreciationFY01;
			this.propertyAssetsChangeFY02 = this.depreciationFY02;
			this.propertyAssetsChangeFY03 = this.depreciationFY03;
			this.propertyAssetsChangeFY04 = this.depreciationFY04;
			this.propertyAssetsChangeFY05 = this.depreciationFY05;
			
		/*} else {
			
			this.propertyAssetsChangeFY01 = 0.00;
			this.propertyAssetsChangeFY02 = 0.00;
			this.propertyAssetsChangeFY03 = 0.00;
			this.propertyAssetsChangeFY04 = 0.00;
			this.propertyAssetsChangeFY05 = 0.00;
			
		}
*/
		if (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00 != 0) {
			
			this.intangibleAssetsChangeFY01 = (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00) / 3;
			this.intangibleAssetsChangeFY02 = (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00) / 3;
			this.intangibleAssetsChangeFY03 = (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00) / 3;
			this.intangibleAssetsChangeFY04 = (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00) / 3;
			this.intangibleAssetsChangeFY05 = (this.intangibleAssetsChangePY02 + this.intangibleAssetsChangePY01 + this.intangibleAssetsChangeY00) / 3;
			
		} else {
			
			this.intangibleAssetsChangeFY01 = 0.00;
			this.intangibleAssetsChangeFY02 = 0.00;
			this.intangibleAssetsChangeFY03 = 0.00;
			this.intangibleAssetsChangeFY04 = 0.00;
			this.intangibleAssetsChangeFY05 = 0.00;
			
		}
		
		if (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00 != 0) {
			
			this.otherAssetsChangeFY01 = (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00) / 3;
			this.otherAssetsChangeFY02 = (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00) / 3;
			this.otherAssetsChangeFY03 = (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00) / 3;
			this.otherAssetsChangeFY04 = (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00) / 3;
			this.otherAssetsChangeFY05 = (this.otherAssetsChangePY02 + this.otherAssetsChangePY01 + this.otherAssetsChangeY00) / 3;
			
		} else {
			
			this.otherAssetsChangeFY01 = 0.00;
			this.otherAssetsChangeFY02 = 0.00;
			this.otherAssetsChangeFY03 = 0.00;
			this.otherAssetsChangeFY04 = 0.00;
			this.otherAssetsChangeFY05 = 0.00;
			
		}

		if (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00 != 0) {
			
			this.inventoryTurnoverFY01 = (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00) / 4;
			this.inventoryTurnoverFY02 = (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00) / 4;
			this.inventoryTurnoverFY03 = (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00) / 4;
			this.inventoryTurnoverFY04 = (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00) / 4;
			this.inventoryTurnoverFY05 = (this.inventoryTurnoverPY03 + this.inventoryTurnoverPY02 + this.inventoryTurnoverPY01 + this.inventoryTurnoverY00) / 4;
			
		} else {
			
			this.inventoryTurnoverFY01 = 0.00;
			this.inventoryTurnoverFY02 = 0.00;
			this.inventoryTurnoverFY03 = 0.00;
			this.inventoryTurnoverFY04 = 0.00;
			this.inventoryTurnoverFY05 = 0.00;
			
		}



		
	}
	

}

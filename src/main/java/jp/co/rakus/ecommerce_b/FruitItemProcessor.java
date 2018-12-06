/*package jp.co.rakus.ecommerce_b;

import org.springframework.batch.item.ItemProcessor;

public class FruitItemProcessor implements ItemProcessor<Fruit, Fruit>  {

	//取得したアイテム（今回はCSV）を加工しています。
	//フルーツ名をtoUpperCase()で大文字に変換しています。
	
	@Override
	  public Fruit process(final Fruit fruit) throws Exception {
	    final String title = fruit.getName().toUpperCase();
	    final int price = fruit.getPrice();
	     
	    final Fruit transformColumns = new Fruit(title, price);
	     
	    return transformColumns;
	  }
	
}*/

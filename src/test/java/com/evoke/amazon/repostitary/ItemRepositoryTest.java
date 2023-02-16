package com.evoke.amazon.repostitary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.evoke.amazon.entity.ItemEntity;
import com.evoke.amazon.repository.ItemRepository;

@DataJpaTest
//@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	// JUnit Test For SaveItem Operation
	@Test
	public void saveItem() {

		// given -precondition or setup
		ItemEntity item = new ItemEntity("Acer Nitro", "Gaming Laptops", "Electronic", "sliver", "Acer", 10, 6);

		// when-action or the behavior that we r going to test.
		ItemEntity saveItem = itemRepository.save(item);

		// then verify the output.
		assertThat(saveItem).isNotNull();
		assertThat(saveItem.getId()).isGreaterThan(1);
		// Assertions.assertThat(saveItem).isNull();

	}

	// JUnit Test For getAllItem Operation

	@Test
	public void getAllItem() {

		// given -precondition or setup.

		ItemEntity item = new ItemEntity("MI Note 11 pro", "Gaming Phone", "Electronic", "green", "MI", 10, 6);
		ItemEntity item1 = new ItemEntity("Dell", "Office Use Laptops", "Electronic", "Black", "Dell", 100, 56);

		itemRepository.save(item);
		itemRepository.save(item1);

		// when-action or the behavior that we r going to test.
		List<ItemEntity> itemList = itemRepository.findAll();
		
		// then verify the output.
		assertThat(itemList).isNotEmpty();
		assertThat(itemList).extracting(ItemEntity::getName);

	}

}

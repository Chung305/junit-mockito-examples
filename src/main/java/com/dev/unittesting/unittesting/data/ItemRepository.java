package com.dev.unittesting.unittesting.data;

import com.dev.unittesting.unittesting.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

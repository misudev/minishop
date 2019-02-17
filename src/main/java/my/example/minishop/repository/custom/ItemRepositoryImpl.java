package my.example.minishop.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.example.minishop.domain.Item;
import my.example.minishop.domain.QItem;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ItemRepositoryImpl extends QuerydslRepositorySupport implements ItemRepositoryCustom {

    public ItemRepositoryImpl() {
        super(Item.class);  //Entity클래스 정보를 전달해준다.
    }

    @Override
    public List<Item> getItems(Long categoryId, int start, int limit, String searchKind, String searchStr) {

        QItem qItem = QItem.item;
        JPQLQuery<Item> jpqlQuery = getItemJPQLQuery(qItem, categoryId, searchKind, searchStr);

        jpqlQuery.orderBy(qItem.id.desc());
        jpqlQuery.offset(start).limit(limit);
        return jpqlQuery.fetch();

    }

    @Override
    public Long getItemsCount(Long categoryId, String searchKind, String searchStr) {
        QItem qItem = QItem.item;
        JPQLQuery<Item> jpqlQuery = getItemJPQLQuery(qItem, categoryId, searchKind, searchStr);

        return jpqlQuery.fetchCount();

    }


    // 중복되는 부분 ? Refactor - Extract - method 로 분리하자.
    private JPQLQuery<Item> getItemJPQLQuery(QItem qItem, Long categoryId, String searchKind, String searchStr) {

        // JPQL
        // SELECT distinct i FROM Item i INNER JOIN FETCH i.category ORDER BY i.id DESC
        // 카테고리로 조회
        // SELECT distinct i FROM Item i INNER JOIN FETCH i.category WHERE i.category.id =:categoryId ORDER BY i.id DESC
        // 이름으로 검색
        // SELECT distinct i FROM Item i INNER JOIN FETCH i.category WHERE i.name = :searchStr ORDER BY i.id DESC
        // 내용으로 검색
        // SELECT distinct i FROM Item i INNER JOIN FETCH i.category WHERE i.description =: searchStr ORDER BY i.id DESC

        JPQLQuery<Item> jpqlQuery = from(qItem).innerJoin(qItem.category).fetchJoin()
                                .leftJoin(qItem.imageFiles).fetchJoin().distinct();

        // 카테고리 아이디가 있으면 조건 추가.
        if(categoryId != null){
            jpqlQuery.where(qItem.category.id.eq(categoryId));
        }
        // NAME_SEARCH , DESCRIPTION_SEARCH , NAME_OR_DESCRIPTION_SEARCH
        if("NAME_SEARCH".equals(searchKind)){
            jpqlQuery.where(qItem.name.like("%" + searchStr + "%"));
        }else if("DESCRIPTION_SEARCH".equals(searchKind)){
            jpqlQuery.where(qItem.description.like("%" + searchStr + "%"));
        }else if("NAME_OR_DESCRIPTION_SEARCH".equals(searchKind)){
            jpqlQuery.where(qItem.name.like("%" + searchStr + "%")
                    .or(qItem.description.like("%"+ searchStr + "%")));
        }
        return jpqlQuery;
    }
}

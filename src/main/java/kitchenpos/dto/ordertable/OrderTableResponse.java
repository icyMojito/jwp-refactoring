package kitchenpos.dto.ordertable;

import kitchenpos.domain.table.OrderTable;

import java.util.Objects;

public class OrderTableResponse {
    private Long id;
    private Long tableGroupId;
    private int numberOfGuests;
    private boolean empty;

    public OrderTableResponse(Long id, Long tableGroupId, int numberOfGuests, boolean empty) {
        this.id = id;
        this.tableGroupId = tableGroupId;
        this.numberOfGuests = numberOfGuests;
        this.empty = empty;
    }

    public static OrderTableResponse from(OrderTable orderTable) {
        Long id = orderTable.getId();
        Long tableGroupId = Objects.isNull(orderTable.getTableGroup()) ? null : orderTable.getTableGroup().getId();
        int numberOfGuests = orderTable.getNumberOfGuests().getValue();
        boolean empty = orderTable.isEmpty();

        return new OrderTableResponse(id, tableGroupId, numberOfGuests, empty);
    }

    public Long getId() {
        return id;
    }

    public Long getTableGroupId() {
        return tableGroupId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isEmpty() {
        return empty;
    }
}

package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.Transfer;
import br.com.findesk.findesk.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    public Transfer createTransfer(Transfer transfer) {
        if (transfer.getOriginAccount().getId().equals(transfer.getDestinationAccount().getId())) {
            throw new IllegalArgumentException("A conta de origem não pode ser igual à conta de destino.");
        }
        if (transfer.getAmount().doubleValue() <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        return transferRepository.save(transfer);
    }
}
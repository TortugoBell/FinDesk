package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.TransferDTO;
import br.com.findesk.findesk.model.Transfer;
import br.com.findesk.findesk.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public Transfer create(@RequestBody TransferDTO dto) {
        Transfer transfer = new Transfer();
        transfer.setAmount(dto.getAmount());
        transfer.setTransferDate(dto.getTransferDate());
        transfer.setDescription(dto.getDescription());
        transfer.setStatus(dto.getStatus());
        return transferService.createTransfer(transfer);
    }
}
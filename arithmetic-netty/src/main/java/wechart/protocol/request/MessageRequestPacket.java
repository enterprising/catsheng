package wechart.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.MESSAGE_REQUEST;

/**
 * Created by peng.tan on 2019/5/1.
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

}

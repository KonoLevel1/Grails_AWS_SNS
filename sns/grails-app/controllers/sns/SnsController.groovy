package sns

class SnsController {

    def snsService
    def index() {
        snsService.subscribe()
        snsService.sendMessage()
    }
}

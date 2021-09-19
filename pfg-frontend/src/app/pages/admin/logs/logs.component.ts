import {Component} from '@angular/core';
import {AdminService} from '../../../@core/utils/admin.service';
import {Log} from '../../../@core/data/log';
import {Page} from '../../../@core/data/page';
import {RestError} from '../../../@core/data/error';
import {NbToastrService} from '@nebular/theme';

@Component({
    selector: 'ngx-logs',
    templateUrl: './logs.component.html',
    styleUrls: ['./logs.component.scss'],
})
export class LogsComponent {

    firstCard = {
        logs: [],
        placeholders: [],
        loading: false,
        pageToLoadNext: 0,
    };

    pageSize = 5;

    constructor(
        private adminService: AdminService,
        private toastrService: NbToastrService) {

    }

    loadNext(cardData) {
        if (cardData.loading) {
            return;
        }

        cardData.loading = true;
        cardData.placeholders = new Array(this.pageSize);
        this.adminService.getLogs(cardData.pageToLoadNext, this.pageSize, false)
            .subscribe(
                (page: Page<Log>) => {
                    cardData.placeholders = [];
                    cardData.logs.push(...page.content);
                    cardData.loading = false;
                    cardData.pageToLoadNext++;
                },
                (response: RestError) => {
                    this.toastrService.danger(response.error.message, 'ERROR');
                });
    }

}
